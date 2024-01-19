import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankApp {
    public static void main(String[] args) {
        Connection conn = DBConnection.getInstance();
        try {
            String insert = "insert into account_tb(password, balance, created_at) values(?, ?, now())";
            String delete = "delete from account_tb where number = ?";
            String update = "update account_tb set balance = balance + ? where number = ?";

            PreparedStatement pstmt = conn.prepareStatement(insert);
            pstmt.setString(1,"ssar");
            pstmt.setInt(2,12345);
//            pstmt.setInt(2,4);

            int num = pstmt.executeUpdate();
            System.out.println(num);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}









