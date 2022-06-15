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
import in.icomputercoding.computercoding.databinding.ActivityHtml5ScreenBinding;

public class HTML5Screen extends AppCompatActivity {

    ActivityHtml5ScreenBinding binding;

    List<Notes> notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHtml5ScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_about_card_show);
        binding.relHtml.startAnimation(animation);

        binding.HtmlList.setLayoutManager(new LinearLayoutManager(this));
        binding.HtmlList.setHasFixedSize(true);


        notesList = new ArrayList<>();

        notesList.add(
                new Notes(
                        1,
                        "Chapter 1\n",
                        "https://firebasestorage.googleapis.com/v0/b/computer-coding-41b62.appspot.com/o/HTML5%20Programming%2FChapter1_HTML.pdf?alt=media&token=89b3221c-e361-4ca5-9764-a28f51954a59"
                ));

        notesList.add(
                new Notes(
                        1,
                        "Chapter 2\n",
                        "https://firebasestorage.googleapis.com/v0/b/computer-coding-41b62.appspot.com/o/HTML5%20Programming%2FChapter2_HTML.pdf?alt=media&token=e8469f1c-53c5-4120-8f16-663a21ba1bb4"
                ));

        notesList.add(
                new Notes(
                        1,
                        "Chapter 3\n",
                        "https://firebasestorage.googleapis.com/v0/b/computer-coding-41b62.appspot.com/o/HTML5%20Programming%2FChapter3_HTML.pdf?alt=media&token=e934b99d-0ce9-45e6-b071-2399117c37cb"
                ));

        notesList.add(
                new Notes(
                        1,
                        "Chapter 4\n",
                        "https://firebasestorage.googleapis.com/v0/b/computer-coding-41b62.appspot.com/o/HTML5%20Programming%2FChapter4_HTML.pdf?alt=media&token=bc85df7c-5805-449d-ac02-6b2246a24b31"
                ));

        notesList.add(
                new Notes(
                        1,
                        "Chapter 5\n",
                        "https://firebasestorage.googleapis.com/v0/b/computer-coding-41b62.appspot.com/o/HTML5%20Programming%2FChapter5_HTML.pdf?alt=media&token=54605e12-369c-40f9-8a62-03962f78512b"
                ));

        notesList.add(
                new Notes(
                        1,
                        "Chapter 6\n",
                        "https://firebasestorage.googleapis.com/v0/b/computer-coding-41b62.appspot.com/o/HTML5%20Programming%2FChapter6_HTML.pdf?alt=media&token=2f7ba69d-981a-4296-9f9c-a56560004e09"
                ));

        notesList.add(
                new Notes(
                        1,
                        "Chapter 7\n",
                        "https://firebasestorage.googleapis.com/v0/b/computer-coding-41b62.appspot.com/o/HTML5%20Programming%2FChapter7_HTML.pdf?alt=media&token=53663ecd-69ee-45da-a1b1-669ede731ec0"
                ));


        //creating recyclerview adapter
        NotesAdapter adapter = new NotesAdapter(this, notesList);

        //setting adapter to recyclerview
        binding.HtmlList.setAdapter(adapter);

    }
}