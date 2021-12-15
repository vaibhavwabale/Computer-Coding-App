package in.icomputercoding.computercoding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class AboutUsScreen extends AppCompatActivity {

    RelativeLayout website, telegram, share;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us_screen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        website = findViewById(R.id.website);
        share = findViewById(R.id.share);
        telegram = findViewById(R.id.telegram);


        telegram.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://t.me/icomputercoding"));
            startActivity(i);
        });

        share.setOnClickListener(v -> {
            try {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "CodeLab - Computer Coding");
                i.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details>id=" + getApplicationContext().getPackageName());
                startActivity(Intent.createChooser(i, "Share With"));
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Unable to share this app", Toast.LENGTH_SHORT).show();
            }
        });


        website.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://icomputercoding.in"));
            startActivity(i);
        });
    }


}
