package controllerU;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.lich;
import model.nguoiDung;
import serviceImpU.lichServiceImp;

/**
 * Servlet implementation class datacalendar
 */
public class datacalendar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public datacalendar() {
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
			String notification = (String)request.getAttribute("notification");
			nguoiDung user= (nguoiDung)session.getAttribute("userSession");
			int idUser = user.getIdNguoiDung();
			List<lich> listAllOfUser = new lichServiceImp().listAllOfUser(idUser);
			if(listAllOfUser==null) {
				response.sendRedirect("/quanlythoigian/views/calendar.jsp");
			}else {
				if(notification!=null) {
					request.setAttribute("nofication", notification);
				}
				request.setAttribute("listCalendar", listAllOfUser);
				RequestDispatcher rsd = request.getRequestDispatcher("/views/calendar.jsp");
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
