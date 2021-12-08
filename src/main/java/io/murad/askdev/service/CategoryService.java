package io.murad.askdev.service;

import io.murad.askdev.dto.CategoryDto;
import io.murad.askdev.exception.AskDevException;
import io.murad.askdev.mapper.CategoryMapper;
import io.murad.askdev.model.Category;
import io.murad.askdev.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public void saveCategory(CategoryDto categoryDto) {
//        Category save = categoryRepository.save(categoryMapper.mapDtoToCategory(categoryDto));
//        categoryDto.setId(save.getId());
        categoryRepository.save(categoryMapper.mapDtoToCategory(categoryDto));
        log.info("Saved...");
    }

    public List<CategoryDto> getCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::mapCategoryToDto)
                .collect(Collectors.toList());
    }

    public CategoryDto getCategory(Long id) {
      Category category =  categoryRepository.findById(id).orElseThrow(()->new AskDevException("No Category found with Id - " + id));
      log.info(category.getName());
        return categoryMapper.mapCategoryToDto(category);
    }
}
