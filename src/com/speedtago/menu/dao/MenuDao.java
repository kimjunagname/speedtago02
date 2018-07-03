package com.speedtago.menu.dao;

import java.util.List;

import com.speedtago.menu.model.*;

public interface MenuDao {

	List<MenuListDto> getBoardMenu();
	List<CategoryDto> getCategory();
	void makeCategory(String cname);
	List<MenuTypeDto> getMenuType();
	void makeBoard(MenuListDto menuListDto);
	
	
}
