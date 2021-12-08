package io.murad.askdev.repository;

import io.murad.askdev.model.Answer;
import io.murad.askdev.model.Question;
import io.murad.askdev.model.Question;
import io.murad.askdev.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    public List<Answer> findByQuestion(Question question);

    public List<Answer> findAllByUser(User user);
}
