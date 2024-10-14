package mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalDate;

import model.thoiKhoaBieu;

public class thoiKhoaBieuMapper implements rowMapper<thoiKhoaBieu> {

	public thoiKhoaBieu mapRow(ResultSet rs) {
		try {
			int idTkb = rs.getInt("idThoiKhoaBieu");
			int idNd = rs.getInt("idNguoiDung");
			String thu = rs.getNString("thu");
			LocalDate currentDate = LocalDate.now();
			String noiDung = rs.getNString("noiDung");
			Time thoiGianBatDau = rs.getTime("thoiGianBatDau");
			Time thoiGianKetThuc = rs.getTime("thoiGianKetThuc");
			Date ngayTao = Date.valueOf(currentDate);
			Date ngayCapNhap = Date.valueOf(currentDate);
			thoiKhoaBieu tkb = new thoiKhoaBieu(idTkb, idNd, thu, noiDung,thoiGianBatDau, thoiGianKetThuc, ngayTao, ngayCapNhap);
			return tkb;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
}
