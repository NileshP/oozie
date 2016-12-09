package com.infy.model;

import org.apache.oozie.client.OozieClient;
import org.apache.oozie.client.OozieClientException;
import org.apache.oozie.client.WorkflowJob;
import org.apache.oozie.client.WorkflowJob.Status;

import java.util.Properties;


public class OozieClientTest {

	public Properties getConfiguration(OozieClient wc){
		
		Properties conf = wc.createConfiguration();

		conf.setProperty("nameNode", "maprfs:///");
		conf.setProperty("jobTracker", "maprfs:///");
		conf.setProperty("queueName", "yodlee");
		conf.setProperty("oozie.libpath", "${nameNode}/axp/rim/yodlee/dev/oozie/yarn-lib/lib");
		//conf.setProperty("oozie.use.system.libpath", "true");
		//conf.setProperty("oozie.wf.rerun.failnodes", "true");

		conf.setProperty("oozieProjectRoot",
				"/axp/rim/yodlee/dev/yodlee_sai");
		conf.setProperty("appPath",
				"${oozieProjectRoot}/shell-test-workflow.xml");
		conf.setProperty(OozieClient.APP_PATH, "${appPath}");

		conf.setProperty("insertionPath", "${oozieProjectRoot}/scripts/test.sh");
		
		return conf;
	}
	
	public String getJobId(OozieClient wc,Properties conf){
		String jobId = null;
		try {
			jobId = wc.run(conf);
		} catch (OozieClientException e) {
			e.printStackTrace();
		}
		return jobId;
	}
	
	
	public static void main(String[] args) {
		OozieClientTest oozieClientTest = new OozieClientTest();
		

		Properties conf= oozieClientTest.getConfiguration(wc);
		String jobId = oozieClientTest.getJobId(wc,conf);
		
	}
}
