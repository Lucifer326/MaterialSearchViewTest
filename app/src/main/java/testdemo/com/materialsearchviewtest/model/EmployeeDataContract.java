package testdemo.com.materialsearchviewtest.model;

import android.provider.BaseColumns;

public class EmployeeDataContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public EmployeeDataContract() {
    }

    // Inner class defining the table contents 
    public static abstract class EmployeeDataEntry implements BaseColumns {

        public static final String TABLE_NAME = "tblEmployeeData"; // Local SQLLite table

        public static final String COLUMN_NAME_NULLABLE = null;

        // _emp is used here to avoid naming columns things like "group" 
        // which is a SQL keyword
        // using _emp as a suffix so as to make column names easier to see
        // in the Android SQLite tools which somtimes cut off the column name on the display
        public static final String COLUMN_NAME_ID = "_id";
        public static final String COLUMN_NAME_ADDRESS = "address_emp";
        public static final String COLUMN_NAME_CELL = "cell_emp";
        public static final String COLUMN_NAME_CITY = "city_emp";
        public static final String COLUMN_NAME_DIVISION = "division_emp";
        public static final String COLUMN_NAME_EMNRDPASSID = "emnrdpassid_emp";
        public static final String COLUMN_NAME_EMAIL = "email_emp";
        public static final String COLUMN_NAME_FAX = "fax_emp";
        public static final String COLUMN_NAME_LATITUDE = "latitude_emp";
        public static final String COLUMN_NAME_LONGITUDE = "longitude_emp";
        public static final String COLUMN_NAME_NAME = "name_emp";
        public static final String COLUMN_NAME_PHONE = "phone_emp";
        public static final String COLUMN_NAME_STATE = "state_emp";
        public static final String COLUMN_NAME_TITLE = "title_emp";
        public static final String COLUMN_NAME_ZIP = "zip_emp";
        public static final String COLUMN_NAME_LOCATION = "location_emp";
        
    }
}
