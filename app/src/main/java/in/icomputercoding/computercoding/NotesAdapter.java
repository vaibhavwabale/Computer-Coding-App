package in.icomputercoding.computercoding;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;


public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {


    private Context context;

    private List<Notes> notesList;


    public NotesAdapter(Context context, List<Notes> notesList) {
        this.context = context;
        this.notesList = notesList;
    }

    @Override
    public NotesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_notes, null);
        return new NotesViewHolder(view);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onBindViewHolder(NotesViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        final Notes notes = notesList.get(position);


        holder.textViewTitle.setText(notes.getTitle());

        holder.cardView.setOnClickListener(v -> {

            Intent i = new Intent(v.getContext(), PdfViewer.class);
            i.putExtra("title", notesList.get(position).getTitle());
            i.putExtra("notes", notesList.get(position).getTitle());
            i.putExtra("link", notesList.get(position).getLink());
            context.startActivity(i);

        });
    }


    @Override
    public int getItemCount() {
        return notesList.size();
    }


    class NotesViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle;
        RelativeLayout cardView;

        public NotesViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardview);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
        }
    }
}