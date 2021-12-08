package io.murad.askdev.dto;

import java.time.Instant;

public class AnswerDto {

    private Long questionId;
    private Instant createdDate;
    private String text;
    private String userName;

    public AnswerDto(Long questionId, Instant createdDate, String text, String userName) {
        this.questionId = questionId;
        this.createdDate = createdDate;
        this.text = text;
        this.userName = userName;
    }

    public AnswerDto() {
    }

    public Long getQuestionId() {
        return this.questionId;
    }

    public Instant getCreatedDate() {
        return this.createdDate;
    }

    public String getText() {
        return this.text;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof AnswerDto)) return false;
        final AnswerDto other = (AnswerDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$questionId = this.getQuestionId();
        final Object other$questionId = other.getQuestionId();
        if (this$questionId == null ? other$questionId != null : !this$questionId.equals(other$questionId))
            return false;
        final Object this$createdDate = this.getCreatedDate();
        final Object other$createdDate = other.getCreatedDate();
        if (this$createdDate == null ? other$createdDate != null : !this$createdDate.equals(other$createdDate))
            return false;
        final Object this$text = this.getText();
        final Object other$text = other.getText();
        if (this$text == null ? other$text != null : !this$text.equals(other$text)) return false;
        final Object this$userName = this.getUserName();
        final Object other$userName = other.getUserName();
        if (this$userName == null ? other$userName != null : !this$userName.equals(other$userName)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AnswerDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $questionId = this.getQuestionId();
        result = result * PRIME + ($questionId == null ? 43 : $questionId.hashCode());
        final Object $createdDate = this.getCreatedDate();
        result = result * PRIME + ($createdDate == null ? 43 : $createdDate.hashCode());
        final Object $text = this.getText();
        result = result * PRIME + ($text == null ? 43 : $text.hashCode());
        final Object $userName = this.getUserName();
        result = result * PRIME + ($userName == null ? 43 : $userName.hashCode());
        return result;
    }

    public String toString() {
        return "AnswerDto(id=" + ", questionId=" + this.getQuestionId() + ", createdDate=" + this.getCreatedDate() + ", text=" + this.getText() + ", userName=" + this.getUserName() + ")";
    }
}
