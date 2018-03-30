package util;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Enumeration;
import java.util.EventListener;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.SessionCookieConfig;
import javax.servlet.SessionTrackingMode;
import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.descriptor.JspConfigDescriptor;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class Quartz {
	private static Scheduler sc;
	public static void activateCycleCrawler() throws SchedulerException{
		System.out.println("activateCycleCrawler()");
		JobDetail job =JobBuilder.newJob(QuartzJob.class).build();
		Trigger t1 = TriggerBuilder.newTrigger().withIdentity("CronTrigger").withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * 1/1 * ? *")).build();
		sc = StdSchedulerFactory.getDefaultScheduler();
		sc.scheduleJob(job, t1);
		sc.start();
	}
	
	public static void stopCycleCrawler() throws SchedulerException {
		System.out.println("stopCycleCrawler()");
		if (sc != null) {
			sc.shutdown();
		}
	}
}
