package org.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.reports.JvmReport;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = "D:\\selenium\\Demo_Banking\\src\\test\\resources\\features",
                 glue = {"org.stepdefination","org.hooks"},
                 dryRun = !true,
                 monochrome = true,
                 plugin = {"pretty",
                		 "html:target\\htmlReport.html",
                		 "json:target\\jsonReport.json",
                		 "junit:target\\junitReport.xml"
                 }
		
		
		)

public class Runner {
	@AfterClass
	public static void reports() throws InterruptedException {
		//Thread.sleep(2000);
		JvmReport.generateJvmReport("target\\jsonReport.json");
		System.out.println("------------------Report Generated--------------------");
	}

}
