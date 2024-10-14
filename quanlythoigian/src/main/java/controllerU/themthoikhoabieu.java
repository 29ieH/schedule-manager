package controllerU;

import java.io.IOException;
import java.sql.Time;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.nguoiDung;
import serviceImpU.thoiKhoaBieuServiceImp;

/**
 * Servlet implementation class themthoikhoabieu
 */
public class themthoikhoabieu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public themthoikhoabieu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session!=null) {
			nguoiDung user =  (nguoiDung)session.getAttribute("userSession");
			String thu = request.getParameter("thu");
			String noiDung = request.getParameter("noiDung");
			String thoiGianBatDau = request.getParameter("thoiGianBatDau");
			String thoiGianKetThuc = request.getParameter("thoiGianKetThuc");
			thoiGianBatDau+=":00";
			thoiGianKetThuc+=":00";
			Time tgbd = Time.valueOf(thoiGianBatDau);
			Time tgkt = Time.valueOf(thoiGianKetThuc);
			boolean check = false;
			check = new thoiKhoaBieuServiceImp().checkDangKy(user, thu, noiDung, tgbd, tgkt);
			if(check) {
				response.sendRedirect("/quanlythoigian/data-tkb");
			}else {
				String mess = "Khung giờ bạn đăng ký đã bị trùng.Vui lòng thay đổi lại thời gian phù hợp hơn !";
				request.setAttribute("errorMess", mess);
				RequestDispatcher rsd = request.getRequestDispatcher("/views/addtkb.jsp");
				rsd.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
