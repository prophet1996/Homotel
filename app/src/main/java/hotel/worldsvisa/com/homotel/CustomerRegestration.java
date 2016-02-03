package hotel.worldsvisa.com.homotel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by PROPHET on 31-01-2016.
 */
public class CustomerRegestration extends AppCompatActivity {
    /******************
     * Data Sets Used *
     ******************/
    Spinner spin_month, spin_ampm, spin_min, spin_date, spin_person, spin_hour;
    EditText name, email;
    String emaila, namea, timea, datea, persona;
    public static String[] hour = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12 "};
    public static String[] month = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
    public static String[] ampm = {"PM", "AM"};
    public static String[] person = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
    public static String[] minutes = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"};
    public static String[] date = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};


    /*******************/
    MySQLiteHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_regitration);
        db = new MySQLiteHelper(getApplicationContext());

// spinner declarations
        spin_month = (Spinner) findViewById(R.id.month);
        spin_ampm = (Spinner) findViewById(R.id.ampm);
        spin_hour = (Spinner) findViewById(R.id.hour);
        spin_min = (Spinner) findViewById(R.id.minutes);
        spin_date = (Spinner) findViewById(R.id.date);
        spin_person = (Spinner) findViewById(R.id.person);

// spinner adapters
        ArrayAdapter<String> month_adp = new ArrayAdapter<String>(CustomerRegestration.this, android.R.layout.simple_spinner_item, month);
        ArrayAdapter<String> ampm_adp = new ArrayAdapter<String>(CustomerRegestration.this, android.R.layout.simple_spinner_item, ampm);
        ArrayAdapter<String> hour_adp = new ArrayAdapter<String>(CustomerRegestration.this, android.R.layout.simple_spinner_item, hour);
        ArrayAdapter<String> min_adp = new ArrayAdapter<String>(CustomerRegestration.this, android.R.layout.simple_spinner_item, minutes);
        ArrayAdapter<String> date_adp = new ArrayAdapter<String>(CustomerRegestration.this, android.R.layout.simple_spinner_item, date);
        ArrayAdapter<String> person_adp = new ArrayAdapter<String>(CustomerRegestration.this, android.R.layout.simple_spinner_item, person);


        month_adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ampm_adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hour_adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        min_adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        date_adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        person_adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spin_month.setAdapter(month_adp);
        spin_ampm.setAdapter(ampm_adp);
        spin_hour.setAdapter(hour_adp);
        spin_min.setAdapter(min_adp);
        spin_date.setAdapter(date_adp);
        spin_person.setAdapter(person_adp);


        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);


    }


    private String setTheString(final Spinner spinner) {
        final Object[] abc = new Object[1];

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String get = spinner.getItemAtPosition(position).toString();
                abc[0] = get;
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return abc.toString();
    }

    public void submit(View view) {
        table table = new table();
        setDateEntries();
        table.db_name = namea;
        table.db_time = timea;
        table.db_email = emaila;
        table.db_date = datea;
        table.db_nop = persona;
        db.addtable(table);
        Intent i = new Intent(CustomerRegestration.this, Sucess.class);
        startActivity(i);


    }

    private void setDateEntries() {
        emaila = email.getText().toString();
        namea = name.getText().toString();
        timea = setTheString(spin_hour) + ":" + setTheString(spin_min) + " " + setTheString(spin_ampm);
        datea = setTheString(spin_date) + " " + setTheString(spin_month);
        persona = setTheString(spin_person);
    }

}
