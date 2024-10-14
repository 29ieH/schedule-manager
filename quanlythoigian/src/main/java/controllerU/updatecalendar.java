package controllerU;

import java.io.IOException;
import java.sql.Time;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.lich;
import model.nguoiDung;
import serviceImpU.lichServiceImp;

/**
 * Servlet implementation class updatecalendar
 */
public class updatecalendar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatecalendar() {
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
			nguoiDung user = (nguoiDung)session.getAttribute("userSession");
			int idUser = user.getIdNguoiDung();
			String id = request.getParameter("id");
			String eventName = request.getParameter("tenSuKien");
			String contentEvent = request.getParameter("noiDung");
			String timeOpen = request.getParameter("thoiGianBatDau");
			String timeEnd = request.getParameter("thoiGianKetThuc");
			String day = request.getParameter("day");
			String month = request.getParameter("month");
			String year = request.getParameter("year");
			if(timeOpen.length()==0) {
				timeOpen = "00:00:00";
			}
			if(timeEnd.length()==0) {
				timeEnd = "00:00:00";
			}
			try {
				int idLich = Integer.parseInt(id);
				int dayInt = Integer.parseInt(day);
				int monthInt = Integer.parseInt(month);
				int yearInt = Integer.parseInt(year);
				if(timeOpen.length()==5) {
					timeOpen+=":00";
				}
				if(timeEnd.length()==5) {
					timeEnd+=":00";
				}
				lich lich = new lich();
				lich.setIdLich(idLich);
				lich.setNgay(dayInt);
				lich.setThang(monthInt);
				lich.setNam(yearInt);
				lich.setTenSuKien(eventName);
				lich.setNoiDung(contentEvent);
				lich.setThoiGianBatDau(Time.valueOf(timeOpen));
				lich.setThoiGianKetThuc(Time.valueOf(timeEnd));
				boolean check = new lichServiceImp().checkUpdate(idUser, lich);
				if(check) {
					response.sendRedirect("/quanlythoigian/data-calendar");
				}else {
					String noti = "Thời gian mà bạn muốn cập nhập đã bị trùng với một sự kiện nào đó trong ngày ! - Vui lòng thử lại";
					request.setAttribute("nofication", noti);
					RequestDispatcher rsd = request.getRequestDispatcher("/views/viewcalendar.jsp");
					rsd.forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
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
