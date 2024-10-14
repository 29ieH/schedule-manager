package daoU;

import java.util.Date;
import java.util.List;

import model.nguoiDung;
import model.suKien;

public interface suKienI {
	List<suKien> All();
	List<suKien> listUuTien(nguoiDung u,String myDate);
	List<suKien> listAll(nguoiDung u);
	List<suKien> listOfType(nguoiDung u,String myDate,String type);
	List<suKien> listOfDay(nguoiDung u,String myDate);
	List<suKien> byId(nguoiDung u,int id);
	List<suKien> listBEvent(nguoiDung u,int offset,int maxItemsPage);
	int addOne(nguoiDung u,suKien e);
	int checkAdd(nguoiDung u,suKien e);
	boolean update(nguoiDung u,suKien e);
	boolean delete(nguoiDung u,int id);
	int totalItemsBeforeDay(nguoiDung u);
	List<suKien> listOfName(nguoiDung u,String Name);
	String getEmail(suKien sk);
}
