package com.sy.modules.service.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.sy.modules.common.Constants;
import com.sy.modules.dao.sys.SysEmployeeMapper;
import com.sy.modules.entity.sys.SysEmployee;
import com.sy.modules.entity.vo.SysEmployeeVo;

@Service
public class SysEmployeeService {

	@Autowired
	private SysEmployeeMapper employmapper;

	// 查询所有员工
	public PageInfo<SysEmployee> findAllSysEmployeesByPage(SysEmployeeVo employeeVo) {
		List<SysEmployee> list = new ArrayList<SysEmployee>(0);
		if (null != employeeVo) {
			employeeVo.seteState(Constants.ISDELSTATE);
			list = employmapper.selectByExample(employeeVo.toExample());
		}
		return new PageInfo<SysEmployee>(list);
	}
	
	//添加员工
	public int saveEmployee(SysEmployee emp){
		emp.setDelStatus(Constants.ISDELSTATE);
		return employmapper.insertSelective(emp);
	}
	
	//删除
	public int deleteEmployee(SysEmployee emp){
		emp.setDelStatus(Constants.DELSTATE);
		return employmapper.updateByPrimaryKeySelective(emp);
	}
	
	public SysEmployee findEmplyee(Integer empId){
		return employmapper.selectByPrimaryKey(empId);
	}
	//修改
	public int updateEmployee(SysEmployee emp){
		emp.setUpdateTime(new Date());
		return employmapper.updateByPrimaryKeySelective(emp);
	}

}
