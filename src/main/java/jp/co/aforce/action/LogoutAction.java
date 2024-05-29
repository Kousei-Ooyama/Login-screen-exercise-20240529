package jp.co.aforce.action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		HttpSession session = request.getSession();
		
		if(session.getAttribute("customer") != null) {
			session.invalidate();
			return "/jsp/logout-bye.jsp";
		}
		
		return "/jsp/logout-error.jsp";
	}

}
