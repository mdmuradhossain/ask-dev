package io.murad.askdev.mapper;

import io.murad.askdev.dto.CategoryDto;
import io.murad.askdev.dto.CategoryDto.CategoryDtoBuilder;
import io.murad.askdev.model.Category;
import io.murad.askdev.model.Category.CategoryBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-05T22:23:24+0600",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDto mapCategoryToDto(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDtoBuilder categoryDto = CategoryDto.builder();

        categoryDto.id( category.getId() );
        categoryDto.name( category.getName() );
        categoryDto.description( category.getDescription() );

        categoryDto.numberOfQuestions( mapQuestions(category.getQuestions()) );

        return categoryDto.build();
    }

    @Override
    public Category mapDtoToCategory(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        CategoryBuilder category = Category.builder();

        category.id( categoryDto.getId() );
        category.name( categoryDto.getName() );
        category.description( categoryDto.getDescription() );

        return category.build();
    }
}
