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
			//����״̬��
			//this.StatusCode(request, response);
			break;
		case "Querycomment":
			//�����û���Ϣ
			//this.GetUser(request,response);
			break;
		case "Querybackcomment":
			//�����û���Ϣ
			//this.GetUser(request,response);
			break;
		case "addcoment":
			//�����û���Ϣ
			//this.GetUser(request,response);
			break;
		case "addfcoment":
			//�����û���Ϣ
			//this.GetUser(request,response);
			break;
		case "addffcoment":
			//�����û���Ϣ
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
			Result result = new Result("200","����ɹ���");
			//�˴�Ҫ��List���ظ�ҳ��
			json=gson.toJson(listfc);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			Result result = new Result("1005","���ݻ�ȡ�쳣��");
			//תΪjson��ʽ���ַ���
			json = gson.toJson(result);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			Result result = new Result("1005","���ݻ�ȡ�쳣��");
			//תΪjson��ʽ���ַ���
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
			Result result = new Result("200","����ɹ���");
			json=gson.toJson(listc);
			
			//�˴�Ҫ��List���ظ�ҳ��
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			Result result = new Result("1005","���ݻ�ȡ�쳣��");
			//תΪjson��ʽ���ַ���
			json = gson.toJson(result);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			Result result = new Result("1005","���ݻ�ȡ�쳣��");
			//תΪjson��ʽ���ַ���
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
			Result result = new Result("200","����ɹ���");
			json=gson.toJson(listc);
			
			//�˴�Ҫ��List���ظ�ҳ��
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			Result result = new Result("1005","���ݻ�ȡ�쳣��");
			//תΪjson��ʽ���ַ���
			json = gson.toJson(result);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			Result result = new Result("1005","���ݻ�ȡ�쳣��");
			//תΪjson��ʽ���ַ���
			json = gson.toJson(result);
			e.printStackTrace();
		}
		
	}
	public void addcoment(HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
			throws IOException {//���
		Gson gson=new Gson();
		String json=null;
		PrintWriter out=null;
		out=response.getWriter();
		CommentServices commentServices=new CommentServicesImpl();
		Comment comment = new Comment();
		try {
			BeanUtils.populate(comment,request.getParameterMap());
			boolean flag=commentServices.addcoment(comment);
			Result result = new Result("msg", "��ӳɹ�");
			json = gson.toJson(result);
			this.Querycomment(request, response);//��Ӻ����²�ѯһ��
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			Result result = new Result("1005","���ݻ�ȡ�쳣��");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			Result result = new Result("1005","���ݻ�ȡ�쳣��");
			e.printStackTrace();
		}
		
	}
	public void addfcoment(HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
			throws IOException {//��һ���ĵ�һ�����
		Gson gson=new Gson();
		String json=null;
		PrintWriter out=null;
		out=response.getWriter();
		CommentServices commentServices=new CommentServicesImpl();
		Comment comment = new Comment();
		try {
			BeanUtils.populate(comment,request.getParameterMap());
			boolean flag=commentServices.addfcoment(comment);
			Result result = new Result("msg", "��ӳɹ�");
			json = gson.toJson(result);
			this.Querycomment(request, response);//��Ӻ����²�ѯһ��
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			Result result = new Result("1005","���ݻ�ȡ�쳣��");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			Result result = new Result("1005","���ݻ�ȡ�쳣��");
			e.printStackTrace();
		}
		
	}
	public void addffcoment(HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
			throws IOException {//ÿһ����һ�����
		Gson gson=new Gson();
		String json=null;
		PrintWriter out=null;
		out=response.getWriter();
		CommentServices commentServices=new CommentServicesImpl();
		Comment comment = new Comment();
		try {
			BeanUtils.populate(comment,request.getParameterMap());
			boolean flag=commentServices.addfcoment(comment);
			Result result = new Result("msg", "��ӳɹ�");
			json = gson.toJson(result);
			this.Querycomment(request, response);//��Ӻ����²�ѯһ��
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			Result result = new Result("1005","���ݻ�ȡ�쳣��");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			Result result = new Result("1005","���ݻ�ȡ�쳣��");
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
