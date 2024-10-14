package serviceIUser;

import model.nguoiDung;
import model.suKien;

public interface Email {
	public void sendNofication(suKien sk);
	public String getEmail(suKien sk);
	public void sendPassReset(nguoiDung user,String psw);
}
