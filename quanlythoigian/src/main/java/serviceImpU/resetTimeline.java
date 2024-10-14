package serviceImpU;

import java.util.List;
import java.util.TimerTask;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import model.nguoiDung;
import model.thoiGianTrongNgay;

public class resetTimeline implements Job {
	private nguoiDung u;
	private List<thoiGianTrongNgay> list;
	public resetTimeline() {}
	public resetTimeline(nguoiDung u,List<thoiGianTrongNgay> list) {
		this.u = u;
		this.list = list;
	}
	
	
	public nguoiDung getU() {
		return u;
	}

	public void setU(nguoiDung u) {
		this.u = u;
	}

	public List<thoiGianTrongNgay> getList() {
		return list;
	}

	public void setList(List<thoiGianTrongNgay> list) {
		this.list = list;
	}
	public void execute(JobExecutionContext context) throws JobExecutionException {
			boolean check = new timelineServiceImp().resetList(u, list);
			if(check) {
				System.out.println("Ok");
			}else {
				System.out.println("No");
			}
	}

}
