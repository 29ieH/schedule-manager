package controllerU;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.nguoiDung;
import model.thoiKhoaBieu;
import serviceImpU.thoiKhoaBieuServiceImp;

/**
 * Servlet implementation class datatkb
 */
public class datatkb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public datatkb() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session!=null) {
			nguoiDung user = (nguoiDung)session.getAttribute("userSession");
			ServletContext context = getServletContext();
			if(user!=null){
				List<thoiKhoaBieu> t2S = new thoiKhoaBieuServiceImp().listOfDayS(user, "Thứ 2");
				List<thoiKhoaBieu> t2C = new thoiKhoaBieuServiceImp().listOfDayC(user, "Thứ 2");
				List<thoiKhoaBieu> t3S = new thoiKhoaBieuServiceImp().listOfDayS(user, "Thứ 3");
				List<thoiKhoaBieu> t3C = new thoiKhoaBieuServiceImp().listOfDayC(user, "Thứ 3");
				List<thoiKhoaBieu> t4S = new thoiKhoaBieuServiceImp().listOfDayS(user, "Thứ 4");
				List<thoiKhoaBieu> t4C = new thoiKhoaBieuServiceImp().listOfDayC(user, "Thứ 4");
				List<thoiKhoaBieu> t5S = new thoiKhoaBieuServiceImp().listOfDayS(user, "Thứ 5");
				List<thoiKhoaBieu> t5C = new thoiKhoaBieuServiceImp().listOfDayC(user, "Thứ 5");
				List<thoiKhoaBieu> t6S = new thoiKhoaBieuServiceImp().listOfDayS(user, "Thứ 6");
				List<thoiKhoaBieu> t6C = new thoiKhoaBieuServiceImp().listOfDayC(user, "Thứ 6");
				List<thoiKhoaBieu> t7S = new thoiKhoaBieuServiceImp().listOfDayS(user, "Thứ 7");
				List<thoiKhoaBieu> t7C = new thoiKhoaBieuServiceImp().listOfDayC(user, "Thứ 7");
				List<thoiKhoaBieu> cnS = new thoiKhoaBieuServiceImp().listOfDayS(user, "Chủ Nhật");
				List<thoiKhoaBieu> cnC = new thoiKhoaBieuServiceImp().listOfDayC(user, "Chủ Nhật");
				context.setAttribute("t2S", t2S);
				context.setAttribute("t2C", t2C);
				context.setAttribute("t3S", t3S);
				context.setAttribute("t3C", t3C);
				context.setAttribute("t4S", t4S);
				context.setAttribute("t4C", t4C);
				context.setAttribute("t5S", t5S);
				context.setAttribute("t5C", t5C);
				context.setAttribute("t6S", t6S);
				context.setAttribute("t6C", t6C);
				context.setAttribute("t7S", t7S);
				context.setAttribute("t7C", t7C);
				context.setAttribute("cnS", cnS);
				context.setAttribute("cnC", cnC);
				response.sendRedirect("/quanlythoigian/views/homeuser.jsp");
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
