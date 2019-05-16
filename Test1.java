试试看
package day0101;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Connection conn =null;
		PreparedStatement  ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql:///:jt_db", "root", "tarena");
			String sql="select from accout where name=?";
			ps= conn.prepareStatement(sql);
			ps.setString(1, "������");
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name =rs.getString("name");
				double money = rs.getDouble("money");
				System.out.println(id+":"+name+":"+money);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("����ʧ��!");
		}finally {
			if(rs !=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					rs =null;
				}
			}
			if(ps !=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					ps = null;
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					conn = null;
				}
			}
			
		}
	}
}
