package com.error404.testsachira;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {



    EditText name,email;
    Button insertButton;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference().child("student");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        name= findViewById(R.id.name);
        email=findViewById(R.id.email);
        insertButton=findViewById(R.id.button);


        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InsertData();
            }
        });
    }

    private void InsertData(){

        String username=name.getText().toString();
        String userEmail=email.getText().toString();

        Students student=new Students(username,userEmail);

        myRef.push().setValue(student);
        Toast.makeText(getApplicationContext(),"Data saved!",Toast.LENGTH_LONG).show();
    }
}