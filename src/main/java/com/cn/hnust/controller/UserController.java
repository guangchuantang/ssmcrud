package com.cn.hnust.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IUserService;

import net.sf.json.JSONArray;

@Controller
@Scope(value="prototype")
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;
	//添加用户
	@RequestMapping("/addUser")
	public String addUser(User u){
		
		int row = this.userService.addUser(u);
		System.out.println("添加成功");
		if(row>0){
			return "login";
		}
		return "register";
	}
	//根据id查询用户
	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request,Model model){
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserById(userId);
		System.out.println("查询成功");
		System.out.println(user.getUserName());
		model.addAttribute("User", user);
		return "update";
	}
	//登录
	@RequestMapping("/loginUser")
	public  String login(Model model,String name,String pwd){
		System.out.println(name+pwd);
		User user = this.userService.findUserExist(name,pwd);
	    //将用户信息放到model
		model.addAttribute("user",user);
		if("".equals(user) || null==user){
			System.out.println("登录失败");
			model.addAttribute("error","用户名或密码不正确");
			return "login";
		}
		//登陆成功页面
		return "main";
	}
	//查询所有用户
	@RequestMapping("/selectUser")
	public String selectUser(HttpServletRequest request,Model model){
		List<User> list = this.userService.selectUser();
		System.out.println("查询成功");
		 JSONArray arr = JSONArray.fromObject(list);
		 JSONObject json = new JSONObject();
		   json.put("data", arr);
		   json.put("msg", "success");
		   model.addAttribute("json",json);
		   System.out.println(json);
		//model.addAttribute("list", list);
		return "showUser";
	}
	//删除
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request,Model model,String id){
		System.out.println("执行删除"+id);
		boolean bool=this.userService.deleteById(Integer.parseInt(id));
		if(bool){
			model.addAttribute("msg","删除成功");
		
		}
		return "redirect:/user/selectUser";
	}
	//根据id修改用户
	@RequestMapping("/updateById")
	public String updateById(User u){
	   int row=this.userService.updateById(u);
	   if(row>0){
		   return "redirect:/user/selectUser";
	   }
	   return "update";
	}
	//根据姓名查询用户
	@RequestMapping("/selectUserByName")
	@ResponseBody//必须加入的注解，使返回值不在被解析为一个url地址
	public JSONObject selectUserByName(@Param(value="name")String name,Model model){
		
	   JSONObject json=new JSONObject();
	   List<User> u=this.userService.selectUserByName(name);
	   JSONArray arr = JSONArray.fromObject(u);
	   json.put("list", arr);
	   json.put("msg", "success");
	   model.addAttribute("json",json);
	   System.out.println(json);
	   return json;
	}
}
