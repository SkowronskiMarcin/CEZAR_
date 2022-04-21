package TEST;
import com.company.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class Main_TEST {

    @Test
    public void checkRange_false(){
        //given
        String a = "3A";
        //when
        boolean result = Main.checkRange(a);
        //then
        Assertions.assertEquals(false,result);
    }

    @Test
    public void checkRange_true(){
        //given
        String a = "21";
        //when
        boolean result = Main.checkRange(a);
        //then
        Assertions.assertEquals(true,result);
    }

    @Test
    public void encryptmessageTEST(){
        //given
        String a = "A B C Testujemy metode 841";
        String b = "2";
        //when
        String result = Main.encryptmessage(a,Main.getRange(b));
        //then
        Assertions.assertEquals("C D E Vguvwlgoa ogvqfg 841",result);
    }

    @Test
    public void normalizemessageTEST(){
        //given
        String a = "ą Ą ć Ć ę Ę ś Ś ż ź Ź Ż ó Ó ń Ń ł Ł";
        //when
        String result = Main.normalizemessage(a);
        //then
        Assertions.assertEquals("a A c C e E s S z z Z Z o O n N l L",result);
    }

}
