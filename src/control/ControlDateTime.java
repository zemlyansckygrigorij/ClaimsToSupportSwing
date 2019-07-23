package control;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ControlDateTime {
    private String dateTime;
    public ControlDateTime(String pattern){
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        Calendar now = Calendar.getInstance();
        dateTime = formatter.format( now.getTime());
    }
    public  String getDateTime(){
        return dateTime;
    }
}
