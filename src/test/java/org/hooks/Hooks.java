package org.hooks;

import java.io.IOException;

import org.base.BaseClass;
import org.utils.Utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	@Before
	public void setUp() {
	   

	    BaseClass.launchBrowser(Utils.getProperty("browser"));
	    BaseClass.launchUrl(Utils.getProperty("url"));
	}


    @After
    public void tearDown(Scenario scenario) throws IOException {
    	 if (scenario.isFailed()) {
    	        try {
    	            Utils.takeScreenshot(scenario.getName());
    	            System.out.println("Screenshot taken for failed scenario");
    	        } catch (IOException e) {
    	            e.printStackTrace();
    	        }
    	    }
    	
        BaseClass.tearDown();
    }

}
