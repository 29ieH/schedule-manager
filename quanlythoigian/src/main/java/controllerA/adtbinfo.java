package controllerA;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.nguoiDung;
import serviceImpA.nguoiDungImp;

/**
 * Servlet implementation class adtbinfo
 */
public class adtbinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adtbinfo() {
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
			String idStr = request.getParameter("id");
			int idInt = 0;
			try {
				idInt = Integer.parseInt(idStr);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			nguoiDung result = new nguoiDungImp().selectOne(idInt);
			if(result!=null) {
				ServletContext context = getServletContext();
				context.setAttribute("listResult",result);
			}
			response.sendRedirect("/quanlythoigian/views/admin/edituser.jsp");
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
