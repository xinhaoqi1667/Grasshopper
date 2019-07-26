package com.hp.servicesImpl;

import java.util.List;

import com.hp.dao.TestF;
import com.hp.entity.Release;
import com.hp.entity.TestFs;
import com.hp.services.TestFServices;

public class TestFServicesImpl implements TestFServices {
	public static void main(String[] args) {
		TestFServicesImpl s = new TestFServicesImpl();
		List<TestFs> list = s.getcount();
		System.out.println(s.getcoun(list));
	}
	private TestF f = new TestF();
	@Override
	public List<TestFs> getlist(int a) {
		// TODO Auto-generated method stub
		return f.getlist(a);
	}
	@Override
	public int getcoun(List<TestFs> list) {
		int i = list.size();
		double b = (double)i/(double)5;
		int con = (int) b ;
		String ss = String.valueOf(b);
		String[] tmo;
		String tj = "\\.";
		tmo = ss.split(tj);
		if((Integer.valueOf(tmo[1]))>0){
			con = con+1;
			return con;
		}else{
			return con;
		}
	}
	@Override
	public List<TestFs> getcount() {
		// TODO Auto-generated method stub
		return f.getcount();
	}
	@Override
	public List<TestFs> getlistfins(int h) {
		// TODO Auto-generated method stub
		return f.getlistfins(h);
	}
	@Override
	public List<TestFs> getlistsl(int ht) {
		// TODO Auto-generated method stub
		return f.getlistsl(ht);
	}
	@Override
	public List<TestFs> getlister() {
		// TODO Auto-generated method stub
		return f.getlister();
	}

}
