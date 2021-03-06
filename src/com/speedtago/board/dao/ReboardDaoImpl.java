package com.speedtago.board.dao;

import java.sql.*;
import java.util.*;

import com.speedtago.board.model.ReboardDto;
import com.speedtago.db.DBClose;
import com.speedtago.db.DBConnection;

public class ReboardDaoImpl implements ReboardDao {
	
	private static ReboardDao reboardDao;
	
	static {
		reboardDao = new ReboardDaoImpl();
	}
	
	private ReboardDaoImpl() {}
	
	public static ReboardDao getReboardDao() {
		return reboardDao;
	}

	@Override
	public int writeArticle(ReboardDto reboardDto) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert all \n");
			sql.append("	into board (seq, name, id, email, subject, content, hit, logtime, bcode) \n");
			sql.append("	values (?, ?, ?, ?, ?, ?, 0, sysdate, ?) \n");
			sql.append("	into reboard (rseq, seq, ref, lev, step, pseq, reply) \n");
			sql.append("	values (reboard_rseq.nextval, ?, ?, 0, 0, 0, 0) \n");
			sql.append("select * from dual");
//			System.out.println(sql);
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;
			pstmt.setInt(++idx, reboardDto.getSeq());
			pstmt.setString(++idx, reboardDto.getName());
			pstmt.setString(++idx, reboardDto.getId());
			pstmt.setString(++idx, reboardDto.getEmail());
			pstmt.setString(++idx, reboardDto.getSubject());
			pstmt.setString(++idx, reboardDto.getContent());
			pstmt.setInt(++idx, reboardDto.getBcode());
			pstmt.setInt(++idx, reboardDto.getSeq());
			pstmt.setInt(++idx, reboardDto.getRef());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}

	//답변 >> writeArticle거와 비슷하다.
	@Override
	public int replyArticle(ReboardDto reboardDto) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//메소드 빼면 하나하나 conn 실행해야 한다.(트랜젝션 을 관리 못한다)
			conn = DBConnection.makeConnection();
			conn.setAutoCommit(false);
			
			StringBuffer update_step = new StringBuffer();
			update_step.append(" update reboard \n ");
			update_step.append(" set step = step + 1 \n ");
			update_step.append(" where ref = ? and step > ? ");
			//원글의 스텝보다 큰얘들을 1씩 증가 식
			pstmt = conn.prepareStatement(update_step.toString());
			pstmt.setInt(1, reboardDto.getRef()); //원글의 ref
			pstmt.setInt(2, reboardDto.getStep()); //원글의 스탭
			pstmt.executeUpdate();
			pstmt.close();
			//conn닫으면 안됨
			
			
			StringBuffer insert_reply = new StringBuffer();
			insert_reply.append("insert all \n");
			insert_reply.append("	into board (seq, name, id, email, subject, content, hit, logtime, bcode) \n");
			insert_reply.append("	values (?, ?, ?, ?, ?, ?, 0, sysdate, ?) \n");
			insert_reply.append("	into reboard (rseq,               seq, ref, lev, step, pseq, reply) \n");
			insert_reply.append("	values       (reboard_rseq.nextval, ?,   ?,   ?,    ?,    ?,     0) \n");
			insert_reply.append("select * from dual ");
			//0은 답글의 갯수 라서 일딴 0임
			
//			System.out.println(sql);
			
			pstmt = conn.prepareStatement(insert_reply.toString());
			int idx = 0;
			pstmt.setInt(++idx, reboardDto.getSeq()); //글번호
			pstmt.setString(++idx, reboardDto.getName()); //이름
			pstmt.setString(++idx, reboardDto.getId()); //아이디
			pstmt.setString(++idx, reboardDto.getEmail()); //이메일
			pstmt.setString(++idx, reboardDto.getSubject()); //제목
			pstmt.setString(++idx, reboardDto.getContent()); //내용
			pstmt.setInt(++idx, reboardDto.getBcode()); //보드 이름
			pstmt.setInt(++idx, reboardDto.getSeq()); //원글의 
			pstmt.setInt(++idx, reboardDto.getRef()); //
			
			pstmt.setInt(++idx, reboardDto.getLev() + 1);//원글의 lev보다 1커야 한다(리보드트 디티오는 원글의 스텝만 가지고 있다)
			pstmt.setInt(++idx, reboardDto.getStep() + 1);//원글보다 step 1이 커야 한다.(정렬순서)
			pstmt.setInt(++idx, reboardDto.getPseq()); //
			pstmt.executeUpdate();
