package bit.hibooks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import lombok.extern.log4j.Log4j;

@Controller
//@Log4j
public class IndexController {
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/index.do")
	public String loginSuccessIndexPage(@RequestParam int loginCode) {
		//log.info("#2 :"+loginCode);
		return "index";
	}
}
 