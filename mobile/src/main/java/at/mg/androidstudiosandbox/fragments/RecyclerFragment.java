package at.mg.androidstudiosandbox.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import at.mg.androidstudiosandbox.R;
import at.mg.androidstudiosandbox.adapters.RecyclerAdapter;
import at.mg.androidstudiosandbox.things.RecyclerDataObject;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecyclerFragment#newInstance} factory method to
 * create an instance of this fragment.
 * created with the new fragment wizard
 */
public class RecyclerFragment extends Fragment {

    private RecyclerAdapter adapter;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment RecyclerFragment.
     */
    public static RecyclerFragment newInstance() {
        RecyclerFragment fragment = new RecyclerFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }

    public RecyclerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);

        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);


//        final StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(staggeredGridLayoutManager);


        // allows for optimizations if all item views are of the same size:
        recyclerView.setHasFixedSize(true);

        adapter = new RecyclerAdapter(generateDataList());
        recyclerView.setAdapter(adapter);


// onClickDetection is done in this Activity's OnItemTouchListener
// with the help of a GestureDetector;
// Tip by Ian Lake on G+ in a comment to this post:
// https://plus.google.com/+LucasRocha/posts/37U8GWtYxDE
//        recyclerView.addOnItemTouchListener(this);
//        gesturedetector =
//                new GestureDetectorCompat(this, new RecyclerViewDemoOnGestureListener());


        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
                Log.i("", "onTouchEvent " + e.getAction());
            }
        });


        recyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.insertItem(3, new RecyclerDataObject("Neu", "neueneu", "27.02.2015"));
            }
        }, 500);

        recyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.removeItem(5);
            }
        }, 2000);

//        recyclerView.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                adapter.moveItem(1, 5);
//            }
//        }, 2500);
//
        recyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                final GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
                recyclerView.setLayoutManager(gridLayoutManager);
                adapter.notifyDataSetChanged();
            }
        }, 3000);


        return view;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
//        try {
//            mListener = (OnFragmentInteractionListener) activity;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(activity.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private List<RecyclerDataObject> generateDataList() {
        List<RecyclerDataObject> list = new ArrayList<>(200);
        for (int i = 0; i < 200; i++) {
            RecyclerDataObject dataObject = new RecyclerDataObject(random(15), random(20), random(10));

            list.add(dataObject);
        }
        return list;
    }

    public static String random(int length) {
        char[] chars1 = "ABCDEF012GHIJKL345MNOPQR678STUVWXYZ9".toCharArray();
        StringBuilder sb1 = new StringBuilder();
        Random random1 = new Random();
        length = random1.nextInt(length);
        for (int i = 0; i < length; i++) {
            char c1 = chars1[random1.nextInt(chars1.length)];
            sb1.append(c1);
        }
        return sb1.toString();
    }

}
