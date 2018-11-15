package ForumApplication.Model;

public class Group {
    private Integer ID;
    private String name;
    private String prefixFormatting;
    private String suffixFormatting;

    public Group(Integer ID, String name, String prefixFormatting, String suffixFormatting) {
        this.ID = ID;
        this.name = name;
        this.prefixFormatting = prefixFormatting;
        this.suffixFormatting = suffixFormatting;
    }

    public Group() {
    }

    public Integer getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getPrefixFormatting() {
        return prefixFormatting;
    }

    public String getSuffixFormatting() {
        return suffixFormatting;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrefixFormatting(String prefixFormatting) {
        this.prefixFormatting = prefixFormatting;
    }

    public void setSuffixFormatting(String suffixFormatting) {
        this.suffixFormatting = suffixFormatting;
    }

    public static GroupBuilder builder() {
        return new GroupBuilder();
    }

    public static class GroupBuilder {
        private Integer ID;
        private String name;
        private String prefixFormatting;
        private String suffixFormatting;

        private GroupBuilder() {
        }

        private GroupBuilder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        private GroupBuilder name(String name) {
            this.name = name;
            return this;
        }

        private GroupBuilder prefixFormatting(String prefixFormatting) {
            this.prefixFormatting = prefixFormatting;
            return this;
        }

        private GroupBuilder suffixFormatting(String suffixFormatting) {
            this.suffixFormatting = suffixFormatting;
            return this;
        }

        public Group build() {
            return new Group(this.ID, this.name, this.prefixFormatting, this.suffixFormatting);
        }
    }

    @Override
    public boolean equals(Object other) {
        return (this == other) || ((other instanceof Group) && ((Group) other).getID().equals(this.ID));
    }
}
