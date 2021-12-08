package io.murad.askdev.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Category name is required")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Question> questions;

    private Instant createdDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Category(Long id, @NotBlank(message = "Category name is required") String name, @NotBlank(message = "Description is required") String description, List<Question> questions, Instant createdDate, User user) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.questions = questions;
        this.createdDate = createdDate;
        this.user = user;
    }

    public Category() {
    }

    public static CategoryBuilder builder() {
        return new CategoryBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public @NotBlank(message = "Category name is required") String getName() {
        return this.name;
    }

    public @NotBlank(message = "Description is required") String getDescription() {
        return this.description;
    }

    public List<Question> getQuestions() {
        return this.questions;
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

    public void setName(@NotBlank(message = "Category name is required") String name) {
        this.name = name;
    }

    public void setDescription(@NotBlank(message = "Description is required") String description) {
        this.description = description;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Category)) return false;
        final Category other = (Category) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        final Object this$questions = this.getQuestions();
        final Object other$questions = other.getQuestions();
        if (this$questions == null ? other$questions != null : !this$questions.equals(other$questions)) return false;
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
        return other instanceof Category;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $questions = this.getQuestions();
        result = result * PRIME + ($questions == null ? 43 : $questions.hashCode());
        final Object $createdDate = this.getCreatedDate();
        result = result * PRIME + ($createdDate == null ? 43 : $createdDate.hashCode());
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        return result;
    }

    public String toString() {
        return "Category(id=" + this.getId() + ", name=" + this.getName() + ", description=" + this.getDescription() + ", questions=" + this.getQuestions() + ", createdDate=" + this.getCreatedDate() + ", user=" + this.getUser() + ")";
    }

    public static class CategoryBuilder {
        private Long id;
        private @NotBlank(message = "Category name is required") String name;
        private @NotBlank(message = "Description is required") String description;
        private List<Question> questions;
        private Instant createdDate;
        private User user;

        CategoryBuilder() {
        }

        public CategoryBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public CategoryBuilder name(@NotBlank(message = "Category name is required") String name) {
            this.name = name;
            return this;
        }

        public CategoryBuilder description(@NotBlank(message = "Description is required") String description) {
            this.description = description;
            return this;
        }

        public CategoryBuilder questions(List<Question> questions) {
            this.questions = questions;
            return this;
        }

        public CategoryBuilder createdDate(Instant createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public CategoryBuilder user(User user) {
            this.user = user;
            return this;
        }

        public Category build() {
            return new Category(id, name, description, questions, createdDate, user);
        }

        public String toString() {
            return "Category.CategoryBuilder(id=" + this.id + ", name=" + this.name + ", description=" + this.description + ", questions=" + this.questions + ", createdDate=" + this.createdDate + ", user=" + this.user + ")";
        }
    }
}
