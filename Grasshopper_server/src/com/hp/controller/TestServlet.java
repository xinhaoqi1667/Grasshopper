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

import com.hp.services.TestServices;
import com.hp.servicesImpl.TestServicesImpl;

/**
 * ʵ��1
 * ���ʸ�TestServlet�����Show����  URL�������ģ�http://localhost:8080/Grasshopper_server/TestServlet_Show.do
 * serlvet����_����������.do��׺
 * 
 */

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	
	protected void service(HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("����");
		try {
			String method = request.getParameter("method");
			switch (method) {
			case "test":
				this.test(request,response);
				break;
			case "GetData":
				this.GetData(request,response);
				break;

			default:
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
	}
	//���Դ��ݲ���
	protected void test(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	{
		
				TestServices TestServicesImpl = new TestServicesImpl();
				//ʹ��Gson���л�	
				Gson gson=new Gson();
				String json=null;
				PrintWriter out=null;
				try {
					String account=request.getParameter("account");
					 String password=request.getParameter("password");
					 
					
						System.out.println("���չ�����ֵ��"+account+"\t"+password);
						//��java����תΪjson��ʽ�ĵ��ַ���
						json = gson.toJson(TestServicesImpl.getData(account,password));
						
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

	//���Է�������
	protected void GetData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	{
		

				response.setContentType("application/json;charset=utf-8");
				TestServices TestServicesImpl = new TestServicesImpl();
				//ʹ��Gson���л�	
				Gson gson=new Gson();
				String json=null;
				PrintWriter out=null;
				out=response.getWriter();
				try {
					List list = TestServicesImpl.getInfo();
					
					 Result result = new Result("200","����ɹ���");
					 Map map=new HashMap<>();
					 map.put("result",result);
					 map.put("resultData",list);
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
	}

}