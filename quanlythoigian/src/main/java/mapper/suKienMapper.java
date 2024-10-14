package mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalDate;

import model.suKien;

public class suKienMapper implements rowMapper<suKien> {

	public suKien mapRow(ResultSet rs) {
		try {
			int idSuKien = rs.getInt("idSuKien");
			int idNguoiDung = rs.getInt("idNguoiDung");
			String tenSuKien = rs.getNString("tenSuKien");
			String moTaNgan = rs.getNString("moTaNgan");
			Date ngayDienRa = rs.getDate("ngayDienRaSuKien");
			Time thoiGianBatDau = rs.getTime("thoiGianBatDau");
			Time thoiGianKetThuc = rs.getTime("thoiGianKetThuc");
			String diaDiem = rs.getNString("diaDiem");
			int henGio = rs.getInt("henGioTruocSuKien");
			String ngThamGia = rs.getNString("nhungNguoiThamGia");
			String loaiSuKien = rs.getNString("loaiSuKien");
			int suKienUuTien = rs.getInt("suKienUuTien");
			int hoanThanh = rs.getInt("hoanThanh");
			LocalDate currentDate = LocalDate.now();
			Date ngayTao = Date.valueOf(currentDate);
			Date ngayCapNhap = Date.valueOf(currentDate);
			suKien sk = new suKien(idSuKien, idNguoiDung, tenSuKien, moTaNgan, ngayDienRa, thoiGianBatDau, thoiGianKetThuc, diaDiem, henGio, ngThamGia, loaiSuKien, suKienUuTien,hoanThanh,ngayTao, ngayCapNhap);
			return sk;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
