package com.whereguesthome.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.whereguesthome.pojo.Admin;
import com.whereguesthome.pojo.User;

/**
 * ��¼��֤������
 * 
 * @author hp1
 *
 */
public class LoginHandlerIntercepter implements HandlerInterceptor {

	public LoginHandlerIntercepter() {
		// TODO Auto-generated constructor stub
	}

	// ����ModelAndView������
	// Ӧ�ó�����ͳһ�쳣����ͳһ��־����
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	// ����Handler�����У�����ModelAndView֮ǰִ��
	// Ӧ�ó�����ModelAndView������������ģ�����������ﴫ����ͼ��Ҳ����������ͳһָ����ͼ
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	// ����Handler����֮ǰ
	// ���������֤
	// ���������֤�������֤ͨ����ʾ��ǰ�û�û�е�½����Ҫ�˷������ز�������ִ��
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		// ��ȡ�����url
		String url = arg0.getRequestURI();
		System.out.println("����");
		// �ж�url�Ƿ�Ϊ������ַ(ʵ��ʹ�ý�������ַ�����ļ���)/
		if (url.indexOf("denglu") >= 0) {
			// ������е�¼�ύ������
			return true;
		}
		HttpSession session = arg0.getSession();
		// ��sessionȡ���û���Ϣ
		Admin user = (Admin) session.getAttribute("a");
		if (user != null) {
			return true;
		}
		// ��������Ҫ��֤��ת����¼ҳ��
		arg0.getRequestDispatcher("/WEB-INF/admin/index.jsp").forward(arg0, arg1);

		return false;
	}

}
