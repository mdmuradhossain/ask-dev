package io.murad.askdev.dto;

import com.github.slugify.Slugify;

public class QuestionRequest {

    private Long questionId;
    private String categoryName;
    private String questionName;
    private String url;
    private String description;

    public QuestionRequest(Long questionId, String categoryName, String questionName, String url, String description) {
        this.questionId = questionId;
        this.categoryName = categoryName;
        this.questionName = questionName;
        this.url = url;
        this.description = description;
    }

    public QuestionRequest() {
    }

    public Long getQuestionId() {
        return this.questionId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public String getQuestionName() {
        return this.questionName;
    }

    public String getUrl() {
        return this.url;
    }

    public String getDescription() {
        return this.description;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof QuestionRequest)) return false;
        final QuestionRequest other = (QuestionRequest) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$questionId = this.getQuestionId();
        final Object other$questionId = other.getQuestionId();
        if (this$questionId == null ? other$questionId != null : !this$questionId.equals(other$questionId))
            return false;
        final Object this$categoryName = this.getCategoryName();
        final Object other$categoryName = other.getCategoryName();
        if (this$categoryName == null ? other$categoryName != null : !this$categoryName.equals(other$categoryName))
            return false;
        final Object this$questionName = this.getQuestionName();
        final Object other$questionName = other.getQuestionName();
        if (this$questionName == null ? other$questionName != null : !this$questionName.equals(other$questionName))
            return false;
        final Object this$url = this.getUrl();
        final Object other$url = other.getUrl();
        if (this$url == null ? other$url != null : !this$url.equals(other$url)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof QuestionRequest;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $questionId = this.getQuestionId();
        result = result * PRIME + ($questionId == null ? 43 : $questionId.hashCode());
        final Object $categoryName = this.getCategoryName();
        result = result * PRIME + ($categoryName == null ? 43 : $categoryName.hashCode());
        final Object $questionName = this.getQuestionName();
        result = result * PRIME + ($questionName == null ? 43 : $questionName.hashCode());
        final Object $url = this.getUrl();
        result = result * PRIME + ($url == null ? 43 : $url.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        return result;
    }

    public String toString() {
        return "QuestionRequest(questionId=" + this.getQuestionId() + ", categoryName=" + this.getCategoryName() + ", questionName=" + this.getQuestionName() + ", url=" + this.getUrl() + ", description=" + this.getDescription() + ")";
    }
}
