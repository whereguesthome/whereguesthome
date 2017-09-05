package com.whereguesthome.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.whereguesthome.pojo.Admin;
import com.whereguesthome.pojo.User;

/**
 * 登录认证拦截器
 * 
 * @author hp1
 *
 */
public class LoginHandlerIntercepter implements HandlerInterceptor {

	public LoginHandlerIntercepter() {
		// TODO Auto-generated constructor stub
	}

	// 进入ModelAndView方法后
	// 应用场景，统一异常处理，统一日志处理
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	// 进入Handler方法中，返回ModelAndView之前执行
	// 应用场景从ModelAndView出发，将公用模型数据在这里传到视图，也可以在这里统一指定视图
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	// 进入Handler方法之前
	// 用于身份认证
	// 比如身份认证，如果认证通过表示当前用户没有登陆，需要此方法拦截不再向下执行
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		// 获取请求的url
		String url = arg0.getRequestURI();
		System.out.println("哈哈");
		// 判断url是否为公开地址(实际使用将公开地址配在文件中)/
		if (url.indexOf("denglu") >= 0) {
			// 如果进行登录提交，放行
			return true;
		}
		HttpSession session = arg0.getSession();
		// 从session取出用户信息
		Admin user = (Admin) session.getAttribute("a");
		if (user != null) {
			return true;
		}
		// 如果身份需要认证跳转到登录页面
		arg0.getRequestDispatcher("/WEB-INF/admin/index.jsp").forward(arg0, arg1);

		return false;
	}

}
