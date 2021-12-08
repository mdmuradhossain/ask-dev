package io.murad.askdev.mapper;

import com.github.marlonlom.utilities.timeago.TimeAgo;
import com.github.slugify.Slugify;
import io.murad.askdev.dto.QuestionRequest;
import io.murad.askdev.dto.QuestionResponse;
import io.murad.askdev.model.*;
import io.murad.askdev.repository.AnswerRepository;
import io.murad.askdev.repository.VoteRepository;
import io.murad.askdev.service.AuthService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Mapper(componentModel = "spring")
public abstract class QuestionMapper {

    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private VoteRepository voteRepository;
    @Autowired
    private AuthService authService;

    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "user", source = "user")
    @Mapping(target = "description", source = "questionRequest.description")
    @Mapping(target = "voteCount", constant = "0")
    @Mapping(target = "questionName",source = "questionRequest.questionName")
    @Mapping(target = "slug",expression = "java(makePrettyUrl(questionRequest.getQuestionName()))")
    public abstract Question map(QuestionRequest questionRequest, Category category, User user);

    @Mapping(target = "id", source = "questionId")
    @Mapping(target = "questionName", source = "questionName")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "url", source = "url")
    @Mapping(target = "categoryName", source = "category.name")
    @Mapping(target = "userName", source = "user.username")
    @Mapping(target = "answerCount", expression = "java(answerCount(question))")
    @Mapping(target = "duration", expression = "java(getDuration(question))")
    @Mapping(target = "upVote", expression = "java(isQuestionUpVoted(question))")
    @Mapping(target = "downVote", expression = "java(isQuestionDownVoted(question))")
    @Mapping(target = "slug",source = "question.slug")
    public abstract QuestionResponse mapToDto(Question question);

    Integer answerCount(Question question) {
        return answerRepository.findByQuestion(question).size();
    }

    String getDuration(Question question) {
        return TimeAgo.using(question.getCreatedDate().toEpochMilli());
    }
    boolean isQuestionUpVoted(Question question) {
        return checkVoteType(question, VoteType.UPVOTE);
    }

    boolean isQuestionDownVoted(Question question) {
        return checkVoteType(question, VoteType.DOWNVOTE);
    }

    private boolean checkVoteType(Question question, VoteType voteType) {
        if (authService.isLoggedIn()) {
            Optional<Vote> voteForQuestionByUser =
                    voteRepository.findTopByQuestionAndUserOrderByVoteIdDesc(question,
                            authService.getCurrentUser());
            return voteForQuestionByUser.filter(vote -> vote.getVoteType().equals(voteType))
                    .isPresent();
        }
        return false;
    }

    String makePrettyUrl(String title){
        Slugify prettyUrl= new Slugify();
        return prettyUrl.slugify(title);
    }

}
