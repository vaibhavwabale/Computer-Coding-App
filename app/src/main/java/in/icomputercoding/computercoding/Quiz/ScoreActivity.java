package in.icomputercoding.computercoding.Quiz;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import in.icomputercoding.computercoding.R;

public class ScoreActivity extends AppCompatActivity {

    TextView scoreTxt,TotalTxt;
    int score, total;

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        score = getIntent().getIntExtra("score",0);
        total = getIntent().getIntExtra("total",0);

        scoreTxt = findViewById(R.id.score);
        TotalTxt = findViewById(R.id.total);

        scoreTxt.setText(String.valueOf(score));
        TotalTxt.setText(String.valueOf(total));

    }
}