package io.murad.askdev.dto;

import io.murad.askdev.model.VoteType;

public class VoteDto {

    private VoteType voteType;
    private Long questionId;

    public VoteDto(VoteType voteType, Long questionId) {
        this.voteType = voteType;
        this.questionId = questionId;
    }

    public VoteDto() {
    }

    public VoteType getVoteType() {
        return this.voteType;
    }

    public Long getQuestionId() {
        return this.questionId;
    }

    public void setVoteType(VoteType voteType) {
        this.voteType = voteType;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof VoteDto)) return false;
        final VoteDto other = (VoteDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$voteType = this.getVoteType();
        final Object other$voteType = other.getVoteType();
        if (this$voteType == null ? other$voteType != null : !this$voteType.equals(other$voteType)) return false;
        final Object this$questionId = this.getQuestionId();
        final Object other$questionId = other.getQuestionId();
        if (this$questionId == null ? other$questionId != null : !this$questionId.equals(other$questionId))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof VoteDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $voteType = this.getVoteType();
        result = result * PRIME + ($voteType == null ? 43 : $voteType.hashCode());
        final Object $questionId = this.getQuestionId();
        result = result * PRIME + ($questionId == null ? 43 : $questionId.hashCode());
        return result;
    }

    public String toString() {
        return "VoteDto(voteType=" + this.getVoteType() + ", questionId=" + this.getQuestionId() + ")";
    }
}
