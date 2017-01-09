import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by HP on 1/9/2017.
 */
public class Tanggalizer {
    public String getWaktu(){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public String getTanggal(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date tanggal = new Date();
        return dateFormat.format(tanggal);
    }
}
