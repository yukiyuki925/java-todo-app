<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク編集画面</title>
<style>
.form-input {
	width: 100%;
}

.form-table td {
	padding: 5px;
}

.form-table label {
	text-align: right;
}

.form-button {
	margin-top: 10px;
}

#description {
	width: 300px;
}
</style>
</head>

<!-- 編集対象を取得 -->
<% TodoBean todoBean = (TodoBean) request.getAttribute("todoBean"); %>


<body>
	<h1>タスク編集画面</h1>
	<form action="TodoUpdateComplete" method="post">
		<table class="form-table">
			<tr>
				<td><label for="title">タイトル:</label></td>
				<td><input type="text" id="title" name="title" class="form-input" value="<%=todoBean.getTitle() %>"
					required></td>
			</tr>
			<tr>
				<td><label for="description">概要:</label></td>
				<td><input type="text" id="description" name="description" value="<%=todoBean.getDescription() %>" required></td>
			</tr>
			<tr>
				<td><label for="due_date">期限日:</label></td>
				<td><input type="date" id="due_date" name="due_date" value="<%=todoBean.getDue_date() %>"
					class="form-input" required></td>
			</tr>
		</table>
		<input type="hidden" name="id" value="<%=todoBean.getId()%>">
		<button type="submit" class="form-button">更新</button>
	</form>
</body>
</html>