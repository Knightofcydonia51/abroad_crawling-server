package util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

//server 시작시 해당 프로젝트의 모든 설정 및 소스가 문제 없다가 인지가 되면 자동 실행되는 클래스
// server만이 호출
@WebListener

//interface JobInterface{
//	public class QuartzJob implements Job{
//
//		@Override
//		public void execute(JobExecutionContext context) throws JobExecutionException {
//			
//		}
//		
//	}
//}

public class CrawlerDataSave implements ServletContextListener {
	
	//서버 시작되면서 단 한번 호출 하는 생성자
    public CrawlerDataSave() {
    	System.out.println("CrawlerDataSave 생성자");
    }
    
    //해당 웹 프로젝트가 정상 실행 가능한 시점에 서버가 자동 호출
    //모든 user 가 공유하는 자원이 있을 경우 공유자원 저장 용도로 주로 자용
    public void contextInitialized(ServletContextEvent arg0)  {
    	System.out.println("CrawlerDataSave 초기메소드");
    	
    	ServletContext context = arg0.getServletContext();
    	try {
			context.setAttribute("crawling", Crawler.allBank());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    //서버 다운시 자동 호출 : 공유 자원 반환
    public void contextDestroyed(ServletContextEvent arg0)  { 
    }
  
}


