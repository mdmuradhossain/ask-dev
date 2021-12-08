package io.murad.askdev.repository;

import io.murad.askdev.model.Question;
import io.murad.askdev.model.User;
import io.murad.askdev.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote,Long> {
    Optional<Vote> findTopByQuestionAndUserOrderByVoteIdDesc(Question question, User currentUser);
}
