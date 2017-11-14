package com.sy.web.controller.sys;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.PageInfo;
import com.sy.modules.entity.sys.SysEmployee;
import com.sy.modules.entity.sys.SysUser;
import com.sy.modules.entity.vo.SysEmployeeVo;
import com.sy.modules.service.sys.SysEmployeeService;
import com.sy.web.commons.SessionUtil;

@Controller
@RequestMapping("/sys")
public class SysEmployeeController {
	
	@Autowired
	private SysEmployeeService emservice;
	
	@RequestMapping(value = "/findAllEmployees", method = { RequestMethod.GET,RequestMethod.POST })
	public String findAllEmployees(Model model,@ModelAttribute SysEmployeeVo emVo, HttpServletRequest request) {
		SysUser user=SessionUtil.getLoginUser(request);
		if(null!=user){
			emVo.setSysUserId(user.getParentid());
		}
		PageInfo<SysEmployee> emlist= emservice.findAllSysEmployeesByPage(emVo);
		model.addAttribute("emlist", emlist);
		return "sys/employeelist";
	}
	
	@RequestMapping(value = "/precreateemp", method = { RequestMethod.GET,RequestMethod.POST })
	public String precreateemp(){
		return "sys/addemp";
	}

}
