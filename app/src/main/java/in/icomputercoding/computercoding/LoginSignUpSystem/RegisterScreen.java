package in.icomputercoding.computercoding.LoginSignUpSystem;


import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Objects;

import in.icomputercoding.computercoding.R;
import in.icomputercoding.computercoding.WelcomeScreen;

public class RegisterScreen extends AppCompatActivity {

    EditText et_name, et_email, et_pass;
    Button register;
    TextView login;
    FirebaseAuth auth;
    DatabaseReference reference;
    ImageView arrow_back;
    String name, email, pass;
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
        setContentView(R.layout.register_screen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        et_name = findViewById(R.id.et_name);
        et_email = findViewById(R.id.et_email);
        et_pass = findViewById(R.id.et_pass);
        register = findViewById(R.id.register);
        login = findViewById(R.id.login);
        arrow_back = findViewById(R.id.arrow_back);

        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.loading_dialog);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        arrow_back.setOnClickListener(view -> {
            startActivity(new Intent(RegisterScreen.this,WelcomeScreen.class));
            finish();
        });





        login.setOnClickListener(view -> {
            startActivity(new Intent(RegisterScreen.this, LoginScreen.class));
            finish();
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = et_name.getText().toString();
                email = et_email.getText().toString();
                pass = et_pass.getText().toString();
                validateUser();

            }

            private void validateUser() {
                if (name.isEmpty() || email.isEmpty() || pass.isEmpty()) {

                    Toast.makeText(RegisterScreen.this,"All fields are required", Toast.LENGTH_SHORT).show();
                } else {
                    registerUser();
                }

            }

            private void registerUser() {

                dialog.show();
                auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {

                        FirebaseUser user = auth.getCurrentUser();
                        assert user != null;
                        String userId = user.getUid();
                        reference = FirebaseDatabase.getInstance().getReference("Users").child(userId);
                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put("userId", userId);
                        hashMap.put("name", name);
                        hashMap.put("email", email);
                        reference.setValue(hashMap).addOnCompleteListener(task1 -> {
                            if (task1.isSuccessful()) {
                                Intent i = new Intent(RegisterScreen.this, LoginScreen.class);
                                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(i);
                            } else {
                                Toast.makeText(RegisterScreen.this, Objects.requireNonNull(task1.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });


                    } else  {

                        dialog.hide();
                        Toast.makeText(RegisterScreen.this, Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }


}