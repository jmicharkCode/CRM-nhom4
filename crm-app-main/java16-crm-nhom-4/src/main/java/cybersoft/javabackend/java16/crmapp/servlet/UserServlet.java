package cybersoft.javabackend.java16.crmapp.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.javabackend.java16.crmapp.dao.UserDao;
import cybersoft.javabackend.java16.crmapp.model.User;
import cybersoft.javabackend.java16.crmapp.utils.JspConst;
import cybersoft.javabackend.java16.crmapp.utils.UrlConst;
@WebServlet(name = "userServlet", urlPatterns = {UrlConst.USER_DASHBOARD,UrlConst.USER_ADD})
public class UserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = req.getServletPath();
		switch(path) {
		case UrlConst.USER_DASHBOARD:
			UserDao dao = new UserDao();
			List<User> list = dao.getAllUser();
			req.setAttribute("users", list);
			req.getRequestDispatcher(JspConst.USER_DASHBOARD).forward(req, resp);
			break;
		case UrlConst.USER_ADD:
			req.getRequestDispatcher(JspConst.USER_ADD).forward(req, resp);
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
			UserDao dao = new UserDao();
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String fullname = req.getParameter("name");
			String phone = req.getParameter("phone");
			String address = req.getParameter("address");
			String[] roles = req.getParameterValues("role");
			int role = 0;
			for(int i = 0; i < roles.length; i++) {
				 role = Integer.parseInt(roles[i]);
			}
			User user = new User();
			user.setEmail(email);
			user.setPassword(password);
			user.setFullname(fullname);
			user.setAddress(address);
			user.setPhone(phone);
			user.setRole(role);
			dao.addUser(user);
			req.getRequestDispatcher(JspConst.USER_DASHBOARD).forward(req, resp);
			break;
		default:
			break;
		}
	}
	
}
