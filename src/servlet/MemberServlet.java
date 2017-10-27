package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import vo.Member;

@WebServlet("/member")
public class MemberServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private MemberService service = MemberService.getInstance();
///////////////////////////////////////////////////////////	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String task = request.getParameter("task");
		String path = "";
		
		if(task.equals("joinForm")) {
			path = "join_form.jsp";
		} else if(task.equals("loginForm")) {
			path = "login_form.jsp";
		} else if(task.equals("delete")) {
			String id = request.getParameter("id");
			
			System.out.println("delete servlet 동작");
			
			if(service.deleteMemberInfo(id) == 1)
				System.out.println("멤서 삭제 성공");
			path="index.jsp";
		}
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher(path);
		dispatcher.forward(request, response);		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Member > doPost() 실행");
		
		request.setCharacterEncoding("UTF-8");
		String task = request.getParameter("task");
		String path = "";
		
		if(task.equals("join")) {
			Member member = new Member();
			member.setId(request.getParameter("id"));
			member.setPw(request.getParameter("pw"));
			member.setName(request.getParameter("name"));
			member.setBirth(request.getParameter("birth"));
			member.setGender(request.getParameter("gender"));
			member.setNickname(request.getParameter("nickname"));
			member.setEmail(request.getParameter("email"));
			member.setPhone(request.getParameter("phone"));
			
			System.out.println(member);
			
			if(service.joinMember(member)) {
				path = "join/join_success.jsp";
			} else {
				path = "join/join_fail.jsp";
			}
		} else if(task.equals("login")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			System.out.println("전달된 로그인 정보: id: "+id+" pw:"+pw);
			String loginId = service.login(id,pw);
			if(loginId!=null) {
				Member memberInfo = service.getMemberInfo(loginId);
				
				HttpSession session = request.getSession();

				session.setAttribute("loginId", loginId);
				session.setAttribute("memberInfo", memberInfo);
				
				path = "join/login_success.jsp";
			}else {
				path = "join/login_fail.jsp";
			}
		} else if(task.equals("update")) {
			String id = request.getParameter("id");
			String nickname = request.getParameter("nickname");
			String pw = request.getParameter("pw");
			System.out.println("전달된 정보 수정 정보: id:"+id+"nickname:"+nickname+" pw:"+pw);
			
			service.updateMemberInfo(id, nickname, pw);

			path="index.jsp";
		} 
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

}
