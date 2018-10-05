package com.dheeraj.learning.miscellaneous;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

public class FTPFileUtil {
    public static void main(String[] args) {
        String ScenarioName = "CCCASE";
        int scenarioThreshold;
        String ScenarioThresholdConfigFile="ftp://eng-colliders-jenkins.rpega.com/patches/ScenarioThreshold.properties";
        String scenarioValue="";
        
        try {
            
            URL url = new URL (ScenarioThresholdConfigFile);
            URLConnection urlc = url.openConnection();
            InputStream is = urlc.getInputStream();
            Properties prop = new Properties();
            prop.load(is);

            scenarioValue = prop.getProperty(ScenarioName);


            if(scenarioValue != null){
                scenarioThreshold = Integer.parseInt(scenarioValue);
            } else
                throw new Exception("Threshold for scenario : "+ScenarioName+" is not defined in ftp location : "+ScenarioThresholdConfigFile);
        } catch (Exception e) {
            System.out.println("Threshold for scenario : "+ScenarioName+" is not defined properly in ftp location : "+ScenarioThresholdConfigFile);
            System.out.println("Current threshold value is : "+scenarioValue);
            System.out.println("Assigning default thresholds for scenario "+ScenarioName+"...");
            switch (ScenarioName) {
                case "CCCASE":
                    scenarioThreshold = 5;
                    break;
                case "DevPerfJUnit":
                    scenarioThreshold = 10;
                    break;
                case "CustomerService":
                    scenarioThreshold = 4;
                    break;
                case "Mortgage":
                    scenarioThreshold = 8;
                    break;
                case "CallCenterJUnit":
                    scenarioThreshold = 6;
                    break;
                case "SimpleSurvey":
                    scenarioThreshold = 6;
                    break;
                case "PerfClip":
                    scenarioThreshold = 15;
                    break;
                case "DSMBatchMarketing":
                    scenarioThreshold = 10;
                    break;
                case "RBS":
                    scenarioThreshold = 6;
                    break;
                case "DataEngineJUnit":
                    scenarioThreshold = 10;
                    break;
                case "ISBANK":
                    scenarioThreshold = 8;
                    break;
                case "Integration":
                    scenarioThreshold = 10;
                    break;
                case "Offline":
                    scenarioThreshold = 10;
                    break;
                case "CRM_731_SA":
                    scenarioThreshold = 5;
                    break;
                case "CRM_731_CS":
                    scenarioThreshold = 5;
                    break;
                default:
                    scenarioThreshold = 10;
                    System.out.println("Invalid scenario name : " + ScenarioName);
            }
        }

        System.out.println(" Threshold for scenario - " + ScenarioName + " is : "+ scenarioThreshold);
    }
}
