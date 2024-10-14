package controllerU;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.nguoiDung;
import model.suKien;
import serviceImpU.suKienServiceImp;

/**
 * Servlet implementation class dataeditsukien
 */
public class dataeditsukien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dataeditsukien() {
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
			ServletContext context = getServletContext();
			String id = request.getParameter("id");
			int idInt = 0;
			try {
				idInt = Integer.parseInt(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			suKien sk = new suKienServiceImp().selectByID(user, idInt);
			context.setAttribute("suKien", sk);
			response.sendRedirect("/quanlythoigian/views/editevent.jsp");
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
