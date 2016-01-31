package hotel.worldsvisa.com.homotel;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
RelativeLayout rl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        rl=(RelativeLayout)findViewById(R.id.rel);
        rl.setBackgroundColor(Color.CYAN);
        TextView tv= (TextView)findViewById(R.id.textView);
        tv.setText("HOMOTEL");
        tv.setGravity(Gravity.CENTER_VERTICAL);

        //tv.setVisibility(View.VISIBLE);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP,34);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this,CustomerRegestration.class);
                startActivity(i);
                finish();
            }
        },3000);

    }


}
