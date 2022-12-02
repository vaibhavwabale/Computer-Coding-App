package in.icomputercoding.computercoding;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import in.icomputercoding.computercoding.databinding.SplashScreenBinding;

@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {

    FirebaseAuth auth;
    SplashScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = SplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth = FirebaseAuth.getInstance();

        if (!isOnline()) {
            Dialog dialog = new Dialog(this);
            //Set Content View
            dialog.setContentView(R.layout.no_internet);
            //Set Outside Touch
            dialog.setCanceledOnTouchOutside(false);
            //dialog.onBackPressed();
            dialog.setOnCancelListener(dialogInterface -> SplashScreen.this.finish());
            //Set Dialog Width and Height
            dialog.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT,WindowManager.LayoutParams.WRAP_CONTENT);
            //Set Transparent Background
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            //Set Animation
            dialog.getWindow().getAttributes().windowAnimations = android.R.style.Animation_Dialog;
            TextView retry = dialog.findViewById(R.id.retry);
            retry.setOnClickListener(view -> recreate());
            dialog.show();
        } else {
            if (auth.getCurrentUser() != null) {
                new Handler().postDelayed(() -> {
                    Intent i = new Intent(SplashScreen.this, HomeScreen.class);
                    startActivity(i);
                    finish();
                }, 1000);
            } else {
                new Handler().postDelayed(() -> {
                    Intent i = new Intent(SplashScreen.this, WelcomeScreen.class);
                    startActivity(i);
                    finish();
                }, 1000);
            }
        }



    }

    private boolean isOnline() {

        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        return networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
    }

    }
