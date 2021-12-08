package io.murad.askdev.service;

import io.murad.askdev.dto.QuestionResponse;
import io.murad.askdev.model.Question;
import io.murad.askdev.repository.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class QuestionServiceTest {

    @Autowired
    private QuestionService questionService;

    @MockBean
    private QuestionRepository questionRepository;

    @BeforeEach
    void setUp() {
        Question question = Question.builder()
                .questionId(1L)
                .build();

        Mockito.when(questionRepository.findById(1L))
                .thenReturn(java.util.Optional.ofNullable(question));
    }

    @Test
    public void getQuestionTest(){
        Long questionId = 1L;
        QuestionResponse foundQuestionById = questionService.getQuestion(questionId);
        assertEquals(questionId,foundQuestionById.getId());
    }
}