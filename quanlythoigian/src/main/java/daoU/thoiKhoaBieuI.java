package daoU;

import java.sql.Time;
import java.util.List;

import model.nguoiDung;
import model.thoiKhoaBieu;

public interface thoiKhoaBieuI {
	List<thoiKhoaBieu> listOfDay(nguoiDung u,String day);
	List<thoiKhoaBieu> listOfDayS(nguoiDung u,String day);
	List<thoiKhoaBieu> listOfDayC(nguoiDung u,String day);
	int addOne(nguoiDung u,String thu,String noiDung,Time thoiGianBatDau,Time thoiGianKetThuc);
	int addOnez(nguoiDung u,String thu,String noiDung,String thoiGianBatDau,String thoiGianKetThuc);
	boolean checkDangky(nguoiDung u,String noiDung,String thu,Time tgbd,Time tgkt);
	boolean updateThoiKhoaBieu(String noiDung,Time thoiGianBatDau,Time thoiGianKetThuc,int id,nguoiDung u);
	List<thoiKhoaBieu> selecOfId(int id);
	boolean deleteLich(nguoiDung u,int id);
}
