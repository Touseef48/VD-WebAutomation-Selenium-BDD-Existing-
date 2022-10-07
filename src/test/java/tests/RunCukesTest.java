package tests;

import static config.ConfigProperties.IsSendEmailAfterExecution;
import static config.ConfigProperties.LogTestRail;


import com.venturedive.base.model.ExecutionStats;
import com.venturedive.base.utility.MessagesIntegration;
import com.venturedive.base.utility.SendEmailAfterExecution;
import com.venturedive.base.utility.TestRail;
import config.ConfigProperties;
import general.*;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import java.io.File;
import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import java.sql.SQLException;
import java.util.Date;
import com.venturedive.base.database.connection.SonarDB;



@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/features" },
        glue = {"stepdefs"},
        plugin = { "pretty", "html:target/cucumber" },
        tags={"@scenario1"})

public  class RunCukesTest {
    static Date startTime = null;
    static Date endTime = null;
    static Integer passedCount = 0;
    static Integer failedCount = 0;
    static Integer skippedCount = 0;

    public static ArrayList<String> automationSteps;
    public static Integer beforeAddingStepsLength;
    public static Integer afterAddingStepsLength;
    public static Integer beforeAddingExpectedResultLength;
    public static Integer afterAddingExpectedResultLength;
    public static ArrayList<String> expectedResults;
    public static ArrayList<File> screenShotCollection = new ArrayList<File>();

    public static Integer getPassCount()
    {
        return passedCount;
    }
    public static Integer getFailCount()
    {
        return failedCount;
    }
    public static Integer getSkippedCount()
    {
        return skippedCount;
    }

    public static void setPassCount(Integer passCount)
    {
        passedCount=passCount;
    }
    public static void setFailCount(Integer failCount)
    {
        failedCount = failCount;
    }
    public static void setSkippedCount(Integer skipCount)
    {
        skippedCount = skipCount;
    }
    public static SonarDB SonarDbCon;

    @BeforeClass
    public static void  beforeClass() throws SQLException {
        // api integration
       // MainCall.preReq.setup();
        SonarDbCon = new SonarDB();
        if (ConfigProperties.IsEnableReporting.equals("true")) {
            MainCall.startReport();
        }

        startTime = GeneralFunctions.getTime();
        automationSteps = new ArrayList<String>();
        expectedResults=new ArrayList<String>();
    }


    @AfterClass
    public static void AfterClass() {
        try {
            WebDriverFactory.finishDriver();

            if (ConfigProperties.IsEnableReporting.equals("true")) {
                MainCall.getExtentReport().flush();
                MainCall.getExtentReport().close();
            }
            endTime = GeneralFunctions.getTime();
            try {
                SonarDbCon.insertReportingDataIntoDB(startTime, passedCount, failedCount, skippedCount, startTime, endTime);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (LogTestRail.equals("true")) {
                TestRail.createSuite();
                TestRail.updateTestRail();
                TestRail.AttachImagesWithTestResults(screenShotCollection);
            }
            if (IsSendEmailAfterExecution.equals("true")) {
                System.out.println("sendEmail");
                SendEmailAfterExecution.sendReportAfterExecution(passedCount, failedCount, skippedCount);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        ExecutionStats executionStats = new ExecutionStats();
        executionStats.passed = passedCount;
        executionStats.failed = failedCount;
        executionStats.skipped = skippedCount;
        executionStats.reportURL = MainCall.reportPath;
        executionStats.executionDateTime = endTime;
        try {
            MessagesIntegration.sendStatsToWorkspace(executionStats);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
