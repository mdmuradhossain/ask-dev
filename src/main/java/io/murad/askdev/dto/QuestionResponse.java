package io.murad.askdev.dto;

public class QuestionResponse {

    private Long id;
    private String questionName;
    private String url;
    private String description;
    private String userName;
    private String categoryName;
    private Integer voteCount;
    private Integer answerCount;
    private String duration;
    private boolean upVote;
    private boolean downVote;
    private String slug;

    public QuestionResponse(Long id, String questionName, String url, String description, String userName, String categoryName, Integer voteCount, Integer answerCount, String duration, boolean upVote, boolean downVote, String slug) {
        this.id = id;
        this.questionName = questionName;
        this.url = url;
        this.description = description;
        this.userName = userName;
        this.categoryName = categoryName;
        this.voteCount = voteCount;
        this.answerCount = answerCount;
        this.duration = duration;
        this.upVote = upVote;
        this.downVote = downVote;
        this.slug = slug;
    }

    public QuestionResponse() {
    }

    public Long getId() {
        return this.id;
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

    public String getUserName() {
        return this.userName;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public Integer getVoteCount() {
        return this.voteCount;
    }

    public Integer getAnswerCount() {
        return this.answerCount;
    }

    public String getDuration() {
        return this.duration;
    }

    public boolean isUpVote() {
        return this.upVote;
    }

    public boolean isDownVote() {
        return this.downVote;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public void setAnswerCount(Integer answerCount) {
        this.answerCount = answerCount;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setUpVote(boolean upVote) {
        this.upVote = upVote;
    }

    public void setDownVote(boolean downVote) {
        this.downVote = downVote;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof QuestionResponse)) return false;
        final QuestionResponse other = (QuestionResponse) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
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
        final Object this$userName = this.getUserName();
        final Object other$userName = other.getUserName();
        if (this$userName == null ? other$userName != null : !this$userName.equals(other$userName)) return false;
        final Object this$categoryName = this.getCategoryName();
        final Object other$categoryName = other.getCategoryName();
        if (this$categoryName == null ? other$categoryName != null : !this$categoryName.equals(other$categoryName))
            return false;
        final Object this$voteCount = this.getVoteCount();
        final Object other$voteCount = other.getVoteCount();
        if (this$voteCount == null ? other$voteCount != null : !this$voteCount.equals(other$voteCount)) return false;
        final Object this$answerCount = this.getAnswerCount();
        final Object other$answerCount = other.getAnswerCount();
        if (this$answerCount == null ? other$answerCount != null : !this$answerCount.equals(other$answerCount))
            return false;
        final Object this$duration = this.getDuration();
        final Object other$duration = other.getDuration();
        if (this$duration == null ? other$duration != null : !this$duration.equals(other$duration)) return false;
        if (this.isUpVote() != other.isUpVote()) return false;
        if (this.isDownVote() != other.isDownVote()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof QuestionResponse;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $questionName = this.getQuestionName();
        result = result * PRIME + ($questionName == null ? 43 : $questionName.hashCode());
        final Object $url = this.getUrl();
        result = result * PRIME + ($url == null ? 43 : $url.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $userName = this.getUserName();
        result = result * PRIME + ($userName == null ? 43 : $userName.hashCode());
        final Object $categoryName = this.getCategoryName();
        result = result * PRIME + ($categoryName == null ? 43 : $categoryName.hashCode());
        final Object $voteCount = this.getVoteCount();
        result = result * PRIME + ($voteCount == null ? 43 : $voteCount.hashCode());
        final Object $answerCount = this.getAnswerCount();
        result = result * PRIME + ($answerCount == null ? 43 : $answerCount.hashCode());
        final Object $duration = this.getDuration();
        result = result * PRIME + ($duration == null ? 43 : $duration.hashCode());
        result = result * PRIME + (this.isUpVote() ? 79 : 97);
        result = result * PRIME + (this.isDownVote() ? 79 : 97);
        return result;
    }

    public String toString() {
        return "QuestionResponse(id=" + this.getId() + ", questionName=" + this.getQuestionName() + ", url=" + this.getUrl() + ", description=" + this.getDescription() + ", userName=" + this.getUserName() + ", categoryName=" + this.getCategoryName() + ", voteCount=" + this.getVoteCount() + ", answerCount=" + this.getAnswerCount() + ", duration=" + this.getDuration() + ", upVote=" + this.isUpVote() + ", downVote=" + this.isDownVote() + ")";
    }
}
