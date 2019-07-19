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

import org.omg.CORBA.Request;

import com.google.gson.Gson;
import com.hp.entity.Result;
import com.hp.services.ConditionReleaseServices;
import com.hp.services.FansServices;
import com.hp.servicesImpl.ConditionReleaseServicesImpl;
import com.hp.servicesImpl.FansServicesImpl;

/**
 * Servlet implementation class ConditionReleaseServlet
 */
@WebServlet("/ConditionReleaseServlet")
public class ConditionReleaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int sort_id;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		switch (method) {
		case "csh":
			this.csh(response);
			break;
		case "StatusCode":
			this.StatusCode(request, response);
			break;	
		case "sw":
			this.sw(request, response);
			break;	
		default:
			break;
		}
		
	}

	public void sw(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("application/json;charset=utf-8");
		ConditionReleaseServices conditionReleaseServicesImpl = new ConditionReleaseServicesImpl();
		//使用Gson序列化	
				Gson gson=new Gson();
				String json=null;
				PrintWriter out=null;
				out=response.getWriter();
				try {
					int sort_id = Integer.valueOf(request.getParameter("sort_id"));
					List list = conditionReleaseServicesImpl.getlist(sort_id);
					Result result = new Result("200","请求成功！");
					Map map=new HashMap<>();
					map.put("result",result);
					map.put("resultReleasee",list);
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

	public void StatusCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ConditionReleaseServices conditionReleaseServicesImpl = new ConditionReleaseServicesImpl();
		Gson gson=new Gson();
		String json=null;
		PrintWriter out=null;
		try {
			int sort_id = Integer.valueOf(request.getParameter("sort_id"));
			System.out.println("接收过来的值是"+sort_id);
			//将java对象转为json格式的的字符串
			json = gson.toJson(conditionReleaseServicesImpl.getData(sort_id));
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

	public void csh(HttpServletResponse response) throws IOException {
		sort_id=1;
		response.setContentType("application/json;charset=utf-8");
		ConditionReleaseServices conditionReleaseServicesImpl = new ConditionReleaseServicesImpl();
		//使用Gson序列化	
				Gson gson=new Gson();
				String json=null;
				PrintWriter out=null;
				out=response.getWriter();
				try {
					List list = conditionReleaseServicesImpl.getlist(sort_id);
					Result result = new Result("200","请求成功！");
					Map map=new HashMap<>();
					map.put("result",result);
					map.put("resultRelease",list);
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
