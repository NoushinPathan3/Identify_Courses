package tests;

import Utils.ExcelReader;
import base.BaseTest;
import org.openqa.selenium.By;
import pages.*;

import org.testng.Assert;
import org.testng.annotations.*;

public class OrangeHRMTest extends BaseTest {


    @BeforeMethod
    @Parameters({"Browser"})
    public void setUp(String browser) {
        launchBrowser(browser);
    }


    @DataProvider(name = "excelData")
    public Object[][] getExcelData() {

        int rows = ExcelReader.getRowCount();
        Object[][] data = new Object[rows][4];

        for (int i = 1; i <= rows; i++) {
            data[i - 1][0] = ExcelReader.getCellData(i, 0);
            data[i - 1][1] = ExcelReader.getCellData(i, 1);
            data[i - 1][2] = ExcelReader.getCellData(i, 2);
            data[i - 1][3] = i;
        }
        return data;
    }


    @Test(dataProvider = "excelData")
    public void addJobTitleTest(
            String username,
            String password,
            String baseJobTitle,
            int rowIndex) throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver, wait);
        DashboardPage dashboard = new DashboardPage(driver, wait);
        JobTitlesPage jobPage = new JobTitlesPage(driver, wait);

        boolean loginSuccess = false;


        try {
            loginPage.login(username, password);
            Thread.sleep(800);
            takeScreenshot("Login_Submitted");

            dashboard.waitForDashboard();
            loginSuccess = true;

        } catch (Exception e) {
            loginSuccess = false;
        }


        if (loginSuccess) {

            String jobTitle = baseJobTitle + "_" + System.currentTimeMillis();

            dashboard.openAdmin();
            Thread.sleep(800);
            takeScreenshot("Admin_Clicked");

            jobPage.openJobTitles();
            Thread.sleep(800);
            takeScreenshot("Job_Titles_Page");

            jobPage.displayJobTitles();
            Thread.sleep(800);
            takeScreenshot("Job_Titles");

            jobPage.addJobTitle(jobTitle);
            Thread.sleep(800);
            takeScreenshot("Job_Added");

            ExcelReader.writeActualResult(
                    rowIndex,
                    "Login Successful | Job Added: " + jobTitle
            );
            ExcelReader.writeStatus(rowIndex, "PASS");

            System.out.println("PASS → Job added for row " + rowIndex);
            Assert.assertTrue(true);
        }


        else {

            ExcelReader.writeActualResult(rowIndex, "Login Failed");
            ExcelReader.writeStatus(rowIndex, "FAIL");

            System.out.println("FAIL → Login failed for row " + rowIndex);


            Assert.fail("Login failed for invalid credentials (row " + rowIndex + ")");
        }
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


