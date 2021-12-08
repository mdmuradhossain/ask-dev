package io.murad.askdev.mapper;

import io.murad.askdev.dto.QuestionRequest;
import io.murad.askdev.dto.QuestionResponse;
import io.murad.askdev.model.Category;
import io.murad.askdev.model.Question;
import io.murad.askdev.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-05T22:23:24+0600",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class QuestionMapperImpl extends QuestionMapper {

    @Override
    public Question map(QuestionRequest questionRequest, Category category, User user) {
        if ( questionRequest == null && category == null && user == null ) {
            return null;
        }

        Question question = new Question();

        if ( questionRequest != null ) {
            question.setDescription( makePrettyUrl( questionRequest.getDescription() ) );
            question.setQuestionName( makePrettyUrl( questionRequest.getQuestionName() ) );
            question.setQuestionId( questionRequest.getQuestionId() );
            question.setUrl( makePrettyUrl( questionRequest.getUrl() ) );
        }
        if ( category != null ) {
            question.setCategory( category );
        }
        if ( user != null ) {
            question.setUser( user );
        }
        question.setCreatedDate( java.time.Instant.now() );
        question.setVoteCount( 0 );
        question.setSlug( makePrettyUrl(questionRequest.getQuestionName()) );

        return question;
    }

    @Override
    public QuestionResponse mapToDto(Question question) {
        if ( question == null ) {
            return null;
        }

        QuestionResponse questionResponse = new QuestionResponse();

        questionResponse.setId( question.getQuestionId() );
        questionResponse.setQuestionName( makePrettyUrl( question.getQuestionName() ) );
        questionResponse.setDescription( makePrettyUrl( question.getDescription() ) );
        questionResponse.setUrl( makePrettyUrl( question.getUrl() ) );
        questionResponse.setCategoryName( makePrettyUrl( questionCategoryName( question ) ) );
        questionResponse.setUserName( makePrettyUrl( questionUserUsername( question ) ) );
        questionResponse.setSlug( makePrettyUrl( question.getSlug() ) );
        questionResponse.setVoteCount( question.getVoteCount() );

        questionResponse.setAnswerCount( answerCount(question) );
        questionResponse.setDuration( getDuration(question) );
        questionResponse.setUpVote( isQuestionUpVoted(question) );
        questionResponse.setDownVote( isQuestionDownVoted(question) );

        return questionResponse;
    }

    private String questionCategoryName(Question question) {
        if ( question == null ) {
            return null;
        }
        Category category = question.getCategory();
        if ( category == null ) {
            return null;
        }
        String name = category.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String questionUserUsername(Question question) {
        if ( question == null ) {
            return null;
        }
        User user = question.getUser();
        if ( user == null ) {
            return null;
        }
        String username = user.getUsername();
        if ( username == null ) {
            return null;
        }
        return username;
    }
}
