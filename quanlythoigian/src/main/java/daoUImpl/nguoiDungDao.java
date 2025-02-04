package daoUImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Savepoint;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

import daoU.nguoiDungI;
import mapper.nguoiDungMapper;
import model.nguoiDung;
import serviceImpU.nguoiDungServiceImp;

public class nguoiDungDao extends abstractDao<nguoiDung> implements nguoiDungI  {
	public List<nguoiDung> selectAll() {
		String sql = "select * from nguoiDung";
		return query(sql, new nguoiDungMapper());
	}
	
	public int dangKy(nguoiDung u) {
		String sql = "insert into nguoiDung(hoVaTen,taiKhoan,matKhau,email,ngaySinh,gioiTinh,diaChi) "
				+ "values (?,?,?,?,?,?,?)";
		String psw = "";
		if(u.getMatKhau().length()>0) {
			psw = DigestUtils.sha256Hex(u.getMatKhau());
		}
		return save(sql, u.getHoVaTen(),u.getTaiKhoan(),psw,u.getEmail()
				,u.getNgaySinh(),u.getGioiTinh(),u.getDiaChi());
	}
	public boolean thayDoiThongTin(nguoiDung u) {
		// TODO Auto-generated method stub
		return false;
	}
	public nguoiDung dangNhap(nguoiDung u) {
		nguoiDung user = null;
		List<nguoiDung> result = selectAll();
		if(u.getMatKhau().length()>0) {
			String psw = DigestUtils.sha256Hex(u.getMatKhau());
		if(result!=null) {
			for (nguoiDung users : result) {
				if(users.getTaiKhoan().equals(u.getTaiKhoan())) {
					if(users.getMatKhau().equals(psw)) {
						user = new nguoiDung(users.getIdNguoiDung(), users.getIdRole(), users.getHoVaTen(), users.getTaiKhoan()
						, users.getMatKhau(),users.getEmail(), users.getNgaySinh(), users.getGioiTinh(), users.getDiaChi(),users.getStatus());
					}
				}
			}
		}
		}
		return user;
	}
	public String checkTaiKhoan(nguoiDung u) {
		String error = "";
		List<nguoiDung> users = selectAll();
		if(users!=null) {
			for (nguoiDung user : users) {
				if(user.getTaiKhoan().equals(u.getTaiKhoan())) {
					error+="Tài khoản đã tồn tại";
				}
				if(user.getEmail().equals(u.getEmail())) {
					error+=",Email của bạn nhập đã đăng ký cho một tài khoản nào trước đó";
				}
			}
		}
		return error;
	}
	public List<nguoiDung> selectOfUser(int offset, int maxItems) {
		String sql = "select * from nguoiDung where idQuyen = 0 order by hoVaTen asc offset ? rows fetch next ? row only";
		return query(sql, new nguoiDungMapper(), offset,maxItems);
	}
	public int countOfUser() {
		String sql = "Select count(idNguoiDung) from nguoiDung where idQuyen = 0";
		return count(sql);
	}

	public List<nguoiDung> selectOfId(int id) {
		String sql = "select * from nguoiDung where idNguoiDung = ?";
		return query(sql, new nguoiDungMapper(), id);
	}
	public boolean updateStatus(int id, int status) {
		String sql = "update nguoiDung set status = ? where idNguoiDung = ?";
		return update(sql, status,id);
	}

	public List<nguoiDung> selectOfEmail(String email) {
		String sql = "select * from nguoidung where email = ? ";
		return query(sql, new nguoiDungMapper() , email);
	}

	public boolean resetPass(nguoiDung u, String psw) {
		String sql = "update nguoidung set matKhau = ? where idNguoiDung = ?";
		return update(sql, psw,u.getIdNguoiDung());
	}
	public static void main(String[] args) {
	
	}

	public boolean deleteOfId(int id) {
		String sql = "delete nguoidung where idNguoiDung = ?";
		return update(sql, id);
	}
}
