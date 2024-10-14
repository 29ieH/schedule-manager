package controllerU;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daoUImpl.suKienDao;
import model.nguoiDung;
import model.suKien;
import serviceImpU.suKienServiceImp;

/**
 * Servlet implementation class themsukien
 */
@WebServlet("/them-su-kien")
public class themsukien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public themsukien() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session!=null) {
			nguoiDung u = (nguoiDung)session.getAttribute("userSession");
			suKien e = new suKien();
			String tenSuKien = request.getParameter("tenSuKien");
			String moTaNgan = request.getParameter("moTa");
			String ngay = request.getParameter("ngay");
			String thoiGianBatDau = request.getParameter("thoiGianBatDau");
			String thoiGianKetThuc = request.getParameter("thoiGianKetThuc");
			String diaDiem = request.getParameter("diaDiem");
			String henGio = request.getParameter("henGio");
			String nguoiThamGia = request.getParameter("nguoiThamGia");
			String loaiSuKien = request.getParameter("loaiSuKien");
			String suKienUuTien = request.getParameter("suUuTien");
			int suKienUuTienInt = 0;
			if(suKienUuTien!=null) {
				if(suKienUuTien.equals("on")) {
					suKienUuTienInt = 1;
				}
			}
			thoiGianBatDau+=":00";
			thoiGianKetThuc+=":00";
			int henGioInt = new suKienDao().convertHenGio(henGio);
			int check = 0;
			e.setTenSuKien(tenSuKien);
			e.setMoTaNgan(moTaNgan);
			e.setNgayDienRaSuKien(Date.valueOf(ngay));
			e.setThoiGianBatDau(Time.valueOf(thoiGianBatDau));
			e.setThoiGianKetThuc(Time.valueOf(thoiGianKetThuc));
			e.setDiaDiem(diaDiem);
			e.setHenGioTruocSuKien(henGioInt);
			e.setNhungNguoiThamGia(nguoiThamGia);
			e.setLoaiSuKien(loaiSuKien);
			e.setSuKienUuTien(suKienUuTienInt);
			check = new suKienServiceImp().checkAdd(u, e);
			if(check!=0) {
				response.sendRedirect("/quanlythoigian/data-sukien");
			}else {
				String error = "Xin lỗi , Thời gian diễn ra sự kiện của bạn đã bị trùng trong ngày hôm nay rồi !";
				request.setAttribute("errorMessage", error);
				RequestDispatcher rsd = request.getRequestDispatcher("/views/addevent.jsp");
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
