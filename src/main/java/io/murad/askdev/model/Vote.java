package io.murad.askdev.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voteId;
    private VoteType voteType;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "questionId",referencedColumnName = "questionId")
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId",referencedColumnName = "userId")
    private User user;

    public Vote(Long voteId, VoteType voteType, @NotNull Question question, User user) {
        this.voteId = voteId;
        this.voteType = voteType;
        this.question = question;
        this.user = user;
    }

    public Vote() {
    }

    public static VoteBuilder builder() {
        return new VoteBuilder();
    }

    public Long getVoteId() {
        return this.voteId;
    }

    public VoteType getVoteType() {
        return this.voteType;
    }

    public @NotNull Question getQuestion() {
        return this.question;
    }

    public User getUser() {
        return this.user;
    }

    public void setVoteId(Long voteId) {
        this.voteId = voteId;
    }

    public void setVoteType(VoteType voteType) {
        this.voteType = voteType;
    }

    public void setQuestion(@NotNull Question question) {
        this.question = question;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Vote)) return false;
        final Vote other = (Vote) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$voteId = this.getVoteId();
        final Object other$voteId = other.getVoteId();
        if (this$voteId == null ? other$voteId != null : !this$voteId.equals(other$voteId)) return false;
        final Object this$voteType = this.getVoteType();
        final Object other$voteType = other.getVoteType();
        if (this$voteType == null ? other$voteType != null : !this$voteType.equals(other$voteType)) return false;
        final Object this$question = this.getQuestion();
        final Object other$question = other.getQuestion();
        if (this$question == null ? other$question != null : !this$question.equals(other$question)) return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Vote;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $voteId = this.getVoteId();
        result = result * PRIME + ($voteId == null ? 43 : $voteId.hashCode());
        final Object $voteType = this.getVoteType();
        result = result * PRIME + ($voteType == null ? 43 : $voteType.hashCode());
        final Object $question = this.getQuestion();
        result = result * PRIME + ($question == null ? 43 : $question.hashCode());
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        return result;
    }

    public String toString() {
        return "Vote(voteId=" + this.getVoteId() + ", voteType=" + this.getVoteType() + ", question=" + this.getQuestion() + ", user=" + this.getUser() + ")";
    }

    public static class VoteBuilder {
        private Long voteId;
        private VoteType voteType;
        private @NotNull Question question;
        private User user;

        VoteBuilder() {
        }

        public VoteBuilder voteId(Long voteId) {
            this.voteId = voteId;
            return this;
        }

        public VoteBuilder voteType(VoteType voteType) {
            this.voteType = voteType;
            return this;
        }

        public VoteBuilder question(@NotNull Question question) {
            this.question = question;
            return this;
        }

        public VoteBuilder user(User user) {
            this.user = user;
            return this;
        }

        public Vote build() {
            return new Vote(voteId, voteType, question, user);
        }

        public String toString() {
            return "Vote.VoteBuilder(voteId=" + this.voteId + ", voteType=" + this.voteType + ", question=" + this.question + ", user=" + this.user + ")";
        }
    }
}
