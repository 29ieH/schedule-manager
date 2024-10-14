package controllerU;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daoUImpl.suKienDao;
import model.nguoiDung;
import model.suKien;
import serviceImpU.suKienServiceImp;

/**
 * Servlet implementation class editsukien
 */
public class editsukien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editsukien() {
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
			String id = request.getParameter("id");
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
			int idInt = 0;
			try {
				idInt = Integer.parseInt(id);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			if(thoiGianBatDau.length()<=5) {
				thoiGianBatDau+=":00";
			}
			if(thoiGianKetThuc.length()<=5) {
				thoiGianKetThuc+=":00";
			}
			int henGioInt = new suKienDao().convertHenGio(henGio);
			e.setIdSuKien(idInt);
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
			boolean check = false;
			check = new suKienServiceImp().checkUpdate(u, e);
			if(check) {
				response.sendRedirect("/quanlythoigian/data-sukien");
			}else {
				String error = "Có vẻ như thời gian mà bạn muốn thay đổi đã trùng với một sự kiện nào khác, Vui lòng thử lại !";
				request.setAttribute("nofication", error);
				RequestDispatcher rsd = request.getRequestDispatcher("/views/editevent.jsp");
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
