package com.example.firebase_exmple1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="MainActivity";
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText et_email = (EditText) findViewById(R.id.et_email);
        EditText et_email1 = (EditText) findViewById(R.id.et_email);
        EditText et_email2 = (EditText) findViewById(R.id.et_email);
        EditText et_email3 = (EditText) findViewById(R.id.et_email);
        EditText et_pwd = (EditText) findViewById(R.id.et_pwd);
        Button b_sing_in = (Button) findViewById(R.id.b_sign_in);
        Button b_sing_out = (Button) findViewById(R.id.b_sign_out);
        mAuth = FirebaseAuth.getInstance();

        b_sing_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = et_email.getText().toString();
                String pwd = et_pwd.getText().toString();

                if (!email.equals("")&& !pwd.equals("")){
                    mAuth.signInWithEmailAndPassword(email,pwd);
                    toastMessege("juste signed innnnnnnnnnnn ");
                }else{
                    toastMessege("you didn't fill all the fields ");
                }
            }
        });
        b_sing_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                toastMessege("juste signed out ");
            }
        });

    }

    private void toastMessege(String messege) {

        Toast.makeText(this,messege,Toast.LENGTH_LONG).show();
    }


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            //reload();
        }
    }
}