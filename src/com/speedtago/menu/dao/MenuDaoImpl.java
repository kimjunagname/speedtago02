package com.speedtago.menu.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.speedtago.db.DBClose;
import com.speedtago.db.DBConnection;
import com.speedtago.menu.model.*;

public class MenuDaoImpl implements MenuDao {

	private static MenuDao menuDao;
	static {	
		menuDao = new MenuDaoImpl();
	}
	private MenuDaoImpl () {}
		
	public static MenuDao getMenuDao() {
		return menuDao;
	}


	@Override
	public List<MenuListDto> getBoardMenu() {
		List<MenuListDto> menu = new ArrayList<MenuListDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select b.bcode, b.bname, b.btype, c.ccode, c.cname, \n");
			sql.append("	case  \n");
			sql.append("		when b.btype = 5 then 'reboard' \n");
			sql.append("		when b.btype = 6 then 'album' \n");
			sql.append("		when b.btype = 7 then 'bbs' \n");
			sql.append("		else 'board' \n");
			sql.append("	end control \n");
			sql.append("from board_list b, category c \n");
			sql.append("where b.ccode = c.ccode \n");
			sql.append("order by bcode asc \n");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MenuListDto menuListDto = new MenuListDto();
				menuListDto.setBcode(rs.getInt("bcode"));
				menuListDto.setBname(rs.getString("bname"));
				menuListDto.setBtype(rs.getInt("btype"));
				menuListDto.setCcode(rs.getInt("ccode"));
				menuListDto.setCname(rs.getString("cname"));
				menuListDto.setControl(rs.getString("control"));
				
				menu.add(menuListDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return menu;
	}

	

	@Override
	public void makeCategory(String cname) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void makeBoard(MenuListDto menuListDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CategoryDto> getCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MenuTypeDto> getMenuType() {
		// TODO Auto-generated method stub
		return null;
	}


}
