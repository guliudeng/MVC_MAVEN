import cn.cry.utils.TenantCodeUtils;
import org.junit.Test;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

public class TestDemo {
    @Test
    public void test01(){
        String aa = "20220312";
        String substring = aa.substring(0, 6);
        System.out.println(substring);
        String substring1 = aa.substring(0, 8);
        System.out.println(substring1);
    }
    @Test
    public void test02(){
        String aa = "谷killer";
        String pinYin = TenantCodeUtils.getHanziPinYin(aa);
        System.out.println(pinYin);
        String initials = TenantCodeUtils.getHanziInitials(aa);
        System.out.println(initials);
    }
    @Test
    public void test03(){
        /**
         * isEmpty 被hasText替换
         * ObjectUtils.isEmpty 不能判断空格的string，会将其判断3为true
         */
        String aa = "";
        System.out.println(StringUtils.hasText(aa));
        String bb = null;
        System.out.println(StringUtils.hasText(bb));
        String cc = " d";
        System.out.println(StringUtils.hasText(cc));

        System.out.println(ObjectUtils.isEmpty(aa));
        System.out.println(ObjectUtils.isEmpty(bb));
        System.out.println(ObjectUtils.isEmpty(cc));

    }
    @Test
    public void test04(){
/**
 * String regPattern = "test_???.txt";
 * String fileName = "test_123.txt";
 * PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:" + regPattern);
 * Path path = Paths.get(fileName);
 * System.out.println(pathMatcher.matches(path) ? "匹配正确" : "匹配错误");
 */
       /* String aa = "/sdf/dfasd/问明天.txt";
        System.out.println(aa.substring(aa.lastIndexOf("/")+1));*/

        String regPattern = "test_???.txt";
        String fileName = "test_hhh.txt";
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:" + regPattern);
        Path path = Paths.get(fileName);
        System.out.println(pathMatcher.matches(path) ? "匹配正确" : "匹配错误");
    }
    /**
     * 日志字段设计
     * id；日志主键id
     * sessionId：sessionid
     * userName:用户名
     * createTime:创建时间
     * type:类型/操作
     * status:状态
     * cluster:集群id
     * message：日志信息
     * ruleId:规则id
     * interface：接口
     * parm:参数
     */
}
