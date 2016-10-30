import com.company.validation.xml.ParamSet;
import com.company.validation.xml.ParamSetFactory;
import org.junit.Test;

/**
 * Created by wangzhj on 2016/10/30.
 */
public class MyTest {

    @Test
    public void test(){

        ParamSetFactory.load();
        ParamSet set = new ParamSetFactory().getParamSet("/login");
        System.out.println(set.getParamLt());
    }
}
