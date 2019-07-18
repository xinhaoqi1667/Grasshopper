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
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.hp.entity.Result;
import com.hp.services.FansServices;
import com.hp.servicesImpl.FansServicesImpl;

/**
 * Servlet implementation class FansServlet
 */
@WebServlet("/FansServlet")
public class FansServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int id;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("测试");
		String method = request.getParameter("method");
		switch (method) {
		case "StatusCode":
			//返回状态码
			this.StatusCode(request, response);
			break;
		case "GetName":
			//返回粉丝名字的集合
			this.GetName(response);
			break;
		default:
			break;
		}
	}
	
	//返回粉丝名字的集合
	public void GetName(HttpServletResponse response) throws IOException {
		response.setContentType("application/json;charset=utf-8");
		FansServices fansServicesImpl = new FansServicesImpl();
		//使用Gson序列化	
		Gson gson=new Gson();
		String json=null;
		PrintWriter out=null;
		out=response.getWriter();
		try {
			List list = fansServicesImpl.user_name(fansServicesImpl.Fans_userid(id));
			Result result = new Result("200","请求成功！");
			Map map=new HashMap<>();
			map.put("result",result);
			map.put("resultName",list);
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
	
	//返回状态码
	public void StatusCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		FansServices fansServicesImpl = new FansServicesImpl();
		Gson gson=new Gson();
		String json=null;
		PrintWriter out=null;
		try {
			int user_id = Integer.valueOf(request.getParameter("user_id"));
			System.out.println("接收过来的值是"+user_id);
			//将java对象转为json格式的的字符串
			json = gson.toJson(fansServicesImpl.getData(user_id));
			id = user_id;
			response.setContentType("application/json;charset=utf-8");
			out = response.getWriter();
		} catch (NullPointerException e) {
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

}
