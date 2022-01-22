package in.icomputercoding.computercoding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import in.icomputercoding.computercoding.LoginSignUpSystem.LoginScreen;
import in.icomputercoding.computercoding.LoginSignUpSystem.RegisterScreen;
import in.icomputercoding.computercoding.databinding.WelcomeScreenBinding;

public class WelcomeScreen extends AppCompatActivity {

    private long pressedTime;
    WelcomeScreenBinding binding;

    @Override
    public void onBackPressed() {
        if (pressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            finish();
        } else {
            Toast.makeText(getBaseContext(), "Tap Again To Exit", Toast.LENGTH_SHORT).show();
        }
        pressedTime = System.currentTimeMillis();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = WelcomeScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        binding.btnLogin.setOnClickListener(v -> startActivity(new Intent(WelcomeScreen.this, LoginScreen.class)));

        binding.btnRegister.setOnClickListener(v -> startActivity(new Intent(WelcomeScreen.this, RegisterScreen.class)));

    }
}