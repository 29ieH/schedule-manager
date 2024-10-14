package controllerU;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.nguoiDung;
import serviceImpU.nguoiDungServiceImp;

/**
 * Servlet implementation class dangky
 */
@WebServlet("/dang-ky")
public class dangky extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangky() {
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
		nguoiDung check = new nguoiDung();
		String hoVaTen = request.getParameter("hoVaTen");
		String email = request.getParameter("email");
		String taiKhoan = request.getParameter("taiKhoan");
		String matKhau = request.getParameter("matKhau");
		String ngaySinh = request.getParameter("ngaySinh");
		String gioiTinh = request.getParameter("gioiTinh");
		String diaChi = request.getParameter("diaChi");
		check.setHoVaTen(hoVaTen);
		check.setEmail(email);
		check.setTaiKhoan(taiKhoan);
		check.setMatKhau(matKhau);
		check.setNgaySinh(Date.valueOf(ngaySinh));
		check.setGioiTinh(gioiTinh);
		check.setDiaChi(diaChi);
		String error = new nguoiDungServiceImp().checkDangKy(check);
		if(error.length()!=0) {
			String errorEmail ="";
			String errorTk ="";
			String errorlist[] = null;
				errorlist = error.split(",");	
				if(errorlist.length==2){
					if(errorlist[0].length()==0){
						errorEmail = errorlist[1];
						errorTk = "";
					}else{
						errorTk = errorlist[0];
						errorEmail = errorlist[1];
					}
				}
				request.setAttribute("errorEmail",errorEmail);
				request.setAttribute("errorTk", errorTk);
				String nofication = "Tài khoản hoặc email của bạn đã bị trùng ! , Vui lòng thử lại";
				request.setAttribute("error", nofication);
				RequestDispatcher rsd = request.getRequestDispatcher("/views/dangky.jsp");
				rsd.forward(request, response);
		}else {
			int id = 0;
			id = new nguoiDungServiceImp().addTaiKhoan(check);
			if(id!=0) {
				HttpSession session = request.getSession();
				String nofication = "Chúc mừng bạn đăng ký thành công ! , vui lòng chọn đăng nhập đễ tiếp tục";
				session.setAttribute("nofication", nofication);
				request.setAttribute("nofication", nofication);
				RequestDispatcher rsd = request.getRequestDispatcher("/index.jsp");
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
