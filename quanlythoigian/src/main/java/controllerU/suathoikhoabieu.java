package controllerU;

import java.io.IOException;
import java.sql.Time;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.nguoiDung;
import serviceImpU.thoiKhoaBieuServiceImp;

/**
 * Servlet implementation class suathoikhoabieu
 */
public class suathoikhoabieu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public suathoikhoabieu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session!=null) {
			nguoiDung user = (nguoiDung)session.getAttribute("userSession");
			String id = request.getParameter("id");
			String thu = request.getParameter("thu");
			String noiDung = request.getParameter("noiDung");
			String tgbd = request.getParameter("thoiGianBatDau");
			String tgkt = request.getParameter("thoiGianKetThuc");
			if(tgbd.length()==5) {
				tgbd+=":00";
			}
			if(tgkt.length()==5) {
				tgkt+=":00";
			}
//			System.out.println(tgbd.length());
			System.out.println(tgkt.length());
//			tgkt+=":00";
			int idInt = 0;
			try {
				idInt = Integer.parseInt(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			thu = thu.trim();
			System.out.println(idInt);
			System.out.println(thu);
			System.out.println(noiDung);
			System.out.println(tgbd);
			System.out.println(tgkt);
			System.out.println(user.getIdNguoiDung());
			boolean check = new thoiKhoaBieuServiceImp().checkUpdate(thu, noiDung, Time.valueOf(tgbd), Time.valueOf(tgkt),idInt,user);
			if(check) {
				response.sendRedirect("/quanlythoigian/data-tkb");
			}else {
				System.out.println("Error");
				String myError = "Thời gian mà bạn muốn chỉnh sửa không phù hợp. Có lẽ trong khoảng thời gian đó đã diễn ra một sự kiện khác !";
				request.setAttribute("nofication", myError);
				RequestDispatcher rsd = request.getRequestDispatcher("/views/homeuser.jsp");
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
