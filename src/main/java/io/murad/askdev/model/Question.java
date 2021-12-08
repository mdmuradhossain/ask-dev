package io.murad.askdev.model;

import lombok.Builder;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

@Entity
@Builder
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @NotBlank(message = "Question name cannot be empty or null")
    private String questionName;

    @Nullable
    private String url;

    @Nullable
    @Lob
    private String description;

    private String slug;

    private Integer voteCount = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    private Instant createdDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Category category;

    public Question(){

    }
    public Question(Long questionId, @NotBlank(message = "Question name cannot be empty or null") String questionName, @Nullable String url, @Nullable String description, String slug, Integer voteCount, User user, Instant createdDate, Category category) {
        this.questionId = questionId;
        this.questionName = questionName;
        this.url = url;
        this.description = description;
        this.slug = slug;
        this.voteCount = voteCount;
        this.user = user;
        this.createdDate = createdDate;
        this.category = category;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    @Nullable
    public String getUrl() {
        return url;
    }

    public void setUrl(@Nullable String url) {
        this.url = url;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
