package kr.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mvc.model.UserManager;

public class UpdateController implements Controller{
	
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		UserForm userForm = new UserForm();
		userForm.setUserid(request.getParameter("userid"));
		userForm.setPassword(request.getParameter("password"));
		userForm.setName(request.getParameter("name"));
		userForm.setEmail(request.getParameter("email"));
		
		int result = UserManager.instance().update(userForm);
		
		ModelAndView modelAndView = new ModelAndView();
		if(result > 0) {
			// update 후 목록보기
			modelAndView.setViewName("list.m2");
		}else {
			modelAndView.setViewName("fail.html");
		}
		modelAndView.setRedirect(true);
		
		return modelAndView;
	}
	
}
