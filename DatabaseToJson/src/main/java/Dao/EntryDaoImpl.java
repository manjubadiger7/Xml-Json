package Dao;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import model.Person;

public class EntryDaoImpl {

	static String url = "jdbc:mysql://localhost:3306/datatojson";
	static String user = "root";
	static String password = "21497518";
	PreparedStatement ps = null;
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;

	public int setDatas(String name, int age) throws ClassNotFoundException, NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		String sql1 = "insert into person( name, age) values(?,?)";

		int answer = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			Random rand = SecureRandom.getInstanceStrong();
			int id = rand.nextInt();
			ps = con.prepareStatement(sql1);

			ps.setString(1, name);
			ps.setInt(2, age);
			answer = ps.executeUpdate();

			return answer;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return 0;
	}

	public List<Person> getValues() throws ClassNotFoundException {
		// TODO Auto-generated method stub
		String sql = "select * from person";
		List<Person> persons = new LinkedList<Person>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Person obj = new Person();
				obj.setPersonId(rs.getInt("id"));
				obj.setPersonName(rs.getString("name"));
				obj.setPersonAge(rs.getInt("age"));

				persons.add(obj);

				System.out.println(obj.getPersonId());
				System.out.println(obj.getPersonName());
				System.out.println(obj.getPersonAge());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (st != null)
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return persons;
	}

}
