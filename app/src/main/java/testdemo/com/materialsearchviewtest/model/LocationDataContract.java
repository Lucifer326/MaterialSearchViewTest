package testdemo.com.materialsearchviewtest.model;

import android.provider.BaseColumns;

public class LocationDataContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public LocationDataContract() {
    }

    // Inner class defining the table contents 
    public static abstract class LocationDataEntry implements BaseColumns {

        public static final String TABLE_NAME = "tblLocationData"; // Local SQLLite table

        public static final String COLUMN_NAME_NULLABLE = null;

        // _loc is used here to avoid naming columns things like "group"
        // which is a SQL keyword
        // using _loc as a suffix so as to make column names easier to see
        // in the Android SQLite tools which somtimes cut off the column name on the display
        public static final String COLUMN_NAME_ID = "_id_loc";
        public static final String COLUMN_NAME_ADDRESS = "address_loc";
        public static final String COLUMN_NAME_ADDRESS2 = "address2_loc";
        public static final String COLUMN_NAME_CITY = "city_loc";
        public static final String COLUMN_NAME_DISPLAY = "display_loc";
        public static final String COLUMN_NAME_DIVISION = "division_loc";
        public static final String COLUMN_NAME_FAX = "fax_loc";
        public static final String COLUMN_NAME_GROUP = "group_loc"; // can't have column named group
        public static final String COLUMN_NAME_LATITUDE = "latitude_loc";
        public static final String COLUMN_NAME_LOCATION_ID = "location_id_loc";
        public static final String COLUMN_NAME_LONGITUDE = "longitude_loc";
        public static final String COLUMN_NAME_NAME = "name_loc";
        public static final String COLUMN_NAME_PHONE = "phone_loc";
        public static final String COLUMN_NAME_STATE = "state_loc";
        public static final String COLUMN_NAME_ZIP = "zip_loc";
        
    }
}
