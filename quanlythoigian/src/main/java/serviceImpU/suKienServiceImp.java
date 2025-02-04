package serviceImpU;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import daoUImpl.suKienDao;
import model.nguoiDung;
import model.suKien;
import serviceIUser.suKienService;

public class suKienServiceImp implements suKienService {
	public suKien selectByID(nguoiDung u, int id) {
		List<suKien> byId = new suKienDao().byId(u, id); 
		return byId.get(0);
	}

	public List<suKien> listUuTien(nguoiDung u,String myDate) {
		return new suKienDao().listUuTien(u,myDate);
	}

	public List<suKien> listAll(nguoiDung u) {
		return new suKienDao().listAll(u);
	}

	public List<suKien> listOfType(nguoiDung u, String myDate, String type) {
		return new suKienDao().listOfType(u, myDate, type);
	}

	public List<suKien> listOfDay(nguoiDung u, String myDate) {
		return new suKienDao().listOfDay(u, myDate);
	}
	public List<suKien> listOfName(nguoiDung u, String name) {
		return new suKienDao().listOfName(u, name) ;
	}
	public int checkAdd(nguoiDung u, suKien e) {
		int flag = 0;
		int check = 0;
		LocalDate current = LocalDate.now();
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String date = current.format(f);
		Date myDate = Date.valueOf(date);
		if(e.getNgayDienRaSuKien().compareTo(myDate)<0) {
			return flag;
		}else if(e.getNgayDienRaSuKien().compareTo(myDate)==0) {
			List<suKien> listOfDay = new suKienDao().listOfDay(u, date);
			if(listOfDay.size()>0) {
				suKien last = listOfDay.get(listOfDay.size()-1);
				if(e.getThoiGianBatDau().compareTo(last.getThoiGianKetThuc())>0) {
					check = new suKienDao().addOne(u, e);
					if(check!=0) {
						flag = 1;
						return flag;
					}
				}
				if(flag==0) {
					Time temp = null;
					for (suKien sk : listOfDay) {
						if(e.getThoiGianKetThuc().compareTo(sk.getThoiGianBatDau())<0) {
							if(temp==null) {
								check = new suKienDao().addOne(u, e);
								if(check!=0) {
									flag = 1;
								}
							}else {
								if(e.getThoiGianBatDau().compareTo(temp)>0) {
									check = new suKienDao().addOne(u, e);
									if(check!=0) {
										flag = 1;
									}
								}
							}
						}else {
							temp = sk.getThoiGianKetThuc();
						}
						if(flag==1) {
							break;
						}
					}
				}
			}else {
				check = new suKienDao().addOne(u, e);
				if(check!=0) {
					flag = 1;
					return flag;
				}
			}
		}else if (e.getNgayDienRaSuKien().compareTo(myDate)>0){
			SimpleDateFormat fd = new SimpleDateFormat("yyyy-MM-dd");
			String dayPresent = fd.format(e.getNgayDienRaSuKien());
			List<suKien> listOfDay = new suKienDao().listOfDay(u, dayPresent);
			if(listOfDay.size()>0) {
				suKien last = listOfDay.get(listOfDay.size()-1);
				if(e.getThoiGianBatDau().compareTo(last.getThoiGianKetThuc())>0) {
					check = new suKienDao().addOne(u, e);
					if(check!=0) {
						flag = 1;
					}
				}
				if(flag==0) {
					Time temp = null;
					for (suKien sk : listOfDay) {
						if(e.getThoiGianKetThuc().compareTo(sk.getThoiGianBatDau())<0) {
							if(temp==null) {
								check = new suKienDao().addOne(u, e);
								if(check!=0) {
									flag = 1;
								}
							}else {
								if(e.getThoiGianBatDau().compareTo(temp)>0) {
									check = new suKienDao().addOne(u, e);
									if(check!=0) {
										flag = 1;
									}
								}
							}
						}else {
							temp = sk.getThoiGianKetThuc();
						}
						if(flag==1) {
							break;
						}
					}
				}
			}else {
				check = new suKienDao().addOne(u, e);
				if(check!=0) {
					flag = 1;
					return flag;
				}
			}
		}
		return flag;
	}
	public boolean checkUpdate(nguoiDung u, suKien e) {
		boolean flag = false;
		int check = 0;
		suKien is = selectByID(u, e.getIdSuKien());
		LocalDate current = LocalDate.now();
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String date = current.format(f);
		Date myDate = Date.valueOf(date);
		if(e.getNgayDienRaSuKien().compareTo(myDate)<0) {
			return flag;
		}else if(e.getNgayDienRaSuKien().compareTo(myDate)==0) {
			List<suKien> listOfDay = new suKienDao().listOfDay(u, date);
			if(listOfDay.size()>0) {
				suKien last = listOfDay.get(listOfDay.size()-1);
				if(listOfDay.size()==1&&is.equals(last)) {
					flag = new suKienDao().update(u, e);
					if(flag) {
						return flag;
					}
				}
				if(listOfDay.size()>1) {
					if(last.equals(is)) {
						last = listOfDay.get(listOfDay.size()-2);
					}
					if(e.getThoiGianBatDau().compareTo(last.getThoiGianKetThuc())>0) {
						flag = new suKienDao().update(u, e);
						if(flag) {
							return flag;
						}
					}
				}
				
				if(!flag) {
					Time temp = null;
					for (suKien sk : listOfDay) {
						if(!sk.equals(is)) {
							if(e.getThoiGianKetThuc().compareTo(sk.getThoiGianBatDau())<0) {
								if(temp==null) {
									flag = new suKienDao().update(u, e);
								}else {
									if(e.getThoiGianBatDau().compareTo(temp)>0) {
										flag = new suKienDao().update(u, e);
									}
								}
							}else {
								temp = sk.getThoiGianKetThuc();
							}
							if(flag) {
								break;
							}
						}
					}
				}
			}else {
				flag = new suKienDao().update(u, e);
				if(flag) {
					return flag;
				}
			}
		}
		return flag;
	}
	public boolean delete(nguoiDung u, int id) {
		return new suKienDao().delete(u, id);
	}
	public List<suKien> listBeforeDay(nguoiDung u, int offset, int maxItemsPage) {
		return new suKienDao().listBEvent(u, offset, maxItemsPage) ;
	}
	public int totalItemsBeforeDay(nguoiDung u) {
		return new suKienDao().totalItemsBeforeDay(u);
	}
	public static void main(String[] args) {
		nguoiDung u = new nguoiDung();
		u.setIdNguoiDung(2);
//		LocalDate current = LocalDate.now();
//		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		String myDate = current.format(format);
//		suKien sk = new suKien();
//		sk.setIdSuKien(20);
//		sk.setTenSuKien("Báo cáo đồ án");
//		sk.setMoTaNgan("Báo cáo đồ án");
//		sk.setNgayDienRaSuKien(Date.valueOf("2023-11-9"));
//		sk.setThoiGianBatDau(Time.valueOf("14:00:00"));
//		sk.setThoiGianKetThuc(Time.valueOf("16:30:00"));
//		sk.setDiaDiem("Trường Đại Học Sư Phạm");
//		sk.setHenGioTruocSuKien(20);
//		sk.setNhungNguoiThamGia("");
//		sk.setLoaiSuKien("Học Tập");
//		sk.setSuKienUuTien(0);
//		boolean check = false;
//		check = new suKienServiceImp().checkUpdate(u, sk);
//		if(check) {
//			System.out.println("Ok");
//		}else {
//			System.out.println("Cook");
//		}
//		int count = new suKienServiceImp().totalItemsBeforeDay(u);
//		System.out.println(count);
		String name = "%Làm%";
		List<suKien> result = new suKienServiceImp().listOfName(u, name);
		System.out.println(result);
	}

	public List<suKien> All() {
		return new suKienDao().All();
	}


}

