package io.murad.askdev.dto;

public class CategoryDto {
    private Long id;
    private String name;
    private String description;
    private Integer numberOfQuestions;

    public CategoryDto(Long id, String name, String description, Integer numberOfQuestions) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.numberOfQuestions = numberOfQuestions;
    }

    public CategoryDto() {
    }

    public static CategoryDtoBuilder builder() {
        return new CategoryDtoBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public Integer getNumberOfQuestions() {
        return this.numberOfQuestions;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNumberOfQuestions(Integer numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CategoryDto)) return false;
        final CategoryDto other = (CategoryDto) o;
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
        final Object this$numberOfQuestions = this.getNumberOfQuestions();
        final Object other$numberOfQuestions = other.getNumberOfQuestions();
        if (this$numberOfQuestions == null ? other$numberOfQuestions != null : !this$numberOfQuestions.equals(other$numberOfQuestions))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CategoryDto;
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
        final Object $numberOfQuestions = this.getNumberOfQuestions();
        result = result * PRIME + ($numberOfQuestions == null ? 43 : $numberOfQuestions.hashCode());
        return result;
    }

    public String toString() {
        return "CategoryDto(id=" + this.getId() + ", name=" + this.getName() + ", description=" + this.getDescription() + ", numberOfQuestions=" + this.getNumberOfQuestions() + ")";
    }

    public static class CategoryDtoBuilder {
        private Long id;
        private String name;
        private String description;
        private Integer numberOfQuestions;

        CategoryDtoBuilder() {
        }

        public CategoryDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public CategoryDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CategoryDtoBuilder description(String description) {
            this.description = description;
            return this;
        }

        public CategoryDtoBuilder numberOfQuestions(Integer numberOfQuestions) {
            this.numberOfQuestions = numberOfQuestions;
            return this;
        }

        public CategoryDto build() {
            return new CategoryDto(id, name, description, numberOfQuestions);
        }

        public String toString() {
            return "CategoryDto.CategoryDtoBuilder(id=" + this.id + ", name=" + this.name + ", description=" + this.description + ", numberOfQuestions=" + this.numberOfQuestions + ")";
        }
    }
}
