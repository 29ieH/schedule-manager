package serviceIUser;

import java.sql.Time;
import java.util.List;

import model.nguoiDung;
import model.thoiKhoaBieu;

public interface thoiKhoaBieuService {
	List<thoiKhoaBieu> listOfDayS(nguoiDung u,String day);
	List<thoiKhoaBieu> listOfDayC(nguoiDung u,String day);
	int addOne(nguoiDung u,String thu,String noiDung,Time thoiGianBatDau,Time thoiGianKetThuc);
	boolean checkDangKy(nguoiDung u,String thu,String noiDung,Time tgbd,Time tgkt);
	boolean checkUpdate(String thu,String noiDung,Time tgbd,Time tgkt,int id,nguoiDung u);
	thoiKhoaBieu oneById(int id);
	boolean deleteLich(nguoiDung u,int id);
}
