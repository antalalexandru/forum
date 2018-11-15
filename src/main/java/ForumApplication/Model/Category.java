package ForumApplication.Model;
import java.util.List;

public class Category {
    private Integer ID;
    private Category parentCategory;
    private String name;
    private String description;
    private List<Category> childCategories;

    public Category(Integer ID, Category parentCategory, String name, String description, List<Category> childCategories) {
        this.ID = ID;
        this.parentCategory = parentCategory;
        this.name = name;
        this.description = description;
        this.childCategories = childCategories;
    }

    public Category() {
    }

    public Integer getID() {
        return ID;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Category> getChildCategories() {
        return childCategories;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setChildCategories(List<Category> childCategories) {
        this.childCategories = childCategories;
    }

    public static CategoryBuilder builder() {
        return new CategoryBuilder();
    }

    public static class CategoryBuilder {
        private Integer ID;
        private Category parentCategory;
        private String name;
        private String description;
        private List<Category> childCategories;

        private CategoryBuilder() {
        }

        public CategoryBuilder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public CategoryBuilder parentCategory(Category parentCategory) {
            this.parentCategory = parentCategory;
            return this;
        }

        public CategoryBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CategoryBuilder description(String description) {
            this.description = description;
            return this;
        }

        public CategoryBuilder childCategories(List<Category> childCategories) {
            this.childCategories = childCategories;
            return this;
        }

        public Category build() {
            return new Category(this.ID, this.parentCategory, this.name, this.description, this.childCategories);
        }
    }

    @Override
    public boolean equals(Object other) {
        return (this == other) || ((other instanceof Category) && ((Category) other).getID().equals(this.ID));
    }
}
