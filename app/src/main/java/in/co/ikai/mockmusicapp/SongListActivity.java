package in.co.ikai.mockmusicapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import in.co.ikai.mockmusicapp.adapters.SongListAdapter;
import in.co.ikai.mockmusicapp.dataModels.SongDetails;
import in.co.ikai.mockmusicapp.utilities.RecyclerTouchListener;

public class SongListActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    // Global objects.
    private SongListAdapter mAdapter;
    private ArrayList<SongDetails> songDetailsArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.song_library);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SongListActivity.this, SongPlayActivity.class));
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

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
                        startActivity(new Intent(SongListActivity.this
                                , SongPlayActivity.class));
                    }

                    @Override
                    public void onLongClick(View view, int position) {

                    }
                }));

        prepareMovieData();

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

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.song_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_my_play_list) {
            startActivity(new Intent(SongListActivity.this
                    , MyPlayListActivity.class));
        } else if (id == R.id.nav_favorite) {
            startActivity(new Intent(SongListActivity.this
                    , FavoriteSongsActivity.class));
        } else if (id == R.id.nav_newly_added) {
            startActivity(new Intent(SongListActivity.this
                    , NewlyAddedSongsActivity.class));
        } else if (id == R.id.nav_most_played) {
            startActivity(new Intent(SongListActivity.this
                    , MostPlayedSongsActivity.class));
        } else if (id == R.id.nav_share) {
            String sharePath = Environment.getExternalStorageDirectory().getPath()
                    + "Soundboard/Ringtones/xyz.mp3";
            Uri uri = Uri.parse(sharePath);
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("audio/*");
            intent.putExtra(Intent.EXTRA_STREAM, uri);
            startActivity(Intent.createChooser(intent, "Share this song"));

        } else if (id == R.id.subscription) {
            startActivity(new Intent(SongListActivity.this
                    , SubscriptionPaymentActivity.class));
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
