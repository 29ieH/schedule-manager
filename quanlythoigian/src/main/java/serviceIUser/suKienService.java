package serviceIUser;

import java.util.List;

import model.nguoiDung;
import model.suKien;

public interface suKienService {
	List<suKien> All();
	List<suKien> listUuTien(nguoiDung u,String myDate);
	List<suKien> listAll(nguoiDung u);
	List<suKien> listOfType(nguoiDung u,String myDate,String type);
	List<suKien> listOfDay(nguoiDung u,String myDate);
	List<suKien> listBeforeDay(nguoiDung u,int offset,int maxItemsPage);
	List<suKien> listOfName(nguoiDung u,String name);
	suKien selectByID(nguoiDung u,int id);
	int checkAdd(nguoiDung u,suKien e);
	int totalItemsBeforeDay(nguoiDung u);
	boolean checkUpdate(nguoiDung u,suKien e);
	boolean delete(nguoiDung u,int id);
}
