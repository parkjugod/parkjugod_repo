package com.sample.app.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sample.app.service.HomeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private HomeService homeService;
	
	/**
	 * @description : return type String 방식 컨트롤러
	 * @return : String
	 * @param : model
	 * @author : JuHyung
	 * @date : 2016. 9. 9. 오후 4:30:01
	 */
	@RequestMapping(value = "/home.do")
	public String home(Model model) {
		
		homeService.homeTest();
		
		return "home";
	}
	
	/**
	 * @description : return type ModelAndView 방식 컨트롤러
	 * @return : String
	 * @param : model
	 * @author : JuHyung
	 * @date : 2016. 9. 9. 오후 4:30:01
	 */
	@RequestMapping("/modelHome.do")
	public ModelAndView modelHome(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		
		return mv;
	}
	
	
	/**
	 * @description : 
	 * @author : JuHyung
	 * @date : 2016. 9. 12. 오전 11:28:10
	 */
	@RequestMapping(value = "/crawlingForm.do")
	public ModelAndView crawlingForm(ModelMap modelMap) {
		
		return new ModelAndView("/crawling/crawlingForm", modelMap);
	}
	
	/**
	 * @description : 
	 * @author : JuHyung
	 * @date : 2016. 9. 12. 오후 1:35:51
	 */
	@RequestMapping(value = "/crawling.do")
	public ModelAndView name(ModelMap modelMap, @RequestParam Map<String, Object> inParam) {
		
		logger.debug("crawling start");

		logger.debug(">>>>> url : " + inParam.get("url").toString());
		homeService.crawling(inParam);
		
		logger.debug("crawling end");

		return new ModelAndView("/crawling/crawlingForm", modelMap);
	}
	
	/**
	 * @description : test
	 * @author : JuHyung
	 * @date : 2016. 9. 23. 오후 2:30:36
	 */
	@RequestMapping(value = "/test.do")
	public ModelAndView test(ModelMap modelMap) {
		logger.info("########## HomeController :: test :: Start ##########");

		

		logger.info("########## HomeController :: test :: End ##########");
		return new ModelAndView("/test/test", modelMap);
	}
}
