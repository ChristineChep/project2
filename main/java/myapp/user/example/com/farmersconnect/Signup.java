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

public class Signup extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText UserName;
    private static final String TAG = "Sign up Activity";
    private static final String USER = "user";
    DatabaseReference reference;
    private User user;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        final EditText name = (EditText)findViewById(R.id.name);
        final EditText category = (EditText)findViewById(R.id.category);
        final EditText email1 = (EditText)findViewById(R.id.emailreg);
        final EditText password1 = (EditText)findViewById(R.id.passreg);
        final EditText cpass = (EditText)findViewById(R.id.cpass);
        final EditText product = (EditText)findViewById(R.id.goods);
        final EditText number = (EditText)findViewById(R.id.no);
        final EditText identification = (EditText)findViewById(R.id.identificationNo);
        final EditText country = (EditText)findViewById(R.id.residCountry);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reference = database.getReference(USER);
        mAuth = FirebaseAuth.getInstance();
        //reference.setValue("Hello Wold!");

//        reference.addValueEventListener(new ValueEventListener() {
////            @Override
////            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
////                String value = dataSnapshot.getValue(String.class);
////                Log.d(TAG, "Failed to red value.",error.toException());
////
////            }
////
////            @Override
////            public void onCancelled(@NonNull DatabaseError databaseError) {
////
////            }
////        });


        TextView textView = (TextView)findViewById(R.id.LoginTextView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Signup.this , Login.class);
                startActivity(i);
            }
        });

        Button button = (Button) findViewById(R.id.register);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = email1.getText().toString();
                String password = password1.getText().toString();


                if (name.getText().toString().length() == 0 ){
                    name.setError("Name is  required");
                } else if (category.getText().toString().length() == 0 ){
                    category.setError("Category is  required");
                }
                else if (email1.getText().toString().length() == 0 ){
                    email1.setError("email is  required");
                }else if (password1.getText().toString().length() == 0 ){
                    password1.setError("Password is  required");
                }else if (cpass.getText().toString().length() == 0 ){
                    cpass.setError("You need to confirm your password");
                }else {


                    String name1 = name.getText().toString();
                    String category1 = category.getText().toString();
                    String product1 = product.getText().toString();
                    String cpass1 = cpass.getText().toString();
                    String number1 = number.getText().toString();
                    String identification1 = identification.getText().toString();
                    String country1 = country.getText().toString();

                    user = new User( name1,category1,email, password , product1,number1,identification1,country1);

                    signUp(email, password);
                }

            }
        });


    }
    private void signUp(String email , String password){
        //FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);

        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Log.d(TAG ,"Registration succesful!");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        }else {
                            Log.w(TAG ,"Sign up failed!" ,task.getException());
                            Toast.makeText(Signup.this,"Authentication failed. ",Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }


    private void updateUI(FirebaseUser currentUser) {
        String keyId = reference.push().getKey();
        reference.child(keyId).setValue(user);
        //FragmentManager manager = getSupportFragmentManager();
        //FragmentTransaction transaction = manager.beginTransaction();
       // transaction.add(R.id.container ,HomeFragment.class,"Login_TAG");
        //transaction.addToBackStack(null);
        //transaction.commit();
        Intent i = new Intent(this,Main2Activity.class);
        startActivity(i);
    }


}
