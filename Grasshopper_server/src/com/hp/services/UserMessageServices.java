package com.hp.services;

import java.util.List;

public interface UserMessageServices {
	public List idFocus(String idFocus);
	public String Focus(int id);
	public boolean addFocus(int idFocus,int id);
	public boolean deleteFocus(int idFocus,int id);
}
