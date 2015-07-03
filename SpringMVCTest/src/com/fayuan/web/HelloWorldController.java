package com.fayuan.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/mvc")
public class HelloWorldController {

	@RequestMapping("/hello")
	public String helloWorld(Model model) {
		model.addAttribute("message", "Hello World!");
		return "index";
	}
	
	/**@RequestMapping(value={"/test1", "/user/create"})：多个URL路径可以映射到同一个处理器的功能处理方法。*/
	@RequestMapping(value = {"/test", "/first"}, method = RequestMethod.GET)
    public ModelAndView helloWorld() {
        //1、收集参数  
        //2、绑定参数到命令对象  
        //3、调用业务对象  
        //4、选择下一个页面  
        ModelAndView mv = new ModelAndView();  
        //添加模型数据 可以是任意的POJO对象  
        mv.addObject("message", "test Spring MVC!");  
        //设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面  
        mv.setViewName("index");
        return mv;  //○3 模型数据和逻辑视图名  
    }
	
	/**
	 * {×××}占位符， 请求的URL可以是 “/users/123456”或
	 * “/users/abcd”，@PathVariable可以提取URI模板模式中的{×××}中的×××变量。
	 * @RequestMapping(value="/users/{userId}/create")：这样也是可以的，请求的URL可以是“/users/123/create”。
	 * @RequestMapping(value="/users/{userId}/topics/{topicId}")：这样也是可以的，请求的URL可以是“/users/123/topics/123”。
	 */
	@RequestMapping("/user/{userId}")
	public String pattern(Model model) {
		model.addAttribute("message", "userId");
		return "index";
	}

	/**
	 *  ②@RequestMapping(params="create", method=RequestMethod.GET) ：
	 *  表示请求中有“create”的参数名且请求方法为“GET”即可匹配，如可匹配的请求URL“http://×××/parameter1?create”；
	 *  
	 *  @RequestMapping(params="!create", method=RequestMethod.GET)：表示请求中没有“create”参数名
	 * @param model
	 * @return
	 */
	@RequestMapping(params = "create", method = RequestMethod.GET)
	public String showForm(Model model) {		
		model.addAttribute("message", "create");
		return "index";
	}
	
	@RequestMapping(value = "/json", 
            produces = { MediaType.APPLICATION_JSON_VALUE }, 
            method = RequestMethod.GET)
	public ResponseEntity<Map<String, String>> getContacts() {

        Map<String, String> dummyData = new HashMap<>();

        dummyData.put("java-examples",
                "http://www.leveluplunch.com/java/examples/");
        dummyData.put("groovy-examples",
                "http://www.leveluplunch.com/groovy/examples/");

        return new ResponseEntity<Map<String, String>>(dummyData, HttpStatus.OK);
    }
}