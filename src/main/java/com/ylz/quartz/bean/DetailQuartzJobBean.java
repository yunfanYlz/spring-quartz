package com.ylz.quartz.bean;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 
 * 定时任务代理类
 * <功能详细描述>
 * 
 */
@DisallowConcurrentExecution// 不允许并发执行  
public class DetailQuartzJobBean extends QuartzJobBean
{
	private static final Log logger = LogFactory.getLog(DetailQuartzJobBean.class);
	
    private ApplicationContext applicationContext;
    
    private String targetObject;
    
    private String targetMethod;
    
    public String getTargetObject()
    {
        return targetObject;
    }
    
    public void setTargetObject(String targetObject)
    {
        this.targetObject = targetObject;
    }
    
    public String getTargetMethod()
    {
        return targetMethod;
    }
    
    public void setTargetMethod(String targetMethod)
    {
        this.targetMethod = targetMethod;
    }
    
    public ApplicationContext getApplicationContext()
    {
        return applicationContext;
    }
    
    /** 
      * 从SchedulerFactoryBean注入的applicationContext. 
      */
    public void setApplicationContext(ApplicationContext applicationContext)
    {
        this.applicationContext = applicationContext;
    }
    
    @Override
    protected void executeInternal(JobExecutionContext ctx)
        throws JobExecutionException
    {
        try
        {
        	if (logger.isInfoEnabled()) {
        		logger.info("execute [" + targetObject + "] at once>>>>>>"); 
			}
            Object otargetObject = applicationContext.getBean(targetObject);
            Method m = null;
            m = otargetObject.getClass().getMethod(targetMethod, new Class[] {});
            m.invoke(otargetObject, new Object[] {});
        }
        catch (Exception e)
        {
        	if (logger.isErrorEnabled()) {
        		logger.error("proxy quartz bean run in error because of " + e.getMessage(), e);
			}
            throw new JobExecutionException(e);
        }
    }
}
