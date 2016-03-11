package com.nongyi.www.handler;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nongyi.www.po.User;
import com.nongyi.www.pojo.UserCustom;
import com.nongyi.www.service.UserService;
import com.nongyi.www.solrj.service.SolrjService;
import com.nongyi.www.vo.PageQuery;
import com.nongyi.www.vo.UserCustomVo;
@Controller
@RequestMapping("/user")
public class UserHandler {
	
	@Resource
	private UserService userService;
	
	@Resource
	private SolrjService solrjService;
	
	
	@RequestMapping("/listUI")
	public String listUI(Model model,UserCustomVo userCustomVo,@RequestParam(defaultValue="5")int pageSize,@RequestParam(defaultValue="1")int currPage)throws Exception{
		
		int count = userService.findEntityCount(userCustomVo);
		
		PageQuery pageQuery=new PageQuery();
		
		pageQuery.setPageParams(count, pageSize, currPage);
		
		userCustomVo.setPageQuery(pageQuery);
		
		List<UserCustom> list = userService.findEntityList(userCustomVo);
		
		model.addAttribute("list",list);
		
		model.addAttribute("page",pageQuery);
		
		currPage=pageQuery.getPageQuery_currPage();
		
		model.addAttribute("currPage",currPage);
		
		//int i= 1/0;
		
		return "/listUI";
		
	}
	
	
	
	@RequestMapping("/addUI")
	public String addUI(Model model,int currPage)throws Exception{
		
		model.addAttribute("currPage",currPage);
		
		return "/addUI";
		
	}
	
	@RequestMapping("/add")
	public String add(Model model,UserCustom user,int currPage)throws Exception{
		
		userService.save(user);
		model.addAttribute("currPage",currPage);
		
		return "redirect:/user/listUI.action";
		
	}
	
	
	@RequestMapping("/editUI")
	public String editUI(Model model,Integer id,int currPage)throws Exception{
		
		User user = userService.getById(id);
		model.addAttribute("currPage",currPage);
		model.addAttribute("user", user);
		
		return "/editUI";
		
	}
	
	@RequestMapping("/edit")
	public String edit(UserCustom userCustom,int id,Model model,int currPage)throws Exception{
		userCustom.setUserId(id);
		userService.update(userCustom);
		model.addAttribute("currPage",currPage);
		return "redirect:/user/listUI.action";
		
	}
	
	@RequestMapping("/delete")
	public String delete(Model model,Integer id,int currPage)throws Exception{
		
		userService.deleteById(id);
		model.addAttribute("currPage",currPage);
		return "redirect:/user/listUI.action";
		
	}
	
	
	@RequestMapping("/searchUI")
	public String searchUI(Model model,@RequestParam(defaultValue="5")int pageSize,@RequestParam(defaultValue="1")int currPage,String search_key)throws Exception{
		
		int count = (int) solrjService.searchItemsCount_new(search_key);
		
		PageQuery pageQuery=new PageQuery();
		
		pageQuery.setPageParams(count, pageSize, currPage);
		
		List<User> list = solrjService.searchItems_new(search_key, pageSize, pageQuery.getPageQuery_currPage());
		
		model.addAttribute("list",list);
		
		model.addAttribute("currPage",pageQuery.getPageQuery_currPage());
		
		model.addAttribute("search_key",search_key);
		
		model.addAttribute("page",pageQuery);
		
		return "/solr/searchUI";
		
	}
	
}
