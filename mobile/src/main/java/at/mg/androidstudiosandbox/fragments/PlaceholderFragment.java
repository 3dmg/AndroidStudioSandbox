package at.mg.androidstudiosandbox.fragments;

import android.animation.Animator;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import at.mg.androidstudiosandbox.R;
import at.mg.androidstudiosandbox.activities.HomeActivity;
import at.mg.androidstudiosandbox.activities.ToolbarActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public PlaceholderFragment() {
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

        textView.post(new Runnable() {
            @Override
            public void run() {
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

        Button button = (Button) rootView.findViewById(R.id.home_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ToolbarActivity.class);
                String transitionName = getString(R.string.transition_image);
//                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), image, transitionName);
//                ActivityCompat.startActivity(getActivity(), intent, optionsCompat);
                ActivityOptions optionsCompat = ActivityOptions.makeSceneTransitionAnimation(getActivity(), image, transitionName);
                startActivity(intent, optionsCompat.toBundle());
            }
        });

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((HomeActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }


}
