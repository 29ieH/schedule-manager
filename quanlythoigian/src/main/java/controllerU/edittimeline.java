package controllerU;

import java.io.IOException;
import java.sql.Time;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.nguoiDung;
import model.thoiGianTrongNgay;
import serviceImpU.timelineServiceImp;

/**
 * Servlet implementation class edittimeline
 */
public class edittimeline extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edittimeline() {
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
			String tenHoatDong = request.getParameter("tenSuKien");
			String moTaNgan = request.getParameter("moTaNgan");
			String diaDiem = request.getParameter("diaChi");
			String thoiGianBatDau = request.getParameter("thoiGianBatDau");
			String thoiGianKetThuc = request.getParameter("thoiGianKetThuc");
			int idInt = 0;
			try {
				idInt = Integer.parseInt(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(thoiGianBatDau.length()<=5) {
				thoiGianBatDau+=":00";
			}
			if(thoiGianKetThuc.length()<=5) {
				thoiGianKetThuc+=":00";
			}
			System.out.println(idInt);
			System.out.println(tenHoatDong);
			System.out.println(moTaNgan);
			System.out.println(diaDiem);
			System.out.println(thoiGianBatDau);
			System.out.println(thoiGianKetThuc);
			thoiGianTrongNgay tg = new thoiGianTrongNgay();
			tg.setIdThoiGianTrongNgay(idInt);
			tg.setTenHoatDong(tenHoatDong);
			tg.setMoTaNgan(moTaNgan);
			tg.setDiaDiem(diaDiem);
			tg.setThoiGianBatDau(Time.valueOf(thoiGianBatDau));
			tg.setThoiGianKetThuc(Time.valueOf(thoiGianKetThuc));
			boolean check = false;
			check = new timelineServiceImp().checkEdit(u, tg);
			if(check) {
				response.sendRedirect("/quanlythoigian/data-timeline");
			}else {
				System.out.println("error");
				String error = "Xin lỗi có thể thời gian bạn muốn thay đổi đã bị trùng với một số nhiệm vụ khác, Vui lòng thay đổi lại !";
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
