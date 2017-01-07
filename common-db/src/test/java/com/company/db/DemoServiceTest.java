package com.company.db;


import com.company.db.service.DemoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wangzhj
 */
public class DemoServiceTest extends JUnitBaseTest {

    @Autowired
    private DemoService demoService;

    @Test
    public void test_add() {
        String name = "我是写写库";
        demoService.add(name);
    }

    @Test
    public void test_get() {
        demoService.get(1L);
    }

    @Test
    public void test_find() {
        demoService.find(1L);
    }

    @Test
    public void test_findLt() {

//        for(int i = 0; i < 2; i++){
            demoService.findLt(1L, false);
//        }
    }


    @Test
    public void test(){
        int type = 5;
        System.out.println(type != 6 && type != 7 && type != 8);
    }
}
