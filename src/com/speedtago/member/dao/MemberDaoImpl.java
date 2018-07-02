package com.speedtago.member.dao;

import java.sql.*;
import java.util.*;

import com.speedtago.db.DBClose;
import com.speedtago.db.DBConnection;
import com.speedtago.member.model.*;

public class MemberDaoImpl implements MemberDao {
	@Override
	public int idCheck(String id) {
		int cnt = 1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			String sql = "";
			sql += "select count(id) cnt \n";
			sql += "from member \n";
			sql += "where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
		} catch (SQLException e) {
			cnt = 1;
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return cnt;
	}

	@Override
	public List<ZipDto> zipSearch(String dong) {
		List<ZipDto> list = new ArrayList<ZipDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String zipcode = "";
			String sido = "";
			String gugun = "";
			String doro = "";
			conn = DBConnection.makeConnection();
			String sql = "";
			sql+="select zipcode, sido || ' ' || gugun || ' ' || doro as address \n";
			sql+="from zipcode \n";
			sql+="where doro like '%'||?||'%'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dong);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ZipDto zipDto = new ZipDto();
				zipDto.setZipcode(rs.getString("zipcode"));
				zipDto.setAddress(rs.getString("address"));
				list.add(zipDto);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt,rs);
		}
		
		return list;
	}

	@Override
	public int registerMember(MemberDetailDto memberDetailDto) {
		
		int cnt = 0; 
		Connection conn = null; 
		PreparedStatement pstmt = null;
		try {
				
			conn = DBConnection.makeConnection();
			String sql = "";
			sql += "insert all \n";
			sql += "into member (name, id, pass, email1, email2, joindate) \n";
			sql += "values (?, ?, ?, ?, ?, sysdate) \n";
			sql += "into member_detail (id, zipcode, addr1, addr2, tel1, tel2, tel3) \n";
			sql += "values (?, ?, ?, ?, ?, ?, ?)";
			sql += "select * from dual";
			
			pstmt = conn.prepareStatement(sql);
			int idx = 0; 
			pstmt.setString(++idx, memberDetailDto.getName());
			pstmt.setString(++idx, memberDetailDto.getId());
			pstmt.setString(++idx, memberDetailDto.getPass());
			pstmt.setString(++idx, memberDetailDto.getEmail1());
			pstmt.setString(++idx, memberDetailDto.getEmail2());
			pstmt.setString(++idx, memberDetailDto.getId());
			pstmt.setString(++idx, memberDetailDto.getZipcode());
			pstmt.setString(++idx, memberDetailDto.getAddr1());
			pstmt.setString(++idx, memberDetailDto.getAddr2());
			pstmt.setString(++idx, memberDetailDto.getTel1());
			pstmt.setString(++idx, memberDetailDto.getTel2());
			pstmt.setString(++idx, memberDetailDto.getTel3());
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}

	@Override
	public MemberDetailDto getMember(String id) {
		System.out.println("DAO>>>>" + id);
		MemberDetailDto memberDetailDto = null;
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.makeConnection();
			String sql = "";
			sql += " select m.name, m.id, m.pass, m.email1, m.email2, m.joindate, md.zipcode, md.addr1, md.addr2, md.tel1, md.tel2, md.tel3  \n ";
			sql += " from member m, MEMBER_DETAIL md \n";
			sql += " where m.id = md.id \n";
			sql += " and m.id = ? ";
			//sql += "select * from dual";
			//select m.name, m.id, m.pass, m.email1, m.email2, m.joindate, md.zipcode, md.addr1, md.addr2, md.tel1, md.tel2, md.tel3 
			//from member m, MEMBER_DETAIL md
			//where m.id = md.id
			//and m.id = 'user1';

			pstmt = conn.prepareStatement(sql);
			int indx = 0;
			pstmt.setString(++indx, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				memberDetailDto = new MemberDetailDto();
				memberDetailDto.setId(rs.getString("id"));
				memberDetailDto.setName(rs.getString("name"));
				memberDetailDto.setPass(rs.getString("pass"));
				memberDetailDto.setEmail1(rs.getString("email1"));
				memberDetailDto.setEmail2(rs.getString("email2"));
				memberDetailDto.setZipcode(rs.getString("zipcode"));
				memberDetailDto.setAddr1(rs.getString("addr1"));
				memberDetailDto.setAddr2(rs.getString("addr2"));
				memberDetailDto.setTel1(rs.getString("tel1"));
				memberDetailDto.setTel2(rs.getString("tel2"));
				memberDetailDto.setTel3(rs.getString("tel3"));
			}
			System.out.println("DAO1>>>>" + memberDetailDto.getId());
			System.out.println("DAO2>>>>" + memberDetailDto.getName());
			System.out.println("DAO2>>>>" + memberDetailDto.getTel3());
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return memberDetailDto;
	}

	
	
	
	
	
	@Override
	public int modifyMember(MemberDetailDto memberDetailDto) {
		int cnt = 0;
		Connection conn = null; 
		PreparedStatement pstmt = null;
		try {
				
			conn = DBConnection.makeConnection();
			String sql = "";
			sql += " update member \n" ; 
			sql += " set \n" ;
			sql += " name = ?, \n" ;
			sql += " pass= ?, \n" ;
			sql += " email1 = ?,  \n" ;
			sql += " email2 = ?,  \n" ;
			sql += " joindate = sysdate \n" ;
			sql += " where id = ? " ;
			
			System.out.println("DAO_modifyMember>>>>" + memberDetailDto.getId());
			
			pstmt = conn.prepareStatement(sql);
			int idx = 0; 
			
			pstmt.setString(++idx, memberDetailDto.getName());
			pstmt.setString(++idx, memberDetailDto.getPass());
			pstmt.setString(++idx, memberDetailDto.getEmail1());
			pstmt.setString(++idx, memberDetailDto.getEmail2());
			pstmt.setString(++idx, memberDetailDto.getId());
		
			cnt = pstmt.executeUpdate();
			System.out.println("DAO_modifyMember>>cnt>>" + cnt);
			
			sql ="";
			sql += "update member_detail \n" ;
			sql += "set \n" ;
			sql += "zipcode = ?, \n" ;
			sql += "addr1 = ?, \n" ;
			sql += "addr2 = ?, \n" ;
			sql += "tel1 = ?, \n" ;
			sql += "tel2 = ?, \n" ;
			sql += "tel3 = ? \n" ;
			sql += "where id = ? " ;

			System.out.println("DAO_modifyMember>>>>" + memberDetailDto.getId());
			
			pstmt = conn.prepareStatement(sql);
			idx = 0; 
			pstmt.setString(++idx, memberDetailDto.getZipcode());
			pstmt.setString(++idx, memberDetailDto.getAddr1());
			pstmt.setString(++idx, memberDetailDto.getAddr2());
			pstmt.setString(++idx, memberDetailDto.getTel1());
			pstmt.setString(++idx, memberDetailDto.getTel2());
			pstmt.setString(++idx, memberDetailDto.getTel3());
			pstmt.setString(++idx, memberDetailDto.getId());
			
			cnt = pstmt.executeUpdate();
			System.out.println("DAO_modifyMember>>cnt>>" + cnt);
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn = DBConnection.makeConnection();
				String sql = "";
				sql += " roolback; \n" ; 
				pstmt = conn.prepareStatement(sql);
				pstmt.executeUpdate();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}
	
	
	@Override
	public int deleteMember(String id) {

		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			String sql = "";
			sql += "delete from member_detail where id = ? \n";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			sql = "";
			sql += "delete from member where id = ? \n";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			cnt = 1;
		} catch (SQLException e) {
			e.printStackTrace();
			cnt = 0;
			try {
				conn = DBConnection.makeConnection();
				String sql = "";
				sql += " roolback; \n" ; 
				pstmt = conn.prepareStatement(sql);
				pstmt.executeUpdate();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return cnt;
	}
	
	
	@Override
	public MemberDto login(Map<String, String> map) {
		MemberDto memberDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			String sql = "";
			sql+="select id, name, email1, email2 \n";
			sql+="from member \n";
			sql+="where id= ? and pass= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, map.get("userid"));
			pstmt.setString(2, map.get("userpass"));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberDto = new MemberDto();
				memberDto.setId(rs.getString("id"));
				memberDto.setName(rs.getString("name"));
				memberDto.setEmail1(rs.getString("email1"));
				memberDto.setEmail2(rs.getString("email2"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}		
		return memberDto;
	}


	/*
	 * try{
	 * cnt = u m
	 * cnt = u m_d
	 * com
	 * } catch(){
	 * roolback;
	 * }
	 * 
	 * */
	
	
	
	
	@Override
	public MemberDetailDto getIdSearch(MemberDetailDto memberDetailDto) {
		int cnt = 0;
		Connection conn = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
				
			conn = DBConnection.makeConnection();
			String sql = "";
			sql += " select m.id \n" ; 
			sql += " from member m \n" ;
			sql += " where m.name = ? \n" ;
			sql += " and m.email1 = ? \n" ;
			sql += " and m.email2 = ? " ;
			
			System.out.println("DAO_getIdSearch>>>>" + memberDetailDto.getName());
			System.out.println("DAO_getIdSearch>>>>" + memberDetailDto.getEmail1());
			System.out.println("DAO_getIdSearch>>>>" + memberDetailDto.getEmail2());
			
			
			pstmt = conn.prepareStatement(sql);
			int idx = 0; 
			pstmt.setString(++idx, memberDetailDto.getName());
			pstmt.setString(++idx, memberDetailDto.getEmail1());
			pstmt.setString(++idx, memberDetailDto.getEmail2());
		
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberDetailDto = new MemberDetailDto();
				memberDetailDto.setId(rs.getString("id"));
			}
			System.out.println("DAO - getIdSearch id>>>" + memberDetailDto.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return memberDetailDto;
	}

	@Override
	public MemberDetailDto getPassSearch(MemberDetailDto memberDetailDto) {
		int cnt = 0;
		Connection conn = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
				
			conn = DBConnection.makeConnection();
			String sql = "";
			sql += " select m.pass \n" ; 
			sql += " from member m \n" ;
			sql += " where m.name = ? \n" ;
			sql += " and m.email1 = ? \n" ;
			sql += " and m.email2 = ?  \n" ;
			sql += " and m.id = ?  " ;
			
			System.out.println("DAO_getPassSearch>>>>" + memberDetailDto.getName());
			System.out.println("DAO_getPassSearch>>>>" + memberDetailDto.getEmail1());
			System.out.println("DAO_getPassSearch>>>>" + memberDetailDto.getEmail2());
			System.out.println("DAO_getPassSearch>>>>" + memberDetailDto.getId());
			
			pstmt = conn.prepareStatement(sql);
			int idx = 0; 
			pstmt.setString(++idx, memberDetailDto.getName());
			pstmt.setString(++idx, memberDetailDto.getEmail1());
			pstmt.setString(++idx, memberDetailDto.getEmail2());
			pstmt.setString(++idx, memberDetailDto.getId());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				memberDetailDto = new MemberDetailDto();
				memberDetailDto.setPass(rs.getString("pass"));
			}
			
			cnt = rs.getInt(1);
			
			System.out.println("DAO - getPassSearch pass>>>" + memberDetailDto.getPass());
		} catch (SQLException e) {
			e.printStackTrace();
			cnt = 0;
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return memberDetailDto;
	}

	@Override
	public int getPassChange(MemberDetailDto memberDetailDto) {
		int cnt = 0;
		Connection conn = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
				
			conn = DBConnection.makeConnection();
			String sql = "";
			sql += " update member m \n" ; 
			sql += " set m.pass = ? \n" ;
			sql += " where m.id = ?  " ;
			
			System.out.println("DAO_getPassChange>>>>" + memberDetailDto.getName());
			System.out.println("DAO_getPassChange>>>>" + memberDetailDto.getPass());
			
			pstmt = conn.prepareStatement(sql);
			int idx = 0; 
			pstmt.setString(++idx, memberDetailDto.getPass());
			pstmt.setString(++idx, memberDetailDto.getId());
			
			cnt = pstmt.executeUpdate();
			System.out.println("DAO_getPassChange>>cnt>>" + cnt);
			
		} catch (SQLException e) {
			e.printStackTrace();
			cnt = 0;
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return cnt;
	}


}
