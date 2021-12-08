package io.murad.askdev.mapper;

import io.murad.askdev.dto.AnswerDto;
import io.murad.askdev.model.Answer;
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
public class AnswerMapperImpl implements AnswerMapper {

    @Override
    public Answer map(AnswerDto answerDto, Question question, User user) {
        if ( answerDto == null && question == null && user == null ) {
            return null;
        }

        Answer answer = new Answer();

        if ( answerDto != null ) {
            answer.setText( answerDto.getText() );
        }
        if ( question != null ) {
            answer.setQuestion( question );
        }
        if ( user != null ) {
            answer.setUser( user );
        }
        answer.setCreatedDate( java.time.Instant.now() );

        return answer;
    }

    @Override
    public AnswerDto mapToDto(Answer answer) {
        if ( answer == null ) {
            return null;
        }

        AnswerDto answerDto = new AnswerDto();

        answerDto.setCreatedDate( answer.getCreatedDate() );
        answerDto.setText( answer.getText() );

        answerDto.setQuestionId( answer.getQuestion().getQuestionId() );
        answerDto.setUserName( answer.getUser().getUsername() );

        return answerDto;
    }
}
