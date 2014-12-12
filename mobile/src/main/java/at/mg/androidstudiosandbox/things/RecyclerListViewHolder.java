package at.mg.androidstudiosandbox.things;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import at.mg.androidstudiosandbox.R;

/**
 * ViewHolder for the RecyclerView
 * <p/>
 * Created by Markus on 12.12.2014.
 */
public class RecyclerListViewHolder extends RecyclerView.ViewHolder {

    public TextView title, desc, date;

    public RecyclerListViewHolder(View itemView) {
        super(itemView);

        title = (TextView) itemView.findViewById(R.id.recentry_title);
        desc = (TextView) itemView.findViewById(R.id.recentry_desc);
        date = (TextView) itemView.findViewById(R.id.recentry_date);

    }
}
