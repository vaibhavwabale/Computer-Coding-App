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
import in.icomputercoding.computercoding.databinding.ActivityAptitudeBinding;

public class AptitudeActivity extends AppCompatActivity {

    ActivityAptitudeBinding binding;
    List<Notes> notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAptitudeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_about_card_show);
        binding.aptitude.startAnimation(animation);

        binding.aptitudeList.setLayoutManager(new LinearLayoutManager(this));
        binding.aptitudeList.setHasFixedSize(true);


        notesList = new ArrayList<>();

        notesList.add(
                new Notes(
                        0,
                        "Formula Book By CampusGate\n",
                        "https://firebasestorage.googleapis.com/v0/b/computer-coding-41b62.appspot.com/o/Placements%2FFormula.pdf?alt=media&token=4fcb0472-23f9-4d7b-b900-29f3896b38d3"
                )
        );

        //creating recyclerview adapter
        NotesAdapter adapter = new NotesAdapter(this, notesList);

        //setting adapter to recyclerview
        binding.aptitudeList.setAdapter(adapter);


    }
}