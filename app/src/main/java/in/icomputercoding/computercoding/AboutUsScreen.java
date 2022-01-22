package in.icomputercoding.computercoding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import in.icomputercoding.computercoding.databinding.AboutUsScreenBinding;


public class AboutUsScreen extends AppCompatActivity {

    AboutUsScreenBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AboutUsScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);


        binding.telegram.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://t.me/icomputercoding"));
            startActivity(i);
        });

        binding.share.setOnClickListener(v -> {
            try {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "Learn Coding: CodeLab");
                i.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName());
                startActivity(Intent.createChooser(i, "Share With"));
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Unable to share this app", Toast.LENGTH_SHORT).show();
            }
        });


        binding.website.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://icomputercoding.in"));
            startActivity(i);
        });
    }


}
