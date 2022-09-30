
    import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class JDBC_CRUD {

	static Connection conn = null;
	// static CallableStatement cs = null;
	static Statement st = null;
	static PreparedStatement ps = null;
	static ResultSet rt = null;
	static ResultSetMetaData rm = null;
	static InputStreamReader ir = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(ir);

	public static Connection getconn() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/courseid";
		String uname = "root";
		String pass = "root";
		return DriverManager.getConnection(url, uname, pass);
	}

	public static void insert() throws NumberFormatException, IOException, SQLException {
		System.out.println("Enter Name : ");
		String name = br.readLine();
		System.out.println("Enter instructor : ");
		String instructor = br.readLine();
		System.out.println("Enter duration : ");
		int duration = Integer.parseInt(br.readLine());
		System.out.println("Enter fees : ");
		int fees = Integer.parseInt(br.readLine());
		String que = "insert into courseinfo values (?,?,?,?)";
		conn = getconn();
		System.out.println("Connection Sucessfull");
		ps = conn.prepareStatement(que);
		ps.setString(1, name);
		ps.setString(2, instructor);
		ps.setInt(3, duration);
		ps.setInt(4, fees);
		ps.executeUpdate();
		System.out.println("Record inserted ");
	}

	public static void select() throws SQLException {
		conn = getconn();
		st = conn.createStatement();
		rt = st.executeQuery("select * from courseinfo");
		rm = rt.getMetaData();
		System.out.println();
		while (rt.next()) {
			for (int i = 1; i <= rm.getColumnCount(); i++) {
				System.out.print(rt.getString(i) + " ");
			}
			System.out.println();

		}
		System.out.println();
	}

	public static void update() throws NumberFormatException, IOException, SQLException {
		System.out.println("Enter id for which you want to update : ");
		String name = br.readLine();

		System.out.println("Enter instructor : ");
		String instructor = br.readLine();
		System.out.println("Enter duration : ");
		int duration = Integer.parseInt(br.readLine());
		System.out.println("Enter fees : ");
		int fees = Integer.parseInt(br.readLine());

		String query = "update courseinfo set instructor=? , duration=? , fees=?  where stud_name=?";
		conn = getconn();
		ps = conn.prepareStatement(query);
		ps.setString(1, instructor);
		ps.setInt(2, duration);
		ps.setInt(3, fees);
		ps.setString(4, name);
		ps.executeUpdate();
		System.out.println("Record updated  ");
	}

	public static void delete() throws NumberFormatException, IOException, SQLException {
		conn = getconn();

		System.out.println("Enter name for which you want to delete record : ");
		String name = br.readLine();
		String query = "delete from courseinfo where stud_name=?";
		ps = conn.prepareStatement(query);
		ps.setString(1, name);
		ps.executeUpdate();
		System.out.println("Record Deleted");

	}

	public static void main(String[] args) {
		System.out.println("Enter your option : ");

		try {
			while (true) {
				System.out.println("1. Read \n2. Insert\n3. Update\n4. Delete\n5. exit");
				int option = Integer.parseInt(br.readLine());
				if (option == 1) {
					select();
				} else if (option == 2) {
					insert();
				} else if (option == 3) {
					update();
				} else if (option == 4) {
					delete();
				} else if (option == 5) {
					break;
				} else {
					System.out.println("Choose correct option");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rt != null)
					rt.close();
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Thankyou ");

	}

}
    

