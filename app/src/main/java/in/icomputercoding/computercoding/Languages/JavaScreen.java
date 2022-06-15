package in.icomputercoding.computercoding.Languages;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import in.icomputercoding.computercoding.Notes;
import in.icomputercoding.computercoding.NotesAdapter;
import in.icomputercoding.computercoding.PdfViewer;
import in.icomputercoding.computercoding.R;
import in.icomputercoding.computercoding.databinding.ActivityCppscreenBinding;
import in.icomputercoding.computercoding.databinding.ActivityJavaScreenBinding;

public class JavaScreen extends AppCompatActivity {

    ActivityJavaScreenBinding binding;

    List<Notes> notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityJavaScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_about_card_show);
        binding.relJava.startAnimation(animation);

        binding.JavaList.setLayoutManager(new LinearLayoutManager(this));
        binding.JavaList.setHasFixedSize(true);


        notesList = new ArrayList<>();

        notesList.add(
                new Notes(
                        1,
                        "Chapter 1\n",
                        "https://firebasestorage.googleapis.com/v0/b/computer-coding-41b62.appspot.com/o/Java%20Programming%2FChapter1_Java.pdf?alt=media&token=7d3be4e5-d11a-48c9-a430-04a56ec1a1eb"
                ));

        notesList.add(
                new Notes(
                        1,
                        "Chapter 2\n",
                        "https://firebasestorage.googleapis.com/v0/b/computer-coding-41b62.appspot.com/o/Java%20Programming%2FChapter2_Java.pdf?alt=media&token=f547f06e-4c48-40f4-8045-e8e58ffcdbaa"
                ));

        notesList.add(
                new Notes(
                        1,
                        "Chapter 3\n",
                        "https://firebasestorage.googleapis.com/v0/b/computer-coding-41b62.appspot.com/o/Java%20Programming%2FChapter3_Java.pdf?alt=media&token=9ca326c0-66c5-44af-9b20-a1ee7a2db3da"
                ));

        notesList.add(
                new Notes(
                        1,
                        "Chapter 4\n",
                        "https://firebasestorage.googleapis.com/v0/b/computer-coding-41b62.appspot.com/o/Java%20Programming%2FChapter4_Java.pdf?alt=media&token=5326a19d-ae18-4b4e-8a0c-460133fba75a"
                ));

        notesList.add(
                new Notes(
                        1,
                        "Chapter 5\n",
                        "https://firebasestorage.googleapis.com/v0/b/computer-coding-41b62.appspot.com/o/Java%20Programming%2FChapter5_Java.pdf?alt=media&token=efea5502-a359-40e5-bde2-52940ad55666"
                ));

        notesList.add(
                new Notes(
                        1,
                        "Chapter 6\n",
                        "https://firebasestorage.googleapis.com/v0/b/computer-coding-41b62.appspot.com/o/Java%20Programming%2FChapter6_Java.pdf?alt=media&token=94c7a371-8877-4219-a27c-5127c2c18794"
                ));

        notesList.add(
                new Notes(
                        1,
                        "Chapter 7\n",
                        "https://firebasestorage.googleapis.com/v0/b/computer-coding-41b62.appspot.com/o/Java%20Programming%2FChapter7_Java.pdf?alt=media&token=942fd101-8bce-449d-a05b-9fc70325a937"
                ));


        //creating recyclerview adapter
        NotesAdapter adapter = new NotesAdapter(this, notesList);

        //setting adapter to recyclerview
        binding.JavaList.setAdapter(adapter);


    }
}