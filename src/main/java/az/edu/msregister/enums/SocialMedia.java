package az.edu.msregister.enums;

public enum SocialMedia {
    GITHUB("GitHub", "https://github.com/"),
    LINKEDIN("LinkedIn", "https://linkedin.com/"),
    BEHANCE("Behance", "https://www.behance.net/"),
    OTHER("Other", "");

    private final String platform;
    private final String link;

    SocialMedia(String platform, String link) {
        this.platform = platform;
        this.link = link;
    }

    public String getPlatform() {
        return platform;
    }

    public String getLink() {
        return link;
    }
}
