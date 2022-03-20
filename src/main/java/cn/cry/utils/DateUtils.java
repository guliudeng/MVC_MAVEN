package cn.cry.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 */
public class DateUtils {
    private static final String stf = "yyyy-MM-dd HH:mm:ss";

    /**
     * 格式化当前时间
     * @return
     */
    public String timeForm(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(stf);
        return  simpleDateFormat.format(new Date());
    }
}
