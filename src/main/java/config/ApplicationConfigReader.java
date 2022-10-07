package config;

import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource.Classpath;

@Classpath({"ApplicationConfig.properties"})
public class ApplicationConfigReader {


    private static ApplicationConfigReader config;

    public static ApplicationConfigReader getConfig() {
        if (config == null) {
            config = new ApplicationConfigReader();
        }
        return config;
    }

    @Property("baseUrl")
    private String Url;

    @Property("web_assignment_Url")
    private String WebAssignmentUrl;

    @Property("userName")
    private String UserName;

    @Property("password")
    private String Password;


    @Property("Environment")
    private String Environment;

    @Property("Device")
    private String Device;

    @Property("Browser")
    private String Browser;

    @Property("isEnableReporting")
    private String isEnableReporting;


    @Property("headless")
    private String headless;

    @Property("coreBaseUrl")
    private String coreBaseUrl;

    @Property("fpsBaseUrl")
    private String fpsBaseUrl;

    @Property("authUrl")
    private String authUrl;


    @Property("Project")
    private String Project;

    @Property("ENV")
    private String ENV;

    @Property("GIT_COMMIT")
    private String GIT_COMMIT;

    @Property("GIT_BRANCH")
    private String GIT_BRANCH;

    @Property("BUILD_NUMBER")
    private String BUILD_NUMBER;

    @Property("COMPONENT_ID")
    private String COMPONENT_ID;

    @Property("LogTestRail")
    private String LogTestRail;

    @Property("isEnableRecording")
    private String isEnableRecording;

    @Property("LogJIRA")
    private String LogJIRA;

    @Property("UpdateCase")
    private String UpdateCase;

    @Property("TemplateId")
    private String TemplateId;
    @Property("SendEmailAfterExecution")
    private String SendEmailAfterExecution = "";


    public ApplicationConfigReader() {
        PropertyLoader.newInstance().populate(this);
    }

    public String getUrl() {
        return this.Url;
    }
    public String getWebAssignmentUrl() {
        return this.WebAssignmentUrl;
    }
    public String getUserName() {
        return this.UserName;
    }

    public String getEnvironment() {
        return this.Environment;
    }
    public String getDevice() {
        return this.Device;
    }

    public String getBrowser() {
        return this.Browser;
    }
    public String getIsEnableReporting() {
        return this.isEnableReporting;
    }

    public String getHeadless() {
        return headless;
    }
    public String getLogTestRail() { return LogTestRail; }

    public String getLogJIRA() { return LogJIRA; }


    public String getSendEmailAfterExecution() {
        return this.SendEmailAfterExecution;
    }


}
