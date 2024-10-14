package controllerU;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.nguoiDung;
import model.suKien;
import model.thoiGianTrongNgay;
import serviceImpU.timelineServiceImp;

/**
 * Servlet implementation class addtimeline
 */
public class addtimeline extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addtimeline() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session!=null) {
			boolean check = false;
			nguoiDung u = (nguoiDung)session.getAttribute("userSession");
			String tenSuKien = request.getParameter("tenSuKienz");
			String moTaNgan = request.getParameter("moTaNganz");
			String diaDiem = request.getParameter("diaChiz");
			String thoiGianBatDau = request.getParameter("thoiGianBatDauz");
			String thoiGianKetThuc = request.getParameter("thoiGianKetThucz");
			System.out.println(thoiGianBatDau);
			System.out.println(thoiGianKetThuc);
			if(thoiGianBatDau.length()<=5) {
				thoiGianBatDau+=":00";
			}
			if(thoiGianKetThuc.length()<=5) {
				thoiGianKetThuc+=":00";
			}
			thoiGianTrongNgay tl = new thoiGianTrongNgay();
			tl.setTenHoatDong(tenSuKien);
			tl.setMoTaNgan(moTaNgan);
			tl.setDiaDiem(diaDiem);
			tl.setThoiGianBatDau(Time.valueOf(thoiGianBatDau));
			tl.setThoiGianKetThuc(Time.valueOf(thoiGianKetThuc));
			check = new timelineServiceImp().checkAdd(u, tl);
			if(check) {
				response.sendRedirect("/quanlythoigian/data-timeline");
			}else {
				String error = "Đã xảy ra lỗi ! , Có vẻ thời gian của hoạt động mà bạn muốn thêm đã bị trùng. Xin hãy thử lại";
				request.setAttribute("nofication", error);
				RequestDispatcher rsd = request.getRequestDispatcher("/views/indextimeline.jsp");
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
