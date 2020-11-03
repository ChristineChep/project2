package myapp.user.example.com.farmersconnect;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private static final String TAG = "Login Activity";
    private static final String USER = "user";
    DatabaseReference reference;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reference = database.getReference();

        final EditText emailLogin = (EditText)findViewById(R.id.emailLogin);
        final EditText LoginPass = (EditText)findViewById(R.id.passwordLogin);

        TextView textView = (TextView)findViewById(R.id.registerTextView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this , Signup.class);
                startActivity(i);
            }
        });
        Button button = (Button)findViewById(R.id.loginbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String LoginEmail = emailLogin.getText().toString();
                String PasswordLogin = LoginPass.getText().toString();

                User user = new User(LoginEmail,PasswordLogin);

                if (emailLogin.getText().toString().length() == 0 ) {
                    emailLogin.setError("Email is  required");
                }else if ( LoginPass.getText().toString().length() == 0){
                    LoginPass.setError("Password is  required");
                }else {
                   // emailLogin.setError(null);
                   // isUser();
                    //return;
                    login(LoginEmail , PasswordLogin);
                }

            }
        });

    }

    private void login(String email , String password){

//        if (!validateUserName() | !validatePassword()){
//            return;
//        }
//        else {
//            isUser();
//        }
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);

        mAuth.signInWithEmailAndPassword(email , password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Log.d(TAG , "Sign in successful");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        }else {
                            Log.w(TAG , "Sign in failed.");
                            Toast.makeText(Login.this ,"Authentication Failed!" , Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }
//    private void isUser(){
//        final String userEnteredEmail = email.getEditText().getText().toString().trim();
//        final String userEnteredPassword = password.getEditText().getText().toString().trim();
//
//        DatabaseReference reference =FirebaseDatabase.getInstance().getReference("user");
//
//        Query checkUser = reference.orderByChild("email").equalTo(userEnteredPassword);
//        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                if(dataSnapshot.exists()){
//                    String passwordFromDB = dataSnapshot.child(userEnteredEmail).child("password").getValue(String.class);
//                    if (passwordFromDB.equals(userEnteredPassword)){
//
//                        String category1dFromDB = dataSnapshot.child(userEnteredEmail).child("category1").getValue(String.class);
//                        String country1FromDB = dataSnapshot.child(userEnteredEmail).child("country1").getValue(String.class);
//                        String emailFromDB = dataSnapshot.child(userEnteredEmail).child("email").getValue(String.class);
//                        String identification1FromDB = dataSnapshot.child(userEnteredEmail).child("identification1").getValue(String.class);
//                        String name1FromDB = dataSnapshot.child(userEnteredEmail).child("name1").getValue(String.class);
//                        String number1FromDB = dataSnapshot.child(userEnteredEmail).child("number1").getValue(String.class);
//                        String password1FromDB = dataSnapshot.child(userEnteredEmail).child("password").getValue(String.class);
//                        String product1FromDB = dataSnapshot.child(userEnteredEmail).child("product1").getValue(String.class);
//
//                        Intent intent = new Intent(getApplicationContext(),UserProfile.class);
//
//                        intent.putExtra("category1",category1dFromDB);
//                        intent.putExtra("country1",country1FromDB);
//                        intent.putExtra("email",emailFromDB);
//                        intent.putExtra("identification1",identification1FromDB);
//                        intent.putExtra("name1",name1FromDB);
//                        intent.putExtra("number1",number1FromDB);
//                        intent.putExtra("password1",password1FromDB);
//                        intent.putExtra("product1",product1FromDB);
//
//                        startActivity(intent);
//                    }else {
//                        userEnteredPassword.setError("Wrong password");

//                    }
//                }else {
//                    userEnteredEmail.setError("No such email exists");
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//    }

    private void updateUI(FirebaseUser currentUser) {

            String keyId = reference.push().getKey();
            reference.child(keyId).setValue(user);
            Intent i = new Intent(this,Main2Activity.class);
            startActivity(i);
        }
    }


