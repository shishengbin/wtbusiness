<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="../ws/pageControl/jstlImport.jsp" %>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="${pageContext.request.contextPath}/sys/findAllRoles" method="post">
	<div class="searchBar">
		<table class="searchContent" style="float: left;">
			<tr>
				<td>
					员工姓名：<input type="text" name="wtRName" value=""/>
				</td>
			</tr>
		</table>
		<div class="subBar" style="float: right;">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="${pageContext.request.contextPath}/sys/precreateemp" target="navTab" title="添加员工" width="820" height="400" ><span>添加</span></a></li>
			<li><a class="delete" href="${pageContext.request.contextPath}/sys/{sid_user}/delete" target="ajaxTodo" title="确认删除吗?" rel="page2"><span>删除</span></a></li>
			<li><a class="edit" href="${pageContext.request.contextPath}/sys/searchMenusByRId?rid={sid_user}" target="navTab" title="修改角色"><span>修改</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="112">
		<thead>
			<tr>
				<th width="10%">姓名</th>
				<th width="10%">编号</th>
				<th width="10%">电话</th>
				<th width="10%">邮箱</th>
				<th width="5%">性别</th>
				<th width="5%">是否可用</th>
				<th width="10%">创建时间</th>
				<th width="10%">修改时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${emlist.list}" var="em">
					<tr target="sid_user" rel="${em.eId}">
						<td>${em["eName"]}</td>
						<td>${em["eName"]}</td>
						<td>${em["eName"]}</td>
						<td>${em["eName"]}</td>
						<td>${em["eName"]}</td>
						<td>${em["eName"]}</td>
						<td>${em["eName"]}</td>
						<td>${em["eName"]}</td>
					</tr>
			</c:forEach>
			
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox"  name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})" showvalue="${numPerPage}">
			<option value="10">10</option>
				<option value="15">15</option>
				<option value="20">20</option>
				<option value="30">30</option>
				<option value="40">40</option>
				<option value="50">50</option>
			</select>
			<span>条，共${emlist.total}条</span>
		</div>
		 <div class="pagination" targetType="navTab" totalCount="${emlist.total}" numPerPage="${emlist.pageSize}"
			pageNumShown="${emlist.pageSize}" currentPage="${emlist.pageNum}"></div>
    </div>
</div>
