//import controller.BankController;
//import lombok.AllArgsConstructor;
//
//import java.lang.reflect.Method;
//
///*
//책임 : 라우팅
// */
//@AllArgsConstructor
//public class Dispatcher {
//
//    private BankController con;
//
////@RequestRapping?/ 기반 코드가 어디있죠...
//    public void route(String url){
//        Method[] methods = con.getClass().getDeclaredMethods();
//        for(Method method : methods){
//            RequestMapping rm = method.getDeclaredAnnotation(RequestMapping.class);
//
//            if(rm == null) continue;
//
//            if(rm.uri().equals(path)){
//
//            }
//        }
//        public void insert(){
//            System.out.println("삽입 호출됨");
//        }
//
//        public void delete(){
//            System.out.println("삽입 호출됨");
//        }
//
//        public void update(){
//            System.out.println("삽입 호출됨");
//        }
//
//        public void selectOne(){
//            System.out.println("삽입 호출됨");
//        }
//
//
//
////        // 라우터, 디스패쳐
////        if(url.equals("insert")){
////            con.insert();
////        }else if(url.equals("delete")){
////            con.delete();
////        }else if(url.equals("update")){
////            con.update();
////        }else if(url.equals("selectOne")){
////            con.selectOne();
////        }else if(url.equals("selectAll")){
////            con.selectAll();
////        }
//    }
//}