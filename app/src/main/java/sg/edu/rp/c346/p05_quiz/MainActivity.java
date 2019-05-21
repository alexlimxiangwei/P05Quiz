package sg.edu.rp.c346.p05_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox cb1;
    CheckBox cb2;
    Button min;
    Button plus;
    TextView pax;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb1 = findViewById(R.id.cbType1);
        cb2 = findViewById(R.id.cvType2);
        min = findViewById(R.id.btnMin);
        plus = findViewById(R.id.btnPlus);
        pax = findViewById(R.id.tvPax);
        submit = findViewById(R.id.btnSubmit);

        min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currPax = Integer.valueOf(pax.getText().toString());
                if(currPax == 1){
                    Toast.makeText(MainActivity.this,"Number of Pax cannot be below 1",Toast.LENGTH_LONG).show();
                }
                else{
                    currPax -= 1;
                    pax.setText(currPax + "");
                }
            }

        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currPax = Integer.valueOf(pax.getText().toString());
                currPax += 1;
                pax.setText(currPax + "");
            }

        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb1.isChecked() && cb2.isChecked()){
                    Toast.makeText(MainActivity.this,"Please select only one ticket type",Toast.LENGTH_LONG).show();
                }
                else if (!cb1.isChecked() && !cb2.isChecked()){
                    Toast.makeText(MainActivity.this,"Please select a ticket type",Toast.LENGTH_LONG).show();
                }
                else{
                    Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                    if(cb1.isChecked()){
                        intent.putExtra("type",1);
                    }
                    else{
                        intent.putExtra("type",2);
                    }

                    intent.putExtra("pax",Integer.valueOf(pax.getText().toString()));
                    startActivity(intent);
                }
            }

        });

    }
}
