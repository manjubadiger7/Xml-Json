package servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.EntryDaoImpl;

@WebServlet("/entry")
public class Entry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		int answer = 0;
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));

		try {
			answer = new EntryDaoImpl().setDatas(name, age);
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		} catch (NoSuchAlgorithmException e1) {

			e1.printStackTrace();
		}
		if (answer != 0) {
			try {
				response.sendRedirect("home.jsp");
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

}
