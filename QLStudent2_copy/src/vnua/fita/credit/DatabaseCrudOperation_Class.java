package vnua.fita.credit;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseCrudOperation_Class {

	private static String jdbcURL ="jdbc:ucanaccess://lib/Database1.accdb";
	private static String jdbcUsername = "";
	private static String jdbcPassword = "";
	
	
	// phuong thuc tra ve ket noi
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(jdbcURL,jdbcPassword,jdbcUsername);
			
		} catch (Exception e) {
			System.out.println("Loi ket noi access: "+ e.getLocalizedMessage());
			e.printStackTrace();
		}
		return connection;
	}
	
	//them phuong thuc moi Lop
	public static void insertUser(String MaLop, String TenLop,String MaKhoa  ) {
		String INSERT_Lop_SQL = "INSERT INTO LOP(MaLop,TenLop,MaKhoa) VALUES(?,?,?)";
		
		//buoc1: thiet lapket noi
		try(Connection connection = getConnection() ;
		
				//buoc 2: tao cau truy van
		PreparedStatement preparedStatement  = connection.prepareStatement(INSERT_Lop_SQL))
		{
			preparedStatement.setString(1, MaLop);
			preparedStatement.setString(2, TenLop);
			preparedStatement.setString(3, MaKhoa);
			
			System.out.println(preparedStatement);
			
			//buoc 3 : thuc thi cau try van
			int rowsInserted =  preparedStatement.executeUpdate();
			if(rowsInserted > 0) {
				System.out.println("them moi thanh cong !");
			}else {
				System.out.println("them moi khong thanh cong !");
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	// phuong thuc lay tat ca User trogn bang
	public static void selectAllUser() {
		String SELECT_ALL_Lop_SQL ="SELECT * FROM lOP";
		try (
			
			Connection connection = getConnection();
			Statement statement = connection.createStatement())
			{
			ResultSet rs = statement.executeQuery(SELECT_ALL_Lop_SQL);

			// Duyệt danh sach bản ghi trả về

			while (rs.next()) {

			String MaLop = rs.getString("MaLop");

			String TenLop = rs.getString("TenLop");
			
			String MaKhoa = rs.getString("MaKhoa");

			System.out.println(TenLop + "," + MaLop +","+ MaKhoa);
				
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	// phuong thuckiem tra su ton tai cua Lop
	public static void checkLop(String MaKhoa,String MaLop,String TenLop) {
		String SELECT_Lop_SQL = "SELECT *from Lop WHERE MaLop = ?,TenLop = ? and MaKhoa = ?";
		try(
				Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_Lop_SQL)){
				preparedStatement.setString(1, MaLop);
				preparedStatement.setString(2, 	TenLop);
				preparedStatement.setString(3, MaKhoa);
				
				System.out.println(preparedStatement);
				ResultSet resultSet = preparedStatement.executeQuery();
				
				boolean status = resultSet.next();
				if(status) {
					System.out.println("da ton tai!");
				}else {
					System.out.println("chua ton tai !");
				}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	
	public DatabaseCrudOperation_Class() {
		// TODO Auto-generated constructor stub
	}

	


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Thêm mới 2 User
		DatabaseCrudOperation_Class databaseCrudOperation_Class=new DatabaseCrudOperation_Class();
		databaseCrudOperation_Class.insertUser("19345", "tsst", "HTTK");
	}
	
}
