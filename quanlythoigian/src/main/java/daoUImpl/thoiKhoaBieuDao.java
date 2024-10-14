package daoUImpl;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import daoU.thoiKhoaBieuI;
import mapper.thoiKhoaBieuMapper;
import model.nguoiDung;
import model.thoiKhoaBieu;

public class thoiKhoaBieuDao extends abstractDao<thoiKhoaBieu> implements thoiKhoaBieuI  {
	public List<thoiKhoaBieu> selecOfId(int id) {
		String sql = "select * from thoiKhoaBieu where idThoiKhoaBieu = ?";
		return query(sql, new thoiKhoaBieuMapper(), id);
	}
	public List<thoiKhoaBieu> listOfDay(nguoiDung u, String day) {
		String sql = "select * from thoiKhoaBieu where idNguoiDung = ? and thu = ? order by thoiGianBatDau ASC";
		return query(sql, new thoiKhoaBieuMapper(), u.getIdNguoiDung(),day);
	}
	public List<thoiKhoaBieu> listOfDayS(nguoiDung u,String day) {
		String sql = "select * from thoiKhoaBieu where idNguoiDung = ? and thu = ? and thoiGianKetThuc < '13:00' order by thoiGianBatDau ASC";
		return query(sql,  new thoiKhoaBieuMapper(),u.getIdNguoiDung(),day);
	}
	public List<thoiKhoaBieu> listOfDayC(nguoiDung u, String day) {
		String sql = "select * from thoiKhoaBieu where idNguoiDung = ? and thu = ? and thoiGianBatDau >= '12:00' order by thoiGianBatDau ASC";
		return query(sql, new thoiKhoaBieuMapper(), u.getIdNguoiDung(),day);
	}

	public int addOne(nguoiDung u, String thu, String noiDung,Time thoiGianBatDau,Time thoiGianKetThuc) {
		String sql = "insert into thoiKhoaBieu values (?,?,?,?,?)";
		return save(sql, u.getIdNguoiDung(),thu,noiDung,thoiGianBatDau,thoiGianKetThuc);
	}
	public int addOnez(nguoiDung u, String thu, String noiDung, String thoiGianBatDau, String thoiGianKetThuc) {
		String sql = "insert into thoiKhoaBieu values (?,?,?,?,?)";
		return save(sql, u.getIdNguoiDung(),thu,noiDung,thoiGianBatDau,thoiGianKetThuc);
	}
	public boolean updateThoiKhoaBieu(String noiDung, Time thoiGianBatDau,Time thoiGianKetThuc,int id,nguoiDung u) {
		String sql = "update thoiKhoaBieu set noiDung = ? , thoiGianBatDau = ? , thoiGianKetThuc = ? where idThoiKhoaBieu = ? and idNguoiDung = ?";
		return update(sql, noiDung,thoiGianBatDau,thoiGianKetThuc,id,u.getIdNguoiDung());
	}
	public boolean deleteLich(nguoiDung u, int id) {
		String sql = "delete from thoiKhoaBieu where idNguoiDung = ? and idThoiKhoaBieu = ?";
		return update(sql, u.getIdNguoiDung(),id);
	}
	public boolean checkDangky(nguoiDung u,String thu,String noiDung,Time tgbd, Time tgkt) {
		List<thoiKhoaBieu> result = listOfDay(u, thu);
		thoiKhoaBieu last = null;
		Time temp = null;
		boolean flag = false;
		int check = 0;
		if(result.size()>0) {
			last  = result.get(result.size()-1);
		}
		if(last!=null) {
			if(tgbd.compareTo(last.getThoiGianKetThuc())>0) {
				check = addOne(u, thu, noiDung, tgbd, tgkt);
				if(check>0) {
					flag = true;
				}
			}
		}
		if(!flag) {
			for (thoiKhoaBieu tkb : result) {
				if(tgkt.compareTo(tkb.getThoiGianBatDau())<0) {
					if(temp==null) {
						check = addOne(u, thu, noiDung, tgbd, tgkt);
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
			}
		}
		return flag;
	}
	public static void main(String[] args) {
		nguoiDung u = new nguoiDung();
		u.setIdNguoiDung(2);
		int id = 24;
//		String nd = "Học hệ quản trị cơ sở dữ liệu nâng cao";
//		String tgbd = "13:00:00";
//		String tgkt = "16:35:00";
//		boolean check = false;
//		check = new thoiKhoaBieuDao().updateThoiKhoaBieu(nd, Time.valueOf(tgbd), Time.valueOf(tgkt), id, u);
//		if(check) {
//			System.out.println("Ok");
//		}else {
//			System.out.println("Cook");
//		}
	}

}
