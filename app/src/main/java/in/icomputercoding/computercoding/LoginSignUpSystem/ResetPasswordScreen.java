package in.icomputercoding.computercoding.LoginSignUpSystem;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import java.util.Objects;
import in.icomputercoding.computercoding.databinding.ResetPasswordScreenBinding;


public class ResetPasswordScreen extends AppCompatActivity {

    FirebaseAuth auth;
    ResetPasswordScreenBinding binding;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ResetPasswordScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        binding.arrowBack.setOnClickListener(view -> {
            startActivity(new Intent(ResetPasswordScreen.this, LoginScreen.class));
            finish();
        });

        auth = FirebaseAuth.getInstance();

        binding.resetOtp.setOnClickListener(view -> {
            String email = binding.resetEmail.getText().toString();
            String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
            if (email.isEmpty()) {
                Toast.makeText(ResetPasswordScreen.this, "All fields are required", Toast.LENGTH_SHORT).show();
            } else if (!email.matches(emailPattern)) {
                Toast.makeText(ResetPasswordScreen.this, "Enter a  valid email address", Toast.LENGTH_SHORT).show();
            } else {
                ResetUser();
            }

        });
    }

    private void ResetUser() {
        binding.progress.setVisibility(View.VISIBLE);
        auth.fetchSignInMethodsForEmail(binding.resetEmail.getText().toString()).addOnCompleteListener(task -> {
            if (Objects.requireNonNull(Objects.requireNonNull(task.getResult()).getSignInMethods()).isEmpty()) {
                binding.progress.setVisibility(View.GONE);
                Toast.makeText(this, "This is not an registered email, you can create new account", Toast.LENGTH_SHORT).show();
            } else {
                auth.sendPasswordResetEmail(binding.resetEmail.getText().toString()).addOnCompleteListener(task1 -> {
                    if (task1.isSuccessful()) {
                        binding.progress.setVisibility(View.GONE);
                        if (task1.isSuccessful()) {
                            Toast.makeText(this, "An reset email has been sent to your email address", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(ResetPasswordScreen.this, LoginScreen.class);
                            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(i);
                            finish();
                        } else {
                            Toast.makeText(this, "Please check again your email address", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}