package controller;

import dao.BankDAO;
import lombok.AllArgsConstructor;

/*
책임 : 유효성검사(바디데이터), 파싱(바디데이터), 적절한 DAO 찾기
책임을 한 개 가지라기 보다 최대한 작게 하라고?
 */
@AllArgsConstructor
public class BankController {
    private BankDAO dao;

    @RequestMapping(uri="/insert")
    public void insert(){
        //1. 파싱

        //2. 유효성검사(front, backend모두 다 막아)

        //3. dao 찾기
        System.out.println("controller : insert");
        dao.insert("1234",1000);
    }

    @RequestMapping(uri="/delete")
    public void delete(){
        System.out.println("controller : delete");
        dao.deleteByNumber(1);
    }

    @RequestMapping(uri="/update")
    public void update(){
        System.out.println("controller : update");
        dao.updateByNumber(1000,1);
    }

    @RequestMapping(uri="/selectOne")
    public void selectOne(){
        System.out.println("controller : selectOne");
        dao.selectByNumber(1);
    }

    @RequestMapping(uri="/selectAll")
    public void selectAll(){
        System.out.println("controller : selectAll");
        dao.selectAll();
    }
}
