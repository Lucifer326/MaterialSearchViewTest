package testdemo.com.materialsearchviewtest.adapters;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import testdemo.com.materialsearchviewtest.R;

// RowItemView has 4 rows
// This class has 3, combining rows 1 & 2 into one
public class ThreeRowsItemView extends GridLayout {

    private TextView row0;
    private TextView row1;
    private TextView row2;
    private ImageView image;

    public ThreeRowsItemView(Context context) {
        super(context);
    }

    public ThreeRowsItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ThreeRowsItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        image = (ImageView) findViewById(R.id.logo);

        row0 = (TextView) findViewById(R.id.row0);
        row1 = (TextView) findViewById(R.id.row1);
        row2 = (TextView) findViewById(R.id.row2);

    }

    // Not sure what toString() is used for, yet
    @Override
    public String toString() {
        return row0.getText() + "," + row1.getText() + "," + row2.getText();
    }


//    @Override
//    public String toString() {
//        return row0.getText() + "v" + row1.getText()
//                + ": " + getLeft() + "," + getTop()
//                + ": " + getMeasuredWidth() + "x" + getMeasuredHeight();
//    }
}
