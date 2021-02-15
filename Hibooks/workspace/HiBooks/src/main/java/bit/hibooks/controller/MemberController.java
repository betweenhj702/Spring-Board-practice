package bit.hibooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bit.hibooks.domain.Member;
import bit.hibooks.service.MemberService;
import lombok.extern.log4j.Log4j;

import static bit.hibooks.setting.MemberModeSet.*;

import javax.servlet.http.HttpSession;

@Log4j
@Controller
@RequestMapping("member")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("join.do")
	public String joinPage() {
		
		return "member/join";
	}
	@PostMapping("join.do")
	public ModelAndView join(Member member) {
		int joinCode = service.join(member);
		if(joinCode == JOIN_F_EMAIL_EXIST) {
			//log.info(joinCode);
			return new ModelAndView("member/join","joinCode", joinCode);	// 회원가입 실패 메세지
		}else if(joinCode == JOIN_SUCCESS){
			return new ModelAndView("redirect:/");
		}
		return null;
	}
	@GetMapping("login.do")
	public String loginPage() {
		return "member/login";
	}
	@PostMapping("login.do")
	public ModelAndView login(Member member, HttpSession session) {
		int loginCode = service.loginCheck(member);
		ModelAndView mv = new ModelAndView();
		if(loginCode == LOGIN_SUCCESS) {
			Member loginUser = service.getMemberInfo(member); 
			session.setAttribute("loginUser", loginUser);	//session에 회원정보 넣어주기
			mv.addObject("loginCode", loginCode);	//모델앤뷰에 로그인 성공 코드 넣기
			mv.setViewName("redirect:/index.do");
			return mv;
		}else if(loginCode != LOGIN_SUCCESS) {
			mv.addObject("loginCode", loginCode);
			mv.setViewName("member/login");
			return mv;
		}
		return mv;
	}
}
