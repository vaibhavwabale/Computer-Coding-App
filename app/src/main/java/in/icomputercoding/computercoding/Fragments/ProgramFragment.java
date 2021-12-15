package in.icomputercoding.computercoding.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import in.icomputercoding.computercoding.Programs.CodeCategoryActivity;
import in.icomputercoding.computercoding.R;


public class ProgramFragment extends Fragment implements View.OnClickListener {

    RelativeLayout c_programs, cpp_programs, java_programs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_program, container, false);


        c_programs = myView.findViewById(R.id.c_programs);
        cpp_programs = myView.findViewById(R.id.cpp_programs);
        java_programs = myView.findViewById(R.id.java_programs);

        c_programs.setOnClickListener(this);
        cpp_programs.setOnClickListener(this);
        java_programs.setOnClickListener(this);


        return myView;
    }


    @Override
    public void onClick(View view) {
        Intent i = new Intent(getContext(), CodeCategoryActivity.class);
        int id = view.getId();
        if (id == R.id.c_programs) {
            i.putExtra("codeCategory", "c_programs");
            startActivity(i);
        } else if (id == R.id.cpp_programs) {
            i.putExtra("codeCategory", "cpp_programs");
            startActivity(i);
        } else if (id == R.id.java_programs) {
            i.putExtra("codeCategory", "java_programs");
            startActivity(i);
        }
    }
}