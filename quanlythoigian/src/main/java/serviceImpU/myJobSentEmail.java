package serviceImpU;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import model.suKien;

public class myJobSentEmail  implements Job {
	private List<suKien> listEvent = new suKienServiceImp().All() ;
	public void execute(JobExecutionContext context) throws JobExecutionException {
		DateTimeFormatter fDay = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter tDay = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDate currentDate = LocalDate.now();
		LocalTime currentTime = LocalTime.now();
		Date getDate = Date.valueOf(new String(currentDate.format(fDay)));
		Time getTime = Time.valueOf(new String(currentTime.format(tDay)));
		for (suKien suKien : listEvent) {
			if(suKien.getNgayDienRaSuKien().compareTo(getDate)==0) {
				LocalTime current = suKien.getThoiGianBatDau().toLocalTime();
				List<Integer> convert = new myJobSentEmail().convert(suKien.getHenGioTruocSuKien());
				if(convert.size()>=2) {
					LocalTime bf = current.minusHours(convert.get(0)).minusMinutes(convert.get(1));
					Time timeSentEmail = Time.valueOf(bf);
					if(timeSentEmail.compareTo(getTime)==0) {
						new emailServiceImp().sendNofication(suKien); 
					}
				}else {
					LocalTime bf = current.minusMinutes(convert.get(0));
					Time timeSentEmail = Time.valueOf(bf);
					if(timeSentEmail.compareTo(getTime)==0) {
						new emailServiceImp().sendNofication(suKien);
					}
				}
			}
		}
	}
	public List<Integer> convert(int time) {
		List<Integer> listResult = new ArrayList<Integer>();
		int current = time;
		while(current>0) {
			int s = current%10;
			listResult.add(s);
			current = current/10;
		}
		if(listResult.size()>=3) {
			String x = listResult.get(1)+""+listResult.get(0);
			String y;
			if(listResult.size()>3) {
				y = listResult.get(3)+""+listResult.get(2);
			}else {
				y = ""+listResult.get(2);
			}
			int h = Integer.parseInt(y);
			int m = Integer.parseInt(x);
			listResult.clear();
			listResult.add(0, h);
			listResult.add(1,m);
		}
		return listResult;
	}
}
