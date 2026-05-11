package model;

public class Session {
    private String username;
    private String school;
    private String sessionName;
    private String qualityType;
    private String mode;
    private Scenario selectedScenario;

    public Session() {
        this.username = "";
        this.school = "";
        this.sessionName = "";
        this.qualityType = "";
        this.mode = "";
        this.selectedScenario = null;
    }

    public String validateProfile() {
        if (username == null || username.trim().isEmpty())
            return "Please enter your username to continue.";
        if (school == null || school.trim().isEmpty())
            return "Please enter your school name to continue.";
        if (sessionName == null || sessionName.trim().isEmpty())
            return "Please enter a session name to continue.";
        return null;
    }

    public String validateDefine() {
        if (qualityType == null || qualityType.isEmpty())
            return "Please select a quality type to continue.";
        if (mode == null || mode.isEmpty())
            return "Please select a mode to continue.";
        if (selectedScenario == null)
            return "Please select a scenario to continue.";
        return null;
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getSchool() { return school; }
    public void setSchool(String school) { this.school = school; }
    public String getSessionName() { return sessionName; }
    public void setSessionName(String sessionName) { this.sessionName = sessionName; }
    public String getQualityType() { return qualityType; }
    public void setQualityType(String qualityType) { this.qualityType = qualityType; }
    public String getMode() { return mode; }
    public void setMode(String mode) { this.mode = mode; }
    public Scenario getSelectedScenario() { return selectedScenario; }
    public void setSelectedScenario(Scenario scenario) { this.selectedScenario = scenario; }
}