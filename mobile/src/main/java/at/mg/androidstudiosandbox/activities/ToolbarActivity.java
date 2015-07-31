package at.mg.androidstudiosandbox.activities;


import android.app.Fragment;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import at.mg.androidstudiosandbox.R;


public class ToolbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(getResources().getColor(android.R.color.holo_blue_dark));

        setContentView(R.layout.activity_toolbar);


        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(tb);

        ActionBar ab = getSupportActionBar();
        assert ab != null;
        ab.setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        boolean useImage1 = false;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_toolbar, container, false);

            // see https://chris.banes.me/2014/10/20/palette-v21/

            paletteTest(rootView, R.drawable.palettetest);

            final ImageView image = (ImageView) rootView.findViewById(R.id.toolbar_image);

            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    image.setImageResource(useImage1 ? R.drawable.palettetest : R.drawable.palettetest2);
                    paletteTest(rootView, useImage1 ? R.drawable.palettetest : R.drawable.palettetest2);
                    useImage1 = !useImage1;
                }
            });


            return rootView;
        }

        private void paletteTest(final View rootView, @DrawableRes int drawable) {

            new Palette.Builder(BitmapFactory.decodeResource(getResources(), drawable)).maximumColorCount(24).generate(new Palette.PaletteAsyncListener() {
                @Override
                public void onGenerated(Palette palette) {
                    Palette.Swatch swatch;
                    TextView text;

                    List<Palette.Swatch> swatches = palette.getSwatches();

                    text = (TextView) rootView.findViewById(R.id.toolbar_swatchcount);
                    text.setBackgroundColor(swatches.get(0).getRgb());
                    text.setTextColor(swatches.get(0).getTitleTextColor());
                    text.setText("swatches " + swatches.size());

                    //vibrant color
                    swatch = palette.getVibrantSwatch();
                    if (swatch != null) {
                        text = (TextView) rootView.findViewById(R.id.toolbar_vibrant);
                        text.setBackgroundColor(swatch.getRgb());
                        text.setTextColor(swatch.getTitleTextColor());
                    }

                    // light vibrant color
                    swatch = palette.getLightVibrantSwatch();
                    if (swatch != null) {
                        text = (TextView) rootView.findViewById(R.id.toolbar_lightvibrant);
                        text.setBackgroundColor(swatch.getRgb());
                        text.setTextColor(swatch.getTitleTextColor());
                    }

                    // dark vibrant color
                    swatch = palette.getDarkVibrantSwatch();
                    if (swatch != null) {
                        text = (TextView) rootView.findViewById(R.id.toolbar_darkvibrant);
                        text.setBackgroundColor(swatch.getRgb());
                        text.setTextColor(swatch.getTitleTextColor());
                    }

                    // muted color
                    swatch = palette.getMutedSwatch();
                    if (swatch != null) {
                        text = (TextView) rootView.findViewById(R.id.toolbar_muted);
                        text.setBackgroundColor(swatch.getRgb());
                        text.setTextColor(swatch.getTitleTextColor());
                    }

                    // light muted color
                    swatch = palette.getLightMutedSwatch();
                    if (swatch != null) {
                        text = (TextView) rootView.findViewById(R.id.toolbar_lightmuted);
                        text.setBackgroundColor(swatch.getRgb());
                        text.setTextColor(swatch.getTitleTextColor());
                    }

                    // dark muted color
                    swatch = palette.getDarkMutedSwatch();
                    if (swatch != null) {
                        text = (TextView) rootView.findViewById(R.id.toolbar_darkmuted);
                        text.setBackgroundColor(swatch.getRgb());
                        text.setTextColor(swatch.getTitleTextColor());
                    }
                }
            });
        }
    }


}
