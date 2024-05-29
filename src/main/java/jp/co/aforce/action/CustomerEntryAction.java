package jp.co.aforce.action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jp.co.aforce.dao.LoginDAO;

public class CustomerEntryAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		request.setCharacterEncoding("utf-8");
		String login_name=request.getParameter("login_name");
		String password =request.getParameter("password");
		String password_again = request.getParameter("password_again");
		
		if(password.equals(password_again)) {
			LoginDAO dao = new LoginDAO();
			if(dao.search(login_name) == null) {
				//loginテーブル内に同じlogin_nameがなかったのでinsert
				dao.insert(login_name, password);
				return "/jsp/customer-entry-success.jsp";
			}else {
				//loginテーブル内に同じlogin_nameがあったのでもう一度
				request.setAttribute("entry_result", "login_name-error");
				return "/jsp/customer-entry.jsp";
			}
		}
		
		request.setAttribute("entry_result", "password-error");
		return "/jsp/customer-entry.jsp";
		
	}

}
