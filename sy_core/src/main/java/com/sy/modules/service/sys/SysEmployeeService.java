package com.sy.modules.service.sys;

import java.util.ArrayList;
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

}
