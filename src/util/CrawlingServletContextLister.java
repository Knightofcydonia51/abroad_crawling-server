package util;

import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.quartz.SchedulerException;

/**
 * Servlet implementation class servletContextLister
 */
@WebListener
public class CrawlingServletContextLister implements ServletContextListener {
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("contextDestroyed");
		try {
			Quartz.stopCycleCrawler();
			Quartz.stopAirportCrawler();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("contextInitialized");
		try {
			Quartz.activateCycleCrawler();
			Quartz.airportCycleCrawler();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
}
