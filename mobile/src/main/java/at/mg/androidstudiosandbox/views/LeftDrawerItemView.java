package at.mg.androidstudiosandbox.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import at.mg.androidstudiosandbox.R;

/**
 * navigation drawer menu item
 */
public class LeftDrawerItemView extends RelativeLayout {

    public LeftDrawerItemView(Context context) {
        this(context, null);
    }

    public LeftDrawerItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LeftDrawerItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        // Read custom parameters...
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.LeftDrawerItem, 0, 0);

        String text;
        Drawable image;
        try {
            text = a.getString(R.styleable.LeftDrawerItem_text);
            image = a.getDrawable(R.styleable.LeftDrawerItem_image);
        } finally {
            a.recycle();
        }


        this.setClickable(true);
        this.setFocusable(true);

        // Fill view with provided data
        LayoutInflater li = LayoutInflater.from(context);
        LeftDrawerItemView leftdraweritem = (LeftDrawerItemView) li.inflate(R.layout.view_leftdrawer_item, this);
        ImageView imageView = (ImageView) leftdraweritem.findViewById(R.id.leftdrawer_img);
        imageView.setImageDrawable(image);
        TextView textView = (TextView) leftdraweritem.findViewById(R.id.leftdrawer_text);
        textView.setText(text);

    }

}
