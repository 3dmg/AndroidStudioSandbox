package at.mg.androidstudiosandbox.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import at.mg.androidstudiosandbox.R;
import at.mg.androidstudiosandbox.things.RecyclerDataObject;
import at.mg.androidstudiosandbox.things.RecyclerListViewHolder;

/**
 * Adapter for the RecyclerView
 * <p/>
 * Created by Markus on 12.12.2014.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerListViewHolder> {

    private List<RecyclerDataObject> list;

    public RecyclerAdapter(List<RecyclerDataObject> list) {
        this.list = list;
    }

    @Override
    public RecyclerListViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View entry = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_entry, viewGroup, false);
        return new RecyclerListViewHolder(entry);
    }

    @Override
    public void onBindViewHolder(RecyclerListViewHolder recyclerListViewHolder, int position) {
        RecyclerDataObject object = list.get(position);
        recyclerListViewHolder.title.setText(object.title);
        recyclerListViewHolder.desc.setText(object.description);
        recyclerListViewHolder.date.setText(object.date);
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }


    public void insertItem(int position, RecyclerDataObject dataObject) {
        list.add(position, dataObject);
        notifyItemInserted(position);
//        notifyItemRangeInserted(position, 10);
    }


    public void removeItem(int position) {
        list.remove(position);
        notifyItemRemoved(position);
//        notifyItemRangeRemoved(position, 10);
    }

    public void moveItem(int from, int to) {
        notifyItemMoved(from, to);
    }
}
