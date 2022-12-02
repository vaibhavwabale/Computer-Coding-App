package in.icomputercoding.computercoding.Quiz;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import in.icomputercoding.computercoding.databinding.ActivityScoreBinding;

public class ScoreActivity extends AppCompatActivity {

    int score, total;
    ActivityScoreBinding binding;

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        score = getIntent().getIntExtra("score",0);
        total = getIntent().getIntExtra("total",0);

        binding.score.setText(String.valueOf(score));
        binding.total.setText(String.valueOf(total));

    }
}