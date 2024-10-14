package mapper;

import java.sql.ResultSet;
import java.sql.Time;

import model.lich;

public class lichMapper implements rowMapper<lich> {

	public lich mapRow(ResultSet rs) {
		try {
			int idLich = rs.getInt("idLich");
			int idNguoiDung = rs.getInt("idNguoiDung");
			String tenSuKien = rs.getNString("tenSuKien");
			int ngay = rs.getInt("ngay");
			int thang = rs.getInt("thang");
			int nam = rs.getInt("nam");
			String noiDung = rs.getNString("noiDung");
			Time thoiGianBatDau = rs.getTime("thoiGianBatDau");
			Time thoiGianKetThuc = rs.getTime("thoiGianKetThuc");
			lich newLich = new lich(idLich, idNguoiDung, tenSuKien, ngay, thang, nam, noiDung, thoiGianBatDau, thoiGianKetThuc);
			return newLich;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
