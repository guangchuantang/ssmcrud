package com.cn.hnust.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.hnust.pojo.Teacher;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.TeacherService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	
	@Resource
	private TeacherService tService;
    
	//查询所有教师信息
	//查询所有用户
	@RequestMapping(value = "/selectTeacher",method = RequestMethod.GET)
	@ResponseBody
	public JSONObject selectUser(HttpServletRequest request,HttpServletResponse response){
		List<Teacher> list = tService.selectTeacher();
		System.out.println("查询成功");
        JSONArray json = JSONArray.fromObject(list);
        JSONObject obj = new JSONObject();
        obj.put("msg", "success");
        obj.put("data", json);
        System.out.print(obj);
        response.setContentType("text/html;charset=utf-8");
		return obj;
	}
	//根据id删除教师信息
	@RequestMapping(value = "/delete",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public JSONObject delete(HttpServletRequest request,HttpServletResponse response,String id){
		System.out.println("执行删除"+id);
		boolean bool = tService.deleteById(Integer.parseInt(id));
		
		JSONObject obj = new JSONObject();
		if(bool){
		 obj.put("msg", "success");
		}else{
		 obj.put("msg", "fail");
		}
		System.out.println(obj);
		response.setContentType("text/html;charset=utf-8");
		return obj;
	}
	//根据id修改用户
	@RequestMapping(value = "/updateById",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public JSONObject updateById(HttpServletRequest request,HttpServletResponse response,Teacher t){
	   int row = tService.updateById(t);
	   JSONObject obj = new JSONObject();
		if(row > 0){
		 obj.put("msg", "success");
		}else{
		 obj.put("msg", "fail");
		}
		System.out.println(obj);
		response.setContentType("text/html;charset=utf-8");
		return obj;
	}
	//添加教师信息
	@RequestMapping(value = "/addTeacher",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public JSONObject addUser(HttpServletRequest request,HttpServletResponse response,Teacher t){
		
		int row = this.tService.addTeacher(t);
		JSONObject obj = new JSONObject();
		if(row > 0){
		   obj.put("msg", "success");
		}else{
		   obj.put("msg", "fail");
		}
		System.out.println(obj.toString());
		response.setContentType("text/html;charset=utf-8");
		return obj;
	}
}
