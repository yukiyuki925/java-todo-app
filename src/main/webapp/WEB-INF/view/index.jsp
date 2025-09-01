<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.border {
	border: 1px solid black;
	padding: 5px;
	margin-bottom: 5px;
}
</style>
</head>
<body>
	<%
	//Todoリストを作る
	ArrayList<TodoBean> todoList = (ArrayList<TodoBean>) request.getAttribute("todoList");
	%>

	<%
	for (TodoBean todoBean : todoList) {
	%>
	<div class="border">
		<p>
			タイトル：<a href="TodoUpdate?id=<%=todoBean.getId()%>"><%=todoBean.getTitle()%></a>
		</p>
		<p>
			概要：<%=todoBean.getDescription()%></p>
		<p>
			期日：<%=todoBean.getDue_date()%></p>
		<form action="TodoDelete" method="post" style="display: inline;">
			<input type="hidden" name="id" value="<%=todoBean.getId()%>">
			<button onclick="return confirmDelete()" type="submit">削除</button>
		</form>
	</div>
	<%
	}
	%>
	<p></p>
	<form action="TodoInsert">
		<input type="submit" value="登録する">
	</form>
	
  <script>
    function confirmDelete() {
      return confirm("本当に削除しますか？");
    }
  </script>
</body>
</html>