package vnua.fita.credit.copy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseCrudOperation10 {
		private static String jdbcURL = "jdbc:ucanaccess://lib/QLSV.accdb";
		private static String jdbcUsername = "";
		private static String jdbcPassword = "";

		// Phương thức trả về một kết nối
		public static Connection getConnection() {
			Connection connection = null;
			try {
				connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return connection;
		}

		// Phương thức lấy tất cả User trong bảng
		public static void selectAllUsers() {
			String SELECT_ALL_USERS_SQL = "SELECT * FROM SINHVIEN";
			try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {

				ResultSet rs = statement.executeQuery(SELECT_ALL_USERS_SQL);

				// Duyệt danh sach bản ghi trả về
				while (rs.next()) {
					String username = rs.getString("MaSV");
					String password = rs.getString("Hodem");
					System.out.println(rs.getString("MaSV") + "," + rs.getString("Hodem") + " " + rs.getString("Ten"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public static Student selectStudent(String MaSV) {
			Student student = new Student();
			String SELECT_ALL_USERS_SQL = "SELECT * FROM SINHVIEN sv "
					+ " INNER JOIN KETQUA kq ON sv.MaSV = kq.MaSV"
					+ " INNER JOIN MONHOC mh ON kq.MaMH = mh.MaMH"
					+ " WHERE MaSV = " + MaSV;
			try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {

				ResultSet rs = statement.executeQuery(SELECT_ALL_USERS_SQL);

				// Duyệt danh sach bản ghi trả về
				while (rs.next()) {
					/*
					String username = rs.getString("MaSV");
					String password = rs.getString("Hodem");
					System.out.println(rs.getString("MaSV") + "," + rs.getString("TenMH") + " " + rs.getString("Diem"));
					*/
					student.setCode(rs.getString("MaSV"));
					student.setFullname(rs.getString("Hodem") + " " + rs.getString("Ten"));
					
					Subject sub = new Subject(rs.getString("MaMH"), rs.getString("TenMH"), rs.getInt("soTc"));
					student.addSubject(rs.getString("KyHoc"), (CreditRule) sub);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return student;
		}
		
		public static List<Student> selectAllStudent() {
			List<Student> studentListList = null;
			Map<String, Student> studentMap = new HashMap<String, Student>();
			String SELECT_ALL_USERS_SQL = "SELECT * FROM SINHVIEN sv "
					+ " INNER JOIN KETQUA kq ON sv.MaSV = kq.MaSV"
					+ " INNER JOIN MONHOC mh ON kq.MaMH = mh.MaMH";
			try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {

				ResultSet rs = statement.executeQuery(SELECT_ALL_USERS_SQL);

				// Duyệt danh sach bản ghi trả về
				while (rs.next()) {
					/*
					String username = rs.getString("MaSV");
					String password = rs.getString("Hodem");
					System.out.println(rs.getString("MaSV") + "," + rs.getString("TenMH") + " " + rs.getString("Diem"));
					*/
					Student student = new Student();
					student.setCode(rs.getString("MaSV"));
					student.setFullname(rs.getString("Hodem") + " " + rs.getString("Ten"));
					
					if(studentMap.containsKey(rs.getString("MaSV"))) { // Neu đa có sv đó rồi thì cập nhật ds môn học của sv đó
						Subject sub = new Subject(rs.getString("MaMH"), rs.getString("TenMH"), rs.getInt("soTc"));
						student.addSubject(rs.getString("KyHoc"), (CreditRule) sub);
					}else { // nếu chưa có thì thêm sv vào map
						studentMap.put(rs.getString("MaSV"), student);
					}
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			studentListList = (List<Student>) studentMap.values(); // Chuyển từ Map về List
			
			return studentListList;
		}
		
		public static void main(String[] args) {
			DatabaseCrudOperation.selectStudent("581768");
		}
	
	public DatabaseCrudOperation10() {
		// TODO Auto-generated constructor stub
	}

}
