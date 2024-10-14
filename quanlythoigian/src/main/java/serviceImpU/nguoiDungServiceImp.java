package serviceImpU;

import java.util.List;

import daoUImpl.nguoiDungDao;
import model.nguoiDung;
import serviceIUser.nguoiDungServiceI;

public class nguoiDungServiceImp implements nguoiDungServiceI {

	public nguoiDung dangNhap(nguoiDung u) {
		return new nguoiDungDao().dangNhap(u);
	}

	public String checkDangKy(nguoiDung u) {
		return new nguoiDungDao().checkTaiKhoan(u);
	}
	public int addTaiKhoan(nguoiDung u) {
		return new nguoiDungDao().dangKy(u);
	}
	public static void main(String[] args) {
		nguoiDung u = new nguoiDung();
		u.setTaiKhoan("th29zz");
		u.setEmail("niehzxc29@gmail.comzzz");
		String errorEmail = "";
		String errorTk = "";
		String error = new nguoiDungServiceImp().checkDangKy(u);
		String errorlist[] = null;
		if(error.length()!=0){
			errorlist = error.split(",");	
			if(errorlist.length==2){
				if(errorlist[0].length()==0){
					errorEmail = errorlist[1];
					errorTk = "";
				}else{
					errorTk = errorlist[0];
					errorEmail = errorlist[1];
				}
			}
		}else {
			System.out.println("out");
		}
	}

	public nguoiDung findOfByEmail(String email) {
		List<nguoiDung> result = new nguoiDungDao().selectOfEmail(email);
		if(result.size()!=0) {
			return result.get(0);
		}
		return null;
	}

	public boolean resetPass(nguoiDung u, String password) {
		return new nguoiDungDao().resetPass(u, password);
	}
}
