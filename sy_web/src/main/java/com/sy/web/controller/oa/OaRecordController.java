package com.sy.web.controller.oa;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.sy.modules.entity.oa.OaRecord;
import com.sy.modules.entity.vo.oa.OaRecordVo;
import com.sy.modules.service.oa.OaRecordService;
import com.sy.web.commons.Constants;
import com.sy.web.commons.JsonUtil;

@Controller
@RequestMapping("/oa")
public class OaRecordController {

	@Autowired
	private OaRecordService recordservice;

	// find all records by page
	@RequestMapping(value = "/findAllRecordsByPage/{rId}", method = {RequestMethod.GET, RequestMethod.POST })
	public String findAllRecordsByPage(Model model,@PathVariable Long rId, @ModelAttribute OaRecordVo recordVo, HttpServletRequest request) {
		if(null !=rId && rId>0){
			recordVo.setcId(rId);
			PageInfo<OaRecord> recordlist = recordservice.findAllRecordsByPage(recordVo);
			model.addAttribute("recordlist", recordlist);
			model.addAttribute("rId", rId);
		}
		return "oa/recordlist";
	}

	// prepare add
	@RequestMapping(value = "/precreaterecord", method = { RequestMethod.GET,RequestMethod.POST })
	public String precreaterecord(Model model,HttpServletRequest request) {
		String ridstr=request.getParameter("rid");
		if(StringUtils.isNotBlank(ridstr)){
			Integer rId=Integer.parseInt(ridstr);
			model.addAttribute("rId", rId);
		}
		return "oa/addrecord";
	}

	// save record info
	@RequestMapping(value = "/saveRecord", method = { RequestMethod.GET,RequestMethod.POST })
	@ResponseBody
	public String saveRecord(Model model, HttpServletRequest request,@ModelAttribute OaRecord record) {
		int flag = -1;
		if (null != record) {
			flag = recordservice.saveRecord(record);
		}
		if (flag > 0) {
			return JsonUtil.transferJsonResponse(Constants.SUCCESS,Constants.MSG_ADD_SUCCESS, Constants.REL_RECORDMANAGER,null, Constants.CLOSECURRENT, "oa/findAllRecordsByPage/"+1);
		} else {
			return JsonUtil.transferJsonResponse(Constants.ERROR,Constants.MSG_ADD_FAIL, null, null, null, null);
		}
	}

	// delete record
	@RequestMapping(value = "/{cid}/deleteRecord")
	@ResponseBody
	public String deleteRecord(@PathVariable Integer rid,HttpServletRequest request) {
		int flag = -1;
		if (null != rid && rid > 0) {
			OaRecord record = new OaRecord();
			record.setrId(rid.longValue());
			flag = recordservice.deleteRecord(record);
		}
		if (flag > 0) {
			return JsonUtil.transferJsonResponse(Constants.SUCCESS,Constants.MSG_DEL_SUCCESS, Constants.REL_RECORDMANAGER,null, null, null);
		} else {
			return JsonUtil.transferJsonResponse(Constants.ERROR,Constants.MSG_DEL_FAIL, Constants.REL_RECORDMANAGER,null, null, null);
		}
	}

	@RequestMapping(value = "/findRecordById/{rid}")
	public String findLinkmanById(@PathVariable("rid") Integer rid,Model model, HttpServletRequest request) {
		if (null != rid) {
			OaRecord record = recordservice.findRecord(rid);
			model.addAttribute("record", record);
		}
		return "oa/preupdrecord";
	}

	// update customer
	@RequestMapping(value = "/saveRecordByUpd")
	@ResponseBody
	public String saveRecordByUpd(Model model,@ModelAttribute OaRecord record, HttpServletRequest request) {
		int flag = -1;
		if (null != record) {
			flag = recordservice.updateRecord(record);
		}
		if (flag > 0) {
			return JsonUtil.transferJsonResponse(Constants.SUCCESS,Constants.MSG_UPDATE_SUCCESS, Constants.REL_RECORDMANAGER,null, Constants.CLOSECURRENT, "oa/findAllLinkmansByPage/"+1);
		} else {
			return JsonUtil.transferJsonResponse(Constants.ERROR,Constants.MSG_UPDATE_FAIL, null, null, null, null);
		}
	}

}
