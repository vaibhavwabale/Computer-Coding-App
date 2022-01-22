package in.icomputercoding.computercoding.Languages;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import in.icomputercoding.computercoding.PdfViewer;
import in.icomputercoding.computercoding.databinding.ActivityCscreenBinding;

public class CScreen extends AppCompatActivity {

    ActivityCscreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCscreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        String[] pdfFiles = {"Chapter 1", "Chapter 2", "Chapter 3", "Chapter 4", "Chapter 5", "Chapter 6", "Chapter 7", "Chapter 8"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pdfFiles) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                return super.getView(position, convertView, parent);
            }
        };


        binding.PdfList.setAdapter(adapter);

        binding.PdfList.setOnItemClickListener((parent, view, position, id) -> {
            String item = binding.PdfList.getItemAtPosition(position).toString();

            Intent i = new Intent(CScreen.this, PdfViewer.class);
            i.putExtra("CProgramming", item);
            startActivity(i);
        });

    }
}
