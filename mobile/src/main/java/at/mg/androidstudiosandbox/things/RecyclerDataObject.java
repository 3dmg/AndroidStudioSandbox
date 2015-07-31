package at.mg.androidstudiosandbox.things;

import android.support.annotation.Nullable;

/**
 * dataobject for the RecyclerView
 * <p/>
 * Created by Markus on 12.12.2014.
 */
public class RecyclerDataObject {

    @Nullable
    public final String title;
    @Nullable
    public final String description;
    @Nullable
    public final String date;

    public RecyclerDataObject(@Nullable String title, @Nullable String description, @Nullable String date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }


}
