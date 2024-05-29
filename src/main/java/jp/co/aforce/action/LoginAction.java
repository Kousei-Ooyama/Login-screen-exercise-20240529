package jp.co.aforce.action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.aforce.bean.Customer;
import jp.co.aforce.dao.LoginDAO;

public class LoginAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		HttpSession session=request.getSession();
		
		request.setCharacterEncoding("utf-8");
		String login_name=request.getParameter("login_name");
		String password = request.getParameter("password");
		
		LoginDAO dao = new LoginDAO();
		Customer customer=dao.search(login_name, password);
		
		//データベースに存在しない場合
		if(customer == null) {
			request.setAttribute("login_name", login_name);
			return "/jsp/login.jsp";
		}
		
		session.setAttribute("customer", customer);
		return "/jsp/login-welcome.jsp";
	}

}
