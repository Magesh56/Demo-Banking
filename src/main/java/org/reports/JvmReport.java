package org.reports;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;


public class JvmReport {
	
	public static void generateJvmReport(String JsonFile) {
		File f=new File(System.getProperty("user.dir")+"\\target\\JVM Report");
		
		Configuration con = new Configuration(f, "E_Com_Project");
		con.addClassifications("Browser", "Chrome");
		con.addClassifications("Tester", "Magesh");
		con.addClassifications("Project", "Demo Project");
		con.addClassifications("Os", "Windows");
		
		List<String> json=new LinkedList<String>();
		json.add(JsonFile);
		
		ReportBuilder r=new ReportBuilder(json, con);
		r.generateReports();
	}

}
