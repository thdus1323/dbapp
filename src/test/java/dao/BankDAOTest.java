package dao;

import model.Account;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BankDAOTest {
    @Test
    public void selectAll_test(){
        //given ~없어도 됨. 기본이니까?

        //when 은 무조건 있어야 함.
        BankDAO dao = new BankDAO();
        List<Account> accountList = dao.selectAll();

        System.out.println(accountList.size());
        System.out.println(accountList);
    }
    @Test
    public void selectByNumber_test(){
        //given
        int number = 7;
        //when
        BankDAO dao = new BankDAO();
        Account account = dao.selectByNumber(number);
        //then
        if(account == null){
            System.out.println(number+"로 조회된 값이 없습니다");
        }else{
            System.out.println(account);
//            System.out.println(account.getNumber());
//            System.out.println(account.getPassword());
//            System.out.println(account.getBalance());
//            System.out.println(account.getCreatedAt());

        }
    }

    @Test
    public void deleteByNumber_test() {
        //given
        int number = 5;

        //when
        BankDAO dao = new BankDAO();
        int result = dao.deleteByNumber(number);

        //then
        if (result == 1) {
            System.out.println("삭제 성공");
        } else if (result == 0) {
            System.out.println(number + "번호를 찾을 수 없습니다");
        } else {
            System.out.println("삭제 실패");
        }
    }


    @Test
    public void insert_test() {
        //given
        String password = "1237";
        int balance = 8000;

        //when
        BankDAO dao = new BankDAO();
        int result = dao.insert(password, balance);

        //then
        if (result == 1) {
            System.out.println("삽입 성공");
        } else if (result == 0) {
            System.out.println(password + balance + "데이터를 찾을 수 없습니다.");
        } else {
            System.out.println("데이터양식이 바르지 않습니다.");
        }
    }

    @Test
    public void updateByNumber(){
        //given
        int balance = 1004;
        int number =6;
        //when
        BankDAO dao = new BankDAO();
        int result = dao.updateByNumber(balance,number);
        //then
        if (result == 1) {
            System.out.println("수정 성공");
        } else if (result == 0) {
            System.out.println(balance + number+ "데이터를 찾을 수 없습니다.");
        } else {
            System.out.println("데이터양식이 바르지 않습니다.");
        }
    }

}

