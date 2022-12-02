package in.icomputercoding.computercoding;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

import in.icomputercoding.computercoding.Fragments.HomeFragment;
import in.icomputercoding.computercoding.Fragments.PlacementFragment;
import in.icomputercoding.computercoding.Fragments.QuizFragment;
import in.icomputercoding.computercoding.LoginSignUpSystem.UsersData;
import in.icomputercoding.computercoding.databinding.HomeScreenBinding;

public class HomeScreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private long pressedTime;
    ActionBarDrawerToggle toggle;
    FirebaseUser user;
    DatabaseReference reference;
    FirebaseAuth auth;
    String name;
    TextView Name;
    HomeScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Screenshots
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        binding = HomeScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        setSupportActionBar(binding.toolbar);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        View header = binding.navigationView.getHeaderView(0);
        Name = header.findViewById(R.id.profileName);


        reference = FirebaseDatabase.getInstance().getReference("Users").child(user.getUid());
        reference.addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UsersData usersData = snapshot.getValue(UsersData.class);
                assert usersData != null;
                Name.setText(usersData.getName());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(HomeScreen.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }

        });

        name = Name.getText().toString();

        toggle = new ActionBarDrawerToggle(this, binding.drawer, R.string.open, R.string.close);


        binding.drawer.addDrawerListener(toggle);
        toggle.syncState();


        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        binding.navigationView.setItemIconTintList(null);
        binding.navigationView.setItemTextColor(ColorStateList.valueOf(Color.parseColor("#000000")));
        binding.navigationView.setNavigationItemSelectedListener(this);
        binding.bottomNavigation.setItemSelected(R.id.bottom_home, true);
        binding.navigationView.bringToFront();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.navHostFragment, new HomeFragment()).commit();
            binding.navigationView.setCheckedItem(R.id.nav_home);
            binding.toolbar.setTitle("Computer Coding");
        }
        bottomMenu();


    }

    private void bottomMenu() {
        binding.bottomNavigation.setOnItemSelectedListener(i -> {
            Fragment fragment = null;
            if (i == R.id.bottom_home) {
                fragment = new HomeFragment();
                binding.toolbar.setTitle("Home");
            } else if (i == R.id.bottom_quiz) {
                fragment = new QuizFragment();
                binding.toolbar.setTitle("Quiz");
            } else if (i == R.id.bottom_placement) {
                fragment = new PlacementFragment();
                binding.toolbar.setTitle("Placement");
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.navHostFragment, Objects.requireNonNull(fragment)).commit();
        });

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {


        if (binding.drawer.isDrawerOpen(GravityCompat.START)) {
            binding.drawer.closeDrawer(GravityCompat.START);
        } else if (pressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            finish();
        } else {
            Toast.makeText(getBaseContext(), "Tap again to exit", Toast.LENGTH_SHORT).show();
        }
        pressedTime = System.currentTimeMillis();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Fragment fragment = null;
        if (id == R.id.nav_home) {
            fragment = new HomeFragment();
            binding.bottomNavigation.setItemSelected(R.id.bottom_home, true);
            binding.toolbar.setTitle("Home");
        } else if (id == R.id.nav_about) {
            Intent i = new Intent(HomeScreen.this, AboutUsScreen.class);
            startActivity(i);
        } else if (id == R.id.nav_share) {
            try {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "CodeLab - Computer Coding");
                i.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName());
                startActivity(Intent.createChooser(i, "Share With"));
            } catch (Exception e) {
                Toast.makeText(this, "Unable to share this app.", Toast.LENGTH_SHORT).show();
            }
        } else if (id == R.id.nav_logout) {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(HomeScreen.this, WelcomeScreen.class));
        } else if (id == R.id.nav_instagram) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://www.instagram.com/codewithwabale/"));
            startActivity(i);
        } else if (id == R.id.nav_telegram) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://t.me/android_flutter_group"));
            startActivity(i);
        }
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.navHostFragment, fragment);
            ft.commit();
        }
        binding.drawer.closeDrawer(GravityCompat.START);
        return true;


    }
}