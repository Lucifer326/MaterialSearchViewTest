package testdemo.com.materialsearchviewtest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class EmployeeGeneratedData {

    // manual
    public static final int ID_INDEX = 0;
    public static final int ADDRESS_INDEX = 1;
    public static final int CELL_INDEX = 2;
    public static final int CITY_INDEX = 3;
    public static final int DIVISION_INDEX = 4;
    public static final int EMNRD_PASS_ID_INDEX = 5;
    public static final int EMAIL_INDEX = 6;
    public static final int FAX_INDEX = 7;
    public static final int LATITUDE_INDEX = 8;
    public static final int LONGITUDE_INDEX = 9;
    public static final int NAME_INDEX = 10;
    public static final int PHONE_INDEX = 11;
    public static final int STATE_INDEX = 12;
    public static final int TITLE_INDEX = 13;
    public static final int ZIP_INDEX = 14;
    public static final int LOCATION_INDEX = 15;

    public static final String JSON_EMPLOYEE_ID = "Id";
    public static final String JSON_EMPLOYEE_ADDRESS = "Address";
    public static final String JSON_EMPLOYEE_CELL = "Cell";
    public static final String JSON_EMPLOYEE_CITY = "City";
    public static final String JSON_EMPLOYEE_DIVISION = "Division";
    public static final String JSON_EMPLOYEE_EMNRDPassID = "EMNRDPassID";
    public static final String JSON_EMPLOYEE_EMAIL = "EmailAddress";
    public static final String JSON_EMPLOYEE_FAX = "Fax";
    public static final String JSON_EMPLOYEE_LATITUDE = "Latitude";
    public static final String JSON_EMPLOYEE_LONGITUDE = "Longitude";
    public static final String JSON_EMPLOYEE_NAME = "Name";
    public static final String JSON_EMPLOYEE_PHONE = "Phone";
    public static final String JSON_EMPLOYEE_STATE = "State";
    public static final String JSON_EMPLOYEE_TITLE = "Title";
    public static final String JSON_EMPLOYEE_ZIP = "Zip";
    public static final String JSON_EMPLOYEE_LOCATION = "Location";

    public static final String NOBODY = "Nobody Nowhere";

    public EmployeeGeneratedData() {
        Id = 0;
        eMNRDPassID = 0;
        name = NOBODY;
    }

    // manual
    @SerializedName("Id")
    @Expose
    public int Id;

    /**
     *
     * @return
     * The name
     */
    public int getId() {
        return Id;
    }

    /**
     *
     * @param id
     * The Name
     */
    public void setId(int id) {
        this.Id = id;
    }

        // generated
        @SerializedName("EMNRDPassID")
        @Expose
        private Integer eMNRDPassID;
        @SerializedName("Name")
        @Expose
        private String name;
        @SerializedName("Cell")
        @Expose
        private String cell;
        @SerializedName("Title")
        @Expose
        private String title;
        @SerializedName("EmailAddress")
        @Expose
        private String emailAddress;
        @SerializedName("Division")
        @Expose
        private String division;
        @SerializedName("Location")
        @Expose
        private String location;
        @SerializedName("Phone")
        @Expose
        private String phone;
        @SerializedName("Fax")
        @Expose
        private String fax;
        @SerializedName("Address")
        @Expose
        private String address;
        @SerializedName("City")
        @Expose
        private String city;
        @SerializedName("State")
        @Expose
        private String state;
        @SerializedName("Zip")
        @Expose
        private String zip;
        @SerializedName("Latitude")
        @Expose
        private Double latitude;
        @SerializedName("Longitude")
        @Expose
        private Double longitude;

        /**
         *
         * @return
         * The eMNRDPassID
         */
        public Integer getEMNRDPassID() {
            return eMNRDPassID;
        }

        /**
         *
         * @param eMNRDPassID
         * The EMNRDPassID
         */
        public void setEMNRDPassID(Integer eMNRDPassID) {
            this.eMNRDPassID = eMNRDPassID;
        }

        /**
         *
         * @return
         * The name
         */
        public String getName() {
            return name;
        }

        /**
         *
         * @param name
         * The Name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         *
         * @return
         * The cell
         */
        public String getCell() {
            return cell;
        }

        /**
         *
         * @param cell
         * The Cell
         */
        public void setCell(String cell) {
            this.cell = cell;
        }

        /**
         *
         * @return
         * The title
         */
        public String getTitle() {
            return title;
        }

        /**
         *
         * @param title
         * The Title
         */
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         *
         * @return
         * The emailAddress
         */
        public String getEmailAddress() {
            return emailAddress;
        }

        /**
         *
         * @param emailAddress
         * The EmailAddress
         */
        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }

        /**
         *
         * @return
         * The division
         */
        public String getDivision() {
            return division;
        }

        /**
         *
         * @param division
         * The Division
         */
        public void setDivision(String division) {
            this.division = division;
        }

        /**
         *
         * @return
         * The location
         */
        public String getLocation() {
            return location;
        }

        /**
         *
         * @param location
         * The Location
         */
        public void setLocation(String location) {
            this.location = location;
        }

        /**
         *
         * @return
         * The phone
         */
        public String getPhone() {
            return phone;
        }

        /**
         *
         * @param phone
         * The Phone
         */
        public void setPhone(String phone) {
            this.phone = phone;
        }

        /**
         *
         * @return
         * The fax
         */
        public String getFax() {
            return fax;
        }

        /**
         *
         * @param fax
         * The Fax
         */
        public void setFax(String fax) {
            this.fax = fax;
        }

        /**
         *
         * @return
         * The address
         */
        public String getAddress() {
            return address;
        }

        /**
         *
         * @param address
         * The Address
         */
        public void setAddress(String address) {
            this.address = address;
        }

        /**
         *
         * @return
         * The city
         */
        public String getCity() {
            return city;
        }

        /**
         *
         * @param city
         * The City
         */
        public void setCity(String city) {
            this.city = city;
        }

        /**
         *
         * @return
         * The state
         */
        public String getState() {
            return state;
        }

        /**
         *
         * @param state
         * The State
         */
        public void setState(String state) {
            this.state = state;
        }

        /**
         *
         * @return
         * The zip
         */
        public String getZip() {
            return zip;
        }

        /**
         *
         * @param zip
         * The Zip
         */
        public void setZip(String zip) {
            this.zip = zip;
        }

        /**
         *
         * @return
         * The latitude
         */
        public Double getLatitude() {
            return latitude;
        }

        /**
         *
         * @param latitude
         * The Latitude
         */
        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }

        /**
         *
         * @return
         * The longitude
         */
        public Double getLongitude() {
            return longitude;
        }

        /**
         *
         * @param longitude
         * The Longitude
         */
        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }

    // manual
    public String toString() {

        //string to use for creating fake data
        String string = "new EmployeeGeneratedData (" +
                +Id + ", " +
                "\"" + address + "\", " +
                "\"" + cell + "\", " +
                "\"" + city + "\", " +
                "\"" + division + "\", " +
                "\"" + eMNRDPassID + "\", " +
                "\"" + emailAddress + "\", " +
                "\"" + fax + "\", " +
                "\"" + latitude + "\", " +
                "\"" + longitude + "\", " +
                "\"" + name + "\", " +
                "\"" + phone + "\", " +
                "\"" + state + "\", " +
                "\"" + title + "\", " +
                "\"" + zip + "\", " +
                "\"" + location + "\", " +  "\"),";

        return string;

    }
}
