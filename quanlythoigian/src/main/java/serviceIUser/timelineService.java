package serviceIUser;

import java.util.List;

import model.nguoiDung;
import model.thoiGianTrongNgay;

public interface timelineService {
	List<thoiGianTrongNgay> listAll(nguoiDung u);
	boolean delete(nguoiDung u,int id);
	boolean complete(nguoiDung u,int id);
	boolean checkEdit(nguoiDung u,thoiGianTrongNgay tg);
	boolean checkAdd(nguoiDung u,thoiGianTrongNgay tg);
	boolean resetList(nguoiDung u,List<thoiGianTrongNgay> tg);
	boolean resetAll();
	List<thoiGianTrongNgay> listOfComplete(int idUser);
}
