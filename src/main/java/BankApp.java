import controller.BankController;
import controller.RequestMapping;
import dao.BankDAO;
import model.Account;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Scanner;
//라우터, 컨트롤러 개념 잡는 게 중요.
public class BankApp {
    public static void main(String[] args) {
//       String url = "selectAll";
//
//       //dependecy injection?
//        BankDAO dao = new BankDAO();
//        BankController con = new BankController(dao);
//
//        //한 번 만들고 의존하면 됨. 매번 new don't need
//        Dispatcher dis = new Dispatcher(con);
//        dis.route(url);
        String path = "/selectAll";

        BankDAO dao = new BankDAO();
        BankController con = new BankController(dao);

        //UserController의 클래스를 들고와서 거기 안에 있는 메서드 다 들고와
        Method[] methods = con.getClass().getDeclaredMethods();
//        System.out.println(methods.length);
//
        for (Method method : methods) {
            RequestMapping rm = method.getDeclaredAnnotation(RequestMapping.class);

            if (rm == null) continue;

            if (rm.uri().equals(path)) {
                try {
                    method.invoke(con); // =con.login()이랑 같은 코드임
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }



    }
}