package in.icomputercoding.computercoding.LoginSignUpSystem;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

import in.icomputercoding.computercoding.R;


public class ResetPasswordScreen extends AppCompatActivity {

    Button reset_otp;
    EditText reset_email;
    FirebaseAuth auth;
    ImageView arrow_back;
    ProgressBar progress;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reset_password_screen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        reset_otp = findViewById(R.id.reset_otp);
        reset_email = findViewById(R.id.reset_email);
        arrow_back = findViewById(R.id.arrow_back);
        progress = findViewById(R.id.progress);

        arrow_back.setOnClickListener(view -> {
            startActivity(new Intent(ResetPasswordScreen.this, LoginScreen.class));
            finish();
        });

        auth = FirebaseAuth.getInstance();

        reset_otp.setOnClickListener(view -> {
            progress.setVisibility(View.VISIBLE);
            auth.fetchSignInMethodsForEmail(reset_email.getText().toString()).addOnCompleteListener(task -> {
                if (Objects.requireNonNull(Objects.requireNonNull(task.getResult()).getSignInMethods()).isEmpty()) {
                    progress.setVisibility(View.GONE);
                    Toast.makeText(this,"This is not an registered email, you can create new account",Toast.LENGTH_SHORT).show();
                } else {
                    auth.sendPasswordResetEmail(reset_email.getText().toString()).addOnCompleteListener(task1 -> {
                        if (task1.isSuccessful()) {
                            progress.setVisibility(View.GONE);
                            if (task1.isSuccessful()) {
                                Toast.makeText(this,"An reset email has been sent to your email address",Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(ResetPasswordScreen.this, LoginScreen.class);
                                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(i);
                                finish();
                            } else {
                                Toast.makeText(this, Objects.requireNonNull(task1.getException()).getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            });
        });
    }
}