package com.hp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.google.gson.Gson;
import com.hp.entity.Release;
import com.hp.entity.Result;
import com.hp.entity.User;
import com.hp.services.ExaServices;
import com.hp.services.ReleaseServices;
import com.hp.services.SortServices;
import com.hp.services.TestServices;
import com.hp.services.UserMessageServices;
import com.hp.servicesImpl.ExaServicesImpl;
import com.hp.servicesImpl.RelesaeServicesImpl;
import com.hp.servicesImpl.SortServicesImpl;
import com.hp.servicesImpl.TestServicesImpl;
import com.hp.servicesImpl.UserMessageServicesImpl;

/**
 * ʵ��1
 * ���ʸ�TestServlet�����Show����  URL�������ģ�http://localhost:8080/Grasshopper_server/TestServlet_Show.do
 * serlvet����_����������.do��׺
 * 
 */

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String user_names = null;
	
	protected void service(HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
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
			case "getFocus":
				this.getFocus(request,response);
				break;
			case "getFocus_id":
				this.getFocus_id(request,response);
				break;
			case "addRelease":
				this.addRelease(request,response);
				break;
			case "querySort":
				this.querySort(request,response);
				break;
			case "queryExamine":
				this.queryExamine(request,response);
				break;
			case "queryAll":
				this.queryAll(request,response);
				break;
			case "queryNoPass":
				this.queryNoPass(request,response);
				break;
			case "getPass":
				this.getPass(request,response);
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
						user_names = account;
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
					User user=TestServicesImpl.getUser(user_names);
					 Result result = new Result("200","����ɹ���");
					 Map map=new HashMap<>();
					 map.put("result",result);
					 map.put("resultData",list);
					 map.put("name", user_names);
					 map.put("user_id",user.getId());
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
	
	protected void getFocus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		TestServices TestServicesImpl = new TestServicesImpl();
		//ʹ��Gson���л�	
		Gson gson=new Gson();
		String json=null;
		PrintWriter out=null;
		out=response.getWriter();
		UserMessageServices userMessageServices=new UserMessageServicesImpl();
		String f=userMessageServices.Focus(2);
		ReleaseServices releaseServices= new RelesaeServicesImpl();
		List list=releaseServices.FocusContent(f);
		try {
			 Result result=TestServicesImpl.getDate(list);
			
			 
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
	protected void getFocus_id(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		TestServices TestServicesImpl = new TestServicesImpl();
		//ʹ��Gson���л�	
		Gson gson=new Gson();
		String json=null;
		PrintWriter out=null;
		out=response.getWriter();
		UserMessageServices userMessageServices=new UserMessageServicesImpl();
		String f=userMessageServices.Focus(Integer.valueOf(request.getParameter("user_id")));
		List list=TestServicesImpl.findByID(f);
	    
		try {
			 Result result=TestServicesImpl.getDate(list);
			
			
			 Map map=new HashMap<>();
			 map.put("result",result);
			 map.put("resultUser",list);
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
	private void findByID(String f) {
		// TODO Auto-generated method stub
		
	}
	protected void addRelease(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		{			
					ReleaseServices releaseServices=new RelesaeServicesImpl();
					//ʹ��Gson���л�	
					Gson gson=new Gson();
					String json=null;
					PrintWriter out=null;
					try {
						
						Release release=new Release();
						
							new BeanUtils().populate(release,request.getParameterMap());
							//��java����תΪjson��ʽ�ĵ��ַ���
							json = gson.toJson(releaseServices.add(release));
							
							response.setContentType("application/json;charset=utf-8");
							out = response.getWriter();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
							
							
					 catch (NullPointerException e) {
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
	protected void querySort(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		
		//ʹ��Gson���л�	
		Gson gson=new Gson();
		String json=null;
		PrintWriter out=null;
		out=response.getWriter();
		SortServices sortServices=new SortServicesImpl();
	    List list=sortServices.querySort();
		System.out.println(list.toString());
	    try {

			 Map map=new HashMap<>();
			 
			 map.put("resultSort",list);
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

	protected void queryExamine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		
		//ʹ��Gson���л�	
		Gson gson=new Gson();
		String json=null;
		PrintWriter out=null;
		out=response.getWriter();
		ReleaseServices releaseServices=new RelesaeServicesImpl();
		
	    List list=releaseServices.select(Integer.valueOf(request.getParameter("release_id")));
		System.out.println(list.toString());
	    try {

			 Map map=new HashMap<>();
			 
			 map.put("resultExamine",list);
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
	protected void queryAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		
		//ʹ��Gson���л�	
		Gson gson=new Gson();
		String json=null;
		PrintWriter out=null;
		out=response.getWriter();
		ReleaseServices releaseServices=new RelesaeServicesImpl();
		
	    List list=releaseServices.queryAll();
		System.out.println(list.toString());
	    try {

			 Map map=new HashMap<>();
			 
			 map.put("resultAll",list);
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
	protected void queryNoPass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		
		//ʹ��Gson���л�	
		Gson gson=new Gson();
		String json=null;
		PrintWriter out=null;
		out=response.getWriter();
		ReleaseServices releaseServices=new RelesaeServicesImpl();
		ExaServices exaServices=new ExaServicesImpl();
	    List list=releaseServices.noPass();
	    List list1=exaServices.queryAll();
		System.out.println(list.toString());
	    try {

			 Map map=new HashMap<>();
			 
			 map.put("resultNoPass",list);
			 map.put("resultExa", list1);
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
	protected void getPass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
	
		//ʹ��Gson���л�	
		Gson gson=new Gson();
		String json=null;
		PrintWriter out=null;
		out=response.getWriter();
		ReleaseServices releaseServices=new RelesaeServicesImpl();
		boolean flag=releaseServices.update(Integer.valueOf(request.getParameter("examine_id")), Integer.valueOf(request.getParameter("id")));
	    System.out.println(flag);
		try {

		
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
