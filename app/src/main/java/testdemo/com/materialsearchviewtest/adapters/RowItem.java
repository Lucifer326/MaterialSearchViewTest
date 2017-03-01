package testdemo.com.materialsearchviewtest.adapters;

public class RowItem {
    public String row0;
    public String row1;
    public String row2;
    public String row3;
    public String row4;

    public RowItem(String row0) {
        this.row0 = row0;
        this.row1 = "";
        this.row2 = "";
        this.row3 = "";
    }

    public RowItem(String row0, String row1) {
        this.row0 = row0;
        this.row1 = row1;
        this.row2 = "";
        this.row3 = "";
    }

    public RowItem(String row0, String row1, String row2) {
        this.row0 = row0;
        this.row1 = row1;
        this.row2 = row2;
        this.row3 = "";
    }

    public RowItem(String row0, String row1, String row2, String row3) {
        this.row0 = row0;
        this.row1 = row1;
        this.row2 = row2;
        this.row3 = row3;
        this.row4 = "";
    }

    // row4 is used for the Divison of a Location.
    // The text of the Division is not displayed in the Location list but rather the logo is.
    public RowItem(String row0, String row1, String row2, String row3, String row4) {
        this.row0 = row0;
        this.row1 = row1;
        this.row2 = row2;
        this.row3 = row3;
        this.row4 = row4;
    }
}
