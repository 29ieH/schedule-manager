package controllerU;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

import model.thoiGianTrongNgay;
import serviceImpU.emailServiceImp;
import serviceImpU.scheulder;

@WebListener
public class myListener implements ServletContextListener {
	private Scheduler scheduler;
	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		scheulder sch = new scheulder();
		emailServiceImp email = new emailServiceImp();
		try {
//			email.send(context);
			sch.setup();
			this.scheduler = sch.getScheduler();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	public void contextDestroyed(ServletContextEvent event) {
		try {
			if (scheduler!=null) {
				scheduler.shutdown();
			}
			 // Hủy đăng ký trình điều khiển JDBC khi ứng dụng web bị dừng
	        Enumeration<Driver> drivers = DriverManager.getDrivers();
	        while (drivers.hasMoreElements()) {
	          Driver driver = drivers.nextElement();
	          DriverManager.deregisterDriver(driver); 
	       }
		} catch (SchedulerException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
}
