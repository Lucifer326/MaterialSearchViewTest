package testdemo.com.materialsearchviewtest.model;

import android.os.Parcel;
import android.os.Parcelable;

public class EmployeeListRestrictionsParcelable implements Parcelable {

    public final static String BUNDLE_KEY = "EmployeeListRestrictionsParcelable";

    // if location and division are "", then display all
    private String location;
    private String division;
    private String search; // the search string, if any

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(this.location);
        dest.writeString(this.division);
        dest.writeString(this.search);
    }

    public EmployeeListRestrictionsParcelable() {
        location = "";
        division = "";
        search = "";
    }

    protected EmployeeListRestrictionsParcelable(Parcel in) {
        this.location = in.readString();
        this.division = in.readString();
        this.search = in.readString();
    }

    public static final Creator<EmployeeListRestrictionsParcelable> CREATOR = new Creator<EmployeeListRestrictionsParcelable>() {
        @Override
        public EmployeeListRestrictionsParcelable createFromParcel(Parcel source) {
            return new EmployeeListRestrictionsParcelable(source);
        }

        @Override
        public EmployeeListRestrictionsParcelable[] newArray(int size) {
            return new EmployeeListRestrictionsParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
