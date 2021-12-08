package io.murad.askdev.controller;

import io.murad.askdev.dto.QuestionRequest;
import io.murad.askdev.dto.QuestionResponse;
import io.murad.askdev.service.QuestionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.status;

import java.util.List;

/*
 *
 *   @author Md Murad Hossain
 *
 */

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/questions")
@CrossOrigin
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping
    public ResponseEntity<?> createQuestion(@RequestBody QuestionRequest questionRequest){
        questionService.saveQuestion(questionRequest);
        log.info("Post saved...");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<QuestionResponse>> getAllQuestions(){
        return new ResponseEntity<>(questionService.getAllQuestions(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionResponse> getQuestion(@PathVariable Long id){
        return new ResponseEntity<>(questionService.getQuestion(id),HttpStatus.OK);
    }
    @GetMapping("by-category/{id}")
    public ResponseEntity<List<QuestionResponse>> getQuestionsByCategory(@PathVariable Long id) {
        return status(HttpStatus.OK).body(questionService.getQuestionsByCategory(id));
    }

    @GetMapping("by-user/{name}")
    public ResponseEntity<List<QuestionResponse>> getQuestionsByUsername(@PathVariable String name) {
        return status(HttpStatus.OK).body(questionService.getQuestionsByUsername(name));
    }

//    @GetMapping("/{id}/{slug}")
//    public ResponseEntity<QuestionResponse> getQuestionBySlug(@PathVariable("slug") String slug, @PathVariable("id") Long id) {
//        return status(HttpStatus.OK).body(questionService.getQuestionByName(slug));
//    }
}