//			cnt = pstmt.executeUpdate();
			pstmt.close();
			
			StringBuffer update_reply = new StringBuffer();
			update_reply.append(" update reboard \n");
			update_reply.append(" set reply = reply + 1 \n");
			update_reply.append(" where seq = ? ");
			pstmt = conn.prepareStatement(update_reply.toString());
			pstmt.setInt(1, reboardDto.getPseq()); //글번호 seq  = 원글의 답글번호 pseq 
			pstmt.executeUpdate();
			//colose 할필요 없다
			
			conn.commit();
			cnt = 1; //0이상없이 dao가 실행되었을때 cnt 1로 줌
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
				cnt = 0;
				//cnt = 0이면, 글작성 실패임
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}

	@Override
	public List<ReboardDto> listArticle(Map<String, String> map) {
		List<ReboardDto> list = new ArrayList<ReboardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select b.* \n");
			sql.append("from ( \n");
			sql.append("	select rownum rn, a.* \n");
			sql.append("	from ( \n");
			sql.append("		select b.seq, b.id, b.name, b.email, b.subject, b.content, b.hit, b.bcode, \n");
			sql.append("				r.rseq, r.ref, r.lev, r.step, r.pseq, r.reply, \n");
			sql.append(" 				case  \n");
			sql.append("					when to_char(logtime, 'yymmdd') = to_char(sysdate, 'yymmdd') \n");
			sql.append("					then to_char(logtime, 'hh24:mi:ss') \n");
			sql.append("					else to_char(logtime, 'yy.mm.dd') \n");
			sql.append("				end logtime \n");
			sql.append("		from board b, reboard r \n");
			sql.append("		where b.seq = r.seq \n");
			sql.append("		and b.bcode = ? \n");
			String key = map.get("key");
			String word = map.get("word");
			if(!key.isEmpty() && !word.isEmpty()) {
				if(key.equals("subject")) {
					sql.append("		and b.subject like '%'||?||'%' \n");
				} else {//name, seq, id
					sql.append("		and b." + key + " = ? \n");
				}
			}
			//sql.append("		order by seq desc \n"); //list 정렬 기준
			sql.append("		order by ref desc, step \n"); //답변형 게시판
			sql.append("		) a \n");
			sql.append("	where rownum <= ? \n");
			sql.append("	) b \n");
			sql.append("where b.rn > ? \n");
//			System.out.println(sql);
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;
			pstmt.setString(++idx, map.get("bcode"));
			if(!key.isEmpty() && !word.isEmpty()) {
				pstmt.setString(++idx, word);
			}
			pstmt.setString(++idx, map.get("end"));
			pstmt.setString(++idx, map.get("start"));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReboardDto reboardDto = new ReboardDto();
				reboardDto.setSeq(rs.getInt("seq"));
				reboardDto.setName(rs.getString("name"));
				reboardDto.setId(rs.getString("id"));
				reboardDto.setEmail(rs.getString("email"));
				reboardDto.setSubject(rs.getString("subject"));
				reboardDto.setContent(rs.getString("content"));
				reboardDto.setHit(rs.getInt("hit"));
				reboardDto.setLogtime(rs.getString("logtime"));
				reboardDto.setBcode(rs.getInt("bcode"));
				reboardDto.setRseq(rs.getInt("rseq"));
				reboardDto.setRef(rs.getInt("ref"));
				reboardDto.setLev(rs.getInt("lev"));
				reboardDto.setStep(rs.getInt("step"));
				reboardDto.setPseq(rs.getInt("pseq"));
				reboardDto.setReply(rs.getInt("reply"));
				
				list.add(reboardDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public ReboardDto viewArticle(int seq) {
		ReboardDto reboardDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select b.seq, b.id, b.name, b.email, b.subject, b.content, b.hit, b.bcode, b.logtime, \n");
			sql.append("		r.rseq, r.ref, r.lev, r.step, r.pseq, r.reply \n");
			sql.append("from board b, reboard r \n");
			sql.append("where b.seq = r.seq \n");
			sql.append("and b.seq = ? \n");


			System.out.println("DAO>>>>>>>>>" + sql);
			
			pstmt = conn.prepareStatement(sql.toString());
			System.out.println("DAO>>>>>>>>>" + seq);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				reboardDto = new ReboardDto();
				reboardDto.setSeq(rs.getInt("seq"));
				reboardDto.setName(rs.getString("name"));
				reboardDto.setId(rs.getString("id"));
				reboardDto.setEmail(rs.getString("email"));
				reboardDto.setSubject(rs.getString("subject"));
				reboardDto.setContent(rs.getString("content"));
				reboardDto.setHit(rs.getInt("hit"));
				reboardDto.setLogtime(rs.getString("logtime"));
				reboardDto.setBcode(rs.getInt("bcode"));
				reboardDto.setRseq(rs.getInt("rseq"));
				reboardDto.setRef(rs.getInt("ref"));
				reboardDto.setLev(rs.getInt("lev"));
				reboardDto.setStep(rs.getInt("step"));
				reboardDto.setPseq(rs.getInt("pseq"));
				reboardDto.setReply(rs.getInt("reply"));
			}
			System.out.println("DAO >> query >> " + reboardDto);
			System.out.println("DAO >> query >> " + reboardDto.getContent());
			System.out.println("DAO >> query >> " + reboardDto.getName());
			System.out.println("DAO >> query >> " + reboardDto.getSeq());
			System.out.println("DAO >> query >> " + reboardDto.getSubject());
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return reboardDto;
	}

	/*
	@Override
	public ReboardDto getArticle(int seq) {
		return null;
	}*/

	@Override
	public int modifyArticle(ReboardDto reboardDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update BOARD set CONTENT = ?, SUBJECT = ?  \n");
			sql.append("where SEQ = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			
			int idx = 0;
			pstmt.setString(++idx, reboardDto.getContent());
			pstmt.setString(++idx, reboardDto.getSubject());
			pstmt.setInt(++idx, reboardDto.getSeq());
			
			//rs = pstmt.executeQuery(); - select
			cnt = pstmt.executeUpdate();
			System.out.println("DAO >> modifyArticlequery >> " + reboardDto);
			System.out.println("DAO >> modifyArticlequery >> " + reboardDto.getContent());
			System.out.println("DAO >> modifyArticlequery >> " + reboardDto.getSeq());
			System.out.println("DAO >> modifyArticlequery >> " + reboardDto.getSubject());
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return cnt;	
	}

	@Override
	public int deleteArticle(ReboardDto reboardDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		System.out.println("seq>>>>>>>>>>>DAO" + reboardDto.getSeq());
		
		try {
			conn = DBConnection.makeConnection();
			conn.setAutoCommit(false);
			StringBuffer sql = new StringBuffer();
			sql.append("delete from reboard where seq = ?  \n");
			pstmt = conn.prepareStatement(sql.toString());
			System.out.println(">>>>>>>>>>>>>>>1번"+sql.toString());
			
			pstmt.setInt(1, reboardDto.getSeq());
			cnt = pstmt.executeUpdate();
			pstmt.close();
			
			//delete from reboard where seq = '479';
			//delete from board where seq = '479';
			sql.setLength(0); //길이를 0으로 만들어라
			sql.append("delete from board where seq = ?  \n");
			pstmt = conn.prepareStatement(sql.toString());
			System.out.println(">>>>>>>>>>>>>>>2번"+sql.toString());
			
			pstmt.setInt(1, reboardDto.getSeq());
			cnt = pstmt.executeUpdate();
			
			//rs = pstmt.executeQuery(); - select
			
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;	
	}
}
