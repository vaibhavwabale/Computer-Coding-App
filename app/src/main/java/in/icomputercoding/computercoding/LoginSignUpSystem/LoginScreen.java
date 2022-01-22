package in.icomputercoding.computercoding.LoginSignUpSystem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

import in.icomputercoding.computercoding.HomeScreen;
import in.icomputercoding.computercoding.R;
import in.icomputercoding.computercoding.WelcomeScreen;
import in.icomputercoding.computercoding.databinding.LoginScreenBinding;

public class LoginScreen extends AppCompatActivity {

    FirebaseAuth auth;
    Dialog dialog;
    private long pressedTime;
    String email, pass;
    LoginScreenBinding binding;

    @Override
    public void onBackPressed() {
        if (pressedTime + 2000 > System.currentTimeMillis()) {
            Intent i = new Intent(this, WelcomeScreen.class);
            startActivity(i);
            super.onBackPressed();
            finish();
        }
        pressedTime = System.currentTimeMillis();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = LoginScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();


        dialog = new Dialog(this);
        dialog.setContentView(R.layout.loading_dialog);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        binding.arrowBack.setOnClickListener(view -> {
            startActivity(new Intent(LoginScreen.this, WelcomeScreen.class));
            finish();
        });

        binding.reset.setOnClickListener(view -> {
            startActivity(new Intent(LoginScreen.this, ResetPasswordScreen.class));
            finish();
        });

        binding.tvRegister.setOnClickListener(view -> {
            startActivity(new Intent(LoginScreen.this, RegisterScreen.class));
            finish();
        });

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateUser();
            }

            private void validateUser() {
                email = binding.etEmail.getText().toString();
                pass = binding.etPass.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if (email.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(LoginScreen.this, "All fields are required", Toast.LENGTH_SHORT).show();
                } else if (!email.matches(emailPattern)) {
                    Toast.makeText(LoginScreen.this, "Enter a  valid email address", Toast.LENGTH_SHORT).show();
                } else if (pass.length() < 6) {
                    Toast.makeText(LoginScreen.this, "Password should contain 6 characters!", Toast.LENGTH_SHORT).show();
                } else {
                    loginUser();
                }

            }

            private void loginUser() {
                dialog.show();
                auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(task -> {
                    dialog.hide();
                    if (task.isSuccessful()) {
                        Intent i = new Intent(LoginScreen.this, HomeScreen.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(i);
                        finish();
                    } else {
                        Toast.makeText(LoginScreen.this, Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }

        });
    }
}
