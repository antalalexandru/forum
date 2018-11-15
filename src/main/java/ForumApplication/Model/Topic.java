package ForumApplication.Model;

import java.util.List;

public class Topic {
    private Integer ID;
    private String topicName;
    private List<Post> posts;
    private Category category;
    private Boolean isClosed;
    private Boolean isHidden;
    private Boolean isPinned;

    public Topic(Integer ID, String topicName, List<Post> posts, Category category, Boolean isClosed, Boolean isHidden, Boolean isPinned) {
        this.ID = ID;
        this.topicName = topicName;
        this.posts = posts;
        this.category = category;
        this.isClosed = isClosed;
        this.isHidden = isHidden;
        this.isPinned = isPinned;
    }

    public Topic() {
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Boolean getClosed() {
        return isClosed;
    }

    public void setClosed(Boolean closed) {
        isClosed = closed;
    }

    public Boolean getHidden() {
        return isHidden;
    }

    public void setHidden(Boolean hidden) {
        isHidden = hidden;
    }

    public Boolean getPinned() {
        return isPinned;
    }

    public void setPinned(Boolean pinned) {
        isPinned = pinned;
    }

    public static TopicBuilder builder() {
        return new TopicBuilder();
    }

    public static class TopicBuilder {
        private Integer ID;
        private String topicName;
        private List<Post> posts;
        private Category category;
        private Boolean isClosed;
        private Boolean isHidden;
        private Boolean isPinned;

        private TopicBuilder() {
        }

        private TopicBuilder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        private TopicBuilder topicName(String topicName) {
            this.topicName = topicName;
            return this;
        }

        private TopicBuilder posts(List<Post> posts) {
            this.posts = posts;
            return this;
        }

        private TopicBuilder category(Category category) {
            this.category = category;
            return this;
        }

        private TopicBuilder isClosed(Boolean isClosed) {
            this.isClosed = isClosed;
            return this;
        }

        private TopicBuilder isHidden(Boolean isHidden) {
            this.isHidden = isHidden;
            return this;
        }

        private TopicBuilder isPinned(Boolean isPinned) {
            this.isPinned = isPinned;
            return this;
        }
    }
}
