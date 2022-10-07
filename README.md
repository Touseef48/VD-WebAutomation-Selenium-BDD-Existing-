# Insructions:

Packages

### Recources Folder
1. Update the **ApplicationConfig.properties** file for changing the project credentials
2. All Features files.

### Object Package
1. All Pages are define in objects package 


### Com.cucumber.tests Package
1.update test **RunCukesTest** for executing particular feature file.

### DB Connection Package
1. Database connectivity is define in **dbConn** class

### General Package
1. General functions for reports defined in **MainCall** class
2. General functions are define in **GeneralFunctions** class
3. Webdriver related functions defined in **WebDriverFactory** class
4. Selenium Functions defined in **SeleniumFunctions** class

### stepdefs Package
1. defined step definition for cucumber steps in **stepdefs** Packages
2. define before and after scenario hooks in **Hooks** class.



# Setup Code

Pre-requisites:
- Java JDK 8+ should be installed
- JAVA_HOME environment variable should be set

Steps to setup:
- Clone repository
- Open project on IntelliJ through pom.xml file
- Checkout develop branch
    - Git checkout -f develop

Steps to execute script:
- Right click feature file and Run it
- Wait for full execution
- After execution is completed, open /reports/ExtentReport.html on Chrome browser to view results

Setup of Jenkins Locally:
Jenkins setup:
* Tutorial link: https://www.guru99.com/download-install-jenkins.html
- Click on Manage Jenkins
- Click on Global Tool Configuration
- Under Maven, add Name (“mvnLatest”) and check Install automatically
- Click on Apply and then Save

Reports created under Report folder, sample report provided under report folder

Setup of Percy:
- Login to percy.io
- Create New project on Percy
- Integrate Github or Bitbucket with your repository
- Get Percy token and export in local machine
- Execute test cases using "npx percy exec -- mvn test"


###### DataBase Connection

db =

dbUrl=

dbUserName=

dbPassword=2

dbPort =

1-for mysql db set **db=mysql**

2-for postgres db set **db=postgres**

3-import venture dive jar in POM

4-initialize dbConnection db class  in MainCall class i.e **DbOperation dbOp = new DbOperation();**

5-DataBase integration example in **objects.Login** class function name **dataBaseQuery()**
