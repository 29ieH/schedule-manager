package serviceImpU;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import fake.dateFake;
import model.lich;

public class Util {
	
	public int convertDay(Date date) {
		LocalDate localDate = date.toLocalDate();
		return localDate.getDayOfMonth();
	}
	public int convertMonth(Date date) {
		LocalDate localDate = date.toLocalDate();
		return localDate.getMonthValue();
	}
	public int convertYear(Date date) {
		LocalDate localDate = date.toLocalDate();
		return localDate.getYear();
	}
	public int getDayOfMonth(int month,int year) {
		int result = 0;
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:{
			result = 31;
			break;
		}
		case 4:
		case 6:
		case 9:
		case 11:{
			result = 30;
			break;
		}
		case 2:{
			if((year%4==0&&year%100!=0)||(year%400==0)) {
				result = 29;
			}else {
				result = 28;
			}
			break;
		}
			
		default:
			result = 0;
			break;
		}
		return result;
	}
	public List<lich> listRepeat(int repeat,lich lich){
		int day = lich.getNgay();
		int month = lich.getThang();
		int year = lich.getNam();
		int currentDay = new Util().getDayOfMonth(month, year);
		List<lich> result = new ArrayList<lich>();
		lich newLich = new lich();
		newLich.setNgay(day);
		newLich.setThang(month);
		newLich.setNam(year);
		newLich.setTenSuKien(lich.getTenSuKien());
		newLich.setNoiDung(lich.getNoiDung());
		newLich.setThoiGianBatDau(lich.getThoiGianBatDau());
		newLich.setThoiGianKetThuc(lich.getThoiGianKetThuc());
		result.add(newLich);
		for (int i = 0; i < repeat-1; i++) {
			if(day+7>currentDay&&month<12) {
				month+=1;
				int dayOld = currentDay - day;
				int dayNew = 7 - dayOld;
				lich newLich1 = new lich();
				newLich1.setNgay(dayNew);
				newLich1.setThang(month);
				newLich1.setNam(year);
				newLich1.setTenSuKien(lich.getTenSuKien());
				newLich1.setNoiDung(lich.getNoiDung());
				newLich1.setThoiGianBatDau(lich.getThoiGianBatDau());
				newLich1.setThoiGianKetThuc(lich.getThoiGianKetThuc());
				result.add(newLich1);
				currentDay = new Util().getDayOfMonth(month, year);
				day = dayNew;
			}else if(day+7>currentDay&&month==12) {
				year = year+1;
				int dayOld = currentDay-day;
				int dayNew = 7 - dayOld;
				month = 1;
				lich newLich1 = new lich();
				newLich1.setNgay(dayNew);
				newLich1.setThang(month);
				newLich1.setNam(year);
				newLich1.setTenSuKien(lich.getTenSuKien());
				newLich1.setNoiDung(lich.getNoiDung());
				newLich1.setThoiGianBatDau(lich.getThoiGianBatDau());
				newLich1.setThoiGianKetThuc(lich.getThoiGianKetThuc());
				result.add(newLich1);
				day = dayNew;
				currentDay = new Util().getDayOfMonth(month, year);
				System.out.println(day+" "+month+" "+year);
			}else if(day+7<currentDay) {
				int daynew = day+7;
				lich newLich1 = new lich();
				newLich1.setNgay(daynew);
				newLich1.setThang(month);
				newLich1.setNam(year);
				newLich1.setTenSuKien(lich.getTenSuKien());
				newLich1.setNoiDung(lich.getNoiDung());
				newLich1.setThoiGianBatDau(lich.getThoiGianBatDau());
				newLich1.setThoiGianKetThuc(lich.getThoiGianKetThuc());
				result.add(newLich1);
				day = daynew;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		lich l = new lich();
		l.setNgay(29);
		l.setThang(12);
		l.setNam(2023);
		l.setTenSuKien("Da bong");
		l.setNoiDung("Da bong vs may th e");
		l.setThoiGianBatDau(Time.valueOf("12:30:00"));
		l.setThoiGianKetThuc(Time.valueOf("13:30:00"));
		List<lich> result = new Util().listRepeat(6, l);
		for (lich lich : result) {
			System.out.println(lich);
		}
	}
 
}
