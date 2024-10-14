package serviceIAd;

import java.util.List;

import model.nguoiDung;

public interface aNguoiDungI {
	public List<nguoiDung> listOfUser(int offset,int maxItems);
	public int countOfUser();
	public nguoiDung selectOne(int id);
	public boolean deletedOne(int id);

}
