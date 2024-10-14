package daoUImpl;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.jsp.jstl.fmt.LocalizationContext;

import daoU.timelineI;
import mapper.thoiGianTNMapper;
import model.nguoiDung;
import model.thoiGianTrongNgay;

public class timelineDao extends abstractDao<thoiGianTrongNgay> implements timelineI {

	public List<thoiGianTrongNgay> selectAll(nguoiDung u) {
		String sql = "select * from thoiGianTrongNgay where idNguoiDung = ? order by thoiGianBatDau asc";
		return query(sql, new thoiGianTNMapper(), u.getIdNguoiDung());
	}
	public List<thoiGianTrongNgay> selectOne(int id) {
		String sql = "select * from thoiGianTrongNgay where idThoiGianTrongNgay = ?";
		return query(sql, new thoiGianTNMapper(), id);
	}
	public boolean resetAll() {
		String sql = "update thoiGianTrongNgay set hoanThanh = 0";
		return update(sql);
	}
	public int addOne(nguoiDung u, thoiGianTrongNgay tg) {
		LocalDate current = LocalDate.now();
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String myDate = current.format(f);
		String sql = "insert into thoiGianTrongNgay(idNguoiDung,tenHoatDong,moTaNgan,diaDiem,thoiGianBatDau,thoiGianKetThuc,ngayHienTai)\r\n" + 
				"values (?,?,?,?,?,?,?)";
		return save(sql, u.getIdNguoiDung(),tg.getTenHoatDong(),tg.getMoTaNgan(),tg.getDiaDiem(),tg.getThoiGianBatDau(),tg.getThoiGianKetThuc(),myDate);
	}

	public boolean delete(nguoiDung u, int id) {
		String sql = "delete from thoiGianTrongNgay where idNguoiDung = ? and idThoiGianTrongNgay = ?";
		return update(sql, u.getIdNguoiDung(),id);
	}

	public boolean complete(nguoiDung u, int id) {
		String sql = "update thoiGianTrongNgay set hoanThanh = 1 where idNguoiDung = ? and idThoiGianTrongNgay = ?";
		return update(sql, u.getIdNguoiDung(),id);
	}

	public boolean update(nguoiDung u,thoiGianTrongNgay tgtn) {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate current = LocalDate.now();
		String myDate = current.format(f);
		String sql = "update thoiGianTrongNgay set tenHoatDong = ?,moTaNgan = ?,diaDiem= ?,thoiGianBatDau = ?,\r\n" + 
				"thoiGianKetThuc= ?,ngayHienTai= ? where idNguoiDung = ? and idThoiGianTrongNgay = ?";
		return update(sql,tgtn.getTenHoatDong(),tgtn.getMoTaNgan(),tgtn.getDiaDiem(),tgtn.getThoiGianBatDau(),
				tgtn.getThoiGianKetThuc(),myDate, u.getIdNguoiDung(),tgtn.getIdThoiGianTrongNgay());
	}
	public boolean reset(nguoiDung u,thoiGianTrongNgay timeline ) {
		String sql = "update thoiGianTrongNgay set hoanThanh = 0 where idNguoiDung = ? and idThoiGianTrongNgay = ?";
		return update(sql, u.getIdNguoiDung(),timeline.getIdThoiGianTrongNgay());
	}
	public boolean resetList(nguoiDung u, List<thoiGianTrongNgay> list) {
		boolean check = true;
		for (thoiGianTrongNgay tgtn : list) {
			check = reset(u,tgtn);
			if(!check) {
				break;
			}
		}
		return check;
	}
	public static void main(String[] args) {
	}
	public List<thoiGianTrongNgay> listComplete(int idUser) {
		String sql = "select * from thoiGianTrongNgay where idNguoiDung = ? and hoanThanh = 1 order by thoiGianBatDau asc";
		return query(sql, new thoiGianTNMapper(), idUser);
	}
}
