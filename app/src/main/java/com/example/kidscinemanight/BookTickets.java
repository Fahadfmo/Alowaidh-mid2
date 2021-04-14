package com.example.kidscinemanight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BookTickets extends AppCompatActivity {
CheckBox cb1, cb2, cb3;
EditText et;
Button btn;
TextView total_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_tickets);

        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);

        et = findViewById(R.id.et1);
        btn = findViewById(R.id.button);

        total_txt = findViewById(R.id.total_text);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int num = Integer.parseInt(et.getText().toString());
                    int mov = 0;
                    if(cb1.isChecked()){
                        mov++;
                    }
                    if(cb2.isChecked()){
                        mov++;
                    }
                    if(cb3.isChecked()){
                        mov++;
                    }
                    Toast.makeText(BookTickets.this, "You have booked " + String.valueOf(mov) + " movies", Toast.LENGTH_SHORT).show();

                    int total = num*mov*20;
                    total_txt.setText(String.format("Total Price: %s", String.valueOf(total)));
                }catch (Exception e){

                }
            }
        });
    }
}