package myapp.user.example.com.farmersconnect;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class find extends AppCompatActivity {

//    private ImageView imageView2;
//    private TextView textView2;
//    private ListView l2;

    private ImageView imageView2;
    private TextView textView2;
    private ListView l2;


    ArrayList<String> myArrayList = new ArrayList<>();

    DatabaseReference mref;

//    private ArrayAdapter<String> adapter;
//    String[]default_items = new String[]{"Name","Email"};
//    UserInfo info;
//
//    private List<String> itemlist;
//    private String uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);

        final ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<>(find.this, android.R.layout.simple_list_item_1, myArrayList);
        l2 = (ListView) findViewById(R.id.listView2);

        l2.setAdapter(myArrayAdapter);
        mref = FirebaseDatabase.getInstance().getReference();

        mref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
               // String value = dataSnapshot.getValue(String.class);
                //myArrayList.add(value);
                User data = (User)dataSnapshot.getValue(User.class);
                myArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                myArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                myArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                myArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                myArrayAdapter.notifyDataSetChanged();
            }
        });

//        l2 = (ListView)findViewById(R.id.listView2);
//        ArrayList<String> myArrayList = new ArrayList<>();
//
//        FirebaseUser user1 = FirebaseAuth.getInstance().getCurrentUser();
//        if( user1 != null) {
//            uid = user1.getUid();
//            itemlist = new ArrayList<>();
//
//        }
//        //DatabaseReference mref;
//        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                itemlist.clear();
//                String user_name = dataSnapshot.child(uid).child("name").getValue(String.class);
//                String user_email = dataSnapshot.child(uid).child("email").getValue(String.class);
//
//                itemlist.add(user_name);
//                itemlist.add(user_email);
//
//                adapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,itemlist);
//                l2.setAdapter(adapter);
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                Toast.makeText(getApplicationContext(),"Network Error,Please check your network connection",Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
//
//        ref.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                final ContactsContract.Profile p = dataSnapshot.getValue(ContactsContract.Profile.class);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });


    }
}

