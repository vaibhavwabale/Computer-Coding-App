package in.icomputercoding.computercoding.Fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import in.icomputercoding.computercoding.Languages.CPPScreen;
import in.icomputercoding.computercoding.Languages.CScreen;
import in.icomputercoding.computercoding.Languages.JavaScreen;
import in.icomputercoding.computercoding.LoginSignUpSystem.UsersData;
import in.icomputercoding.computercoding.R;


public class HomeFragment extends Fragment implements View.OnClickListener {

    RelativeLayout Learn_cpp, Learn_c, Learn_java;
    TextView name;
    FirebaseUser user;
    FirebaseAuth auth;
    DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View myView = inflater.inflate(R.layout.fragment_home, container, false);

        Learn_cpp = myView.findViewById(R.id.Learn_cpp);
        name = myView.findViewById(R.id.name);
        Learn_cpp.setOnClickListener(this);
        Learn_c = myView.findViewById(R.id.Learn_c);
        Learn_c.setOnClickListener(this);
        Learn_java = myView.findViewById(R.id.Learn_java);
        Learn_java.setOnClickListener(this);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        reference = FirebaseDatabase.getInstance().getReference("Users").child(user.getUid());
        reference.addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UsersData usersData = snapshot.getValue(UsersData.class);
                assert usersData != null;
                name.setText("Hi, " + usersData.getName() + "!");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

            }

        });
        return myView;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.Learn_cpp) {
            Intent i = new Intent(getActivity(), CPPScreen.class);
            startActivity(i);
        } else if (v.getId() == R.id.Learn_c) {
            Intent i = new Intent(getActivity(), CScreen.class);
            startActivity(i);
        } else if (v.getId() == R.id.Learn_java) {
            Intent i = new Intent(getActivity(), JavaScreen.class);
            startActivity(i);
        }
    }
}