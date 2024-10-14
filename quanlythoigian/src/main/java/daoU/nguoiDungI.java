package daoU;

import java.util.List;

import model.nguoiDung;

public interface nguoiDungI {
	int dangKy(nguoiDung u);
	String checkTaiKhoan(nguoiDung u);
	boolean thayDoiThongTin(nguoiDung u);
	nguoiDung dangNhap(nguoiDung u);
	List<nguoiDung> selectAll();
	List<nguoiDung> selectOfUser(int offset,int maxItems);
	List<nguoiDung> selectOfId(int id);
	boolean updateStatus(int id,int status);
	List<nguoiDung> selectOfEmail(String email);
	boolean resetPass(nguoiDung u,String psw);
	boolean deleteOfId(int id);
}
