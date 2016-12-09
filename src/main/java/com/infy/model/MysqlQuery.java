package com.infy.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.oozie.client.OozieClient;
import org.springframework.stereotype.Service;


@Service
public class MysqlQuery {
	
	Connection con;
	
	@PostConstruct
	private void init() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");

	   

	}

	public List<OozieBean> fetchOozieJobDetails(String startTime, String endTime) throws ClassNotFoundException, SQLException {

	
		List<OozieBean> oozieBeans = new ArrayList<OozieBean>();

		Statement stmt = con.createStatement();

		StringBuilder query = new StringBuilder();
		query.append("select id,status,start_time,IFNULL(TIMEDIFF(end_time,start_time),0) as duration from WF_JOBS where DATE(last_modified_time) BETWEEN DATE(\"");
		query.append(startTime+"\")");
		query.append(" AND DATE(\"");
		query.append(endTime+"\")");
		
		ResultSet rs = stmt.executeQuery(query.toString());
		
		while(rs.next())  {
		
			OozieBean bean = new OozieBean();
			bean.setOozieId(rs.getString(1));
			bean.setStatus(rs.getString(2));
			bean.setStartDate(rs.getString(3));
			bean.setDuration(rs.getString(4));
			bean.setOwner("yodlees");
			
			oozieBeans.add(bean);
			
			System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3) +"  "+rs.getString(4));  
		}
		return oozieBeans;

	}

}
