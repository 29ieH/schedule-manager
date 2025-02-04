package controllerA;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daoUImpl.nguoiDungDao;

/**
 * Servlet implementation class aedituser
 */
public class aedituser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public aedituser() {
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
			boolean check = false;
			String idStr = request.getParameter("id");
			String editStatus = request.getParameter("editStatus");
			int editStatusInt = 9;
			int idInt = 0;
			try {
				idInt = Integer.parseInt(idStr);
				editStatusInt = Integer.parseInt(editStatus);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			if(editStatusInt==2) {
				response.sendRedirect("/quanlythoigian/a-dtb-user?page=1&maxItemsPage=5");
			}else {
				if(editStatusInt==1||editStatusInt==0) {
					check = new nguoiDungDao().updateStatus(idInt, editStatusInt);
				}
				if(check) {
					response.sendRedirect("/quanlythoigian/a-dtb-user?page=1&maxItemsPage=5");
				}else {
					String error = "Đã xảy ra lỗi vui lòng thử lại !";
					request.setAttribute("nofication", error);
					RequestDispatcher rsd = request.getRequestDispatcher("/views/admin/edituser.jsp");
					rsd.forward(request, response);
				}
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
