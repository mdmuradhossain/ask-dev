package io.murad.askdev.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "questionId", referencedColumnName = "questionId")
    private Question question;

    private Instant createdDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    public Answer(Long id, @NotEmpty String text, Question question, Instant createdDate, User user) {
        this.id = id;
        this.text = text;
        this.question = question;
        this.createdDate = createdDate;
        this.user = user;
    }

    public Answer() {
    }

    public Long getId() {
        return this.id;
    }

    public @NotEmpty String getText() {
        return this.text;
    }

    public Question getQuestion() {
        return this.question;
    }

    public Instant getCreatedDate() {
        return this.createdDate;
    }

    public User getUser() {
        return this.user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setText(@NotEmpty String text) {
        this.text = text;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Answer)) return false;
        final Answer other = (Answer) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$text = this.getText();
        final Object other$text = other.getText();
        if (this$text == null ? other$text != null : !this$text.equals(other$text)) return false;
        final Object this$question = this.getQuestion();
        final Object other$question = other.getQuestion();
        if (this$question == null ? other$question != null : !this$question.equals(other$question)) return false;
        final Object this$createdDate = this.getCreatedDate();
        final Object other$createdDate = other.getCreatedDate();
        if (this$createdDate == null ? other$createdDate != null : !this$createdDate.equals(other$createdDate))
            return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Answer;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $text = this.getText();
        result = result * PRIME + ($text == null ? 43 : $text.hashCode());
        final Object $question = this.getQuestion();
        result = result * PRIME + ($question == null ? 43 : $question.hashCode());
        final Object $createdDate = this.getCreatedDate();
        result = result * PRIME + ($createdDate == null ? 43 : $createdDate.hashCode());
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        return result;
    }

    public String toString() {
        return "Answer(id=" + this.getId() + ", text=" + this.getText() + ", question=" + this.getQuestion() + ", createdDate=" + this.getCreatedDate() + ", user=" + this.getUser() + ")";
    }
}
