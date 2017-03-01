package testdemo.com.materialsearchviewtest.adapters;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridLayout;
import android.widget.TextView;

import testdemo.com.materialsearchviewtest.R;

public class RowItemView extends GridLayout {

    private TextView row0;
    private TextView row1;
    private TextView row2;
    private TextView row3;

    public RowItemView(Context context) {
        super(context);
    }

    public RowItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RowItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        row0 = (TextView) findViewById(R.id.row0);
        row1 = (TextView) findViewById(R.id.row1);
        row2 = (TextView) findViewById(R.id.row2);
        row3 = (TextView) findViewById(R.id.row3);
    }

    // Not sure what toString() is used for, yet
    @Override
    public String toString() {
        return row0.getText() + "," + row1.getText() + row2.getText() + "," + row3.getText();
    }


//    @Override
//    public String toString() {
//        return row0.getText() + "v" + row1.getText()
//                + ": " + getLeft() + "," + getTop()
//                + ": " + getMeasuredWidth() + "x" + getMeasuredHeight();
//    }
}
