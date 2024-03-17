package vnua.fita.credit;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseCrudOperation_User {
	

	public class DatabaseCrudExample {
	    private static String jdbcURL = "jdbc:mysql://localhost:3306/training";
	    private static String jdbcUsername = "root";
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
	    
	    // Phương thức thêm mới User
		public static void insertUser(String username, String password) {
			String INSERT_USERS_SQL = "INSERT INTO tbluser (username, password) VALUES (?, ?)";
	        // Bước 1: Thiết lập kết nối
	        try (Connection connection = getConnection();
	            // Bước 2: Tạo câu truy vấn
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
	            
	        	preparedStatement.setString(1, username);
	            preparedStatement.setString(2, password);

	            System.out.println(preparedStatement);
	            // Bước 3: Thực thi câu truy vấn
	            int rowsInserted = preparedStatement.executeUpdate();
	            if (rowsInserted > 0) {
	                System.out.println("Thêm mới thành công!");
	            }else {
	            	System.out.println("Thêm mới không thành công!");
	            }
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        }
		}
		
		// Phương thức lấy tất cả User trong bảng
		public static void selectAllUsers() {
			String SELECT_ALL_USERS_SQL = "SELECT * FROM tbluser";
	        try (Connection connection = getConnection();
	            Statement statement = connection.createStatement()) {

	            ResultSet rs = statement.executeQuery(SELECT_ALL_USERS_SQL);

	            // Duyệt danh sach bản ghi trả về
	            while (rs.next()) {
	                String username = rs.getString("username");
	                String password = rs.getString("password");
	                System.out.println(username + "," + password);
	            }
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        }
		}
		
		// Phương thức kiểm tra sự tồn tại của một User
		public static void checkUser(String username, String password){
			String SELECT_USERS_SQL = "SELECT * from tbluser WHERE username = ? and password = ?";
			
	    	try (
	    		Connection connection = getConnection();
	    		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS_SQL))  {
	        	preparedStatement.setString(1, username);
	        	preparedStatement.setString(2, password);

	        	System.out.println(preparedStatement);
	        	ResultSet resultSet = preparedStatement.executeQuery();
	        
	        	boolean status = resultSet.next();
	        	// status = true: có tồn tại username, password trả về
	        	if(status) {
	        		System.out.println("Tài khoản tồn tại!");
	        	}else {
	        		System.out.println("Tài khoản không tồn tại!");
			}
	    	} catch (SQLException e) {
	        	e.printStackTrace();
	    	}
		}
		
		// Phương thức đổi mật khẩu
		public static void changePassword(String username, String newPassword) {
		   String UPDATE_USERS_SQL = "UPDATE tbluser SET password = ? WHERE username = ?";
	        try (Connection connection = getConnection();

	            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL)) {
	            preparedStatement.setString(1, newPassword);
	            preparedStatement.setString(2, username);

	            System.out.println(preparedStatement);
	            int rowsUpdated = preparedStatement.executeUpdate();
	            if (rowsUpdated > 0) {
	                System.out.println("Đổi mật khẩu thành công!");
	            }else {
	            	System.out.println("Đổi mật khẩu không thành công!");
	            }
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        }
		}
		
		// Phương thức xóa User
		public static void deleteUser(String username) {
		   String DELETE_USERS_SQL = "DELETE FROM tbluser WHERE username = ?";
	        try (Connection connection = getConnection();
	            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL)) {
	            preparedStatement.setString(1, username);

	            System.out.println(preparedStatement);
	            int rowsDeleted = preparedStatement.executeUpdate();
	            if (rowsDeleted > 0) {
	                System.out.println("Xóa thành công!");
	            }else {
	            	System.out.println("Xóa không thành công!");
	            }
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        }
		}
		
		// Chạy chương trình
		public static void main(String[] args) throws ClassNotFoundException{
			// Thêm mới 2 User
			insertUser("admin", "123");
			insertUser("pvduc", "65xyz");
			// In danh sách User
			selectAllUsers();
			// Kiểm tra sự tồn tại của User
			checkUser("pvduc", "65xyz");
			// Đổi mật khẩu của User "admin"
			changePassword("admin", "123@abc");
			// Xóa User "pvduc"
			deleteUser("pvduc");
			// In lại danh sách User để kiểm tra
			selectAllUsers();
		}
	}


	
	
	public DatabaseCrudOperation_User() {
		// TODO Auto-generated constructor stub
	}

}
