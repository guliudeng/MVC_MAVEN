import cn.cry.utils.TenantCodeUtils;
import org.junit.Test;

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

}
