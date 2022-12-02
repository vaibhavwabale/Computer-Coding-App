package in.icomputercoding.computercoding.Placements;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;
import java.util.List;

import in.icomputercoding.computercoding.Notes;
import in.icomputercoding.computercoding.NotesAdapter;
import in.icomputercoding.computercoding.R;
import in.icomputercoding.computercoding.databinding.ActivityOtherResourcesBinding;

public class OtherResourcesActivity extends AppCompatActivity {

    ActivityOtherResourcesBinding binding;
    List<Notes> notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOtherResourcesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_about_card_show);
        binding.resources.startAnimation(animation);

        binding.resourcesList.setLayoutManager(new LinearLayoutManager(this));
        binding.resourcesList.setHasFixedSize(true);


        notesList = new ArrayList<>();

        notesList.add(
                new Notes(
                        0,
                        "Git Cheatsheet\n",
                        "https://firebasestorage.googleapis.com/v0/b/computer-coding-41b62.appspot.com/o/Placements%2FGIT%20CheatSheet.pdf?alt=media&token=184aeec7-f897-412a-b3a2-ed4253737941"
                )
        );

        //creating recyclerview adapter
        NotesAdapter adapter = new NotesAdapter(this, notesList);

        //setting adapter to recyclerview
        binding.resourcesList.setAdapter(adapter);


    }
}