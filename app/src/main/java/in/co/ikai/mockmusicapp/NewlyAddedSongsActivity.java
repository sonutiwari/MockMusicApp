package in.co.ikai.mockmusicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import in.co.ikai.mockmusicapp.adapters.SongListAdapter;
import in.co.ikai.mockmusicapp.dataModels.SongDetails;
import in.co.ikai.mockmusicapp.utilities.RecyclerTouchListener;

public class NewlyAddedSongsActivity extends AppCompatActivity {

    // Global objects.
    private SongListAdapter mAdapter;
    private ArrayList<SongDetails> songDetailsArrayList = new ArrayList<>();
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newly_added_songs);

        setTitle(R.string.newly_added_songs);

        // Getting reference of recycler view.
        RecyclerView songListRecyclerView = findViewById(R.id.song_list_recycler_view);

        mAdapter = new SongListAdapter(songDetailsArrayList);
        RecyclerView.LayoutManager mLayoutManager =
                new LinearLayoutManager(getApplicationContext());
        songListRecyclerView.setLayoutManager(mLayoutManager);
        songListRecyclerView.setItemAnimator(new DefaultItemAnimator());
        songListRecyclerView.addItemDecoration(new DividerItemDecoration(this
                , LinearLayoutManager.VERTICAL));
        songListRecyclerView.setAdapter(mAdapter);

        songListRecyclerView.addOnItemTouchListener(
                new RecyclerTouchListener(getApplicationContext()
                        , songListRecyclerView, new RecyclerTouchListener.ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        startActivity(new Intent(NewlyAddedSongsActivity.this
                                , SongPlayActivity.class));
                    }

                    @Override
                    public void onLongClick(View view, int position) {

                    }
                }));

        prepareMovieData();

        // Getting reference of back button.
        backButton = findViewById(R.id.go_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NewlyAddedSongsActivity.this
                        , SongListActivity.class));
            }
        });

        // Enabling back navigation.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }

    private void prepareMovieData() {
        SongDetails song = new SongDetails("O O Jane jana", "Udit Narayan"
                , "6 Min");
        songDetailsArrayList.add(song);

        song = new SongDetails("O O Jane jana", "Udit Narayan"
                , "6 Min");
        songDetailsArrayList.add(song);

        song = new SongDetails("O O Jane jana", "Udit Narayan"
                , "6 Min");
        songDetailsArrayList.add(song);

        song = new SongDetails("O O Jane jana", "Udit Narayan"
                , "6 Min");
        songDetailsArrayList.add(song);

        song = new SongDetails("O O Jane jana", "Udit Narayan"
                , "6 Min");
        songDetailsArrayList.add(song);

        song = new SongDetails("O O Jane jana", "Udit Narayan"
                , "6 Min");
        songDetailsArrayList.add(song);

        song = new SongDetails("O O Jane jana", "Udit Narayan"
                , "6 Min");
        songDetailsArrayList.add(song);

        song = new SongDetails("O O Jane jana", "Udit Narayan"
                , "6 Min");
        songDetailsArrayList.add(song);

        song = new SongDetails("O O Jane jana", "Udit Narayan"
                , "6 Min");
        songDetailsArrayList.add(song);

        song = new SongDetails("O O Jane jana", "Udit Narayan"
                , "6 Min");
        songDetailsArrayList.add(song);

        song = new SongDetails("O O Jane jana", "Udit Narayan"
                , "6 Min");
        songDetailsArrayList.add(song);

        song = new SongDetails("O O Jane jana", "Udit Narayan"
                , "6 Min");
        songDetailsArrayList.add(song);

        song = new SongDetails("O O Jane jana", "Udit Narayan"
                , "6 Min");
        songDetailsArrayList.add(song);

        mAdapter.notifyDataSetChanged();
    }

    // performing back navigation action.
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            startActivity(new Intent(NewlyAddedSongsActivity.this
                    , SongListActivity.class));
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
