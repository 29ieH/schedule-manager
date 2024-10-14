package controllerA;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.nguoiDung;
import model.suKien;
import serviceImpA.nguoiDungImp;
import serviceImpU.suKienServiceImp;

/**
 * Servlet implementation class adtbuser
 */
public class adtbuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adtbuser() {
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
			nguoiDung u = (nguoiDung)session.getAttribute("adminSession");
			String pageStr = request.getParameter("page");
			String maxItemsPageStr = request.getParameter("maxItemsPage");
			int page = 1;
			int maxItemsPage = 5;
			int toltalItems = new nguoiDungImp().countOfUser();
			try {
				page = Integer.parseInt(pageStr);
				maxItemsPage = Integer.parseInt(maxItemsPageStr);
				int totalPage = 0;
				if(toltalItems%maxItemsPage!=0) {
					 totalPage = (toltalItems/maxItemsPage)+1;
				}else {
					 totalPage = toltalItems/maxItemsPage;
				}
				int offset = (page-1)*maxItemsPage;
				List<nguoiDung> result = new nguoiDungImp().listOfUser(offset,maxItemsPage);
				request.setAttribute("totalPage", totalPage);
				request.setAttribute("currentPage", page);
				request.setAttribute("listResult", result);
				System.out.println("....");
			} catch (Exception e) {
				e.printStackTrace();
			}
			RequestDispatcher rsd = request.getRequestDispatcher("/views/admin/home.jsp");
			rsd.forward(request, response);
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
