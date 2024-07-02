package kr.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mvc.model.UserDto;
import kr.mvc.model.UserManager;

public class DeleteFormController implements Controller{
	
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String userid = request.getParameter("userid");
		
		int res = UserManager.instance().delete(userid);
		request.setAttribute("user", res);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("list.m2");
		modelAndView.setRedirect(true);
		
		return modelAndView;
	}
	
}
