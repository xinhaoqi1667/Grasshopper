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
		System.out.println("����");
		String method = request.getParameter("method");
		switch (method) {
		case "StatusCode":
			//����״̬��
			this.StatusCode(request, response);
			break;
		case "GetName":
			//���ط�˿���ֵļ���
			this.GetName(response);
			break;
		default:
			break;
		}
	}
	
	//���ط�˿���ֵļ���
	public void GetName(HttpServletResponse response) throws IOException {
		response.setContentType("application/json;charset=utf-8");
		FansServices fansServicesImpl = new FansServicesImpl();
		//ʹ��Gson���л�	
		Gson gson=new Gson();
		String json=null;
		PrintWriter out=null;
		out=response.getWriter();
		try {
			List list = fansServicesImpl.user_name(fansServicesImpl.Fans_userid(id));
			Result result = new Result("200","����ɹ���");
			Map map=new HashMap<>();
			map.put("result",result);
			map.put("resultName",list);
			json=gson.toJson(map);
		} catch (Exception e) {
			e.printStackTrace();
			Result result = new Result("1005","���ݻ�ȡ�쳣��");
			//תΪjson��ʽ���ַ���
			json = gson.toJson(result);
			// TODO: handle exception
		}
		System.out.println(json);
		//�������json��ʽ��¶���س�ȥ
		out.write(json);
	}
	
	//����״̬��
	public void StatusCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		FansServices fansServicesImpl = new FansServicesImpl();
		Gson gson=new Gson();
		String json=null;
		PrintWriter out=null;
		try {
			int user_id = Integer.valueOf(request.getParameter("user_id"));
			System.out.println("���չ�����ֵ��"+user_id);
			//��java����תΪjson��ʽ�ĵ��ַ���
			json = gson.toJson(fansServicesImpl.getData(user_id));
			id = user_id;
			response.setContentType("application/json;charset=utf-8");
			out = response.getWriter();
		} catch (NullPointerException e) {
			System.out.println("�����쳣");
			// TODO: handle exception
			e.printStackTrace();
			Result result = new Result("1003","��������Ϊ�գ�");
			//תΪjson��ʽ���ַ���
			json = gson.toJson(result);
		}
		System.out.println(json);
		//�������json��ʽ��¶���س�ȥ
		out.write(json);
	}

}
