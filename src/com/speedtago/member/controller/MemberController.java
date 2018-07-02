package com.speedtago.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.speedtago.member.model.*;
import com.speedtago.member.service.MemberService;
import com.speedtago.member.service.MemberServiceImpl;
import com.speedtago.util.PageMove;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthSeparatorUI;


@WebServlet("/user")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MemberService memberService;
	
	public void init() {
		memberService = new MemberServiceImpl();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getContextPath();
		
		String act = request.getParameter("act");
		System.out.println("act ==== " + act);
		
		if("mvjoin".equals(act)) {
			PageMove.redirect(request, response, "/join/member_write.jsp");
			//top.jsp -> ȸ�� ���� -> mvjoin >> member_write.jsp �̵�
			
		} else if("mvlogin".equals(act)) {
			PageMove.redirect(request, response, "/login/login.jsp");
			//top.jsp -> �α��� -> mvjoin >> login.jsp �̵�
			
		} else if("idsearch".equals(act)) {
			//member_write.jsp -> ���̵� ã�� -> idsearch >> ��� ����, �Ұ� �˷��ֱ�
			
			String id = request.getParameter("id");
			System.out.println("�˻� ���̵� : " + id);
			int cnt = memberService.idCheck(id);
			System.out.println("�˻� ���̵� ���� : " + cnt);
			response.setContentType("text/plain;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(cnt);
			
		} else if("mvzip".equals(act)) {
			PageMove.redirect(request, response, "/join/zipsearch.jsp");
			
		} else if("zipsearch".equals(act)) {
			request.setCharacterEncoding("utf-8");
			String zipcod = request.getParameter("zipNo");
			String addr1 = request.getParameter("roadAddrPart1");
			String addr2 = request.getParameter("roadAddrPart2");
			
			System.out.println(zipcod);
			System.out.println(addr1);
			System.out.println(addr2);
			
			//String zipNo = request.getParameter("zipNo");
			//System.out.println("�˻� zipNo : " + zipNo);
			//List<ZipDto> list = memberService.zipSearch(zipNo);
			//System.out.println("�˻��� ���� : " + list.size());
			//request.setAttribute("zipList", list);
			//request.setAttribute("searchDong", zipNo);
			
			PageMove.forward(request, response, "/join/zipsearch.jsp");
		} else if("register".equals(act)) {
			//member_write.jsp -> ȸ������ -> register >> ������: /join/register_ok.jsp �̵� // ���н�: /join/register_fail.jsp �̵� 
			MemberDetailDto memberDetailDto = new MemberDetailDto();
			memberDetailDto.setId(request.getParameter("id"));
			memberDetailDto.setName(request.getParameter("name"));
			memberDetailDto.setPass(request.getParameter("pass"));
			memberDetailDto.setEmail1(request.getParameter("email1"));
			memberDetailDto.setEmail2(request.getParameter("email2"));
			memberDetailDto.setTel1(request.getParameter("tel1"));
			memberDetailDto.setTel2(request.getParameter("tel2"));
			memberDetailDto.setTel3(request.getParameter("tel3"));
			memberDetailDto.setZipcode(request.getParameter("zipcode"));
			memberDetailDto.setAddr1(request.getParameter("addr1"));
			memberDetailDto.setAddr2(request.getParameter("addr2"));
			
			int cnt = memberService.registerMember(memberDetailDto);
			if(cnt != 0) {//����.
				request.setAttribute("userInfo", memberDetailDto);
				PageMove.forward(request, response, "/join/register_ok.jsp");
			} else {
				PageMove.redirect(request, response, "/join/register_fail.jsp");
			}
			
		} else if("login".equals(act)) {
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");
			
			MemberDto memberDto = memberService.login(id, pass);
			
			if(memberDto != null) {
				
				
				/////////////////////////// Cookie /////////////////////////////
				if("saveok".equals(request.getParameter("idsave"))) {
					System.out.println("���̵� �����Ѵ�.");
					Cookie cookie = new Cookie("loginid", id);
					cookie.setPath(root);
					cookie.setMaxAge(60*60*24*365*10);
					
					response.addCookie(cookie);
				} else {
					Cookie cookie[] = request.getCookies();
					if(cookie != null) {
						int len = cookie.length;
						for(int i=0;i<len;i++) {
							if("loginid".equals(cookie[i].getName())) {
								cookie[i].setMaxAge(0);
								cookie[i].setPath(root);
								
								response.addCookie(cookie[i]);
								break;
							}
						}
					}
				}
				////////////////////////////////////////////////////////////////
				
				///////////////////////// session //////////////////////////////
				
				HttpSession session = request.getSession();
				session.setAttribute("userInfo", memberDto);
				session.setAttribute("id", id);
				
				////////////////////////////////////////////////////////////////

				
				PageMove.redirect(request, response, "/index.jsp");
			} else {
				PageMove.redirect(request, response, "/login/login_fail.jsp");
			}
		} else if("mvlogout".equals(act)) {
			//top.jsp -> �α׾ƿ� -> mvlogout >> /index.jsp �̵�
			HttpSession session = request.getSession();
//			session.setAttribute("userInfo", null);
			session.removeAttribute("userInfo");
//			session.invalidate();
			PageMove.redirect(request, response, "/index.jsp");
		} else if("mvmaillist".equals(act)) {
			List<String> mail = new ArrayList<String>();
			mail.add("����1�� ���� ����.");
			mail.add("����2�� ���� ����.");
			mail.add("����3�� ���� ����.");
			mail.add("����4�� ���� ����.");
			mail.add("����5�� ���� ����.");
			mail.add("����6�� ���� ����.");
			
			request.setAttribute("maillist", mail);
			PageMove.forward(request, response, "/mail/list.jsp");
		}else if("mvindex".equals(act)) {
			PageMove.redirect(request, response, "/index.jsp");
		} else if("mvidpass_search".equals(act)) {
			//idpass ã��: top > act=mvidpass_search > membercontroller > /login/idpass_search.jsp �̵� 
			PageMove.redirect(request, response, "/login/idpass_search.jsp");
		} else if("mvid_search".equals(act)) {
			//idpass ã��: top > act=mvidpass_search > membercontroller > /login/idpass_search.jsp �̵� 
			String name1 = request.getParameter("name1");
			String email1 = request.getParameter("email1");
			String email2 = request.getParameter("email2");
			
			System.out.println("name1" + name1);
			System.out.println("email1 >> " + email1 + "  email2 >>" + email2);
			
			MemberDetailDto memberDetailDto = new MemberDetailDto();
			memberDetailDto.setName(request.getParameter("name1"));
			memberDetailDto.setEmail1(request.getParameter("email1"));
			memberDetailDto.setEmail2(request.getParameter("email2"));
			memberDetailDto = memberService.getIdSearch(memberDetailDto);
			
			System.out.println("id" + memberDetailDto.getId());
			HttpSession session = request.getSession();
			String id = (String) session.getAttribute("id");
			System.out.println("id >>>>>>>>>>>>>>" + id);
			request.setAttribute("id", id);
			request.setAttribute("userInfo", memberDetailDto);
			PageMove.forward(request, response, "/login/id_search_result.jsp");
		
		
		} else if("mvpass_search".equals(act)) {
			//idpass ã��: top > act=mvidpass_search > membercontroller > /login/idpass_search.jsp �̵� 
			
			request.getAttribute("id");
			
			System.out.println("mvpass_search >> mvpass_search id >>>>" + request.getParameter("id"));
			
			MemberDetailDto memberDetailDto = new MemberDetailDto();
			memberDetailDto.setId(request.getParameter("id"));
//			memberDetailDto.setPass(request.getParameter("pass"));
			memberDetailDto.setName(request.getParameter("name"));
			memberDetailDto.setEmail1(request.getParameter("email1"));
			memberDetailDto.setEmail2(request.getParameter("email2"));
						
			request.setAttribute("userInfo", memberDetailDto);
			int cnt = memberService.getPassChange(memberDetailDto);
			
			
			request.setAttribute("userInfo", memberDetailDto);
			System.out.println(memberDetailDto.getPass());
			PageMove.forward(request, response, "/login/pass_change.jsp");
			
		} else if("mvpasschange".equals(act)) {
			//mypage: top > act=mvpasschange > membercontroller > /mypage/mypage_modify.jsp �̵�
			
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");
			
			System.out.println("id" + id);
			System.out.println("pass" + pass);
			
			MemberDetailDto memberDetailDto = new MemberDetailDto();
			memberDetailDto.setId(request.getParameter("id"));
			memberDetailDto.setPass(request.getParameter("pass"));
			
			request.setAttribute("userInfo", memberDetailDto);
			int cnt = memberService.getPassChange(memberDetailDto);
			
			//request.setAttribute("userInfo", memberDetailDto);
			System.out.println("controll mvpasschange cnt " + cnt);
			if(cnt != 0) {
			PageMove.redirect(request, response, "/login/pass_search_result.jsp");
			}else{
			PageMove.redirect(request, response, "/index.jsp");		 
			}
			
		}else if("mvmypage".equals(act)) {
			//mypage: top > act=mvmypage_modify > membercontroller > /mypage/mypage_modify.jsp �̵�
			
			HttpSession session = request.getSession();
			String id = (String) session.getAttribute("id");
			System.out.println("id1>>>>" + id);
			
			MemberDetailDto memberDetailDto = new MemberDetailDto();
			memberDetailDto = memberService.getMember(id);
			
			System.out.println("memberDetailDto" + memberDetailDto.getId());
			System.out.println("memberDetailDto" + memberDetailDto.getName());
			System.out.println("memberDetailDto" + memberDetailDto.getPass());
			System.out.println("memberDetailDto" + memberDetailDto.getZipcode());
			
			request.setAttribute("userInfo", memberDetailDto);
			PageMove.forward(request, response, "/mypage/mypage_modify.jsp");
			
			
		}else if("mvmodify".equals(act)) {
			
			HttpSession session = request.getSession();
			String id = (String) session.getAttribute("id");
			System.out.println("memberinfor_modify >> id >>>>" + id);
			System.out.println("memberinfor_modify >> getParameter id >>>>" + request.getParameter("id"));
			
			MemberDetailDto memberDetailDto = new MemberDetailDto();
			memberDetailDto.setId(request.getParameter("id"));
			memberDetailDto.setName(request.getParameter("name"));
			memberDetailDto.setPass(request.getParameter("pass"));
			memberDetailDto.setEmail1(request.getParameter("email1"));
			memberDetailDto.setEmail2(request.getParameter("email2"));
			memberDetailDto.setTel1(request.getParameter("tel1"));
			memberDetailDto.setTel2(request.getParameter("tel2"));
			memberDetailDto.setTel3(request.getParameter("tel3"));
			memberDetailDto.setZipcode(request.getParameter("zipcode"));
			memberDetailDto.setAddr1(request.getParameter("addr1"));
			memberDetailDto.setAddr2(request.getParameter("addr2"));
			
			int cnt = memberService.modifyMember(memberDetailDto);
			
			if(cnt != 0) {//����.
				request.setAttribute("userInfo", memberDetailDto);
				System.out.println("Controll>>>" + memberDetailDto);
				
				PageMove.forward(request, response, "/mypage/mypage_modify_ok.jsp");
			} else {
				PageMove.redirect(request, response, "/mypage/mypage_modify_fail.jsp");
			}
		
		
		}else if("mvsecession".equals(act)) {
			//mypage: top > act=mvmypage_modify > membercontroller > /mypage/mypage_modify.jsp �̵�
			
			    HttpSession session = request.getSession();
				String id = (String) session.getAttribute("id");
				System.out.println("id1>>>>" + id);
				
				MemberDetailDto memberDetailDto = new MemberDetailDto();
				int cnt = memberService.deleteMember(id);
				
				if(cnt != 0) {
				session.removeAttribute("userInfo");
				session.removeAttribute("id");
				PageMove.redirect(request, response, "/index.jsp");
				}
				
			}else {
			PageMove.redirect(request, response, "/index.jsp");
			//top.jsp -> Ȩ������ ���� -> "" >> login.jsp �̵�
			//top.jsp -> �޴�- Home -> "" >> login.jsp �̵�
		}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}