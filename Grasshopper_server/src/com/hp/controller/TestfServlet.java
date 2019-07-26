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
import com.hp.entity.TestFs;
import com.hp.services.TestFServices;
import com.hp.servicesImpl.TestFServicesImpl;

/**
 * Servlet implementation class TestfServlet
 */
@WebServlet("/TestfServlet")
public class TestfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestfServlet() {
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");	
		switch (method) {
		case "up":
			this.up(request, response);
			break;
		case "down":
			this.down(request, response);
			break;
		default:
			break;
		}
	}

	public void up(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String a = request.getParameter("s");
		response.setContentType("application/json;charset=utf-8");
		int i = Integer.valueOf(a);
		System.out.println("接受的id是"+i);
		TestFServices testFServicesImpl = new TestFServicesImpl();
		//使用Gson序列化	
		Gson gson=new Gson();
		String json=null;
		PrintWriter out=null;
		out=response.getWriter();
		try {
			List<TestFs> list;
			if(i<=0){
				list = testFServicesImpl.getlister();
				List<TestFs> lis = testFServicesImpl.getcount();
				int count = testFServicesImpl.getcoun(lis);
				Result result = new Result("200","请求成功！");
				Map map=new HashMap<>();
				map.put("result",result);
				map.put("resultN",list);
				map.put("count",count);
				json=gson.toJson(map);
			}else if(i>0){
				list = testFServicesImpl.getlistsl(i);
				List<TestFs> lis = testFServicesImpl.getcount();
				int count = testFServicesImpl.getcoun(lis);
				Result result = new Result("200","请求成功！");
				Map map=new HashMap<>();
				map.put("result",result);
				map.put("resultN",list);
				map.put("count",count);
				json=gson.toJson(map);
			}
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
	
	public void down(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String bl = request.getParameter("h");
		response.setContentType("application/json;charset=utf-8");
		int h = Integer.valueOf(bl);
		TestFServices testFServicesImpl = new TestFServicesImpl();
		//使用Gson序列化	
		Gson gson=new Gson();
		String json=null;
		PrintWriter out=null;
		out=response.getWriter();
		try {
			List<TestFs> list = testFServicesImpl.getlistfins(h);
			Result result = new Result("200","请求成功！");
			Map map=new HashMap<>();
			map.put("result",result);
			map.put("resultH",list);
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
