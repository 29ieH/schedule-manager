package serviceImpU;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class myJob implements Job {

	public void execute(JobExecutionContext context) throws JobExecutionException {
		timelineServiceImp serviceT = new timelineServiceImp();
		boolean check = serviceT.resetAll();
		if(check) {
			System.out.println("Ok");
		}else {
			System.out.println("Cook");
		}
	}
}
