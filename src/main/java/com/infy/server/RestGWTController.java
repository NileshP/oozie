package com.infy.server;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.oozie.tools.workflowgenerator.client.OrderConfirmation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.infy.model.MysqlQuery;
import com.infy.model.OozieBean;

@Controller
public class RestGWTController {
	
	Logger logger = Logger.getLogger("RESTLOGGER");
	
	
	@Autowired
	MysqlQuery query;
	
	@RequestMapping(value = "/loadInfo", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody OrderConfirmation handleRequest(@RequestBody OrderConfirmation xml,HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//	GreetingServiceEndpoint endpoint = greetingService.getGreetingServiceEndpointPort();
		OrderConfirmation confirmation = new OrderConfirmation();
		confirmation.message = "Hello";
		confirmation.ready_time = System.currentTimeMillis() + 1000 * 60 * 30;
		System.out.println(" ssreturning from Load info");
		logger.log(Level.SEVERE,"XML is "+xml.message);
		logger.log(Level.SEVERE,"returning from Load info");
		
		
		java.io.FileWriter fw = new java.io.FileWriter("test1.xml");
	    fw.write(xml.message);
	    fw.close();
	    
	    
		
		
		return confirmation;
	}
	
	
	@RequestMapping(value = "/oozie", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<OozieBean> handleRequestoozie()
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		
		return query.fetchOozieJobDetails("2016-11-21 00:00:00","2016-11-21 00:59:59");
		
	}
	
}
