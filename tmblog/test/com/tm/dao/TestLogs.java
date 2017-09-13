package com.tm.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TestLogs {

	Log log = LogFactory.getLog(this.getClass());
	
	public void teston(){
		log.info("进入了这个方法");
		
		try {
			int t = 9/0;
			System.out.println(t);
		} catch (RuntimeException e) {
			log.error(e.getMessage());
		}
		
		log.info("执行完了这个方法");
	}
	
	public static void main(String[] args) {
		TestLogs testLogs = new TestLogs();
		testLogs.teston();
	}
}
