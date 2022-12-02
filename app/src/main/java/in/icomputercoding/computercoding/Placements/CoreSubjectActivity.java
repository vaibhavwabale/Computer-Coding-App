package in.icomputercoding.computercoding.Placements;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;
import java.util.List;

import in.icomputercoding.computercoding.Notes;
import in.icomputercoding.computercoding.NotesAdapter;
import in.icomputercoding.computercoding.R;
import in.icomputercoding.computercoding.databinding.ActivityCoreSubjectBinding;

public class CoreSubjectActivity extends AppCompatActivity {

    ActivityCoreSubjectBinding binding;

    List<Notes> notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCoreSubjectBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_about_card_show);
        binding.coreSubjects.startAnimation(animation);

        binding.subjectList.setLayoutManager(new LinearLayoutManager(this));
        binding.subjectList.setHasFixedSize(true);


        notesList = new ArrayList<>();

        notesList.add(
                new Notes(
                        0,
                        "Database Management\n",
                        "https://firebasestorage.googleapis.com/v0/b/computer-coding-41b62.appspot.com/o/Placements%2FDBMS_Notes.pdf?alt=media&token=5d59dcb9-a061-4068-a412-b2e682f8f379"
                ));

        //creating recyclerview adapter
        NotesAdapter adapter = new NotesAdapter(this, notesList);

        //setting adapter to recyclerview
        binding.subjectList.setAdapter(adapter);


    }
}