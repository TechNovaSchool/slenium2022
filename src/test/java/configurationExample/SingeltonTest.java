package configurationExample;

import org.testng.annotations.Test;

public class SingeltonTest {

    @Test
    public void test(){
        String str1 = Singelton.getExample();
        System.out.println(str1);
        String str2 = Singelton.getExample();
        System.out.println(str2);

//        Singelton str = new Singelton();

    }
}
