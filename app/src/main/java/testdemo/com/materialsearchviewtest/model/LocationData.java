package testdemo.com.materialsearchviewtest.model;

//<Location>
//    <Address>4001 Edith Blvd., NE</Address>
//    <Address2/>
//    <City>Albuquerque</City>
//    <DisplayOrder>-1</DisplayOrder>
//    <Division>Forestry</Division>
//    <Fax>(505) 345-1392</Fax>
//    <Group>Forestry Field</Group>
//    <Latitude>35.11997</Latitude>
//    <LocationId>24</LocationId>
//    <Longitude>-106.63412</Longitude>
//    <Name>Albuquerque</Name>
//    <Phone>(505) 345-2200</Phone>
//    <State>NM</State>
//    <Zip>87107</Zip>
//</Location>

public class LocationData {

    public static final int ID_INDEX = 0;
    public static final int ADDRESS_INDEX = 1;
    public static final int ADDRESS2_INDEX = 2;
    public static final int CITY_INDEX = 3;
    public static final int DISPLAY_INDEX = 4;
    public static final int DIVISION_INDEX = 5;
    public static final int FAX_INDEX = 6;
    public static final int GROUP_INDEX = 7;
    public static final int LATITUDE_INDEX = 8;
    public static final int LOCATION_INDEX = 9;
    public static final int LONGITUDE_INDEX = 10;
    public static final int NAME_INDEX = 11;
    public static final int PHONE_INDEX = 12;
    public static final int STATE_INDEX = 13;
    public static final int ZIP_INDEX = 14;

    public static final String JSON_LOCATION_ID = "Id";
    public static final String JSON_LOCATION_ADDRESS = "Address";
    public static final String JSON_LOCATION_ADDRESS2 = "Address2";
    public static final String JSON_LOCATION_CITY = "City";
    public static final String JSON_LOCATION_DISPLAY = "DisplayOrder";
    public static final String JSON_LOCATION_DIVISION = "Division";
    public static final String JSON_LOCATION_FAX = "Fax";
    public static final String JSON_LOCATION_GROUP = "Group";
    public static final String JSON_LOCATION_LATITUDE = "Latitude";
    public static final String JSON_LOCATION_LOCATION = "LocationId";
    public static final String JSON_LOCATION_LONGITUDE = "Longitude";
    public static final String JSON_LOCATION_NAME = "Name";
    public static final String JSON_LOCATION_PHONE = "Phone";
    public static final String JSON_LOCATION_STATE = "State";
    public static final String JSON_LOCATION_ZIP = "Zip";

    // members are public and start with uppercase for JSON compatibility
    public int Id;
    public String Address;
    public String Address2;
    public String City;
    public String DisplayOrder;
    public String Division;
    public String FAX;
    public String Group;
    public String Latitude;
    public String LocationId;
    public String Longitude;
    public String Name;
    public String Phone;
    public String State;
    public String ZIP;

    public LocationData() {
    }

    public LocationData(int id,
                        String address,
                        String address2,
                        String city,
                        String displayOrder,
                        String division,
                        String fax,
                        String group,
                        String latitude,
                        String locationId,
                        String longitude,
                        String name,
                        String phone,
                        String state,
                        String ZIP) {

        this.Id = id;
        this.Address = address;
        this.Address2 = address2;
        this.City = city;
        this.DisplayOrder = displayOrder;
        this.Division = division;
        this.FAX = fax;
        this.Group = group;
        this.Latitude = latitude;
        this.LocationId = locationId;
        this.Longitude = longitude;
        this.Name = name;
        this.Phone = phone;
        this.State = state;
        this.ZIP = ZIP;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getAddress2() {
        return Address2;
    }

    public void setAddress2(String address2) {
        Address2 = address2;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getDisplayOrder() {
        return DisplayOrder;
    }

    public void setDisplayOrder(String displayOrder) {
        DisplayOrder = displayOrder;
    }

    public String getDivision() {
        return Division;
    }

    public void setDivision(String division) {
        Division = division;
    }

    public String getFax() {
        return FAX;
    }

    public void setFAX(String FAX) {
        this.FAX = FAX;
    }

    public String getGroup() {
        return Group;
    }

    public void setGroup(String group) {
        Group = group;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLocationId() {
        return LocationId;
    }

    public void setLocationId(String locationId) {
        LocationId = locationId;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getZip() {
        return ZIP;
    }

    public void setZIP(String ZIP) {
        this.ZIP = ZIP;
    }

    public String toString() {

        //string to use for creating fake data
        String string = "new LocationData (" +
                +Id + ", " +
                "\"" + Address + "\", " +
                "\"" + Address2 + "\", " +
                "\"" + City + "\", " +
                "\"" + DisplayOrder + "\", " +
                "\"" + Division + "\", " +
                "\"" + FAX + "\", " +
                "\"" + Group + "\", " +
                "\"" + Latitude + "\", " +
                "\"" + LocationId + "\", " +
                "\"" + Longitude + "\", " +
                "\"" + Name + "\", " +
                "\"" + Phone + "\", " +
                "\"" + State + "\", " +
                "\"" + ZIP + "\", " +  "\"),";

        return string;

    }
}
