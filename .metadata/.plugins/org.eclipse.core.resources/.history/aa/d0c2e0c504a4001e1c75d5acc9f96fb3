package controllerU;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;

import daoUImpl.nguoiDungDao;
import model.nguoiDung;
import serviceImpU.nguoiDungServiceImp;

/**
 * Servlet implementation class checkresetpass
 */
public class checkresetpass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkresetpass() {
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
			String oldPass = request.getParameter("currentpass");
			String newPass = request.getParameter("newpass");
			nguoiDung user = (nguoiDung)session.getAttribute("userTemp");
			if(user.getMatKhau().equals(oldPass)) {
				boolean check = false;
				String psw = DigestUtils.sha256Hex(newPass);
				check = new nguoiDungServiceImp().resetPass(user, psw);
				String notifi = "Chúc mừng bạn đã thay đổi mật khẩu thành công ! - Vui lòng đăng nhập đễ tiếp tục";
				request.setAttribute("nofication", notifi);
				RequestDispatcher rsd = request.getRequestDispatcher("/index.jsp");
				rsd.forward(request, response);
			}else {
				String error = "Mật khẩu không chính xác - Vui lòng kểm tra lại mật khẩu chúng tôi gửi cho bạn !";
				request.setAttribute("nofication", error);
				RequestDispatcher rsd = request.getRequestDispatcher("/views/resetpass.jsp");
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
