package com.xxglpt.utile;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

/**
 * 应答页面工具类
 * @author wusq
 *
 */
public class ResponseUtils {

	public static void write(HttpServletResponse response, String result){
		try {
			response.getWriter().write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static HttpSession getSession() {
		HttpServletRequest  request= ServletActionContext.getRequest();
	    HttpSession session = request.getSession();
	    session.setAttribute("name","JACK");
		return session;
	}
}
