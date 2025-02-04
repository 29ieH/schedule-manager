package daoUImpl;

import java.sql.Time;
import java.util.List;

import daoU.lichI;
import mapper.lichMapper;
import model.lich;

public class lichDao extends abstractDao<lich> implements lichI {

	public List<lich> listOfUser(int idUser) {
		String sql = "select * from lich where idNguoiDung = ? order by thoiGianBatDau asc";
		return query(sql, new lichMapper(), idUser);
	}
	public int addLich(int idUser, lich lich) {
		String sql = "insert into lich values (?,?,?,?,?,?,?,?)";
		return save(sql, idUser,lich.getTenSuKien(),lich.getNgay(),lich.getThang(),lich.getNam(),lich.getNoiDung(),lich.getThoiGianBatDau(),lich.getThoiGianKetThuc());
	}

	public List<lich> listOfDMY(int user, int day, int month, int year) {
		String sql = "select * from lich where idNguoiDung = ? and ngay = ? and thang = ? and nam = ? order by thoiGianBatDau asc";
		return query(sql, new lichMapper(), user,day,month,year);
	}
	public List<lich> listOfId(int idUser, int idLich) {
		String sql = "select * from lich where idNguoiDung = ? and idLich = ?";
		return query(sql, new lichMapper(), idUser,idLich);
	}
	public boolean updateCalendar(int idUser, lich lich) {
		String sql = "update lich set tenSuKien = ?,noidung = ?,ngay = ?,thang =?,nam=?,\r\n" + 
				"thoiGianBatDau=?,thoiGianKetThuc = ? where idLich = ? and idNguoiDung = ?";
		return update(sql, lich.getTenSuKien(),lich.getNoiDung(),lich.getNgay(),lich.getThang(),lich.getNam(),
				lich.getThoiGianBatDau(),lich.getThoiGianKetThuc(),lich.getIdLich(),idUser);
	}
	public boolean checkUpdate(int idUser, lich lich) {
		boolean check = false;
		List<lich> listOfDMY = new lichDao().listOfDMY(idUser, lich.getNgay(), lich.getThang(), lich.getNam());
		int length = listOfDMY.size();
		if(length>0) {
			lich end = listOfDMY.get(length-1);
			if(!end.equals(lich)) {
				if(lich.getThoiGianBatDau().compareTo(end.getThoiGianKetThuc())>0) {
					check = new lichDao().updateCalendar(idUser, lich);
					if(check) {
						return check;
					}
				}
			}else {
				if(length>1) {
					lich kt = listOfDMY.get(length-2);
					if(lich.getThoiGianBatDau().compareTo(kt.getThoiGianKetThuc())>0) {
						check = new lichDao().updateCalendar(idUser, lich);
						if(check) {
							return check;
						}
					}
				}
			}
		}
		Time temp = null;
		for (lich lichCheck : listOfDMY) {
			if(!lich.equals(lichCheck)) {
				if(lich.getThoiGianKetThuc().compareTo(lichCheck.getThoiGianBatDau())<0) {
					if(temp==null) {
						check = new lichDao().updateCalendar(idUser, lich);
					}else {
						if(lich.getThoiGianBatDau().compareTo(temp)>0) {
							check = new lichDao().updateCalendar(idUser, lich);
						}
					}
				}else {
					temp = lichCheck.getThoiGianKetThuc();
				}
			}
			if(check==true) {
				break;
			}
		}
		return check;
	}
	public static void main(String[] args) {
	}
	public boolean deleteCalendar(int idUser, int idLich) {
		String sql = "delete lich where idNguoiDung = ? and idLich = ?";
		return update(sql, idUser,idLich);
	}
	public lich getById(int idLich) {
		String sql = "select * from lich where idLich = ?";
		List<lich> rs = query(sql, new lichMapper(), idLich);
		if(rs.size()>0) {
			return rs.get(0);
		}
		return null;
	}
	
}
