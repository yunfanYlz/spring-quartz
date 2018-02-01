/*
 * 文 件 名:  AccountSettlementJob.java
 * 版    权:  ETOC 信息技术有限公司, Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  Administrator
 * 修改时间:  2015-1-8
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ylz.quartz;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

  
@Component(value = "MyQuartzJob")
public class MyQuartzJob{
	
	private Logger log = Logger.getLogger(MyQuartzJob.class);
	
	public void execute() throws JobExecutionException {
		log.info("MyQuartzJob Start");
		System.out.println("好无聊啊，每分钟一条");
		log.info("好无聊啊，每分钟一条");
		log.info("MyQuartzJob End");
	}
	
	
	public static void main(String[] args) {
		for(int i = 1;i <= 100 ; i ++){
//			int r = (int)( Math.random());
			System.out.println(Math.random());
		}
		
/*		double d = 9.90;
		System.out.println((int) d);*/
	}

}
