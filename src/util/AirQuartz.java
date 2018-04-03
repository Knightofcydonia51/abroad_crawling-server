package util;

import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServlet;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;

//server 시작시 해당 프로젝트의 모든 설정 및 소스가 문제 없다가 인지가 되면 자동 실행되는 클래스
// server만이 호출
public class AirQuartz extends HttpServlet implements Job {
	//서버 시작되면서 단 한번 호출 하는 생성자
    public AirQuartz (){ }
    
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println(new Date());
    	try {    		
    		ServletContext airSc = (ServletContext) context.getScheduler().getContext().get("servletContext");
    		airSc.setAttribute("Airport", Airport.airport());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}