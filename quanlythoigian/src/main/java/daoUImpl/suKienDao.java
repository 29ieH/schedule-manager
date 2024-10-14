package daoUImpl;

import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import daoU.suKienI;
import mapper.rowMapper;
import mapper.suKienMapper;
import model.nguoiDung;
import model.suKien;

public class suKienDao extends abstractDao<suKien> implements suKienI {
	public List<suKien> byId(nguoiDung u, int id) {
		String sql = "select * from suKien where idNguoiDung = ? and idSuKien = ?";
		return query(sql, new suKienMapper(), u.getIdNguoiDung(),id);
	}
	public List<suKien> listUuTien(nguoiDung u,String myDate) {
		String sql = "select * from suKien where idNguoiDung = ? and ngayDienRaSuKien = ? and suKienUuTien = 1  order by thoiGianBatDau asc";
		return query(sql, new suKienMapper(), u.getIdNguoiDung(),myDate);
	}
	public List<suKien> listAll(nguoiDung u) {
		String sql = "select * from suKien where idNguoiDung = ? order by ngayDienRaSuKien desc,thoiGianBatDau desc";
		return query(sql, new suKienMapper(), u.getIdNguoiDung());
	}
	public List<suKien> listOfType(nguoiDung u,String myDay, String type) {
		String sql = "select * from suKien where idNguoiDung = ? and ngayDienRaSuKien = ? and loaiSuKien = ? "
				+ "order by thoiGianBatDau asc";
		return query(sql, new suKienMapper(), u.getIdNguoiDung(),myDay,type);
	}
	public List<suKien> listOfDay(nguoiDung u, String myDate) {
		String sql = "select * from suKien where idNguoiDung = ? and ngayDienRaSuKien = ? order by thoiGianBatDau asc";
		return query(sql, new suKienMapper(), u.getIdNguoiDung(),myDate);
	}
	public int addOne(nguoiDung u, suKien e) {
		String sql = "insert into suKien(idNguoiDung,tenSuKien,moTaNgan,ngayDienRaSuKien,thoiGianBatDau,thoiGianKetThuc,\r\n" + 
				"diaDiem,henGioTruocSuKien,nhungNguoiThamGia,loaiSuKien,suKienUuTien)\r\n" + 
				"values (?,?,?,?,?,\r\n" + 
				"?,?,?,?,?,?)";
		return save(sql,u.getIdNguoiDung(),e.getTenSuKien(),e.getMoTaNgan(),e.getNgayDienRaSuKien(),
				e.getThoiGianBatDau(),e.getThoiGianKetThuc(),e.getDiaDiem(),e.getHenGioTruocSuKien(),e.getNhungNguoiThamGia(),
				e.getLoaiSuKien(),e.getSuKienUuTien());
	}
	public int checkAdd(nguoiDung u, suKien e) {
		int flag = 0;
		int check = 0;
		LocalDate current = LocalDate.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String Date = current.format(format);
		java.sql.Date myDate = java.sql.Date.valueOf(Date);
		List<suKien> listAll = listOfDay(u, Date);
		if(listAll.size()<=0) {
			check = addOne(u, e);
			if(check!=0) {
				flag = 1;
				return flag;
			}
		}
		if(e.getNgayDienRaSuKien().equals(myDate)) {
			suKien last = listAll.get(listAll.size()-1);
			if(last!=null) {
				if(e.getThoiGianBatDau().compareTo(last.getThoiGianKetThuc())>0) {
					check = addOne(u, e);
					if(check!=0) {
						flag = 1;
					}
				}
			}
			Time temp = null;
			if(flag==0) {
				for (suKien suKien : listAll) {
					if(e.getThoiGianKetThuc().compareTo(suKien.getThoiGianBatDau())<0) {
						if(temp==null) {
							check = addOne(u, e);
							if(check!=0) {
								flag = 1;
							}
						}else {
							if(e.getThoiGianBatDau().compareTo(temp)>0) {
								check = addOne(u, e);
								if(check!=0) {
									flag = 1;
								}
							}
						}
					}else {
						temp = suKien.getThoiGianKetThuc();
					}
					if(flag==1) {
						break;
					}
				}
			}
		}
		return flag;
		}
	public static int convertHenGio(String input) {
		input = input.replace("h", "");
		input = input.replace("p", "");
		if(input.matches("\\d+")) {
			return Integer.parseInt(input);
		}
		try {
			int timeNumber = Integer.parseInt(input);
			return timeNumber;
		} catch (Exception e) {
			return 0;
		}
	}
	public boolean update(nguoiDung u, suKien e) {
		String sql = " update suKien set tenSuKien = ?,moTaNgan = ?,ngayDienRaSuKien=?,thoiGianBatDau=?,thoiGianKetThuc\r\n" + 
				" =?,diaDiem=?,henGioTruocSuKien = ?,nhungNguoiThamGia = ?,loaiSuKien = ?,\r\n" + 
				" suKienUuTien = ? where idSuKien = ? and idNguoiDung = ?";
		return update(sql, e.getTenSuKien(),e.getMoTaNgan(),e.getNgayDienRaSuKien(),e.getThoiGianBatDau(),e.getThoiGianKetThuc()
				,e.getDiaDiem(),e.getHenGioTruocSuKien(),e.getNhungNguoiThamGia(),e.getLoaiSuKien(),e.getSuKienUuTien(),
				e.getIdSuKien(),u.getIdNguoiDung());
	}
	public boolean delete(nguoiDung u, int id) {
		String sql = "delete from suKien where idNguoiDung = ? and idSuKien = ?";
		return update(sql, u.getIdNguoiDung(),id);
	}
	public List<suKien> listBEvent(nguoiDung u,int offset,int maxItemsPage) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from suKien where idNguoiDung = ? and ngayDienRaSuKien < ? ");
		sql.append("order by ngayDienRaSuKien desc,thoiGianBatDau desc ");
		sql.append("offset ? rows fetch next ? row only");
		LocalDate current = LocalDate.now();
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		java.sql.Date myDate = java.sql.Date.valueOf(new String(current.format(f)));
		return query(sql.toString(), new suKienMapper(), u.getIdNguoiDung(),myDate,offset,maxItemsPage);
	}
	public int totalItemsBeforeDay(nguoiDung u) {
		LocalDate current = LocalDate.now();
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		java.sql.Date myDate = java.sql.Date.valueOf(new String(current.format(f)));
		String sql = "select count(idSuKien)as count from suKien where idNguoiDung = ? and ngayDienRaSuKien < ?";
		return count(sql, u.getIdNguoiDung(),myDate);
	}
	public List<suKien> listOfName(nguoiDung u, String Name) {
		String sql = "select * from suKien where tenSuKien like ? and idNguoiDung = ?";
		return query(sql, new suKienMapper(), Name,u.getIdNguoiDung());
	}
	public List<suKien> All() {
		String sql = "select * from suKien";
		return query(sql, new suKienMapper());
	}
	public String getEmail(suKien sk) {
		String sql = "select email from suKien as sk join nguoiDung as nd on sk.idNguoiDung = nd.idNguoiDung where sk.idNguoiDung =  ?";
		return email(sql,sk.getIdUser());
	}
	public static void main(String[] args) {
//		int a = convertHenGio("12h30p");
//		System.out.println(a);
		nguoiDung u = new nguoiDung();
		u.setIdNguoiDung(2);
//		LocalDate current = LocalDate.now();
//		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		String myDate = current.format(format);
//		suKien sk = new suKien();
//		sk.setIdSuKien(4);
//		sk.setTenSuKien("abcxyz");
//		sk.setMoTaNgan("abcxyz");
//		sk.setNgayDienRaSuKien(java.sql.Date.valueOf(myDate));
//		sk.setThoiGianBatDau(Time.valueOf("18:30:00"));
//		sk.setThoiGianKetThuc(Time.valueOf("21:00:00"));
//		sk.setDiaDiem("My home");
//		sk.setHenGioTruocSuKien(10);
//		sk.setNhungNguoiThamGia("");
//		sk.setLoaiSuKien("Học Tập");
//		sk.setSuKienUuTien(0);
//		boolean check = false;
//		check = new suKienDao().update(u, sk);
//		if(check) {
//			System.out.println("Ok");
//		}else {
//			System.out.println("Cook");
//		}
//		List<suKien> result = new suKienDao().listBEvent(u, 0, 5);
//		for (suKien suKien : result) {
//			System.out.println(suKien.toString());
//		}
		int count = new suKienDao().totalItemsBeforeDay(u);
		System.out.println(count);
	}
}
