package Utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getExtent() {

        if (extent == null) {
            ExtentSparkReporter spark =
                    new ExtentSparkReporter("reports/OrangeHRM_Report.html");

            spark.config().setDocumentTitle("OrangeHRM Automation Report");
            spark.config().setReportName("OrangeHRM Test Execution");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
}