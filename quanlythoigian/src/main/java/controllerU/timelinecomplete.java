package controllerU;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.nguoiDung;
import serviceImpU.timelineServiceImp;

/**
 * Servlet implementation class timelinecomplete
 */
public class timelinecomplete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public timelinecomplete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);
		if(session!=null) {
			nguoiDung u = (nguoiDung)session.getAttribute("userSession");
			String id = request.getParameter("id");
			int idInt = 0;
			try {
				idInt = Integer.parseInt(id);
				boolean check = false;
				check = new timelineServiceImp().complete(u, idInt);
				if(check) {
					response.sendRedirect("/quanlythoigian/data-timeline");
				}else {
					String error = "Đã có lỗi xãy ra , vui lòng thử lại !";
					request.setAttribute("nofication", error);
					RequestDispatcher rsd = request.getRequestDispatcher("/views/indextimeline.jsp");
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
