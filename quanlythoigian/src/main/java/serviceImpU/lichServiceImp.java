package serviceImpU;

import java.sql.Time;
import java.util.List;

import daoUImpl.lichDao;
import model.lich;
import serviceIUser.lichService;

public class lichServiceImp implements lichService {
	public List<lich> listAllOfUser(int idUser) {
		return new lichDao().listOfUser(idUser);
	}
	public int addLich(int idUser, lich newlich) {
		return new lichDao().addLich(idUser, newlich);
	}
	public List<lich> listOfDMY(int idUser, int day, int month, int year) {
		// TODO Auto-generated method stub
		return new lichDao().listOfDMY(idUser, day, month, year);
	}
	public String notifiAdd(int idUser, lich lich,int repeat) {
		String notifi = "";
		boolean check = true;
		List<lich> listOfRepeat = new Util().listRepeat(repeat, lich);
		for (lich lichOfRepeat : listOfRepeat) {
			check = new lichServiceImp().checkAdd(idUser, lichOfRepeat);
			if(!check) {
				String error = "Sự kiện "+lichOfRepeat.getTenSuKien()+" Ngày : "+lichOfRepeat.getNgay()+" Tháng : "
						+lichOfRepeat.getThang()+" Năm : "+lichOfRepeat.getNam() + " - Đã có sự kiện khác trùng thời gian diễn ra";
				notifi += "\n"+error+"\n";
				error = "";
			}
		}
		return notifi;
	}
	public boolean checkAdd(int idUser,lich lich) {
		boolean rs = false;
		List<lich> result = new lichServiceImp().listOfDMY(idUser, lich.getNgay(), lich.getThang(), lich.getNam());
		if(result.size()<=0) {
			int check = 0;
			check = new lichServiceImp().addLich(idUser, lich);
			if(check!=0) {
				rs = true;
				return rs;
			}
		}else {
			lich end = result.get(result.size()-1);
			if(lich.getThoiGianBatDau().compareTo(end.getThoiGianKetThuc())>0) {
				int check = 0;
				check = new lichServiceImp().addLich(idUser, lich);
				if(check!=0) {
					rs = true;
					return rs;
				}
			}
			Time temp = null;
			int check = 0;
			for (lich lichCheck : result) {
				if(lich.getThoiGianKetThuc().compareTo(lichCheck.getThoiGianBatDau())<0) {
					if(temp==null) {
						check = new lichServiceImp().addLich(idUser, lich);
						if(check!=0) {
							rs = true;
						}
					}else {
						if(lich.getThoiGianBatDau().compareTo(temp)>0) {
							check = new lichServiceImp().addLich(idUser, lich);
							if(check!=0) {
								rs = true;
							}
						}
					}
				}else {
					temp = lichCheck.getThoiGianKetThuc();
				}
				if(rs) {
					break;
				}
			}
			
		}
		return rs;
	}
	public lich LichOfId(int idUser, int idLich) {
		List<lich> rs = new lichDao().listOfId(idUser, idLich);
		if(rs.size()!=0) {
			return rs.get(0);
		}
		return null;
	}
	public boolean checkUpdate(int idUser, lich lich) {
		boolean check = false;
		lich is = new lichDao().getById(lich.getIdLich());
		List<lich> listOfDMY = new lichDao().listOfDMY(idUser, lich.getNgay(), lich.getThang(), lich.getNam());
		int length = listOfDMY.size();
		if(length>0) {
			lich last = listOfDMY.get(length-1);
			if(last.equals(is)&&length==1) {
				check = new lichDao().updateCalendar(idUser, lich);
				if(check) {
					return check;
				}
			}
			if(last.equals(is)) {
				lich klcih = listOfDMY.get(length-2);
				if(lich.getThoiGianBatDau().compareTo(klcih.getThoiGianKetThuc())>0) {
					check = new lichDao().updateCalendar(idUser, lich);
					if(check) {
						return check;
					}
				}
			}
		
		if(lich.getThoiGianBatDau().compareTo(last.getThoiGianKetThuc())>0) {
			check = new lichDao().updateCalendar(idUser, lich);
			if(check) {
				return check;
			}
		}
		if(!check) {
				Time temp = null;
				for (lich lichCurrent : listOfDMY) {
					if(!lichCurrent.equals(is)) {
						if(lich.getThoiGianKetThuc().compareTo(lichCurrent.getThoiGianBatDau())<0){
							if(temp==null) {
								check = new lichDao().updateCalendar(idUser, lich);
							}else {
								if(lich.getThoiGianBatDau().compareTo(temp)>0) {
								check = new lichDao().updateCalendar(idUser, lich);
								}
							}
						}else {
							temp = lichCurrent.getThoiGianKetThuc();
						}
					}
					if(check==true) {
						break;
					}
				}
			}
		}
		return check;
	}
	public boolean deleteCalendar(int idUser, int idLich) {
		return new lichDao().deleteCalendar(idUser, idLich);
	}
	public static void main(String[] args) {
	lich lich = new lich();
	int idUser = 2;
	lich.setIdNguoiDung(idUser);
	lich.setIdLich(13);
	lich.setNam(2024);
	lich.setNgay(4);
	lich.setThang(1);
	lich.setTenSuKien("Di da bong");
	lich.setNoiDung("Da bong o san thuy loi");
	lich.setThoiGianBatDau(Time.valueOf("19:30:00"));
	lich.setThoiGianKetThuc(Time.valueOf("23:40:00"));
	boolean check = false;
	check = new lichServiceImp().checkUpdate(idUser, lich);
	System.out.println(check);
}
}
