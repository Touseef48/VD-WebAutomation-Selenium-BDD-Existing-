package config;

public class ConfigProperties {
    public static ApplicationConfigReader appConfig = new ApplicationConfigReader();

    public static String Environment = appConfig.getEnvironment();
    public static String Url = appConfig.getUrl();
    public static String webAssignmentUrl=appConfig.getWebAssignmentUrl();
    public static String UserName = appConfig.getUserName();
    public static String Device = appConfig.getDevice();
    public static String Browser = appConfig.getBrowser();
    public static String IsEnableReporting = appConfig.getIsEnableReporting();
    public static String isHeadless = appConfig.getHeadless();
    public static String LogTestRail = appConfig.getLogTestRail();
    public static String LogJIRA = appConfig.getLogJIRA();
    public static String IsSendEmailAfterExecution = appConfig.getSendEmailAfterExecution();


}
