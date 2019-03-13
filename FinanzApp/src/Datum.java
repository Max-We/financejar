import java.text.SimpleDateFormat;
import java.util.Date;

public class Datum {

	public String dateValue() {
		Date date = java.util.Calendar.getInstance().getTime();
        SimpleDateFormat dateFormatter = 
                  new SimpleDateFormat("dd.MM.yyyy");
        String dateString = dateFormatter.format(date);

        return(dateString);
        
	}

}
