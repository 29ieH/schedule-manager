package controllerU;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.nguoiDung;
import model.suKien;
import serviceImpU.suKienServiceImp;

/**
 * Servlet implementation class sendEmail
 */
public class sendEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendEmail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html");
//		HttpSession session = request.getSession(false);
//		if(session!=null) {
//			nguoiDung u = (nguoiDung)session.getAttribute("userSession");
//			List<suKien> listAll = new suKienServiceImp().listAll(u);
//			LocalDate dateCurrent = LocalDate.now();
//			DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//			String myDate = dateCurrent.format(f);
//			LocalDateTime timeCurrent = LocalDateTime.now();
//			DateTimeFormatter fT = DateTimeFormatter.ofPattern("HH:mm:ss");
//			String myTime = timeCurrent.format(fT);
//			for (suKien sk : listAll) {
//				if(sk.getNgayDienRaSuKien().compareTo(Date.valueOf(myDate))==0) {
//					
//				}
//			}
//		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
