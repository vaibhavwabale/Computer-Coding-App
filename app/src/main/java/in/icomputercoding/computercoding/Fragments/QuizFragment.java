package in.icomputercoding.computercoding.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import in.icomputercoding.computercoding.Quiz.CPPQuizActivity;
import in.icomputercoding.computercoding.Quiz.CQuizActivity;
import in.icomputercoding.computercoding.Quiz.HTML5QuizActivity;
import in.icomputercoding.computercoding.Quiz.JavaQuizActivity;
import in.icomputercoding.computercoding.R;


public class QuizFragment extends Fragment implements View.OnClickListener {

    RelativeLayout c_language, java_language, cpp_language, html5_language;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_quiz, container, false);

        c_language = myView.findViewById(R.id.c_language);
        java_language = myView.findViewById(R.id.java_language);
        cpp_language = myView.findViewById(R.id.cpp_language);
        html5_language = myView.findViewById(R.id.html5_language);

        c_language.setOnClickListener(this);
        cpp_language.setOnClickListener(this);
        java_language.setOnClickListener(this);
        html5_language.setOnClickListener(this);

        return myView;
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        if (id == R.id.c_language) {
            Intent i = new Intent(getActivity(), CQuizActivity.class);
            startActivity(i);
        } else if (id == R.id.cpp_language) {
            Intent i = new Intent(getActivity(), CPPQuizActivity.class);
            startActivity(i);
        } else if (id == R.id.java_language) {
            Intent i = new Intent(getActivity(), JavaQuizActivity.class);
            startActivity(i);
        } else if (id == R.id.html5_language) {
            Intent i = new Intent(getActivity(), HTML5QuizActivity.class);
            startActivity(i);
        }

    }

}