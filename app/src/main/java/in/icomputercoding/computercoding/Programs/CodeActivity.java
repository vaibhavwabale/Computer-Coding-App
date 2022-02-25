package in.icomputercoding.computercoding.Programs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import in.icomputercoding.computercoding.databinding.ActivityCodeViewBinding;
import thereisnospon.codeview.CodeViewTheme;

public class CodeActivity extends AppCompatActivity {

    ActivityCodeViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCodeViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.codeView.setTheme(CodeViewTheme.DEFAULT);
        loadPrograms();

    }

    private void loadPrograms() {
        String code = null;
        if ("Write a program to find length of string.".equals(getIntent().getStringExtra("position"))) {
            code = Programs.C1;
        } else if ("Write a program to add two matrices using dynamic allocation method.".equals(getIntent().getStringExtra("position"))) {
            code = Programs.C2;
        } else if ("Write a program to find length of a string using arrays.".equals(getIntent().getStringExtra("position"))) {
            code = Programs.C3;
        } else if ("Write a program using arrays to check given string is palindrome or not.".equals(getIntent().getStringExtra("position"))) {
            code = Programs.C4;
        } else if ("Write a program to copy one string to another string using arrays.".equals(getIntent().getStringExtra("position"))) {
            code = Programs.C5;
        } else if ("Write a program to copy one string to another string using pointers.".equals(getIntent().getStringExtra("position"))) {
            code = Programs.C6;
        } else if ("Write a program for nested structure.".equals(getIntent().getStringExtra("position"))) {
            code = Programs.C7;
        } else if ("Write a program to convert string in uppercase without library function using pointers.".equals(getIntent().getStringExtra("position"))) {
            code = Programs.C8;
        } else if ("Program to accept an integer and check if it is even or odd.".equals(getIntent().getStringExtra("position"))) {
            code = Programs.C9;
        } else if ("Accept a character from the user and check whether the character is a vowel or consonant.".equals(getIntent().getStringExtra("position"))) {
            code = Programs.C10;
        } else if ("Write a Java program to perform basic Calculator operations.".equals(getIntent().getStringExtra("position"))) {
            code = Programs.java1;
        } else if ("Write a Java program to calculate a Factorial of a number.".equals(getIntent().getStringExtra("position"))) {
            code = Programs.java2;
        } else if ("Write a Java program to calculate Fibonacci Series up to n numbers.".equals(getIntent().getStringExtra("position"))) {
            code = Programs.java3;
        } else if ("Write a Java program to find out whether the given String is Palindrome or not.".equals(getIntent().getStringExtra("position"))) {
            code = Programs.java4;
        } else if ("Write a Java program to calculate Permutation and Combination of 2 numbers.".equals(getIntent().getStringExtra("position"))) {
            code = Programs.java5;
        } else if ("Write a Java Program to reverse the letters present in the given String.".equals(getIntent().getStringExtra("position"))) {
            code = Programs.java6;
        } else if ("Write a Java Program to check whether the given array is Mirror Inverse or not.".equals(getIntent().getStringExtra("position"))) {
            code = Programs.java7;
        } else if ("Write a Java program to implement a Binary Search Algorithm.".equals(getIntent().getStringExtra("position"))) {
            code = Programs.java8;
        } else if ("Write a Java program to connect to a SQL DataBase.".equals(getIntent().getStringExtra("position"))) {
            code = Programs.java9;
        } else if ("Write a Java program to remove elements from an ArrayList.".equals(getIntent().getStringExtra("position"))) {
            code = Programs.java10;
        } else if ("Write a  CPP program to check whether number is Even or Odd.".equals(getIntent().getStringExtra("position"))) {
            code = Programs.CPP1;
        } else if ("Write a CPP Program to Reverse an Integer.".equals(getIntent().getStringExtra("position"))) {
            code = Programs.CPP2;
        } else if ("Write a CPP Program to Find Fibonacci Series up to n number of terms.".equals(getIntent().getStringExtra("position"))) {
            code = Programs.CPP3;
        } else if ("Write a CPP Program to Check if a year is leap year or not.".equals(getIntent().getStringExtra("position"))) {
            code = Programs.CPP4;
        } else if ("Write a CPP Program to Display multiplication table up to a given range.".equals(getIntent().getStringExtra("position"))) {
            code = Programs.CPP5;
        } else if ("Write a CPP Program for implementation of Quick Sort using array.".equals(getIntent().getStringExtra("position"))) {
            code = Programs.CPP6;
        } else if ("Write a CPP Program to Swap two numbers using call by reference.".equals(getIntent().getStringExtra("position"))) {
            code = Programs.CPP7;
        } else if ("Write a CPP Program to calculate Volume of Cube using constructor.".equals(getIntent().getStringExtra("position"))) {
            code = Programs.CPP8;
        } else if ("Write a CPP Program to Maintain Book Records using File Handling.".equals(getIntent().getStringExtra("position"))) {
            code = Programs.CPP9;
        } else if ("Write a CPP Program to Add two numbers using function template.".equals(getIntent().getStringExtra("position"))) {
            code = Programs.CPP10;
        } else if ("Use CSS to set the background color of the document (body) to yellow.".equals(getIntent().getStringExtra("position"))) {
            code = Programs.HTML1;
        } else if ("Create an HTML5 page which will display names of your family member on separate lines in different sizes. State size of each line in its text.".equals(getIntent().getStringExtra("position"))) {
            code = Programs.HTML10;
        } else if ("Create an HTML5 page containing the polynomial expression as follows ao+a1x+a2x2+a3x3.".equals(getIntent().getStringExtra("position"))) {
            code = Programs.HTML2;
        }
        binding.codeView.showCode(code);
    }
}
