package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.TodoLogic;

/**
 * Servlet implementation class TodoDelete
 */
@WebServlet("/TodoDelete")
public class TodoDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoDelete() {
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
		//インスタンスを作成
		TodoLogic todoLogic = new TodoLogic();
		
		try {
			//削除処理呼び出し
			todoLogic.deleteTodo(Integer.parseInt(request.getParameter("id")));
			//TodoIndexにリダイレクト
			response.sendRedirect("TodoIndex");
			
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
		}
	}

}
