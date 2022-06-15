package in.icomputercoding.computercoding.Languages;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import in.icomputercoding.computercoding.Notes;
import in.icomputercoding.computercoding.NotesAdapter;
import in.icomputercoding.computercoding.PdfViewer;
import in.icomputercoding.computercoding.R;
import in.icomputercoding.computercoding.databinding.ActivityCppscreenBinding;

public class CPPScreen extends AppCompatActivity {

    ActivityCppscreenBinding binding;

    List<Notes> notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCppscreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_about_card_show);
        binding.relCPP.startAnimation(animation);

        binding.cppList.setLayoutManager(new LinearLayoutManager(this));
        binding.cppList.setHasFixedSize(true);


        notesList = new ArrayList<>();

        notesList.add(
                new Notes(
                        1,
                        "Chapter 1\n",
                        "https://firebasestorage.googleapis.com/v0/b/computer-coding-41b62.appspot.com/o/CPP%20Programming%2FChapter1_CPP.pdf?alt=media&token=1eb7d69f-9892-43a5-a79e-e2ef8c64ca19"
                ));

        notesList.add(
                new Notes(
                        1,
                        "Chapter 2\n",
                        "https://firebasestorage.googleapis.com/v0/b/computer-coding-41b62.appspot.com/o/CPP%20Programming%2FChapter2_CPP.pdf?alt=media&token=241b9d9f-9191-4cae-929d-6e62248c874a"
                ));

        notesList.add(
                new Notes(
                        1,
                        "Chapter 3\n",
                        "https://firebasestorage.googleapis.com/v0/b/computer-coding-41b62.appspot.com/o/CPP%20Programming%2FChapter3_CPP.pdf?alt=media&token=26a5e3fd-010c-4d89-9876-d435926a2a4b"
                ));

        notesList.add(
                new Notes(
                        1,
                        "Chapter 4\n",
                        "https://firebasestorage.googleapis.com/v0/b/computer-coding-41b62.appspot.com/o/CPP%20Programming%2FChapter4_CPP.pdf?alt=media&token=398c3ab7-061f-45c0-9b34-07a510f821fd"
                ));

        notesList.add(
                new Notes(
                        1,
                        "Chapter 5\n",
                        "https://firebasestorage.googleapis.com/v0/b/computer-coding-41b62.appspot.com/o/CPP%20Programming%2FChapter5_CPP.pdf?alt=media&token=34c593ed-6bba-4257-b81c-d732d11f7022"
                ));

        notesList.add(
                new Notes(
                        1,
                        "Chapter 6\n",
                        "https://firebasestorage.googleapis.com/v0/b/computer-coding-41b62.appspot.com/o/CPP%20Programming%2FChapter6_CPP.pdf?alt=media&token=45ee523c-d31f-47f4-a5c1-1f94becbf44d"
                ));

        notesList.add(
                new Notes(
                        1,
                        "Chapter 7\n",
                        "https://firebasestorage.googleapis.com/v0/b/computer-coding-41b62.appspot.com/o/CPP%20Programming%2FChapter7_CPP.pdf?alt=media&token=ac0071fd-f947-471e-a3d4-ac6b7b0f5052"
                ));

        notesList.add(
                new Notes(
                        1,
                        "Chapter 8\n",
                        "https://firebasestorage.googleapis.com/v0/b/computer-coding-41b62.appspot.com/o/CPP%20Programming%2FChapter8_CPP.pdf?alt=media&token=0db2e6bb-f84e-4f2f-8e00-d27bf98ac364"
                ));

        notesList.add(
                new Notes(
                        1,
                        "Chapter 9\n",
                        "https://firebasestorage.googleapis.com/v0/b/computer-coding-41b62.appspot.com/o/CPP%20Programming%2FChapter9_CPP.pdf?alt=media&token=f27590a4-de90-4c09-9c18-ce18331d4bfd"
                ));


        //creating recyclerview adapter
        NotesAdapter adapter = new NotesAdapter(this, notesList);

        //setting adapter to recyclerview
        binding.cppList.setAdapter(adapter);


    }
}