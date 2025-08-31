package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import beans.TodoBean;

public class TodoLogic {
	
	//全てのタスクを取得
	public ArrayList<TodoBean> getAllTodo() throws SQLException, NamingException {
		ArrayList<TodoBean> todoList = new ArrayList<TodoBean>();
		
		String sql = "select * from todo";
		
		try (Connection con = ConnectionBase.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			System.out.println(pstmt.toString());
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				//TodoBeanで初期化
				TodoBean todoBean = new TodoBean();
				//取得した値をtodoBeanにセット
				todoBean.setId(rs.getInt("id"));
				todoBean.setTitle(rs.getString("title"));
				todoBean.setDescription(rs.getString("description"));
				todoBean.setDue_date(rs.getDate("due_date"));
				//todoのリストに追加
				todoList.add(todoBean);
			}
		}
		return todoList;
	}
	
	//新規タスクを作成
	public void insertTodo(TodoBean todo) throws SQLException, NamingException {
		String sql = "insert into todo (title, description, due_date) values (?, ?, ?)";
		
		try (Connection con = ConnectionBase.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setString(1, todo.getTitle());
			pstmt.setString(2, todo.getDescription());
			pstmt.setDate(3, todo.getDue_date());
			
			pstmt.executeUpdate();
		}
	}
	
}
