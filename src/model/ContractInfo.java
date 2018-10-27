package model;

public class ContractInfo {
    private String phoneNumber;
    private String skypeNumber;
    private String email;
    private String linkedinUrl;
    private String githubUrl;
    private String stackoverflowUrl;
    private String homePageUrl;

    public ContractInfo(String phoneNumber, String skypeNumber, String email, String linkedinUrl, String githubUrl, String stackoverflowUrl, String homePageUrl) {
        this.phoneNumber = phoneNumber;
        this.skypeNumber = skypeNumber;
        this.email = email;
        this.linkedinUrl = linkedinUrl;
        this.githubUrl = githubUrl;
        this.stackoverflowUrl = stackoverflowUrl;
        this.homePageUrl = homePageUrl;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSkypeNumber() {
        return skypeNumber;
    }

    public void setSkypeNumber(String skypeNumber) {
        this.skypeNumber = skypeNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    public String getStackoverflowUrl() {
        return stackoverflowUrl;
    }

    public void setStackoverflowUrl(String stackoverflowUrl) {
        this.stackoverflowUrl = stackoverflowUrl;
    }

    public String getHomePageUrl() {
        return homePageUrl;
    }

    public void setHomePageUrl(String homePageUrl) {
        this.homePageUrl = homePageUrl;
    }
}
