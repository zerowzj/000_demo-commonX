import com.company.validation.ValidateUtils;
import com.company.validation.xml.ParamSet;
import com.company.validation.xml.ParamSetFactory;
import com.company.validation.xml.validator.Validator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangzhj on 2016/10/30.
 */
public class MyTest {

    @Test
    public void test(){

        ParamSet paramSet = new ParamSetFactory().getParamSet("/login");

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("isbind", new ArrayList<>());

        ValidateUtils.validate(paramMap, paramSet);
    }
}
