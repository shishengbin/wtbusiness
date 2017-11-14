<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="../ws/pageControl/jstlImport.jsp" %>
<div class="pageContent">
	<form method="post" action="demo/common/ajaxDone.html" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<p class="contentTitle">添加员工</p>
		<div class="pageFormContent" layoutH="98">
			<p>
				<label>员工姓名：</label>
				<input name="name" class="required" type="text" size="30"/>
			</p>
			<p>
				<label>员工编号：</label>
				
				<input name="sn" type="text" size="30" value="100001" readonly="readonly"/>
			</p>
			<p>
				<label>英文名：</label>
				<input type="text" size="30" />
			</p>
			<p>
				<label>电话号码：</label>
				<input type="text" size="30" />
			</p>
			<p>
				<label>手机号码：</label>
				<input name="code" class="digits" type="text" size="30" alt="请输入数字"/>
			</p>
			<p>
				<label>性别：</label>
				<select name="type" class="required combox">
					<option value="1" selected>男</option>
					<option value="2" >女</option>
				</select>
			</p>
			<p>
				<label>生日：</label>
				
				<input type="text" name="endDate" class="date" size="30" /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>邮箱：</label>
				<input type="text" size="30" />
			</p>
			<p>
				<label>地址：</label>
				<input type="text" size="30" />
			</p>
			<p>
				<label>学历：</label>
				<select name="capital" class="required combox">
					<option value="">请选择</option>
					<option value="1" selected>本科</option>
					<option value="2" >大专</option>
					<option value="3">博士</option>
					<option value="4">其它</option>
				</select>
			</p>
			<p>
				<label>毕业学校：</label>
				<input type="text" size="30" />
			</p>
			<p>
				<label>选择账号：</label>
				<input type="hidden" name="orgLookup.id" value="${orgLookup.id}"/>
				<input type="text" class="required" name="orgLookup.orgName" value="" suggestFields="orgNum,orgName" suggestUrl="demo/database/db_lookupSuggest.html" lookupGroup="orgLookup" />
				<a class="btnLook" href="public/demo/database/dwzOrgLookup.html" lookupGroup="orgLookup">查找带回</a>		
			</p>
		</div>
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>
</body>
