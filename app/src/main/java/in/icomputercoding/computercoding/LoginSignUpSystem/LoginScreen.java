package in.icomputercoding.computercoding.LoginSignUpSystem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

import in.icomputercoding.computercoding.HomeScreen;
import in.icomputercoding.computercoding.R;
import in.icomputercoding.computercoding.WelcomeScreen;

public class LoginScreen extends AppCompatActivity {

    EditText et_email, et_pass;
    FirebaseAuth auth;
    Button btn_login;
    ImageView arrow_back;
    TextView reset, tv_register;
    String email, pass;
    private long pressedTime;

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
        setContentView(R.layout.login_screen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        et_email = findViewById(R.id.et_email);
        et_pass = findViewById(R.id.et_pass);
        btn_login = findViewById(R.id.btn_login);
        reset = findViewById(R.id.reset);
        tv_register = findViewById(R.id.tv_register);
        arrow_back = findViewById(R.id.arrow_back);


        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.loading_dialog);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        arrow_back.setOnClickListener(view -> {
            startActivity(new Intent(LoginScreen.this, WelcomeScreen.class));
            finish();
        });

        reset.setOnClickListener(view -> {
            startActivity(new Intent(LoginScreen.this, ResetPasswordScreen.class));
            finish();
        });

        tv_register.setOnClickListener(view -> {
            startActivity(new Intent(LoginScreen.this, RegisterScreen.class));
            finish();
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateUser();
            }

            private void validateUser() {

                email = et_email.getText().toString();
                pass = et_pass.getText().toString();

                if (email.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(LoginScreen.this, "All fields are required", Toast.LENGTH_SHORT).show();
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
