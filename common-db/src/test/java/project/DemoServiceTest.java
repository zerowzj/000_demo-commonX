package project;


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
        String name = "王振军";
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
}
