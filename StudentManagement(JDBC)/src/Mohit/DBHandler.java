package Mohit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Formatter;

public class DBHandler {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root" ,"Mj@986903" );
		return con;
	}
	public static int insertStudent(String enno, String name, String department, int sem, String email, String contact) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		PreparedStatement stmt = con.prepareStatement("INSERT INTO STUDENT VALUES (?,?,?,?,?,?)");
		stmt.setString(1,enno);
		stmt.setString(2,name);
		stmt.setString(3,department);
		stmt.setInt(4, sem);
		stmt.setString(5, email);
		stmt.setString(6, contact);
		int result = stmt.executeUpdate();
		return result;
	}
	public static int updateStudent(String enno,int column,String newValue) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		PreparedStatement stmt = null;
		switch(column) {
			case 1 :
				stmt = con.prepareStatement("UPDATE STUDENT SET ENNO = ? WHERE ENNO = ?");
				break;
			case 2 :
				stmt = con.prepareStatement("UPDATE STUDENT SET NAME = ? WHERE ENNO = ?");
				break;
			case 3 :
				stmt = con.prepareStatement("UPDATE STUDENT SET DEPARTMENT = ? WHERE ENNO = ?");
				break;
			case 4 :
				stmt = con.prepareStatement("UPDATE STUDENT SET SEM = ? WHERE ENNO = ?");
				break;
			case 5 :
				stmt = con.prepareStatement("UPDATE STUDENT SET EMAIL = ? WHERE ENNO = ?");
				break;
			case 6 :
				stmt = con.prepareStatement("UPDATE STUDENT SET CONTACT = ? WHERE ENNO = ?");
				break;
		}
		stmt.setString(1,newValue);
		stmt.setString(2, enno);
		int result = stmt.executeUpdate();
		return result;
	}
	public static int deleteStudent(String enno) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		PreparedStatement stmt = con.prepareStatement("DELETE FROM STUDENT WHERE ENNO = ?");
		stmt.setString(1, enno);
		int result = stmt.executeUpdate();
		return result;
	}
	public static ResultSet selectStudent(String enno) throws SQLException, ClassNotFoundException{
		Connection con = getConnection();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM STUDENT WHERE ENNO = ?");
		stmt.setString(1, enno);
		ResultSet set = stmt.executeQuery();
		return set;
	}
	public static ResultSet selectAllStudents() throws SQLException, ClassNotFoundException{
		Connection con = getConnection();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM STUDENT");
		ResultSet set = stmt.executeQuery();
		return set;
	}
}
