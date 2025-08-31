<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員登録画面</title>
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
</style>
</head>
<body>
	<h1>タスク登録画面</h1>
	<form action="TodoInsertComplete" method="post">
		<table class="form-table">
			<tr>
				<td><label for="title">タイトル:</label></td>
				<td><input type="text" id="title" name="title" class="form-input"
					required></td>
			</tr>
			<tr>
				<td><label for="description">概要:</label></td>
				<td><input type="text" id="description" name="description" required></td>
			</tr>
			<tr>
				<td><label for="due_date">期限日:</label></td>
				<td><input type="date" id="due_date" name="due_date"
					class="form-input" required></td>
			</tr>
		</table>
		<button type="submit" class="form-button">登録</button>
	</form>
</body>
</html>