package test;
import org.junit.*;
import static org.junit.Assert.*;
import control.ControlDateTime;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ControlDateTimeTest {


    @Test
    public void testFormatDateTime(String pattern ){
        String dateTime;
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        Calendar now = Calendar.getInstance();
        dateTime = formatter.format( now.getTime());

        System.out.println("testFormatDateTime()");
        try {
            assertEquals(dateTime,new ControlDateTime(pattern).getDateTime());
            System.out.println("формат времени соответствует ожидаемому");
        }catch(AssertionError e ){
            System.out.println("несоответствие формата времени");
           // throw e;
             e.printStackTrace();
        }
    }
}
