package io.murad.askdev.repository;

import io.murad.askdev.model.Category;
import io.murad.askdev.model.Question;
import io.murad.askdev.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findAllByCategory(Category category);

    List<Question> findByUser(User user);

    Question findByQuestionName(String slug);
}
