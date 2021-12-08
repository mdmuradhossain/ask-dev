package io.murad.askdev.controller;

import io.murad.askdev.dto.CategoryDto;
import io.murad.askdev.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/api/categories")
@AllArgsConstructor
@Slf4j
@CrossOrigin
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody CategoryDto categoryDto) {
        categoryService.saveCategory(categoryDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategory() {
        List<CategoryDto> categories = categoryService.getCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getCategory(id));
    }
}
