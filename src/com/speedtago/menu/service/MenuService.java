package com.speedtago.menu.service;

import java.util.List;

import com.speedtago.menu.model.*;

public interface MenuService {

	List<MenuListDto> getBoardMenu();
	List<CategoryDto> getCategory();
	void makeCategory(String cname);
	List<MenuTypeDto> getMenuType();
	void makeBoard(MenuListDto menuListDto);
	
//	TODO 나중에 카테고리변경, 게시판 변경 만들자!!!!
	
}
