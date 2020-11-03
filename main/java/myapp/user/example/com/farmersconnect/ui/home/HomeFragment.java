package myapp.user.example.com.farmersconnect.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import myapp.user.example.com.farmersconnect.Forbidden;
import myapp.user.example.com.farmersconnect.Major;
import myapp.user.example.com.farmersconnect.R;
import myapp.user.example.com.farmersconnect.exporterFind;
import myapp.user.example.com.farmersconnect.required1;
import myapp.user.example.com.farmersconnect.rights;
import myapp.user.example.com.farmersconnect.track;

public class HomeFragment extends Fragment {
public String TAG = "Home Fragment";
    private HomeViewModel homeViewModel;
    private CardView c2;
    private CardView c3;
    private CardView c4;
    private CardView c5;
    private CardView c6;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home,container,false);
        CardView c1 = v.findViewById(R.id.card1);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent intent = new Intent(getActivity(), rights.class);
                startActivity(new Intent (getActivity(),rights.class));
            }
        });

        CardView c2 = v.findViewById(R.id.card2);
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent intent = new Intent(getActivity(), rights.class);
                startActivity(new Intent (getActivity(), exporterFind.class));
            }
        });

        CardView c3 = v.findViewById(R.id.card3);
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent intent = new Intent(getActivity(), rights.class);
                startActivity(new Intent (getActivity(), track.class));
            }
        });

        CardView c4 = v.findViewById(R.id.card4);
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent intent = new Intent(getActivity(), rights.class);
                startActivity(new Intent (getActivity(), Major.class));
            }
        });

        CardView c5 = v.findViewById(R.id.card5);
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent intent = new Intent(getActivity(), rights.class);
                startActivity(new Intent (getActivity(), required1.class));
            }
        });



        CardView c6 = v.findViewById(R.id.card6);
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent intent = new Intent(getActivity(), rights.class);
                startActivity(new Intent (getActivity(), Forbidden.class));
            }
        });


//        homeViewModel =
//                ViewModelProviders.of(this).get(HomeViewModel.class);
//        View root = inflater.inflate(R.layout.fragment_home, container, false);
//       final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
//        return root;


        return v;

    }
     public void onClick (CardView card1){
         Intent intent = new Intent(getActivity(), rights.class);
         startActivity(intent);

     }
}