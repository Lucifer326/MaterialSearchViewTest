package testdemo.com.materialsearchviewtest.fragments;

import java.util.EventObject;

import testdemo.com.materialsearchviewtest.model.EmployeeDataParcelable;

public class FragmentChangeEvent extends EventObject {

    private int position = 0;
    private EmployeeDataParcelable employeeDataParcelable;
    private String divisionName;
    private String locationName;
    private String version;
    private String searchString;

    public FragmentChangeEvent(Object source) {
        //super(source);
        super(new Object()); // not using source
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public EmployeeDataParcelable getEmployeeDataParcelable() {
        return employeeDataParcelable;
    }

    public void setEmployeeDataParcelable(EmployeeDataParcelable employeeDataParcelable) {
        this.employeeDataParcelable = employeeDataParcelable;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }
}
