package bit.sdo.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import bit.sdo.domain.Board;
import bit.sdo.domain.BoardListResult;
import bit.sdo.service.BoardService;
import lombok.extern.log4j.Log4j;


@Log4j
@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardService service;
	@RequestMapping("list.do")
	public ModelAndView list(HttpServletRequest request, HttpSession session) {
		String cpStr = request.getParameter("cp");
		String psStr = request.getParameter("ps");
		
		//(1) cp 
		int cp = 1;
		if(cpStr == null) {
			Object cpObj = session.getAttribute("cp");
			if(cpObj != null) {
				cp = (Integer)cpObj;
			}
		}else {
			cpStr = cpStr.trim();
			cp = Integer.parseInt(cpStr);
		}
		session.setAttribute("cp", cp);
		
		//(2) ps 
		int ps = 3;
		if(psStr == null) {
			Object psObj = session.getAttribute("ps");
			if(psObj != null) {
				ps = (Integer)psObj;
			}
		}else {
			psStr = psStr.trim();
			int psParam = Integer.parseInt(psStr);
			
			Object psObj = session.getAttribute("ps");
			if(psObj != null) {
				int psSession = (Integer)psObj;
				if(psSession != psParam) {
					cp = 1;
					session.setAttribute("cp", cp);
				}
			}else {
				if(ps != psParam) {
					cp = 1;
					session.setAttribute("cp", cp);
				}
			}
			
			ps = psParam;
		}
		session.setAttribute("ps", ps);
		
		BoardListResult listResult = service.getBoardListResult(cp, ps);
		ModelAndView mv = new ModelAndView();
		if(listResult.getList().size() == 0 && cp>1) {
			mv.setViewName("redirect:list.do?cp="+(cp-1));
			return mv;
		}else {
			log.info(listResult);
			mv.setViewName("board/list");
			mv.addObject("listResult", listResult);
			return mv;
		}	
	}
	
	@GetMapping("write.do")
	public String write() {
		return "board/write";
	}
	@PostMapping("write.do")
	public String write(Board board, @RequestParam ArrayList<MultipartFile> files) {
		service.write(board, files);
		
		//
		
		return "redirect:list.do";
	}
	@GetMapping("content.do")
	public ModelAndView getContent(long seq) {
		Board board = service.getContent(seq);
		return new ModelAndView("board/content","board", board);
	}
	@GetMapping("del.do")
	public String remove(long seq) {
		service.remove(seq);
		return "redirect:list.do";
	}
	@GetMapping("update.do")
	public ModelAndView edit(long seq) {
		Board board = service.getContent(seq);
		return new ModelAndView("board/update","board",board);
	}
	@PostMapping("update.do")
	public String edit(Board board) {
		service.edit(board);
		return "redirect:content.do?seq="+ board.getSeq();
	}
}
