package io.murad.askdev.mapper;

import io.murad.askdev.dto.AnswerDto;
import io.murad.askdev.model.Answer;
import io.murad.askdev.model.Question;
import io.murad.askdev.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AnswerMapper {

    @Mapping(target = "text", source = "answerDto.text")
    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "question", source = "question")
    @Mapping(target = "user", source = "user")
    Answer map(AnswerDto answerDto, Question question, User user);

    @Mapping(target = "questionId", expression = "java(answer.getQuestion().getQuestionId())")
    @Mapping(target = "userName", expression = "java(answer.getUser().getUsername())")
    AnswerDto mapToDto(Answer answer);
}
