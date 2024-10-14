package controllerU;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.nguoiDung;
import serviceImpU.lichServiceImp;

/**
 * Servlet implementation class deletecalendar
 */
public class deletecalendar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletecalendar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		if(session!=null) {
			nguoiDung user = (nguoiDung)session.getAttribute("userSession");
			int idUser = user.getIdNguoiDung();
			String id = request.getParameter("id");
			try {
				int idLich = Integer.parseInt(id);
				boolean check = new lichServiceImp().deleteCalendar(idUser, idLich);
				if(check) {
					response.sendRedirect("/quanlythoigian/data-calendar");
				}else {
					String noti = "Đã xảy ra lỗi ! - Vui lòng thử lại";
					request.setAttribute("nofication", noti);
					RequestDispatcher rsd = request.getRequestDispatcher("/data-calendar");
					rsd.forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
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
