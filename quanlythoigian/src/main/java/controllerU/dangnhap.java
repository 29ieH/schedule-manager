package controllerU;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.nguoiDung;
import model.thoiKhoaBieu;
import serviceImpU.nguoiDungServiceImp;
import serviceImpU.thoiKhoaBieuServiceImp;

/**
 * Servlet implementation class dangnhap
 */
@WebServlet("/dang-nhap")
public class dangnhap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangnhap() {
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
		String taiKhoan = request.getParameter("taiKhoan");
		String matKhau = request.getParameter("matKhau");
		nguoiDung check = new nguoiDung();
		check.setTaiKhoan(taiKhoan);
		check.setMatKhau(matKhau);
		nguoiDung result = null;
		result = new nguoiDungServiceImp().dangNhap(check);
		String url = "";
		if(result!=null) {
			if(result.getIdRole()==0&&result.getStatus()==1) {
				request.setAttribute("user", result);
				HttpSession session = request.getSession();
				ServletContext context = getServletContext();
				session.setAttribute("userSession", result);
				context.setAttribute("usserContext", result);
				session.setAttribute("userName", result.getHoVaTen());
				response.sendRedirect("/quanlythoigian/data-tkb");
			}
			if(result.getIdRole()==1&&result.getStatus()==1) {
				request.setAttribute("adminr", result);
				HttpSession session = request.getSession();
				ServletContext context = getServletContext();
				session.setAttribute("adminSession", result);
				context.setAttribute("adminSession", result);
				session.setAttribute("userName", result.getHoVaTen());
				response.sendRedirect("/quanlythoigian/a-dtb-user?page=1&maxItemsPage=5");
			}
			if(result.getStatus()==0){
				String error = "Tài khoản của bạn đã bị khóa !.Vui lòng vào mục hỗ trợ đễ được hiểu rõ";
				request.setAttribute("nofication", error);
				RequestDispatcher rsd = request.getRequestDispatcher("/views/dangnhap.jsp");
				rsd.forward(request, response);
			}
			
		}else {
			String error = "Tài khoản hoặc mật khẩu không hợp lệ !";
			request.setAttribute("error", (String)error);
			RequestDispatcher rsd = request.getRequestDispatcher("/views/dangnhap.jsp");
			rsd.forward(request, response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
