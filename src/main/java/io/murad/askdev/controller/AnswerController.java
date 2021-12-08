package io.murad.askdev.controller;

import io.murad.askdev.dto.AnswerDto;
import io.murad.askdev.service.AnswerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*
*
*   @author Md Murad Hossain
*
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/answers")
@CrossOrigin
public class AnswerController {

    private final AnswerService answerService;

    @PostMapping
    public ResponseEntity<?> createAnswer(@RequestBody AnswerDto answerDto){
    answerService.saveAnswer(answerDto);
    return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/by-question/{questionId}")
    public ResponseEntity<List<AnswerDto>> getAllAnswersForQuestion(@PathVariable Long questionId){
        return new ResponseEntity<>(answerService.getAnswersForPost(questionId),HttpStatus.OK);
    }

    @GetMapping("/by-user/{userName}")
    public ResponseEntity<List<AnswerDto>> getAllAnswersForUser(@PathVariable String userName){
        return new ResponseEntity<>(answerService.getAnswersForUser(userName),HttpStatus.OK);
    }
}
