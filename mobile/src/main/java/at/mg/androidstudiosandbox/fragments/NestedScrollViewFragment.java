package at.mg.androidstudiosandbox.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import at.mg.androidstudiosandbox.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NestedScrollViewFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NestedScrollViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NestedScrollViewFragment extends Fragment {

    public NestedScrollViewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment NestedScrollViewFragment.
     */
    public static NestedScrollViewFragment newInstance() {
        NestedScrollViewFragment fragment = new NestedScrollViewFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nested_scroll_view, container, false);
    }

}
