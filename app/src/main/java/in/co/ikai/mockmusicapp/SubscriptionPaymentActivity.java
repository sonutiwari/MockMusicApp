package in.co.ikai.mockmusicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class SubscriptionPaymentActivity extends AppCompatActivity {

    // Declaring global objects.
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscription_payment);
        setTitle(R.string.payment_page);

        // Getting reference of back button.
        backButton = findViewById(R.id.go_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SubscriptionPaymentActivity.this
                        , SongListActivity.class));
            }
        });


        // Enabling back navigation.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }


    // performing back navigation action.
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            startActivity(new Intent(SubscriptionPaymentActivity.this
                    , SongListActivity.class));
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
