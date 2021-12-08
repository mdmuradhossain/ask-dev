package io.murad.askdev.mapper;

import io.murad.askdev.dto.CategoryDto;
import io.murad.askdev.model.Category;
import io.murad.askdev.model.Question;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "numberOfQuestions", expression = "java(mapQuestions(category.getQuestions()))")
    CategoryDto mapCategoryToDto(Category category);

    default Integer mapQuestions(List<Question> numberOfQuestions) {
        return numberOfQuestions.size();
    }

    @InheritInverseConfiguration
    @Mapping(target = "questions", ignore = true)
    Category mapDtoToCategory(CategoryDto categoryDto);
}
