package at.mg.androidstudiosandbox.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;

import at.mg.androidstudiosandbox.R;


public class CoordinatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TypedValue typedValue = new TypedValue();
        this.getTheme().resolveAttribute(R.attr.colorPrimaryDark, typedValue, true);
        final int color = typedValue.data;

        getWindow().setStatusBarColor(color);
        setContentView(R.layout.activity_coordinator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

}
