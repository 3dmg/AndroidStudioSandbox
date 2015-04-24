package at.mg.androidstudiosandbox.things;

/**
 * dataobject for the RecyclerView
 * <p/>
 * Created by Markus on 12.12.2014.
 */
public class RecyclerDataObject {

    public RecyclerDataObject(String title, String description, String date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public final String title;
    public final String description;
    public final String date;
}
