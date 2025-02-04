package controllerU;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.lich;
import model.nguoiDung;
import serviceImpU.Util;
import serviceImpU.lichServiceImp;

/**
 * Servlet implementation class addcalendar
 */
public class addcalendar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addcalendar() {
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
			nguoiDung user = (nguoiDung)session.getAttribute("userSession");
			int idUser = user.getIdNguoiDung();
			String eventName = request.getParameter("eventName");
			String contentEvent = request.getParameter("contentEvent");
			String timeOpen = request.getParameter("dateTimeOpen");
			String timeEnd = request.getParameter("dateTimeEnd");
			String dateEvent = request.getParameter("dateEvent");
			String numberRepeat = request.getParameter("numberRepeat");
			System.out.println(eventName);
			System.out.println(contentEvent);
			int numberR = 0;
			if(timeOpen.length()==0) {
				timeOpen = "00:00:00";
			}
			if(timeEnd.length()==0) {
				timeEnd = "00:00:00";
			}
			try {
				Date date = Date.valueOf(dateEvent);
				int day = new Util().convertDay(date);
				int month = new Util().convertMonth(date);
				int year = new Util().convertYear(date);
				numberR = Integer.parseInt(numberRepeat);
				if(timeOpen.length()==5) {
					timeOpen+=":00";
				}
				if(timeEnd.length()==5) {
					timeEnd+=":00";
				}
			lich lich = new lich();
			lich.setNgay(day);
			lich.setThang(month);
			lich.setNam(year);
			lich.setTenSuKien(eventName);
			lich.setNoiDung(contentEvent);
			lich.setThoiGianBatDau(Time.valueOf(timeOpen));
			lich.setThoiGianKetThuc(Time.valueOf(timeEnd));
			String notifi = "";
			notifi = new lichServiceImp().notifiAdd(idUser, lich, numberR);
			if(notifi.length()>0) {
				request.setAttribute("notification", notifi);
				RequestDispatcher rsd = request.getRequestDispatcher("/data-calendar");
				rsd.forward(request, response);
			}else {
				response.sendRedirect("/quanlythoigian/data-calendar");
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
