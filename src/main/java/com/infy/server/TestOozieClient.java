package com.infy.server;
import java.util.Properties;

import org.apache.oozie.client.OozieClient;
import org.apache.oozie.client.WorkflowJob;
import org.springframework.stereotype.Service;

@Service
public class TestOozieClient {

       public void runJob() {
              OozieClient wc = new OozieClient("http://gold-oozie.db.aexp.com:11000/oozie");

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
              conf.setProperty("emailIds", "Sai.A.Kokadwar@aexp.com");

              try {
                     String jobId = wc.run(conf);
                     System.out.println("Workflow job, " + jobId + " submitted");

                     while (wc.getJobInfo(jobId).getStatus() == WorkflowJob.Status.RUNNING) {
                           System.out.println("Workflow job running ...");
                           Thread.sleep(10 * 1000);
                     }
                     System.out.println("Workflow job completed ...");
                     System.out.println(wc.getJobInfo(jobId));
              } catch (Exception r) {
                     System.out.println("Errors " + r.getLocalizedMessage());
              }
       }
}
