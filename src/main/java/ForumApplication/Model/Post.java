package ForumApplication.Model;

public class Post {
    private Integer ID;
    private String content;
    private Long datePosted;
    private Member author;

    public Post(Integer ID, String content, Long datePosted, Member author) {
        this.ID = ID;
        this.content = content;
        this.datePosted = datePosted;
        this.author = author;
    }

    public Post() {
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Long datePosted) {
        this.datePosted = datePosted;
    }

    public Member getAuthor() {
        return author;
    }

    public void setAuthor(Member author) {
        this.author = author;
    }

    public static PostBuilder builder() {
        return new PostBuilder();
    }

    public static class PostBuilder {
        private Integer ID;
        private String content;
        private Long datePosted;
        private Member author;

        private PostBuilder() {
        }

        public PostBuilder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public PostBuilder content(String content) {
            this.content = content;
            return this;
        }

        public PostBuilder datePosted(Long datePosted) {
            this.datePosted = datePosted;
            return this;
        }

        public PostBuilder author(Member author) {
            this.author = author;
            return this;
        }

        public Post build() {
            return new Post(ID, content, datePosted, author);
        }
    }
}
