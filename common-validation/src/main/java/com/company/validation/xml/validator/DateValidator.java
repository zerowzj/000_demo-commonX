package com.company.validation.xml.validator;

import com.company.exception.param.FormatErrorException;
import com.company.exception.param.ValueIllegalException;
import com.company.validation.xml.Param;
import com.company.validation.xml.rule.DateRule;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期规则验证器
 *
 * @author wangzhj
 */
public class DateValidator implements Validator {

    private static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Override
    public boolean support(Class<?> clazz) {
        return String.class.isAssignableFrom(clazz) || Date.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Param param, Object value) {
        String paramName = param.getParamName();
        DateRule rule = (DateRule) param.getRule();

        StringBuffer detail = new StringBuffer("[" + paramName + "]");

        //
        String format = rule.getFormat();
        if (format == null) {
            format = DEFAULT_FORMAT;
        }
        DateTimeFormatter dtFormat = DateTimeFormat.forPattern(format);
     /*   if(dtFormat){
            throw new FormatErrorException(paramName, value);
        }*/
        //最小日期
        DateTime date = new DateTime(value);
        String minDate = rule.getMinDate();
        if (minDate != null && date.isBefore(new DateTime(minDate))) {
            detail.append("");
            throw new ValueIllegalException(detail.toString(), paramName, value);
        }
        //最大日期
        String maxDate = rule.getMaxDate();
        if (maxDate != null && date.isAfter(new DateTime(minDate))) {
            detail.append("");
            throw new ValueIllegalException(detail.toString(), paramName, value);
        }
    }

    private boolean isFormat(String format, String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        boolean f = true;
        try {
            sdf.parse(dateStr);
        } catch (Exception ex) {
            f = false;
        }
        return f;
    }

    public static void main(String[] args) {
        String dateString = "2009-04-17";
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyy");
        System.out.println(formatter.isParser());
        System.out.println(formatter.isPrinter());


    }
}
