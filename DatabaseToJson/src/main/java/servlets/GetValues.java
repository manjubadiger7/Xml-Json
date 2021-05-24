package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import Dao.*;
import model.Person;

@WebServlet("/getvalues")
public class GetValues extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<Person> persons = new LinkedList<Person>();
		PrintWriter out = null;
		String personsToJson = null;
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		try {
			out = response.getWriter();
			persons = new EntryDaoImpl().getValues();
			Gson gson = new Gson();
			personsToJson = gson.toJson(persons);
			response.setStatus(200);
			out.println(personsToJson);
			out.flush();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} finally {
			if (out != null)
				out.close();
		}
	}

}
