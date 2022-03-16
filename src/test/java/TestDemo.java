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
}
