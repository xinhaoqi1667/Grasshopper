package com.hp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.google.gson.Gson;
import com.hp.entity.Comment;
import com.hp.entity.Result;
import com.hp.services.CommentServices;
import com.hp.servicesImpl.CommentServicesImpl;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		switch (method) {
		case "Queryfcomment":
			//返回状态码
			//this.StatusCode(request, response);
			break;
		case "Querycomment":
			//返回用户信息
			//this.GetUser(request,response);
			break;
		case "Querybackcomment":
			//返回用户信息
			//this.GetUser(request,response);
			break;
		case "addcoment":
			//返回用户信息
			//this.GetUser(request,response);
			break;
		case "addfcoment":
			//返回用户信息
			//this.GetUser(request,response);
			break;
		case "addffcoment":
			//返回用户信息
			//this.GetUser(request,response);
			break;
		default:
			break;
		}
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void Queryfcomment(HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
			throws IOException {
		CommentServices commentServices=new CommentServicesImpl();
		Comment comment = new Comment();
		Gson gson=new Gson();
		String json=null;
		PrintWriter out=null;
		out=response.getWriter();
		try {
			
			BeanUtils.populate(comment,request.getParameterMap());
			List<Comment>listfc=commentServices.Queryfcomment(Integer.valueOf(request.getParameter("rid")));
			Result result = new Result("200","请求成功！");
			//此处要将List返回给页面
			json=gson.toJson(listfc);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			Result result = new Result("1005","数据获取异常！");
			//转为json格式的字符串
			json = gson.toJson(result);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			Result result = new Result("1005","数据获取异常！");
			//转为json格式的字符串
			json = gson.toJson(result);
			e.printStackTrace();
		}
		out.write(json);
	}
	

	public void Querycomment(HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
			throws IOException {
		Gson gson=new Gson();
		String json=null;
		PrintWriter out=null;
		out=response.getWriter();
		CommentServices commentServices=new CommentServicesImpl();
		Comment comment = new Comment();
		try {
			BeanUtils.populate(comment,request.getParameterMap());
			List<Comment>listc=commentServices.Querycomment(comment);
			Result result = new Result("200","请求成功！");
			json=gson.toJson(listc);
			
			//此处要将List返回给页面
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			Result result = new Result("1005","数据获取异常！");
			//转为json格式的字符串
			json = gson.toJson(result);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			Result result = new Result("1005","数据获取异常！");
			//转为json格式的字符串
			json = gson.toJson(result);
			e.printStackTrace();
		}
		
	}
	public void Querybackcomment(HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
			throws IOException {
		Gson gson=new Gson();
		String json=null;
		PrintWriter out=null;
		out=response.getWriter();
		CommentServices commentServices=new CommentServicesImpl();
		Comment comment = new Comment();
		try {
			BeanUtils.populate(comment,request.getParameterMap());
			List<Comment>listc=commentServices.Querybackcomment(comment);
			Result result = new Result("200","请求成功！");
			json=gson.toJson(listc);
			
			//此处要将List返回给页面
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			Result result = new Result("1005","数据获取异常！");
			//转为json格式的字符串
			json = gson.toJson(result);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			Result result = new Result("1005","数据获取异常！");
			//转为json格式的字符串
			json = gson.toJson(result);
			e.printStackTrace();
		}
		
	}
	public void addcoment(HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
			throws IOException {//添加
		Gson gson=new Gson();
		String json=null;
		PrintWriter out=null;
		out=response.getWriter();
		CommentServices commentServices=new CommentServicesImpl();
		Comment comment = new Comment();
		try {
			BeanUtils.populate(comment,request.getParameterMap());
			boolean flag=commentServices.addcoment(comment);
			Result result = new Result("msg", "添加成功");
			json = gson.toJson(result);
			this.Querycomment(request, response);//添加后重新查询一次
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			Result result = new Result("1005","数据获取异常！");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			Result result = new Result("1005","数据获取异常！");
			e.printStackTrace();
		}
		
	}
	public void addfcoment(HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
			throws IOException {//第一级的第一个添加
		Gson gson=new Gson();
		String json=null;
		PrintWriter out=null;
		out=response.getWriter();
		CommentServices commentServices=new CommentServicesImpl();
		Comment comment = new Comment();
		try {
			BeanUtils.populate(comment,request.getParameterMap());
			boolean flag=commentServices.addfcoment(comment);
			Result result = new Result("msg", "添加成功");
			json = gson.toJson(result);
			this.Querycomment(request, response);//添加后重新查询一次
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			Result result = new Result("1005","数据获取异常！");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			Result result = new Result("1005","数据获取异常！");
			e.printStackTrace();
		}
		
	}
	public void addffcoment(HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
			throws IOException {//每一级第一个添加
		Gson gson=new Gson();
		String json=null;
		PrintWriter out=null;
		out=response.getWriter();
		CommentServices commentServices=new CommentServicesImpl();
		Comment comment = new Comment();
		try {
			BeanUtils.populate(comment,request.getParameterMap());
			boolean flag=commentServices.addfcoment(comment);
			Result result = new Result("msg", "添加成功");
			json = gson.toJson(result);
			this.Querycomment(request, response);//添加后重新查询一次
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			Result result = new Result("1005","数据获取异常！");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			Result result = new Result("1005","数据获取异常！");
			e.printStackTrace();
		}
		
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
