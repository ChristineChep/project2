package myapp.user.example.com.farmersconnect.ui.share;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import myapp.user.example.com.farmersconnect.R;

public class Additional_information extends Fragment {

    private ShareViewModel shareViewModel;
    private  Button button;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_share
                ,container,false);
        button=(Button) v.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("www.industrialization.go.ke/index.php/downloads/108-handbook-on-importing-and-exporting-in-kenya"));
                startActivity(browserIntent);
            }
        });

        return  v;
    }
}

 //shareViewModel =
//                ViewModelProviders.of(this).get(ShareViewModel.class);
//        View root = inflater.inflate(R.layout.fragment_share, container, false);
//        final TextView textView = root.findViewById(R.id.text_share);
//        shareViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
//        return root;