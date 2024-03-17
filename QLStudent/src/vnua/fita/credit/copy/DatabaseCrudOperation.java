package vnua.fita.credit.copy;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseCrudOperation {

	private static String jdbcURL = "jdbc:mysql://localhost:3306/credit";
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "Msql12356";

	// phuong thuc tra ve ket noi
	public static Connection getConnection() {
		Connection connection = null;
		try {
//			try {
//				// Tìm driver Acces
////								Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//				Class.forName("com.mysql.jdbc.Driver");
//			} catch (ClassNotFoundException e) {
//				System.out.println("Class.forName Error");
//				e.printStackTrace();
//			}
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

		} catch (Exception e) {
			System.out.println("Loi ket noi Mysql: " + e.getLocalizedMessage());
			e.printStackTrace();
		}
		return connection;
	}

	// them phuong thuc moi Lop
	public static void insertSINHVIEN(String MaSV, String Hodem, String Ten, String NgaySinh, String GioiTinh,
			String MaLop) {
		String INSERT_SINHVIEN_SQL = "INSERT INTO sinhvien(MaSV,Hodem,Ten,NgaySinh,GioiTinh,MaLop) VALUES(?,?,?,?,?,?)";

		// buoc1: thiet lapket noi
		try (Connection connection = getConnection();

				// buoc 2: tao cau truy van
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SINHVIEN_SQL)) {
			preparedStatement.setString(1, MaSV);
			preparedStatement.setString(2, Hodem);
			preparedStatement.setString(3, Ten);
			preparedStatement.setString(4, NgaySinh);
			preparedStatement.setString(5, GioiTinh);
			preparedStatement.setString(6, MaLop);

			System.out.println(preparedStatement);

			// buoc 3 : thuc thi cau try van
			int rowsInserted = preparedStatement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("them moi thanh cong !");
			} else {
				System.out.println("them moi khong thanh cong !");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
	public static void insertMONHOC(String MaMH, String TenMH, String SoTC, String Dieukien, String KyHoc
			) {
		String INSERT_SINHVIEN_SQL = "INSERT INTO monhoc(MaMH,TenMH,SoTC,Dieukien,KyHoc) VALUES(?,?,?,?,?)";

		// buoc1: thiet lapket noi
		try (Connection connection = getConnection();

				// buoc 2: tao cau truy van
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SINHVIEN_SQL)) {
			preparedStatement.setString(1, MaMH);
			preparedStatement.setString(2, TenMH);
			preparedStatement.setString(3, SoTC);
			preparedStatement.setString(4, Dieukien);
			preparedStatement.setString(5, KyHoc);
			

			System.out.println(preparedStatement);

			// buoc 3 : thuc thi cau try van
			int rowsInserted = preparedStatement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("them moi thanh cong !");
			} else {
				System.out.println("them moi khong thanh cong !");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	public static void insertKETQUA(String MaSV, String MaMH, String Diem
			) {
		String INSERT_KETQUA_SQL = "INSERT INTO ketqua(MaSV,MaMH,Diem) VALUES(?,?,?)";

		// buoc1: thiet lapket noi
		try (Connection connection = getConnection();

				// buoc 2: tao cau truy van
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_KETQUA_SQL)) {
			preparedStatement.setString(1, MaSV);
			preparedStatement.setString(2, MaMH);
			preparedStatement.setString(3,Diem);
			
			

			System.out.println(preparedStatement);

			// buoc 3 : thuc thi cau try van
			int rowsInserted = preparedStatement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("them moi thanh cong !");
			} else {
				System.out.println("them moi khong thanh cong !");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
	public static void selectAllKETQUA() {
		String SELECT_ALL_KETQUA_SQL = "SELECT * FROM ketqua";
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
			ResultSet rs = statement.executeQuery(SELECT_ALL_KETQUA_SQL);

			// Duyệt danh sach bản ghi trả về

			while (rs.next()) {

				String MaSV = rs.getString("MaSV");
				String MaMH = rs.getString("MaMH");
				String Diem = rs.getString("Diem");
				
				System.out.println(MaSV + "," + MaMH + "," + Diem );

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	

	// phuong thuc lay tat ca User trogn bang
	public static void selectAllSINHVIEN() {
		String SELECT_ALL_SINHVIEN_SQL = "SELECT * FROM sinhvien";
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
			ResultSet rs = statement.executeQuery(SELECT_ALL_SINHVIEN_SQL);

			// Duyệt danh sach bản ghi trả về

			while (rs.next()) {

				String MaSV = rs.getString("MaSV");
				String Hodem = rs.getString("Hodem");
				String Ten = rs.getString("Ten");
				String NgaySinh = rs.getString("NgaySinh");
				String GioiTinh = rs.getString("GioiTinh");
				String MaLop = rs.getString("MaLop");

				System.out.println(MaSV + "," + Hodem + "," + Ten + "," + NgaySinh + "," + GioiTinh + "," + MaLop);

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//ktra table ketqua
	public static void selectAllMONHOC() {
		String SELECT_ALL_MONHOC_SQL = "SELECT * FROM monhoc";
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
			ResultSet rs = statement.executeQuery(SELECT_ALL_MONHOC_SQL);

			// Duyệt danh sach bản ghi trả về

			while (rs.next()) {

				String MaMH = rs.getString("MaMH");
				String TenMH = rs.getString("TenMH");
				String SoTC = rs.getString("SoTC");
				String Dieukien = rs.getString("Dieukien");
				String KyHoc = rs.getString("KyHoc");

				System.out.println(MaMH + "," + TenMH + "," + SoTC + "," + Dieukien + "," + KyHoc );

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// phuong thuckiem tra su ton tai cua Lop
	public static void checkSINHVIEN(String MaSV, String Hodem, String Ten, String NgaySinh, String GioiTinh,
			String MaLop) {
		String SELECT_SINHVIEN_SQL = "SELECT *from sinhvien WHERE MaSV = ?,Hodem = ? ,Ten = ? ,NgaySinh = ? ,GioiTinh = ? and MaLop = ?";
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SINHVIEN_SQL)) {
			preparedStatement.setString(1, MaSV);
			preparedStatement.setString(2, Hodem);
			preparedStatement.setString(3, Ten);
			preparedStatement.setString(4, NgaySinh);
			preparedStatement.setString(5, GioiTinh);
			preparedStatement.setString(6, MaLop);

			System.out.println(preparedStatement);
			ResultSet resultSet = preparedStatement.executeQuery();

			boolean status = resultSet.next();
			if (status) {
				System.out.println("da ton tai!");
			} else {
				System.out.println("chua ton tai !");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	// phuong thuc doi ma sv
	public static void changeSINHVIEN(String MaSV, String newHodem, String newTen, String newNgaySinh,
			String newGioiTinh, String newMaLop) {
		String UPDATE_SINHVIEN_SQL = "UPDATE sinhvien SET  Hodem = ? ,Ten = ? ,NgaySinh = ? ,GioiTinh = ?,MaLop = ? WHERE MaSV=?";

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SINHVIEN_SQL)) {
			preparedStatement.setString(1, MaSV);
			preparedStatement.setString(2, newHodem);
			preparedStatement.setString(3, newTen);
			preparedStatement.setString(4, newNgaySinh);
			preparedStatement.setString(5, newGioiTinh);
			preparedStatement.setString(6, newMaLop);

			System.out.println(preparedStatement);
			int rowsUpdated = preparedStatement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("doi ma thanh cong!");
			} else {
				System.out.println("doi ma ko thanh cong!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	// phuong thuc xoa
	public static void deleteSINHVIEN(String MaSV) {
		String DELETE_SINHVIEN_SQL = "DELETE FROM sinhvien WHERE MaSV=?";
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SINHVIEN_SQL)) {
			preparedStatement.setString(1, MaSV);

			System.out.println(preparedStatement);
			int rowsDeleted = preparedStatement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("Xóa thành công!");
			} else {
				System.out.println("Xóa không thành công!");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	

	// phuong thuc lay SINH VIEN ,KET QUA 1.2
	public static void selectSINHVIEN_KETQUA() {
		String SELECT_SUBJECT_ALL_SQL = "SELECT *FROM sinhvien " + "INNER JOIN ketqua ON sinhvien.MaSV = ketqua.MaSV "
				+ "INNER JOIN monhoc ON monhoc.MaMH = ketqua.MaMH";
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
			ResultSet resultSet = statement.executeQuery(SELECT_SUBJECT_ALL_SQL);

			// Duyệt danh sach bản ghi trả về

			while (resultSet.next()) {

				String MaSV = resultSet.getString("MaSV");
				String Hodem = resultSet.getString("Hodem");
				String Ten = resultSet.getString("Ten");
				String NgaySinh = resultSet.getString("NgaySinh");
				String GioiTinh = resultSet.getString("GioiTinh");
				String MaMH = resultSet.getString("MaMH");
				String TenMH = resultSet.getString("TenMH");
				String Diem = resultSet.getString("Diem");
				String MaLop = resultSet.getString("MaLop");

				System.out.println(MaSV + "," + Hodem + "," + Ten + "," + NgaySinh + "," + GioiTinh + "," + MaMH + ","
						+ TenMH + "," + Diem + "," + MaLop);

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// 3
	public static void searchSV(String MaSV) {
		String SEARCH_SV = "SELECT * FROM sinhvien " + "INNER JOIN ketqua ON sinhvien.MaSV = ketqua.MaSV "
				+ "INNER JOIN monhoc ON ketqua.MaMH = monhoc.MaMH " + "WHERE MaSV = '" + MaSV + "'";
		try (Connection connection = getConnection(); Statement statement = connection.createStatement();) {
			ResultSet resultSet = statement.executeQuery(SEARCH_SV);
			while (resultSet.next()) {
				String ten = resultSet.getString("Ten");
				String maSV = resultSet.getString("MaSV");
				String lop = resultSet.getString("MaLop");
				String maMH = resultSet.getString("MaMH");
				String tenMH = resultSet.getString("TenMH");
				Float diem = resultSet.getFloat("Diem");
				System.out.println(
						maSV + " - " + ten + " - " + lop + "\n[ " + maMH + " - " + tenMH + " - " + diem + " ]");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	// 4
	public static void getAllStudent_Diem() {
		String GET_DIEM = "SELECT *FROM sinhvien " + "INNER JOIN ketqua ON sinhvien.MaSV = ketqua.MaSV "
				+ "INNER JOIN monqua ON monhoc.MaMH = ketqua.MaMH "
				+ "INNER JOIN monhoc_kyhoc ON monhoc.MaMH = monhoc_kyhoc.MaMH " + "WHERE ketqua.DIEM > 0";
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
			ResultSet resultSet = statement.executeQuery(GET_DIEM);
			while (resultSet.next()) {
				String ten = resultSet.getString("Ten");
				String maSV = resultSet.getString("MaSV");
				String lop = resultSet.getString("MaLop");
				String maMH = resultSet.getString("MaMH");
				String tenMH = resultSet.getString("TenMH");
				String maKyHoc = resultSet.getString("MaKyHoc");
				Float diem = resultSet.getFloat("Diem");
				System.out.println(maSV + " - " + ten + " - " + lop + "\nKỳ học: " + maKyHoc + " [ " + maMH + " - "
						+ tenMH + " - Điểm: " + diem + " ]\n----------------------------");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void getAllStudent() {
		String GETALL = "SELECT *FROM sinhvien " + "INNER JOIN ketqua ON sinhvien.MaSV = ketqua.MaSV "
				+ "INNER JOIN monhoc ON monhoc.MaMH = ketqua.MaMH "
				+ "INNER JOIN monhoc_kyhoc ON monhoc.MaMH = monhoc_kyhoc.MaMH ";

		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
			ResultSet resultSet = statement.executeQuery(GETALL);
			while (resultSet.next()) {
				String ten = resultSet.getString("Ten");
				String maSV = resultSet.getString("MaSV");
				String lop = resultSet.getString("MaLop");
				String maMH = resultSet.getString("MaMH");
				String tenMH = resultSet.getString("TenMH");
				String maKyHoc = resultSet.getString("MaKyHoc");
				System.out.println(maSV + " - " + ten + " - " + lop + "\nKỳ học: " + maKyHoc + " [ " + maMH + " - "
						+ tenMH + " ]\n----------------------------");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static List<Student> selectAllStudent() {
		List<Student> studentListList = null;
		Map<String, Student> studentMap = new HashMap<String, Student>();
		String SELECT_ALL_USERS_SQL = "SELECT * FROM sinhvien" + " INNER JOIN ketqua kq ON sv.MaSV = kq.MaSV"
				+ " INNER JOIN monhoc mh ON kq.MaMH = mh.MaMH";
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {

			ResultSet rs = statement.executeQuery(SELECT_ALL_USERS_SQL);

			// Duyệt danh sach bản ghi trả về
			while (rs.next()) {
				/*
				 * String username = rs.getString("MaSV"); String password =
				 * rs.getString("Hodem"); System.out.println(rs.getString("MaSV") + "," +
				 * rs.getString("TenMH") + " " + rs.getString("Diem"));
				 */
				Student student = new Student();
				student.setCode(rs.getString("MaSV"));
				student.setFullname(rs.getString("Hodem") + " " + rs.getString("Ten"));

				if (studentMap.containsKey(rs.getString("MaSV"))) { // Neu đa có sv đó rồi thì cập nhật ds môn học của
																	// sv đó
					Subject sub = new Subject(rs.getString("MaMH"), rs.getString("TenMH"), rs.getInt("soTc"));
					student.addSubject(rs.getString("KyHoc"), (CreditRule) sub);
				} else { // nếu chưa có thì thêm sv vào map
					studentMap.put(rs.getString("MaSV"), student);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		studentListList = (List<Student>) studentMap.values(); // Chuyển từ Map về List

		return studentListList;
	}

	/*
	 * public List<Student> getAllStudent() { Map<String, Student> mapStudent=new
	 * HashMap<String, Student>(); PreparedStatement statement = null; ResultSet rs
	 * = null; try { conn = DBConnection.create(jdbcURL, jdbcUsername,
	 * jdbcPassword); String query =
	 * "Select * from SINHVIEN Inner Join KETQUA ON KETQUA.MaSV=SINHVIEN.MaSV INNER JOIN MONHOC_KYHOC ON MONHOC_KYHOC.MaMH=KETQUA.MaMH Inner Join MONHOC ON KETQUA.MaMH=MONHOC.MaMH"
	 * ; statement = conn.prepareStatement(query); rs = statement.executeQuery(); //
	 * Duyệt qua danh sách các bản thi nhận được trong đối tượng ResultSet Student
	 * student=new Student(); while (rs.next()) { String code =
	 * rs.getString("MaSV");
	 * 
	 * String fullname = rs.getString("HoTen"); String class_ = rs.getString("Lop");
	 * String address = rs.getString("DiaChi"); if(!code.equals(student.getCode()))
	 * { student=new Student(); student.setCode(code); student.setAddress(address);
	 * student.setFullname(fullname); student.setClass_(class_); }
	 * 
	 * String subjectCode = rs.getString("MaMH"); String subjectName =
	 * rs.getString("TenMH"); int credit = rs.getInt("SoTC"); float point =
	 * rs.getFloat("Diem");
	 * 
	 * Subject subject=new Subject(subjectCode, subjectName, credit);
	 * subject.setAttendanceMark(point);
	 * 
	 * String semester=rs.getString("KyHoc"); student.addSubject(semester, subject);
	 * mapStudent.put(code, student); } } catch (SQLException e) {
	 * System.out.println("Loi getStudentAndSubject: " + e.getLocalizedMessage()); }
	 * finally { DBConnection.closeResultSet(rs);
	 * DBConnection.closeStatement(statement); DBConnection.closeConnect(conn); }
	 * List<Student> list=new ArrayList<Student>(mapStudent.values()); return list;
	 * }
	 */
	public DatabaseCrudOperation() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		// Thêm mới 2 User
		//DatabaseCrudOperation databaseCrudOperation=new DatabaseCrudOperation();
	//	databaseCrudOperation.insertSINHVIEN("SV008", "Tran anh","Hai","2023-12-12","Nam","DoDC");
		// databaseCrudOperation.changeSINHVIEN( "Tran
		// anh","Quan","2024-11-11","Nam","DJDC","SV009");
		// databaseCrudOperation.deleteSINHVIEN("SV010");

		/*
		  insertSINHVIEN("SV008",
		 * "Tran anh", "Hai","2023-12-12","Nam","DoDC"); // In danh sách User
		 * selectAllSINHVIEN(); // Kiểm tra sự tồn tại của User checkSINHVIEN("SV008",
		 * "Tran anh", "Hai","2023-12-12","Nam","DoDC"); // Đổi mật khẩu của User
		 * "admin" changeSINHVIEN("Tran anh","Quan","2024-11-11","Nam","DJDC","SV009");
		 * // Xóa User "pvduc" deleteSINHVIEN("SV010"); // In lại danh sách User để kiểm
		 * tra selectAllSINHVIEN();
		 */
		// addKETQUA("sv022", "mn01", "9");

		// getAllStudent_Diem();
		//selectSINHVIEN_KETQUA();
		// selectAllStudent();
//		addKETQUA(jdbcUsername, jdbcURL, jdbcPassword)
		//selectAllSINHVIEN();
		//insertMONHOC("1234"," 123"," 2", "qua"," 2");
		//selectAllMONHOC();
		//insertKETQUA("SV008", "1234", "8");
		selectAllKETQUA();
	}

	public static void selectStudent(String string) {
		// TODO Auto-generated method stub
		
	}


}