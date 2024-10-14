package serviceImpU;

import java.sql.Date;
import java.sql.Time;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Timer;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import daoUImpl.thoiKhoaBieuDao;
import daoUImpl.timelineDao;
import model.nguoiDung;
import model.thoiGianTrongNgay;
import model.thoiKhoaBieu;
import serviceIUser.timelineService;

public class timelineServiceImp implements timelineService {

	public List<thoiGianTrongNgay> listAll(nguoiDung u) {
		return new timelineDao().selectAll(u);
	}
	public boolean delete(nguoiDung u, int id) {
		return new timelineDao().delete(u, id);
	}
	public boolean complete(nguoiDung u, int id) {
		return new timelineDao().complete(u, id);
	}
	public thoiGianTrongNgay oneById(int id) {
		List<thoiGianTrongNgay> rs = new timelineDao().selectOne(id);
		return rs.get(rs.size()-1);
	}
	public boolean resetAll() {
		return new timelineDao().resetAll();
	}
	public boolean checkEdit(nguoiDung u, thoiGianTrongNgay tg) {
		List<thoiGianTrongNgay> listAll = new timelineDao().selectAll(u);
		thoiGianTrongNgay is = oneById(tg.getIdThoiGianTrongNgay());
		boolean flag = false;
		if(listAll.size()>0) {
			thoiGianTrongNgay last = listAll.get(listAll.size()-1);
			if(last.equals(is)) {
				last = listAll.get(listAll.size()-2);
			}
			if(tg.getThoiGianBatDau().compareTo(last.getThoiGianKetThuc())>0) {
				flag = new timelineDao().update(u, tg);
			}
			Time temp = null;
			if(!flag) {
				for (thoiGianTrongNgay lists : listAll) {
					if(!lists.equals(is)) {
						if(tg.getThoiGianKetThuc().compareTo(lists.getThoiGianBatDau())<0) {
							if(temp==null) {
								flag = new timelineDao().update(u, tg);
							}else {
								if(tg.getThoiGianBatDau().compareTo(temp)>0) {
									flag = new timelineDao().update(u, tg);
								}
							}
						}else {
							temp = lists.getThoiGianKetThuc();
						}
					}
					if(flag==true) {
						break;
					}
				}
			} 
		}
		return flag;
	}
	public boolean resetList(nguoiDung u, List<thoiGianTrongNgay> tg) {
		return new timelineDao().resetList(u, tg);
	}
	public void resetListz(nguoiDung u,List<thoiGianTrongNgay> tg) {
		   try {
	            // Kiểm tra xem lịch trình đã tồn tại hay chưa
	            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
	            Scheduler scheduler = schedulerFactory.getScheduler();

	            if (!scheduler.isStarted()) {
	                // Nếu lịch trình chưa tồn tại hoặc đã dừng, thì tạo và cấu hình mới
	                // (Bạn cũng có thể lưu trữ thông tin về lịch trình ở một nơi khác để kiểm tra)

	                // Tạo công việc
	            	resetTimeline rst = new resetTimeline();
	            	rst.setU(u);
	            	rst.setList(tg);
	                JobDetail job = JobBuilder.newJob(resetTimeline.class)
	                        .withIdentity("resetJob", "group1")
	                        .build();  // Sử dụng build() để tạo JobDetail từ JobBuilder

	                // Tạo lịch trình trigger bằng cách sử dụng biểu thức cron
	                Trigger trigger = TriggerBuilder.newTrigger()
	                        .withIdentity("resetTrigger", "group1")
	                        .withSchedule(CronScheduleBuilder.cronSchedule("57 23 0 * * ?")) // Lên lịch hàng ngày lúc 00:00:00
	                        .build();
	                // Tạo và cấu hình Scheduler
	                scheduler.start();
	                scheduler.scheduleJob(job, trigger);
	            }
	        } catch (SchedulerException e) {
	            e.printStackTrace();
	        }
	}
	public boolean checkAdd(nguoiDung u, thoiGianTrongNgay tg) {
		List<thoiGianTrongNgay> listAll = listAll(u);
		Time temp = null;
		boolean flag = false;
		int check = 0;
		thoiGianTrongNgay last = null;
			if(listAll.size()>0) {
				last  = listAll.get(listAll.size()-1);
			if(last!=null) {
				if(tg.getThoiGianBatDau().compareTo(last.getThoiGianKetThuc())>0) {
					check = new timelineDao().addOne(u, tg);
					if(check>0) {
						flag = true;
						return flag;
					}
				}
			}
			if(!flag) {
				for (thoiGianTrongNgay tl : listAll) {
					if(tg.getThoiGianKetThuc().compareTo(tl.getThoiGianBatDau())<0) {
						if(temp==null) {
							check = new timelineDao().addOne(u, tg);
							if(check>0) {
								flag = true;
							}
						}else {
							if(tg.getThoiGianBatDau().compareTo(temp)>0) {
								check = new timelineDao().addOne(u, tg);
								if(check>0) {
									flag = true;
								}
							}
						}
					}else {
						temp = tl.getThoiGianKetThuc();
					}
					if(flag) {
						break;
					}
				}
		}
		}else {
			check = new timelineDao().addOne(u, tg);
			if(check>0) {
				flag = true;
			}
		}
		return flag;
	}
	public static void main(String[] args) {
	}
	public List<thoiGianTrongNgay> listOfComplete(int idUser) {
		return new timelineDao().listComplete(idUser);
	}
}
