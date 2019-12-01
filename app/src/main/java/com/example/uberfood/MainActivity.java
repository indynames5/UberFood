package com.example.uberfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth  = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();

    }

    public void signIn(View view){
        Toast.makeText(getApplicationContext(),"Hello Javatpoint",Toast.LENGTH_SHORT).show();
        final String TAG = "testFireStore";

        String email = ((TextView)findViewById(R.id.mail)).getText().toString();
        String password = ((TextView)findViewById(R.id.pass)).getText().toString();

        if(email.isEmpty()&&password.isEmpty()){

            Toast.makeText(getApplicationContext(),"Please type something",Toast.LENGTH_SHORT).show();
        }else{
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "signInWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                updateUI(user);
                            } else {

                                Toast.makeText(getApplicationContext(),"Hello Javatpoint",Toast.LENGTH_SHORT).show();
                                updateUI(null);
                            }

                            // ...
                        }
                    });

        }

    }


    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            updateUI(currentUser);
        }
    }

    public void  updateUI(FirebaseUser account){
        if(account != null){
            Toast.makeText(this,"U Signed In successfully",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this,"U Didnt signed in",Toast.LENGTH_LONG).show();
        }
    }





}
