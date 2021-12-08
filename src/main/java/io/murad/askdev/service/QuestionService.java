package io.murad.askdev.service;

import io.murad.askdev.dto.QuestionRequest;
import io.murad.askdev.dto.QuestionResponse;
import io.murad.askdev.exception.QuestionNotFoundException;
import io.murad.askdev.exception.CategoryNotFoundException;
import io.murad.askdev.mapper.QuestionMapper;
import io.murad.askdev.model.Question;
import io.murad.askdev.model.Category;
import io.murad.askdev.model.User;
import io.murad.askdev.repository.QuestionRepository;
import io.murad.askdev.repository.CategoryRepository;
import io.murad.askdev.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class QuestionService {

    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;
    private final CategoryRepository categoryRepository;
    private final AuthService authService;
    private final QuestionMapper questionMapper;

    public void saveQuestion(QuestionRequest questionRequest) {
       Category category = categoryRepository.findByName(questionRequest.getCategoryName()).orElseThrow(() -> new CategoryNotFoundException(questionRequest.getCategoryName()));
        User currentUser = authService.getCurrentUser();
        questionRepository.save(questionMapper.map(questionRequest, category, currentUser));
    }

    @Transactional(readOnly = true)
    public QuestionResponse getQuestion(Long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new QuestionNotFoundException(id.toString()));
        return questionMapper.mapToDto(question);
    }

    @Transactional(readOnly = true)
    public List<QuestionResponse> getAllQuestions() {
        return questionRepository.findAll()
                .stream()
                .map((question)-> questionMapper.mapToDto(question))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<QuestionResponse> getQuestionsByCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(categoryId.toString()));
        List<Question> questions = questionRepository.findAllByCategory(category);
        return questions.stream().map(questionMapper::mapToDto).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<QuestionResponse> getQuestionsByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return questionRepository.findByUser(user)
                .stream()
                .map(questionMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public QuestionResponse getQuestionByName(String slug) {
        Question question = questionRepository.findByQuestionName(slug);
        return questionMapper.mapToDto(question);
    }
}
