package com.speedtago.menu.service;

import java.util.List;

import com.speedtago.menu.dao.MenuDaoImpl;
import com.speedtago.menu.model.*;

public class MenuServiceImpl implements MenuService {

	private static MenuService menuService;
	
	static {
		menuService = new MenuServiceImpl();
	}
	
	private MenuServiceImpl() {}
	
	public static MenuService getMenuService() {
		return menuService;
	}


	@Override
	public List<MenuListDto> getBoardMenu() {
		// TODO Auto-generated method stub
		return MenuDaoImpl.getMenuDao().getBoardMenu();
	}

	@Override
	public List<CategoryDto> getCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void makeCategory(String cname) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MenuTypeDto> getMenuType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void makeBoard(MenuListDto boardListDto) {
		// TODO Auto-generated method stub
		
	}



}
