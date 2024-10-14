package mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Currency;

import model.nguoiDung;

public class nguoiDungMapper implements rowMapper<nguoiDung>{

	public nguoiDung mapRow(ResultSet rs) {
		try {
			int idNguoiDung = rs.getInt("idNguoiDung");
			int idQuyen = rs.getInt("idQuyen");
			String hvt = rs.getNString("hoVaTen");
			String taiKhoan = rs.getString("taiKhoan");
			String matKhau = rs.getString("matKhau");
			String email = rs.getString("email");
			Date ngaySinh = rs.getDate("ngaySinh");
			String gioiTinh = rs.getNString("gioiTinh");
			String diaChi = rs.getNString("diaChi");
			int status = rs.getInt("status");
			LocalDate currentDate = LocalDate.now();
			Date ngayTao = Date.valueOf(currentDate);
			Date ngayCapNhap = Date.valueOf(currentDate);
			nguoiDung nd = new nguoiDung(idNguoiDung, idQuyen, hvt, taiKhoan, matKhau, email, ngaySinh, gioiTinh, diaChi,status,ngayTao, ngayCapNhap);
			return nd;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
