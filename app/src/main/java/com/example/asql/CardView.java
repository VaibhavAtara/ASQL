package com.example.asql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class CardView extends AppCompatActivity {
    GridLayout maingrid;
    ToggleButton toggle1,toggle2;
    ImageView img1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
        maingrid = (GridLayout)findViewById(R.id.maingrid);
        toggle1 = (ToggleButton)findViewById(R.id.toggle1);
        //toggle2 = (ToggleButton)findViewById(R.id.toggle2);
        img1 = (ImageView)findViewById(R.id.img1);
        toggle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(toggle1.isChecked())
                {

                toggle1.setTextColor(Color.parseColor("#ff0fc005"));
                    img1.setImageDrawable(getResources().getDrawable(R.drawable.bulbon));

                }
                else
                {
                    toggle1.setTextColor(Color.parseColor("#fffc1b00"));
                    img1.setImageDrawable(getResources().getDrawable(R.drawable.bulboff));
                }
            }
        });
        setSingleEvent(maingrid);
    }


    //#######################################################################################
    private void setSingleEvent(GridLayout maingrid){
        for (int i=0;i<maingrid.getChildCount();i++){
            androidx.cardview.widget.CardView cardView =(androidx.cardview.widget.CardView)maingrid.getChildAt(i);
            final int j=i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(j==0){
                        Intent intent = new Intent(CardView.this,MainActivity.class);
                        startActivity(intent);}

                    //Toast.makeText(Main3Activity.this,""+j, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    //#######################################################################################
}
