package io.murad.askdev.service;

import io.murad.askdev.dto.VoteDto;
import io.murad.askdev.exception.AskDevException;
import io.murad.askdev.exception.QuestionNotFoundException;
import io.murad.askdev.model.Question;
import io.murad.askdev.model.Vote;
import io.murad.askdev.model.VoteType;
import io.murad.askdev.repository.QuestionRepository;
import io.murad.askdev.repository.VoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class VoteService {

    private final VoteRepository voteRepository;
    private final QuestionRepository questionRepository;
    private final AuthService authService;

    @Transactional
    public void vote(VoteDto voteDto) {
        Question question = questionRepository.findById(voteDto.getQuestionId()).orElseThrow(() -> new QuestionNotFoundException("Post Not found with id - " + voteDto.getQuestionId()));
        Optional<Vote> voteByPostAndUser = voteRepository.findTopByQuestionAndUserOrderByVoteIdDesc(question, authService.getCurrentUser());
        if (voteByPostAndUser.isPresent() && voteByPostAndUser.get().getVoteType().equals(voteDto.getVoteType())) {
            throw new AskDevException("You have already " + voteDto.getVoteType() + " 'd for this post");
        }
        if (VoteType.UPVOTE.equals(voteDto.getVoteType())) {

            question.setVoteCount(question.getVoteCount() + 1);
        } else {
            question.setVoteCount(question.getVoteCount() - 1);
        }
        voteRepository.save(mapToVote(voteDto, question));
        questionRepository.save(question);

    }

    private Vote mapToVote(VoteDto voteDto, Question question) {
/*
          Vote vote  = new Vote();
          vote.setVoteType(voteDto.getVoteType());
          vote.setPost(post);
          vote.setUser(authService.getCurrentUser());
          return vote;
 */
        return Vote.builder()
                .voteType(voteDto.getVoteType())
                .question(question)
                .user(authService.getCurrentUser())
                .build();

    }
}
