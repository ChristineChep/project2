package myapp.user.example.com.farmersconnect;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class required1 extends AppCompatActivity {

    private CardView c7;
    private CardView c8;
    private CardView c9;
    private CardView c10;
    private CardView c11;
    private CardView c12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_required1);


        CardView c7 = findViewById(R.id.card7);
        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://flightaware.com/live/"));
                startActivity(browserIntent);
            }
        });

        CardView c8 = findViewById(R.id.card8);
        c8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://flightaware.com/live/"));
                startActivity(browserIntent);
            }
        });

        CardView c9 = findViewById(R.id.card9);
        c9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://flightaware.com/live/"));
                startActivity(browserIntent);
            }
        });

        CardView c10 = findViewById(R.id.card10);
        c10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://flightaware.com/live/"));
                startActivity(browserIntent);
            }
        });

        CardView c11 = findViewById(R.id.card11);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://flightaware.com/live/"));
                startActivity(browserIntent);
            }
        });

        CardView c12 = findViewById(R.id.card12);
        c12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://flightaware.com/live/"));
                startActivity(browserIntent);
            }
        });

        CardView c13 = findViewById(R.id.card13);
        c13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/amp/s/www.kenyans.co.ke/news/37779-business-permit-how-apply-renew-single-business-permit-kenya%3famp=1"));
                startActivity(browserIntent);
            }
        });
    }
}
