package controllerU;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.lich;
import model.nguoiDung;
import serviceImpU.lichServiceImp;

/**
 * Servlet implementation class viewcalendar
 */
public class viewcalendar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewcalendar() {
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
			String idStr = request.getParameter("id");
			try {
				int idUser = user.getIdNguoiDung();
				int idLich = Integer.parseInt(idStr);
				lich lich = new lichServiceImp().LichOfId(idUser, idLich);
				if(lich!=null) {
					ServletContext context = getServletContext();
					context.setAttribute("lichModel", lich);
					response.sendRedirect("/quanlythoigian/views/viewcalendar.jsp");
				}else {
					String noti = "Đã có lỗi xảy ra vui lòng thử lại !";
					request.setAttribute("nofication", noti);
					RequestDispatcher rsd = request.getRequestDispatcher("/views/data-calendar");
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
