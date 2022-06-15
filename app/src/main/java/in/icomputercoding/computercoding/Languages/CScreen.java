package in.icomputercoding.computercoding.Languages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import in.icomputercoding.computercoding.Notes;
import in.icomputercoding.computercoding.NotesAdapter;
import in.icomputercoding.computercoding.R;


public class CScreen extends AppCompatActivity {

    List<Notes> notesList;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cscreen);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_about_card_show);
        RelativeLayout relativeLayout = findViewById(R.id.rel1);
        relativeLayout.startAnimation(animation);

        recyclerView = findViewById(R.id.notesList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        notesList = new ArrayList<>();

        notesList.add(
                new Notes(
                        1,
                        "Chapter 1\n",
                        "https://firebasestorage.googleapis.com/v0/b/computer-coding-41b62.appspot.com/o/C%20Programming%2FChapter1_C.pdf?alt=media&token=8301947f-a8f2-48a2-8e52-60e1722f72ca"
                ));

        notesList.add(
                new Notes(
                        1,
                        "Chapter 2\n",
                        "https://firebasestorage.googleapis.com/v0/b/computer-coding-41b62.appspot.com/o/C%20Programming%2FChapter2_C.pdf?alt=media&token=aac589cc-16bd-4e22-8d31-c7a972351fae"
                ));

        notesList.add(
                new Notes(
                        1,
                        "Chapter 3\n",
                        "https://firebasestorage.googleapis.com/v0/b/computer-coding-41b62.appspot.com/o/C%20Programming%2FChapter3_C.pdf?alt=media&token=46e9e600-49ea-400e-a341-7a210ca24f0f"
                ));

        notesList.add(
                new Notes(
                        1,
                        "Chapter 4\n",
                        "https://firebasestorage.googleapis.com/v0/b/computer-coding-41b62.appspot.com/o/C%20Programming%2FChapter4_C.pdf?alt=media&token=49363284-00bc-46d4-ae4e-a6fb88f21685"
                ));

        notesList.add(
                new Notes(
                        1,
                        "Chapter 5\n",
                        "https://firebasestorage.googleapis.com/v0/b/computer-coding-41b62.appspot.com/o/C%20Programming%2FChapter5_C.pdf?alt=media&token=be0eb1d8-5e93-47a3-9548-2cbbd0dcbe23"
                ));

        notesList.add(
                new Notes(
                        1,
                        "Chapter 6\n",
                        "https://firebasestorage.googleapis.com/v0/b/computer-coding-41b62.appspot.com/o/C%20Programming%2FChapter6_C.pdf?alt=media&token=fe37d60a-67e0-47f6-a704-419dfa3120ae"
                ));

        notesList.add(
                new Notes(
                        1,
                        "Chapter 7\n",
                        "https://firebasestorage.googleapis.com/v0/b/computer-coding-41b62.appspot.com/o/C%20Programming%2FChapter7_C.pdf?alt=media&token=94e093d9-ca83-4d0d-b874-eddd343e9556"
                ));

        notesList.add(
                new Notes(
                        1,
                        "Chapter 8\n",
                        "https://firebasestorage.googleapis.com/v0/b/computer-coding-41b62.appspot.com/o/C%20Programming%2FChapter8_C.pdf?alt=media&token=5b97bdf0-ffd4-48da-96f9-d98396942bf8"
                ));


        //creating recyclerview adapter
        NotesAdapter adapter = new NotesAdapter(this, notesList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);


    }
}