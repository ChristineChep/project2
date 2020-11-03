package myapp.user.example.com.farmersconnect;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class exporterFind extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView1;
     ListView l1;
     User user;

     ArrayList<String>list;
     ArrayAdapter<String>adapter;
   // ArrayList<String> myArrayList = new ArrayList<>();

    FirebaseDatabase database;
    DatabaseReference mref;
//    private ArrayAdapter<String>adapter;
//    String[]default_items = new String[]{"Name","Email"};
//    UserInfo info;

    //private List<String> itemlist;
    // private String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exporter_find);

        user = new User();
        l1 = (ListView) findViewById(R.id.listView1);

        mref = FirebaseDatabase.getInstance().getReference("user");
        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this,R.layout.usser_info, R.id.userInfo,list);

        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    user = ds.getValue(User.class);
                    list.add(user.getName1().toString()+ "/n"+ user.getEmail().toString() + " /n" + user.getCategory1().toString()
                    +" " +user.getProduct1().toString() +" /n" + user.getCountry1().toString() +" /n" +user.getNumber1().toString());
                }
                l1.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
//


    }
}