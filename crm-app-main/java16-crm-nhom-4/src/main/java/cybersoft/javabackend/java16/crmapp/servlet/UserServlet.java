package cybersoft.javabackend.java16.crmapp.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cybersoft.javabackend.java16.crmapp.dao.UserDao;
import cybersoft.javabackend.java16.crmapp.model.User;
import cybersoft.javabackend.java16.crmapp.utils.JspConst;
import cybersoft.javabackend.java16.crmapp.utils.UrlConst;
@WebServlet(name = "userServlet", urlPatterns = {UrlConst.USER_DASHBOARD,UrlConst.USER_ADD, UrlConst.USER_DELETE, UrlConst.USER_UPDATE})
public class UserServlet extends HttpServlet {
	private UserDao userDao = null;

	@Override
	public void init() throws ServletException {
		userDao = new UserDao();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = req.getServletPath();
		switch(path) {
		case UrlConst.USER_DASHBOARD:
			
			List<User> list = userDao.getAllUser();
			req.setAttribute("users", list);
			req.getRequestDispatcher(JspConst.USER_DASHBOARD).forward(req, resp);
			break;
		case UrlConst.USER_ADD:
			req.getRequestDispatcher(JspConst.USER_ADD).forward(req, resp);
			break;
		case UrlConst.USER_DELETE:
			userDao.delete(req.getParameter("id"));
			req.setAttribute("users", userDao.getAllUser());
			req.getRequestDispatcher(JspConst.USER_DASHBOARD).forward(req, resp);
			break;
		case UrlConst.USER_UPDATE:
			String id = req.getParameter("id");
			req.setAttribute("id", id);
			req.getRequestDispatcher(JspConst.USER_UPDATE).forward(req, resp);;
			break;
		default:
			break;
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String path = req.getServletPath();
		
		switch(path) {
		case UrlConst.USER_ADD:
			
			User user = new User();
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String address = req.getParameter("address");
			String password = req.getParameter("password");
			String phone = req.getParameter("phone");
			user.setEmail(email);
			user.setAddress(address);
			user.setPhone(phone);
			user.setPassword(password);
			user.setFullname(name);
		    userDao.addUser(user);
			req.getRequestDispatcher(JspConst.USER_ADD).forward(req, resp);
			
			break;
		case UrlConst.USER_UPDATE:
			
			String name1 = req.getParameter("name");
			String email1 = req.getParameter("email");
			String address1 = req.getParameter("address");
			
			String id1 = req.getParameter("id");
			String phone1 = req.getParameter("phone");
			userDao.update(id1, name1, email1, address1, phone1);
			req.setAttribute("users", userDao.getAllUser());
			req.getRequestDispatcher(JspConst.USER_DASHBOARD).forward(req, resp);
			break;
		default:
			break;
		}
	}
	
}
