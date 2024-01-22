package dao;
//DAO-Data Access Object
//srp - 단일책임의 원칙

import db.DBConnection;
import model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BankDAO {
    public int deleteByNumber(int number){
        Connection conn = DBConnection.getInstance();
        try {
            String sql = "delete from account_tb where number = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1,number);

            int num = pstmt.executeUpdate();
            return num;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int insert(String password, int balance){
        Connection conn = DBConnection.getInstance();
        try {//쿼리라서 소문자로 씀. 카멜 말고
            String sql = "insert into account_tb(password,balance,created_at) values(?,?, now())";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,password);
            pstmt.setInt(2,balance);
//
            int num = pstmt.executeUpdate();
            return num;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int updateByNumber(int balance, int number){
        Connection conn = DBConnection.getInstance();
        try {//쿼리라서 소문자로 씀. 카멜 말고
            String sql = "update account_tb set balance = ? where number = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,balance);
            pstmt.setInt(2,number);
            int num = pstmt.executeUpdate();
            return num;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }


    public Account selectByNumber(int number){
        Connection conn = DBConnection.getInstance(); // 꼭 있기
        try {
            String sql = "select * from account_tb where number = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,number);

            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){
                Account account = new Account(
                        rs.getInt("number"),
                        rs.getString("password"),
                        rs.getInt("balance"),
                        rs.getTimestamp("created_at")
                );
                return account;
            }


        }catch (Exception e){
            e.printStackTrace();
        } return null;
    }

    public List<Account> selectAll(){

        Connection conn = DBConnection.getInstance(); // 꼭 있기
        //java >> db bytestream 생김
        try {
            String sql = "select * from account_tb order by number desc";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            //쿼리sql을 버퍼에 담음(""꺼)

            ResultSet rs = pstmt.executeQuery();
            //sql flush(exe)하고 db가 응답해줌. / 그래서 br에 table이 옴.

            List<Account> accountList = new ArrayList<>(); // 스택 이야기 account 없어진다고?
            while(rs.next()){
                Account account = new Account(
                        rs.getInt("number"),
                        rs.getString("password"),
                        rs.getInt("balance"),
                        rs.getTimestamp("created_at")
                );
              accountList.add(account);
            }
            return accountList;


        }catch (Exception e){
            e.printStackTrace();
        } return null;
    }

}
