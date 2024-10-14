package controllerU;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.nguoiDung;
import serviceImpU.thoiKhoaBieuServiceImp;

/**
 * Servlet implementation class xoalich
 */
public class xoalich extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xoalich() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF8");
		response.setContentType("text/html");
		String id = request.getParameter("id");
		HttpSession session = request.getSession(false);
		if(session!=null) {
			nguoiDung u = (nguoiDung)session.getAttribute("userSession");
			int idInt = 0;
			try {
				idInt = Integer.parseInt(id);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
				boolean check = false;
				check = new thoiKhoaBieuServiceImp().deleteLich(u, idInt);
				if(check) {
					response.sendRedirect("/quanlythoigian/data-tkb");
				}else {
					String error = "Đã xảy ra lỗi , vui lòng thử lai !";
					request.setAttribute("nofication", error);
					RequestDispatcher rsd = request.getRequestDispatcher("/views/homeuser.jsp");
					rsd.forward(request, response);
				}
			System.out.println(idInt);
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
