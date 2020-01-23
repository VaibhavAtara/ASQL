package com.example.asql;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    EditText  username,password;
    Button login_btn;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        login_btn = (Button)findViewById(R.id.login);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);



        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                //####################################################################################################

                DatabaseReference Users = FirebaseDatabase.getInstance().getReference("Users");

                Users.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        boolean flag=false;
                        for(DataSnapshot keynode:dataSnapshot.getChildren())
                        {
                            Login login = keynode.getValue(Login.class);
                            if(login.getUsername().equals(username.getText().toString()) && login.getPassword().equals(password.getText().toString()))
                            {
                                Toast.makeText(getApplicationContext(),"Logged in",Toast.LENGTH_SHORT).show();
                                flag = true;
                                progressBar.setVisibility(View.GONE);
                                Intent intent = new Intent(getApplicationContext(),CardView.class);
                                startActivity(intent);
                            }
                        }

                        if(!flag)
                        {Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);}
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });









                //################################################################

            }
        });



        //##########################################################################################################




    }
}
