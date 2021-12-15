package in.icomputercoding.computercoding;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;



public class PdfViewer extends AppCompatActivity {

    PDFView pdfView;
    String C, Java, CPP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf_viewer);

        pdfView = findViewById(R.id.pdfView);



        C = getIntent().getStringExtra("CProgramming");
        Java = getIntent().getStringExtra("JavaProgramming");
        CPP = getIntent().getStringExtra("CPPProgramming");


        if ("Chapter 1".equals(C)) {
            pdfView.fromAsset("Chapter1_C.pdf").load();
        } else if ("Chapter 2".equals(C)) {
            pdfView.fromAsset("Chapter2_C.pdf").load();
        } else if ("Chapter 3".equals(C)) {
            pdfView.fromAsset("Chapter3_C.pdf").load();
        } else if ("Chapter 4".equals(C)) {
            pdfView.fromAsset("Chapter4_C.pdf").load();
        } else if ("Chapter 5".equals(C)) {
            pdfView.fromAsset("Chapter5_C.pdf").load();
        } else if ("Chapter 6".equals(C)) {
            pdfView.fromAsset("Chapter6_C.pdf").load();
        } else if ("Chapter 7".equals(C)) {
            pdfView.fromAsset("Chapter7_C.pdf").load();
        } else if ("Chapter 8".equals(C)) {
            pdfView.fromAsset("Chapter8_C.pdf").load();
        } else if ("Chapter 1".equals(CPP)) {
            pdfView.fromAsset("Chapter1_CPP.pdf").load();
        } else if ("Chapter 2".equals(CPP)) {
            pdfView.fromAsset("Chapter2_CPP.pdf").load();
        } else if ("Chapter 3".equals(CPP)) {
            pdfView.fromAsset("Chapter3_CPP.pdf").load();
        } else if ("Chapter 4".equals(CPP)) {
            pdfView.fromAsset("Chapter4_CPP.pdf").load();
        } else if ("Chapter 5".equals(CPP)) {
            pdfView.fromAsset("Chapter5_CPP.pdf").load();
        } else if ("Chapter 6".equals(CPP)) {
            pdfView.fromAsset("Chapter6_CPP.pdf").load();
        } else if ("Chapter 7".equals(CPP)) {
            pdfView.fromAsset("Chapter7_CPP.pdf").load();
        } else if ("Chapter 8".equals(CPP)) {
            pdfView.fromAsset("Chapter8_CPP.pdf").load();
        } else if ("Chapter 9".equals(CPP)) {
            pdfView.fromAsset("Chapter9_CPP.pdf").load();
        } else if ("Chapter 1".equals(Java)) {
            pdfView.fromAsset("Chapter1_Java.pdf").load();
        } else if ("Chapter 2".equals(Java)) {
            pdfView.fromAsset("Chapter2_Java.pdf").load();
        } else if ("Chapter 3".equals(Java)) {
            pdfView.fromAsset("Chapter3_Java.pdf").load();
        } else if ("Chapter 4".equals(Java)) {
            pdfView.fromAsset("Chapter4_Java.pdf").load();
        } else if ("Chapter 5".equals(Java)) {
            pdfView.fromAsset("Chapter5_Java.pdf").load();
        } else if ("Chapter 6".equals(Java)) {
            pdfView.fromAsset("Chapter6_Java.pdf").load();
        } else if ("Chapter 7".equals(Java)) {
            pdfView.fromAsset("Chapter7_Java.pdf").load();
        }


    }


}