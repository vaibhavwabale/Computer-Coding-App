package in.icomputercoding.computercoding.Quiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import in.icomputercoding.computercoding.R;
import in.icomputercoding.computercoding.databinding.ActivityHtml5QuizBinding;

public class HTML5QuizActivity extends AppCompatActivity {

    Boolean timerAgain = true;
    CountDownTimer countDownTimer;
    DatabaseReference reference;
    int score = 0;
    int position = 0;
    int count = 0;
    ActivityHtml5QuizBinding binding;
    List<QuestionData> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHtml5QuizBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (this.timerAgain) {
            reverseTimer(binding.timer);
        }
        timerAgain = false;
        reference = FirebaseDatabase.getInstance().getReference();
        list = new ArrayList<>();

        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.loading_dialog);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        reference.child("HTML5Quiz").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    String question = Objects.requireNonNull(dataSnapshot.child("question").getValue()).toString();
                    String oA = Objects.requireNonNull(dataSnapshot.child("oA").getValue()).toString();
                    String oB = Objects.requireNonNull(dataSnapshot.child("oB").getValue()).toString();
                    String oC = Objects.requireNonNull(dataSnapshot.child("oC").getValue()).toString();
                    String oD = Objects.requireNonNull(dataSnapshot.child("oD").getValue()).toString();
                    String ans = Objects.requireNonNull(dataSnapshot.child("ans").getValue()).toString();

                    list.add(new QuestionData(oA, oB, oC, oD, ans, question));
                    Collections.shuffle(list);

                }
                if (list.size() > 0) {
                    loadQuestion(binding.question, 0, list.get(position).getQuestion());

                    for (int i = 0; i < 4; i++) {
                        binding.container.getChildAt(i).setOnClickListener(v -> checkAns((Button) v));
                    }

                    binding.nextBtn.setOnClickListener(v -> {
                        binding.nextBtn.setEnabled(false);
                        binding.nextBtn.setAlpha(0.7f);
                        enabled(true);
                        position++;

                        if (position == list.size()) {
                            Intent i = new Intent(HTML5QuizActivity.this, ScoreActivity.class);
                            i.putExtra("score", score);
                            i.putExtra("total", list.size());
                            startActivity(i);
                            finish();
                            return;
                        }
                        count = 0;
                        loadQuestion(binding.question, 0, list.get(position).getQuestion());

                    });

                    binding.shareBtn.setOnClickListener(v -> {
                        String body = "*" + list.get(position).getQuestion() + "*\n" +
                                "(a) " + list.get(position).getoA() + "\n" +
                                "(b) " + list.get(position).getoB() + "\n" +
                                "(c) " + list.get(position).getoC() + "\n" +
                                "(d) " + list.get(position).getoD();
                        Intent i = new Intent(Intent.ACTION_SEND);
                        i.setType("Text/Plain");
                        i.putExtra(Intent.EXTRA_SUBJECT, "CodeLab");
                        i.putExtra(Intent.EXTRA_TEXT, body);
                        startActivity(Intent.createChooser(i, "Share via"));
                    });


                } else {
                    Toast.makeText(HTML5QuizActivity.this, "No Data Found", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(HTML5QuizActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void reverseTimer(TextView textView) {

        final TextView textView1 = textView;
        countDownTimer = new CountDownTimer((120 * 1000) + 1000, 1000) {
            @SuppressLint("SetTextI18n")
            @Override
            public void onTick(long j) {
                NumberFormat f = new DecimalFormat("00");
                long min = (j / 60000) % 60;
                long sec = (j / 1000) % 60;
                textView1.setText(f.format(min) + ":" + f.format(sec));
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onFinish() {
                textView1.setText("00:00");
                Intent intent = new Intent(HTML5QuizActivity.this, ScoreActivity.class);
                intent.putExtra("score", score);
                intent.putExtra("total", list.size());
                startActivity(intent);
                finish();

            }
        }.start();
    }

    private void checkAns(Button selectedOption) {
        enabled(false);
        binding.nextBtn.setEnabled(true);
        binding.nextBtn.setAlpha(1.0f);
        if (selectedOption.getText().toString().equals(list.get(position).getAns())) {
            score++;
            selectedOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#4caf50")));
            return;
        }
        selectedOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff0000")));
        this.binding.container.findViewWithTag(this.list.get(this.position).getAns()).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#4CAF50")));
    }

    private void enabled(Boolean enable) {
        for (int i = 0; i < 4; i++) {
            binding.container.getChildAt(i).setEnabled(enable);
            if (enable) {
                binding.container.getChildAt(i).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#00aeff")));
            }
        }
    }

    private void loadQuestion(View view, int value, String data) {
        for (int i = 0; i < 4; i++) {
            binding.container.getChildAt(i).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#00aeff")));
        }
        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500)
                .setStartDelay(100).setInterpolator(new DecelerateInterpolator())
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        if (value == 0 && count < 4) {
                            String option = "";
                            if (count == 0)
                                option = list.get(position).getoA();
                            else if (count == 1)
                                option = list.get(position).getoB();
                            else if (count == 2)
                                option = list.get(position).getoC();
                            else if (count == 3)
                                option = list.get(position).getoD();

                            loadQuestion(binding.container.getChildAt(count), 0, option);
                            count++;
                        }
                    }

                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onAnimationEnd(Animator animation) {

                        if (value == 0) {
                            try {
                                ((TextView) view).setText(data);
                                binding.indicator.setText(position + "/" + list.size());
                            } catch (ClassCastException e) {
                                ((Button) view).setText(data);
                            }
                            view.setTag(data);
                            loadQuestion(view, 1, data);

                        }

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Do you want to Exit?");
        builder.setPositiveButton("Yes", (dialog, which) -> finish());
        builder.setNegativeButton("No", (dialog, which) -> dialog.cancel());
        AlertDialog alert = builder.create();
        alert.show();
        countDownTimer.cancel();
    }

}