package in.icomputercoding.computercoding;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import in.icomputercoding.computercoding.databinding.PdfViewerBinding;


public class PdfViewer extends AppCompatActivity {

    String C, Java, CPP, HTML5;
    PdfViewerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = PdfViewerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        C = getIntent().getStringExtra("CProgramming");
        Java = getIntent().getStringExtra("JavaProgramming");
        CPP = getIntent().getStringExtra("CPPProgramming");
        HTML5 = getIntent().getStringExtra("HTML5Programming");



        if ("Chapter 1".equals(C)) {
            binding.pdfView.fromAsset("Chapter1_C.pdf").load();
        } else if ("Chapter 2".equals(C)) {
            binding.pdfView.fromAsset("Chapter2_C.pdf").load();
        } else if ("Chapter 3".equals(C)) {
            binding.pdfView.fromAsset("Chapter3_C.pdf").load();
        } else if ("Chapter 4".equals(C)) {
            binding.pdfView.fromAsset("Chapter4_C.pdf").load();
        } else if ("Chapter 5".equals(C)) {
            binding.pdfView.fromAsset("Chapter5_C.pdf").load();
        } else if ("Chapter 6".equals(C)) {
            binding.pdfView.fromAsset("Chapter6_C.pdf").load();
        } else if ("Chapter 7".equals(C)) {
            binding.pdfView.fromAsset("Chapter7_C.pdf").load();
        } else if ("Chapter 8".equals(C)) {
            binding.pdfView.fromAsset("Chapter8_C.pdf").load();
        } else if ("Chapter 1".equals(CPP)) {
            binding.pdfView.fromAsset("Chapter1_CPP.pdf").load();
        } else if ("Chapter 2".equals(CPP)) {
            binding.pdfView.fromAsset("Chapter2_CPP.pdf").load();
        } else if ("Chapter 3".equals(CPP)) {
            binding.pdfView.fromAsset("Chapter3_CPP.pdf").load();
        } else if ("Chapter 4".equals(CPP)) {
            binding.pdfView.fromAsset("Chapter4_CPP.pdf").load();
        } else if ("Chapter 5".equals(CPP)) {
            binding.pdfView.fromAsset("Chapter5_CPP.pdf").load();
        } else if ("Chapter 6".equals(CPP)) {
            binding.pdfView.fromAsset("Chapter6_CPP.pdf").load();
        } else if ("Chapter 7".equals(CPP)) {
            binding.pdfView.fromAsset("Chapter7_CPP.pdf").load();
        } else if ("Chapter 8".equals(CPP)) {
            binding.pdfView.fromAsset("Chapter8_CPP.pdf").load();
        } else if ("Chapter 9".equals(CPP)) {
            binding.pdfView.fromAsset("Chapter9_CPP.pdf").load();
        } else if ("Chapter 1".equals(Java)) {
            binding.pdfView.fromAsset("Chapter1_Java.pdf").load();
        } else if ("Chapter 2".equals(Java)) {
            binding.pdfView.fromAsset("Chapter2_Java.pdf").load();
        } else if ("Chapter 3".equals(Java)) {
            binding.pdfView.fromAsset("Chapter3_Java.pdf").load();
        } else if ("Chapter 4".equals(Java)) {
            binding.pdfView.fromAsset("Chapter4_Java.pdf").load();
        } else if ("Chapter 5".equals(Java)) {
            binding.pdfView.fromAsset("Chapter5_Java.pdf").load();
        } else if ("Chapter 6".equals(Java)) {
            binding.pdfView.fromAsset("Chapter6_Java.pdf").load();
        } else if ("Chapter 7".equals(Java)) {
            binding.pdfView.fromAsset("Chapter7_Java.pdf").load();
        } else if ("Chapter 1".equals(HTML5)) {
            binding.pdfView.fromAsset("Chapter1_HTML.pdf").load();
        } else if ("Chapter 2".equals(HTML5)) {
            binding.pdfView.fromAsset("Chapter2_HTML.pdf").load();
        } else if ("Chapter 3".equals(HTML5)) {
            binding.pdfView.fromAsset("Chapter3_HTML.pdf").load();
        } else if ("Chapter 4".equals(HTML5)) {
            binding.pdfView.fromAsset("Chapter4_HTML.pdf").load();
        } else if ("Chapter 5".equals(HTML5)) {
            binding.pdfView.fromAsset("Chapter5_HTML.pdf").load();
        } else if ("Chapter 6".equals(HTML5)) {
            binding.pdfView.fromAsset("Chapter6_HTML.pdf").load();
        } else if ("Chapter 7".equals(HTML5)) {
            binding.pdfView.fromAsset("Chapter7_HTML.pdf").load();
        }



    }


}