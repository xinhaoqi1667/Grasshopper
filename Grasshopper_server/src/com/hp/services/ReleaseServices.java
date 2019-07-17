package com.hp.services;

import java.util.List;

import com.hp.entity.Release;

public interface ReleaseServices {
	public boolean add(Release release);
	public List<Release> select();
	public boolean update(Release release);
	public boolean delete(int id);
}
