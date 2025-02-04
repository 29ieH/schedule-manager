package serviceImpU;

import java.sql.Time;
import java.util.List;
//import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.ServletContext;

import daoUImpl.abstractDao;
import daoUImpl.suKienDao;
import model.nguoiDung;
import model.suKien;
import serviceIUser.Email;

public class emailServiceImp implements Email   {
	public String getEmail(suKien sk) {
		return new suKienDao().getEmail(sk);
	}
	public void  sendNofication(suKien suKien) {
		final String from = "niehtime@gmail.com";
		final String password = "ffzgkwfuwklptxiu";
//		Khai báo các thuộc tính
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port","587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
//		Create authenticator
		Authenticator  auth = new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		};
//		Phiên làm việc
		Session session = Session.getInstance(props,auth);
//		Người nhận nofication
		String to = new emailServiceImp().getEmail(suKien);
		MimeMessage msg = new MimeMessage(session);
		try {
			//Kiểu nội dung
			msg.addHeader("Content-type", "tex/HTML; charset=UTF-8");
//			Người gửi
			msg.setFrom();
//			Người nhận
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to,false));
//			Tiêu đề email
			String subject = "Cảnh báo sự kiện của bạn sắp được diễn ra !";
            String encodedSubject = MimeUtility.encodeText(subject, "UTF-8", "B");
            msg.setSubject(encodedSubject);
//			msg.setSubject("Cảnh báo! , sự kiện "+suKien.getTenSuKien()+" của bạn sắp được diễn ra");
//			Quy định ngày gửi
//			msg.setSentDate(new Date());
//			Quy định email nhận phản hồi 
//			msg.setContent() truyen sang dang html 
			String htmlConTent = "<div style='padding: 40px; background-color: rgb(56, 29, 29); min-width: 400px;'>"
					+ "<p style='margin: 14px 0px; color: white; font-weight: 600; font-size: 16px;'>Sự kiện: <span style='color: orangered;'>"+suKien.getTenSuKien()+"</span> Sắp được diễn ra </p>"
					+ "<p style='margin: 14px 0px; color: white; font-weight: 600; font-size: 16px;'>Bắt đầu vào lúc: <span style='color: orangered;'>"+suKien.getThoiGianBatDau()+"</span> diễn ra tại: <span style='color: orangered;'>"+suKien.getDiaDiem()+"</span></p>"
					+ "</div>";
			msg.setContent(htmlConTent,"text/html; charset=utf-8");
//			msg.setText("Sự kiện " + suKien.getTenSuKien() +  " sắp được diễn ra tại địa điểm " + suKien.getDiaDiem() +" thời gian bắt đầu là "+suKien.getThoiGianBatDau(),"UTF-8");
			Transport.send(msg);
			System.out.println("Gửi thành công !");
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	public void sendPassReset(nguoiDung user,String psw) {
		final String from = "niehtime@gmail.com";
		final String password = "ffzgkwfuwklptxiu";
//		Khai báo các thuộc tính
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port","587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
//		Create authenticator
		Authenticator  auth = new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		};
//		Phiên làm việc
		Session session = Session.getInstance(props,auth);
//		Người nhận nofication
		String to = user.getEmail();
		MimeMessage msg = new MimeMessage(session);
		try {
			//Kiểu nội dung
			msg.addHeader("Content-type", "tex/HTML; charset=UTF-8");
//			Người gửi
			msg.setFrom();
//			Người nhận
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to,false));
//			Tiêu đề email
			String subject = "Thay đổi password !";
			String encodedSubject = MimeUtility.encodeText(subject, "UTF-8", "B");
            msg.setSubject(encodedSubject);
//			Quy định ngày gửi
//			msg.setSentDate(new Date());
//			Quy định email nhận phản hồi 
//			msg.setContent() truyen sang dang html 
			String htmlContent = "<div style='display: flex; justify-content: center; align-items: center;'>" 
					+ "<div style='font-family: Arial, Helvetica, sans-serif; margin-top: 40px;'>"
					+ "<p style='margin: 10px 0px; font-size: 16px; font-weight: 600;'>Xin chào "+user.getHoVaTen()+"</p>"
					+ "<p style='margin: 10px 0px; font-weight: 600;'>Mật khẩu của bạn đã được thay đổi</p>"
					+ "<div style='border: 2px solid #301414;'>"
					+ "<p style='margin: 0;padding: 20px 40px; background: #d9c0c0; font-weight: 700; font-size: 18px;'>"
					+ psw+"</p> </div>"
					+ "<p style='margin: 10px 0px; font-weight: 600;'>Cảm ơn bạn đã sử dụng NiehTime</p>"
					+ "<p style='margin: 10px 0px; font-size: 14px; color: orange;'>"
					+ "Warning : không được chia sẽ mật khẩu này với bất kì ai. </p>"
					+ "</div> </div>";
			msg.setContent(htmlContent,"text/html; charset=utf-8");
			Transport.send(msg);
			System.out.println("Gửi thành công !");
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	public static void main(String[] args) {
//		suKien e = new suKien();
//		e.setDiaDiem("My home");
//		e.setTenSuKien("Xem bán kết T1-JDG");
//		e.setThoiGianBatDau(Time.valueOf("14:00:00"));
//		e.setIdUser(2);
//		String email = new emailServiceImp().getEmail(e);
//		System.out.println(email);
//		new emailServiceImp().sendNofication(e);
		nguoiDung user = new nguoiDung();
		user.setEmail("nieh29zxc@gmail.com");
		String psw = "abcdefg";
		new emailServiceImp().sendPassReset(user, psw);
	}

}
