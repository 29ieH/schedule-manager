package serviceImpU;

import java.sql.Time;
import java.util.List;

import daoUImpl.thoiKhoaBieuDao;
import model.nguoiDung;
import model.thoiKhoaBieu;
import serviceIUser.thoiKhoaBieuService;

public class thoiKhoaBieuServiceImp implements thoiKhoaBieuService {
	public thoiKhoaBieu oneById(int id) {
		List<thoiKhoaBieu> result = new thoiKhoaBieuDao().selecOfId(id);
		return result.get(0);
	}
	public boolean checkUpdate(String thu,String noiDung, Time tgbd, Time tgkt, int id, nguoiDung u) {
		List<thoiKhoaBieu> listOfDay = new thoiKhoaBieuDao().listOfDay(u, thu);
		thoiKhoaBieu is = oneById(id);
		boolean flag = false;
		if(listOfDay.size()>0) {
			thoiKhoaBieu last = listOfDay.get(listOfDay.size()-1);
			if(last.equals(is)&&listOfDay.size()==1) {
				flag = new thoiKhoaBieuDao().updateThoiKhoaBieu(noiDung, tgbd, tgkt, id, u);
				if(flag) {
					return flag;
				}
			}
			if(last.equals(is)) {
				thoiKhoaBieu klast = listOfDay.get(listOfDay.size()-2);
				if(tgbd.compareTo(klast.getThoiGianKetThuc())>0) {
					flag = new thoiKhoaBieuDao().updateThoiKhoaBieu(noiDung, tgbd, tgkt, id, u);
					if(flag) {
						return flag;
					}
				}
			}
			if(tgbd.compareTo(last.getThoiGianKetThuc())>0) {
				flag = new thoiKhoaBieuDao().updateThoiKhoaBieu(noiDung, tgbd, tgkt, id, u);
			}
			Time temp = null;
			if(!flag) {
				for (thoiKhoaBieu lists : listOfDay) {
					if(!lists.equals(is)) {
						if(tgkt.compareTo(lists.getThoiGianBatDau())<0) {
							if(temp==null) {
								flag = new thoiKhoaBieuDao().updateThoiKhoaBieu(noiDung, tgbd, tgkt, id, u);
							}else {
								if(tgbd.compareTo(temp)>0) {
									flag = new thoiKhoaBieuDao().updateThoiKhoaBieu(noiDung, tgbd, tgkt, id, u);
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
	public List<thoiKhoaBieu> listOfDayS(nguoiDung u, String day) {
		return new thoiKhoaBieuDao().listOfDayS(u, day);
	}
	public List<thoiKhoaBieu> listOfDayC(nguoiDung u, String day) {
		return new thoiKhoaBieuDao().listOfDayC(u, day);
	}
	public int addOne(nguoiDung u, String thu, String noiDung, Time thoiGianBatDau, Time thoiGianKetThuc) {
		return new thoiKhoaBieuDao().addOne(u, thu, noiDung, thoiGianBatDau, thoiGianKetThuc);
	}
	public boolean deleteLich(nguoiDung u, int id) {
		return new thoiKhoaBieuDao().deleteLich(u, id);
	}
	public boolean checkDangKy(nguoiDung u,String thu,String noiDung,Time tgbd, Time tgkt) {
		List<thoiKhoaBieu> listOfDay = new thoiKhoaBieuDao().listOfDay(u, thu);
		Time temp = null;
		boolean flag = false;
		int check = 0;
		thoiKhoaBieu last = null;
			if(listOfDay.size()>0) {
				last  = listOfDay.get(listOfDay.size()-1);
			if(last!=null) {
				if(tgbd.compareTo(last.getThoiGianKetThuc())>0) {
					check = addOne(u, thu, noiDung, tgbd, tgkt);
					if(check>0) {
						flag = true;
						return flag;
					}
				}
			}
			if(!flag) {
				for (thoiKhoaBieu tkb : listOfDay) {
					if(tgkt.compareTo(tkb.getThoiGianBatDau())<0) {
						if(temp==null) {
							check =  addOne(u, thu, noiDung, tgbd, tgkt);
							if(check>0) {
								flag = true;
							}
						}else {
							if(tgbd.compareTo(temp)>0) {
							check = addOne(u, thu, noiDung, tgbd, tgkt);
							if(check>0) {
								flag = true;
								}
							}
						}
					}else {
						temp = tkb.getThoiGianKetThuc();
					}
					if(flag) {
						break;
					}
				}
		}
		}else {
			check = addOne(u, thu, noiDung, tgbd, tgkt);
			if(check>0) {
				flag = true;
			}
		}
		return flag;
	}

public static void main(String[] args) {
	nguoiDung us = new nguoiDung();
	us.setIdNguoiDung(2);
	List<thoiKhoaBieu> list = new thoiKhoaBieuServiceImp().listOfDayC(us, "Thứ 2");
	System.out.println(list);
	}
}
