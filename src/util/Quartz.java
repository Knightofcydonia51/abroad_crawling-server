package util;

import org.quartz.*;

public class Quartz implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		//여기서 5분마다 setattribute
	}
	
	
}
