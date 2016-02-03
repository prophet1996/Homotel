package hotel.worldsvisa.com.homotel;

import java.io.Serializable;

/**
 * Created by PROPHET on 01-02-2016.
 */
public class table implements Serializable {

    public String db_name, db_nop, db_email, db_time, db_date;
    public int id;

    public table() {
    }

    public table(int id, String db_name, String db_email, String db_nop, String db_date, String db_time) {
        this.id = id;
        this.db_email = db_email;
        this.db_name = db_name;
        this.db_nop = db_nop;
        this.db_time = db_time;
        this.db_date = db_date;
        this.id = id;
    }


}
