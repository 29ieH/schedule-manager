package controllerU;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.nguoiDung;
import serviceImpU.suKienServiceImp;
import serviceImpU.timelineServiceImp;

/**
 * Servlet implementation class deletesukien
 */
public class deletesukien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletesukien() {
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
				check = new suKienServiceImp().delete(u, idInt);
				System.out.println(idInt);
				if(check) {
					response.sendRedirect("/quanlythoigian/data-sukien");
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
