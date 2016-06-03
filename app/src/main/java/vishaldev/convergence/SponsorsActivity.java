package vishaldev.convergence;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class SponsorsActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsors);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("SPONSORS");
        mToolbar.setTitleTextColor(Color.WHITE);

        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.drawable.backnew);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
    public void onBackPressed() {
        super.onBackPressed();

    }

}
