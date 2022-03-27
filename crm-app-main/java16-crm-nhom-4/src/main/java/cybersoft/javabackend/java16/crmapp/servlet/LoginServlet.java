package cybersoft.javabackend.java16.crmapp.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
@WebServlet(name = "loginServlet", urlPatterns = UrlConst.LOGIN)
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(JspConst.LOGIN).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		UserDao dao = new UserDao();
		List<User> list = dao.getAllUser();
		Optional<User> curUser = list.stream()
			.filter(t -> t.getEmail().equals(email))
			.filter(t -> t.getPassword().equals(password))
			.findFirst();
		
		if(curUser.isPresent()) { // login thanh cong
			HttpSession session = req.getSession();
			
			session.setAttribute("userId", "" + curUser.get().getId());
			session.setAttribute("fullname", curUser.get().getFullname());
			session.setMaxInactiveInterval(3600);
		resp.sendRedirect(req.getContextPath() + UrlConst.HOME);
	} else { //login khong thanh cong
		resp.sendRedirect(req.getContextPath() + UrlConst.LOGIN);
	}
	}
}
