package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import beans.TodoBean;
import model.TodoLogic;

/**
 * Servlet implementation class TodoIndex
 */
@WebServlet("/TodoIndex")
public class TodoIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoIndex() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Todoロジックの作成
		TodoLogic todoLogic = new TodoLogic();
		
		try {
			//todoリスト取得
			ArrayList<TodoBean> todoList = todoLogic.getAllTodo();
			//todoListをセット
			request.setAttribute("todoList", todoList);
			//index.jspに転送
			request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
