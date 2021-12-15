package in.icomputercoding.computercoding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import in.icomputercoding.computercoding.LoginSignUpSystem.LoginScreen;
import in.icomputercoding.computercoding.LoginSignUpSystem.RegisterScreen;

public class WelcomeScreen extends AppCompatActivity {

    private long pressedTime;

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

    Button btn_login, btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_screen);

        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);


        btn_login.setOnClickListener(v -> startActivity(new Intent(WelcomeScreen.this, LoginScreen.class)));

        btn_register.setOnClickListener(v -> startActivity(new Intent(WelcomeScreen.this, RegisterScreen.class)));

    }
}