package com.hp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.hp.entity.Result;
import com.hp.services.QueryUserServices;
import com.hp.servicesImpl.QueryUserServicesImpl;

/**
 * Servlet implementation class QueryUserServlet
 */
@WebServlet("/QueryUserServlet")
public class QueryUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String user_names = null;
   
	protected void service(HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		switch (method) {
		case "quer":
			this.quer(request,response);
			break;
		case "GetUser":
			this.GetUser(request,response);
			break;
		default:
			break;
		}
	}
	

	public void quer(HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {
		QueryUserServices queryUserServicesImpl = new QueryUserServicesImpl();
		//使用Gson序列化	
		Gson gson=new Gson();
		String json=null;
		PrintWriter out=null;
		try {
			String user_name = request.getParameter("user_name");
			System.out.println("接收过来的值是"+user_name);
			//将java对象转为json格式的的字符串
			json = gson.toJson(queryUserServicesImpl.getData(user_name));
			user_names = user_name;
			response.setContentType("application/json;charset=utf-8");
			out = response.getWriter();
		} catch (Exception e) {
			System.out.println("参数异常");
			// TODO: handle exception
			e.printStackTrace();
			Result result = new Result("1003","参数不能为空！");
			//转为json格式的字符串
			json = gson.toJson(result);
		}
		System.out.println(json);
		//将结果以json形式暴露返回出去
		out.write(json);
	}
   
	public void GetUser(HttpServletRequest request,javax.servlet.http.HttpServletResponse response) throws IOException {
		response.setContentType("application/json;charset=utf-8");
		QueryUserServices queryUserServicesImpl = new QueryUserServicesImpl();
		//使用Gson序列化	
		Gson gson=new Gson();
		String json=null;
		PrintWriter out=null;
		out=response.getWriter();
		try {
			List list = queryUserServicesImpl.getUser(user_names);
			
			 Result result = new Result("200","请求成功！");
			 Map map=new HashMap<>();
			 map.put("result",result);
			 map.put("resultUser",list);
			 json=gson.toJson(map);
		} catch (Exception e) {
			e.printStackTrace();
			Result result = new Result("1005","数据获取异常！");
			//转为json格式的字符串
			json = gson.toJson(result);
			// TODO: handle exception
		}

		System.out.println(json);
		//将结果以json形式暴露返回出去
		out.write(json);
	}

}
