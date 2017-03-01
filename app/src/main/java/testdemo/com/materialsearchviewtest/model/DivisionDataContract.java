package testdemo.com.materialsearchviewtest.model;

import android.provider.BaseColumns;

public class DivisionDataContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public DivisionDataContract() {
    }

    // Inner class defining the table contents 
    public static abstract class DivisionDataEntry implements BaseColumns {

        public static final String TABLE_NAME = "tblDivisionData"; // Local SQLLite table

        public static final String COLUMN_NAME_NULLABLE = null;

        public static final String COLUMN_NAME_ID = "_id";
        public static final String COLUMN_NAME_DIVISION_ID = "division_id";
        public static final String COLUMN_NAME_NAME = "name";

    }
}
