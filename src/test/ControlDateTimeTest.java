package test;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Test;
import control.ControlDateTime;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ControlDateTimeTest {


    @Test
    public void testSomeBehavior() {
        String dateTime;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd hh mm ss a");
        Calendar now = Calendar.getInstance();
        dateTime = formatter.format( now.getTime());

      //  assertEquals("несоответствие формата времени",dateTime,new ControlDateTime().getDateTime());
    }
}
