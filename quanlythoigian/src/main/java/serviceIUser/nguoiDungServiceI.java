package serviceIUser;

import java.util.List;

import model.nguoiDung;

public interface nguoiDungServiceI {
	nguoiDung dangNhap(nguoiDung u);
	String checkDangKy(nguoiDung u);
	int addTaiKhoan(nguoiDung u);
	nguoiDung findOfByEmail(String email);
	boolean resetPass(nguoiDung u,String password);
}
