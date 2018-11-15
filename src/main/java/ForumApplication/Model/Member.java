package ForumApplication.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Member {

    private Integer ID;

    private String name;

    @JsonIgnore
    private String email;

    @JsonIgnore
    private String hashedPassword;

    private Long lastActive;

    private Group group;

    private Integer warningPoints;

    public Member(Integer ID, String name, String email, String hashedPassword, Long lastActive, Group group, Integer warningPoints) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.lastActive = lastActive;
        this.group = group;
        this.warningPoints = warningPoints;
    }

    public Member() {
    }

    public Integer getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public Long getLastActive() {
        return lastActive;
    }

    public Group getGroup() {
        return group;
    }

    public Integer getWarningPoints() {
        return warningPoints;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public void setLastActive(Long lastActive) {
        this.lastActive = lastActive;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setWarningPoints(Integer warningPoints) {
        this.warningPoints = warningPoints;
    }

    public static MemberBuilder builder() {
        return new MemberBuilder();
    }

    public static class MemberBuilder {
        private Integer ID;
        private String name;
        private String email;
        private String hashedPassword;
        private Long lastActive;
        private Group group;
        private Integer warningPoints;

        private MemberBuilder() {
        }

        public MemberBuilder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public MemberBuilder name(String name) {
            this.name = name;
            return this;
        }

        public MemberBuilder email(String email) {
            this.email = email;
            return this;
        }

        public MemberBuilder hashedPassword(String hashedPassword) {
            this.hashedPassword = hashedPassword;
            return this;
        }

        public MemberBuilder lastActive(Long lastActive) {
            this.lastActive = lastActive;
            return this;
        }

        public MemberBuilder group(Group group) {
            this.group = group;
            return this;
        }

        public MemberBuilder warningPoints(Integer warningPoints) {
            this.warningPoints = warningPoints;
            return this;
        }

        public Member build() {
            return new Member(this.ID, this.name, this.email, this.hashedPassword, this.lastActive, this.group, this.warningPoints);
        }
    }
}
