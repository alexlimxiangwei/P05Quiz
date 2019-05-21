package sg.edu.rp.c346.p05_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class ResultActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tv = findViewById(R.id.textView);

        Intent receivedIntent = getIntent();
        int type = receivedIntent.getIntExtra("type",0);
        int pax = receivedIntent.getIntExtra("pax",0);
        double cost = 100 * pax;
        String text = "You have selected ";
        if (type == 1){
            text += "One-Way Trip";

        }
        else{
            text += "Round Trip";
            cost = cost * 2;
        }

        text += ".\n Your air ticket costs $" + cost;

        tv.setText(text);
    }
}
