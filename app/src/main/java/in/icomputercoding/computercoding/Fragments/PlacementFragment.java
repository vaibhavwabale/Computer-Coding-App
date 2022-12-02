package in.icomputercoding.computercoding.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import in.icomputercoding.computercoding.Placements.AptitudeActivity;
import in.icomputercoding.computercoding.Placements.CoreSubjectActivity;
import in.icomputercoding.computercoding.Placements.OtherResourcesActivity;
import in.icomputercoding.computercoding.R;


public class PlacementFragment extends Fragment implements View.OnClickListener {

    RelativeLayout subject, aptitude, resources;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_program, container, false);


        subject = myView.findViewById(R.id.subjects);
        aptitude = myView.findViewById(R.id.aptitude);
        resources = myView.findViewById(R.id.resources);

        subject.setOnClickListener(this);
        aptitude.setOnClickListener(this);
        resources.setOnClickListener(this);

        return myView;
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.subjects) {
            Intent i = new Intent(getActivity(), CoreSubjectActivity.class);
            startActivity(i);
        } else if (v.getId() == R.id.aptitude) {
            Intent i = new Intent(getActivity(), AptitudeActivity.class);
            startActivity(i);
        } else if (v.getId() == R.id.resources) {
            Intent i = new Intent(getActivity(), OtherResourcesActivity.class);
            startActivity(i);
        }
    }
}