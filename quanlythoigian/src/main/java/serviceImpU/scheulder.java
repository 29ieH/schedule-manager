package serviceImpU;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class scheulder {
	private Scheduler scheduler;
	public void setup() throws SchedulerException {

	        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
	        this.scheduler = schedulerFactory.getScheduler();
	   
	        Scheduler scheduler = schedulerFactory.getScheduler();
	    
	        JobDetail jobDetail = JobBuilder.newJob(myJob.class)
	                .withIdentity("myJob", "group1")
	                .build();
	      
	        Trigger trigger = TriggerBuilder.newTrigger()
	                .withIdentity("myTrigger", "group1")
	                .startNow()
	                .withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(0, 0))
	                .build();
	    
//	        scheduler.scheduleJob(jobDetail, trigger);
//	        JobDetail jobDetail2 = JobBuilder.newJob(myJobSentEmail.class)
//	        		.withIdentity("myJob2","group1")
//	        		.build();
//	        Trigger trigger2 = TriggerBuilder.newTrigger()
//	        		.withIdentity("myTrigger2","group1")
//	        		.withSchedule(SimpleScheduleBuilder.repeatSecondlyForever())
//	        		.build();
//	        scheduler.scheduleJob(jobDetail2, trigger2);
	 
	        scheduler.start();
	 }
	public Scheduler getScheduler() {
		return this.scheduler;
	}
}
