package io.murad.askdev.service;

import io.murad.askdev.dto.AnswerDto;
import io.murad.askdev.exception.QuestionNotFoundException;
import io.murad.askdev.mapper.AnswerMapper;
import io.murad.askdev.model.Answer;
import io.murad.askdev.model.NotificationEmail;
import io.murad.askdev.model.Question;
import io.murad.askdev.model.User;
import io.murad.askdev.repository.AnswerRepository;
import io.murad.askdev.repository.QuestionRepository;
import io.murad.askdev.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AnswerService {

    private static final String POST_URL = "";
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;
    private final AuthService authService;
    private final AnswerMapper answerMapper;
    private final AnswerRepository answerRepository;
    private final MailContentBuilder mailContentBuilder;
    private final MailService mailService;

    public void saveAnswer(AnswerDto answerDto) {
        Question question = questionRepository.findById(answerDto.getQuestionId()).orElseThrow(() -> new QuestionNotFoundException(answerDto.getQuestionId().toString()));
        Answer answer = answerMapper.map(answerDto, question, authService.getCurrentUser());
        answerRepository.save(answer);

        String message = mailContentBuilder.build(question.getUser().getUsername() + " posted a comment on your post." + POST_URL);
        sendCommentNotification(message, question.getUser());
    }

    private void sendCommentNotification(String message, User user) {
        mailService.sendMail(new NotificationEmail(user.getUsername() + " Commented on your post", user.getEmail(), message));
    }


    public List<AnswerDto> getAnswersForPost(Long questionId) {
        Question question = questionRepository.findById(questionId).orElseThrow(() -> new QuestionNotFoundException(questionId.toString()));
        return answerRepository.findByQuestion(question).stream().map((answer) -> answerMapper.mapToDto(answer)).collect(Collectors.toList());
    }

    public List<AnswerDto> getAnswersForUser(String userName) {
        User user = userRepository.findByUsername(userName).orElseThrow(() -> new UsernameNotFoundException(userName));
       return answerRepository.findAllByUser(user)
                .stream().map((answer) -> answerMapper.mapToDto(answer)).collect(Collectors.toList());
    }
}
