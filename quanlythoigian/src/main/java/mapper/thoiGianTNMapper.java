package mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalDate;

import model.thoiGianTrongNgay;

public class thoiGianTNMapper implements rowMapper<thoiGianTrongNgay> {

	public thoiGianTrongNgay mapRow(ResultSet rs) {
		try {
			int idTGTN = rs.getInt("idThoiGianTrongNgay");
			int idNguoiDung = rs.getInt("idNguoiDung");
			String tenHoatDong = rs.getNString("tenHoatDong");
			String moTaNgan = rs.getNString("moTaNgan");
			String diaDiem = rs.getNString("diaDiem");
			Time thoiGianBatDau = rs.getTime("thoiGianBatDau");
			Time thoiGianKetThuc = rs.getTime("thoiGianKetThuc");
			Date ngayHienTai = rs.getDate("ngayHienTai");
			int hoanThanh = rs.getInt("hoanThanh");
			int thoiGianNhacNho = rs.getInt("thoiGianNhacNho");
			LocalDate currentDate = LocalDate.now();
			Date ngayTao = Date.valueOf(currentDate);
			Date ngayCapNhap = Date.valueOf(currentDate);
			thoiGianTrongNgay tgtn = new thoiGianTrongNgay(idTGTN, idNguoiDung,tenHoatDong, moTaNgan,diaDiem,ngayHienTai, thoiGianBatDau, thoiGianKetThuc,hoanThanh,ngayTao, ngayCapNhap);
			return tgtn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
