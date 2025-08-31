package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import beans.TodoBean;
import model.TodoLogic;

/**
 * Servlet implementation class TodoInsertComplete
 */
@WebServlet("/TodoInsertComplete")
public class TodoInsertComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoInsertComplete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//フォームの値を取得
		String title = request.getParameter("title");
		String decription = request.getParameter("description");
		String dueDate = request.getParameter("due_date");
		
		//インスタンスを作る
		TodoBean todo = new TodoBean();
		todo.setTitle(title);
		todo.setDescription(decription);
		todo.setDue_date(java.sql.Date.valueOf(dueDate));
		
		//DB登録
		TodoLogic logic = new TodoLogic();
		try {
			logic.insertTodo(todo);
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("TodoIndex");
	}

}
