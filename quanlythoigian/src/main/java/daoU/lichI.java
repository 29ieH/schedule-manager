package daoU;

import java.util.List;

import model.lich;

public interface lichI {
	List<lich> listOfUser(int idUser);
	int addLich(int idUser,lich lich);
	List<lich> listOfDMY(int user,int day,int month,int year);
	List<lich> listOfId(int idUser,int idLich);
	boolean updateCalendar(int idUser,lich lich);
	boolean checkUpdate(int idUser,lich lich);
	boolean deleteCalendar(int idUser,int idLich);
	lich getById(int idLich);
}
