package example.com.demo.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by mii on 11/4/16.
 */
public class FontTextView extends TextView {

    public FontTextView(Context context) {
        super(context);
        init();
    }

    public FontTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public FontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void init() {
     //   Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/roboto.regular.ttf");
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Kruti_Dev_100_Condensed.ttf");
        setTypeface(tf);

    }
}
