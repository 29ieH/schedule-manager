package serviceIUser;

import java.sql.Time;
import java.util.List;

import model.lich;

public interface lichService {
	List<lich> listAllOfUser(int idUser);
	int addLich(int idUser,lich newlich);
	List<lich> listOfDMY(int idUser,int day,int month,int year);
	String notifiAdd(int idUser,lich lich,int repeat);
	boolean checkAdd(int idUser,lich lich);
	lich LichOfId(int idUser,int idLich);
	boolean checkUpdate(int idUser,lich lich);
	boolean deleteCalendar(int idUser,int idLich);
}
