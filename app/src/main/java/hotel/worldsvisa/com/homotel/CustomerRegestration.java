package hotel.worldsvisa.com.homotel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by PROPHET on 31-01-2016.
 */
public class CustomerRegestration extends AppCompatActivity {
    static String a;
    EditText e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);setContentView(R.layout.customer_regitration);
        e=(EditText)findViewById(R.id.editText);
        setTheme(R.style.FormTheme);
    }

    @Override
    public void onBackPressed() {
        a=e.getText().toString();
        e.clearComposingText();
        Toast.makeText(this,a,Toast.LENGTH_SHORT).show();
        super.onBackPressed();



    }


}
