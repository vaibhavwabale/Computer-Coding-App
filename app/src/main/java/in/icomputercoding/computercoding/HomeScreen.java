package in.icomputercoding.computercoding;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
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
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.util.Objects;

import in.icomputercoding.computercoding.Fragments.HomeFragment;
import in.icomputercoding.computercoding.Fragments.ProgramFragment;
import in.icomputercoding.computercoding.Fragments.QuizFragment;
import in.icomputercoding.computercoding.LoginSignUpSystem.UsersData;

public class HomeScreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private long pressedTime;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    ChipNavigationBar chipNavigationBar;
    DrawerLayout drawerLayout;
    FirebaseUser user;
    DatabaseReference reference;
    NavigationView navigationView;
    FirebaseAuth auth;
    String name;
    TextView Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Screenshots
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.home_screen);

        toolbar = findViewById(R.id.toolbar);
        chipNavigationBar = findViewById(R.id.bottomNavigation);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        setSupportActionBar(toolbar);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        View header = navigationView.getHeaderView(0);
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

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);


        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        navigationView.setItemIconTintList(null);
        navigationView.setItemTextColor(ColorStateList.valueOf(Color.parseColor("#000000")));
        navigationView.setNavigationItemSelectedListener(this);
        chipNavigationBar.setItemSelected(R.id.bottom_home, true);
        navigationView.bringToFront();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.navHostFragment, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
            toolbar.setTitle("Computer Coding");
        }
        bottomMenu();


    }

    private void bottomMenu() {
        chipNavigationBar.setOnItemSelectedListener(i -> {
            Fragment fragment = null;
            if (i == R.id.bottom_home) {
                fragment = new HomeFragment();
                toolbar.setTitle("Home");
            } else if (i == R.id.bottom_quiz) {
                fragment = new QuizFragment();
                toolbar.setTitle("Quiz");
            } else if (i == R.id.bottom_programs) {
                fragment = new ProgramFragment();
                toolbar.setTitle("Programs");
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


        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
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
            chipNavigationBar.setItemSelected(R.id.bottom_home, true);
            toolbar.setTitle("Home");
        } else if (id == R.id.nav_about) {
            Intent i = new Intent(HomeScreen.this, AboutUsScreen.class);
            startActivity(i);
        } else if (id == R.id.nav_privacy) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://icomputercoding.in/privacy-policy/"));
            startActivity(i);
        } else if (id == R.id.nav_terms) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://icomputercoding.in/terms-and-conditions/"));
            startActivity(i);
        } else if (id == R.id.nav_share) {
            try {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "CodeLab - Computer Coding");
                i.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details>id=" + getApplicationContext().getPackageName());
                startActivity(Intent.createChooser(i, "Share With"));
            } catch (Exception e) {
                Toast.makeText(this, "Unable to share this app.", Toast.LENGTH_SHORT).show();
            }
        } else if (id == R.id.nav_logout) {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(HomeScreen.this, WelcomeScreen.class));
            Toast.makeText(HomeScreen.this, "Successfully Logout", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_instagram) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://www.instagram.com/icomputercoding/"));
            startActivity(i);
        } else if (id == R.id.nav_telegram) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://t.me/icomputercoding"));
            startActivity(i);
        }
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.navHostFragment, fragment);
            ft.commit();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;


    }
}