package serviceImpA;

import java.util.ArrayList;
import java.util.List;

import daoUImpl.nguoiDungDao;
import model.nguoiDung;
import serviceIAd.aNguoiDungI;

public class nguoiDungImp implements aNguoiDungI {

	public List<nguoiDung> listOfUser(int offset, int maxItems) {
		return new nguoiDungDao().selectOfUser(offset, maxItems);
	}

	public int countOfUser() {
		return new nguoiDungDao().countOfUser();
	}
	public static void main(String[] args) {
	}

	public nguoiDung selectOne(int id) {
		List<nguoiDung> select = new nguoiDungDao().selectOfId(id);
		return select.get(0);
	}

	public boolean deletedOne(int id) {
		return new nguoiDungDao().deleteOfId(id);
	}
}
