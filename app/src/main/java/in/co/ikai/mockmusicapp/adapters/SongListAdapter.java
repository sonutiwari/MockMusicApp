package in.co.ikai.mockmusicapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import in.co.ikai.mockmusicapp.R;
import in.co.ikai.mockmusicapp.dataModels.SongDetails;

public class SongListAdapter extends RecyclerView.Adapter<SongListAdapter.SongViewHolder> {
    // Declaring global objects.
    private List<SongDetails> songDetailsList;

    // Constructor.
    public SongListAdapter(final List<SongDetails> songDetailsList) {
        this.songDetailsList = songDetailsList;
    }

    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_song_row_view, parent, false);

        return new SongViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SongViewHolder holder, int position) {
        SongDetails songDetails = songDetailsList.get(position);
        holder.title.setText(songDetails.getSongName());
        holder.genre.setText(songDetails.getSingerName());
        holder.year.setText(songDetails.getDuration());

    }


    @Override
    public int getItemCount() {
        return songDetailsList.size();
    }

    public class SongViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;

        public SongViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            genre = view.findViewById(R.id.singer);
            year = view.findViewById(R.id.duration);
        }
    }
}
