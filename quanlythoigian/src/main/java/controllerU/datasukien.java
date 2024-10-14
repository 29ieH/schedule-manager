package controllerU;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.nguoiDung;
import model.suKien;
import serviceImpU.suKienServiceImp;

/**
 * Servlet implementation class datasukien
 */
public class datasukien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public datasukien() {
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
			LocalDate current = LocalDate.now();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String myDate = current.format(format);
			ServletContext context = getServletContext();
			List<suKien> listOfUt = new suKienServiceImp().listUuTien(u, myDate);
			List<suKien> listAll = new suKienServiceImp().listAll(u);
			List<suKien> listOfHocTap = new suKienServiceImp().listOfType(u, myDate, "Học tập");
			List<suKien> listOfCongViec = new suKienServiceImp().listOfType(u, myDate, "Công việc");
			List<suKien> listOfBuoiTiec = new suKienServiceImp().listOfType(u, myDate, "Buổi tiệc");
			List<suKien> listOfD = new suKienServiceImp().listOfDay(u, myDate);
			context.setAttribute("listOfUt", listOfUt);
			context.setAttribute("listOfHocTap", listOfHocTap);
			context.setAttribute("listOfCongViec", listOfCongViec);
			context.setAttribute("listOfBuoiTiec", listOfBuoiTiec);
			response.sendRedirect("/quanlythoigian/views/indexevent.jsp");
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
