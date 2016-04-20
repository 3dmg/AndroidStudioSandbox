package at.mg.androidstudiosandbox.fragments;

import android.animation.Animator;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.ColorUtils;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;

import java.util.concurrent.TimeUnit;

import at.mg.androidstudiosandbox.R;
import at.mg.androidstudiosandbox.activities.CoordinatorActivity;
import at.mg.androidstudiosandbox.activities.PaletteActivity;
import rx.Subscription;


/**
 * A placeholder fragment containing a simple view.
 */
public class HomeFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static HomeFragment newInstance(int sectionNumber) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        final TextView textView = (TextView) rootView.findViewById(R.id.home_text);
        //set the elevation in code; in pixel
        ViewCompat.setElevation(textView, 40);
//        textView.setElevation(50);

        TextView newtext = new TextView(getActivity());
        newtext.setText("FLY IN");

        textView.post(() -> {
            if (textView.isAttachedToWindow()) {
                Animator reveal = ViewAnimationUtils.createCircularReveal(
                        textView, // The new View to reveal
                        0,      // x co-ordinate to start the mask from
                        0,      // y co-ordinate to start the mask from
                        0,  // radius of the starting mask
                        180);   // radius of the final mask
                reveal.start();
            }
        });


        final View image = rootView.findViewById(R.id.home_image);
        image.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), PaletteActivity.class);
            String transitionName = getString(R.string.transition_image);
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), image, transitionName);
            ActivityCompat.startActivity(getActivity(), intent, optionsCompat.toBundle());
        });


        Button button = (Button) rootView.findViewById(R.id.home_button);
        button.setOnClickListener(v -> startActivity(new Intent(getContext(), CoordinatorActivity.class)));

        View rxButton = rootView.findViewById(R.id.home_rxbutton);
        Subscription subscribe = RxView.clicks(rxButton).subscribe(o -> Log.i("RX", "button clicked"), oe -> Log.e("RX", "onerror"));
        subscribe.unsubscribe();

        EditText editText = (EditText) rootView.findViewById(R.id.home_edit);
        RxTextView.textChangeEvents(editText).debounce(1, TimeUnit.SECONDS).subscribe(textViewTextChangeEvent -> Log.i("RX", textViewTextChangeEvent.text().toString()));

        int buttonColor = Color.BLACK;
        TypedValue a = new TypedValue();
        getActivity().getTheme().resolveAttribute(R.attr.colorButtonNormal, a, true);
        if (a.type >= TypedValue.TYPE_FIRST_COLOR_INT && a.type <= TypedValue.TYPE_LAST_COLOR_INT) {
            buttonColor = a.data;
        }

        int minAlpha = ColorUtils.calculateMinimumAlpha(Color.BLACK, buttonColor, 4.5f);
        Log.i("PF", "minAlpha: " + minAlpha);
        if (minAlpha != -1) {
            button.setTextColor(ColorUtils.setAlphaComponent(Color.BLACK, minAlpha));
        }

        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setOnClickListener(v -> {
            Resources r = getResources();
            AlertDialog alertDialog = new AlertDialog.Builder(getActivity(), R.style.AppCompatAlertDialogStyle).setTitle(r.getString(R.string.dialog_title))
                    .setMessage(r.getString(R.string.dialog_message)).setPositiveButton(r.getString(R.string.dialog_pos), null)
                    .setNegativeButton(r.getString(R.string.dialog_neg), null).setNeutralButton(r.getString(R.string.dialog_neutr), null).create();
            alertDialog.show();
        });

        return rootView;
    }
}
