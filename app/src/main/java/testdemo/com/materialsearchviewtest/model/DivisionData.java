package testdemo.com.materialsearchviewtest.model;

//<Division>
//    <DivisionId>1</DivisionId>
//    <DivisionName>ASD</DivisionName>
//</Division>

public class DivisionData {

    public static final int ID_INDEX = 0;
    public static final int DIVISION_INDEX = 1;
    public static final int DIVISION_NAME_INDEX = 2;

    public static final String JSON_ID = "Id";
    public static final String JSON_DIVISION = "DivisionId";
    public static final String JSON_NAME = "DivisionName";

    // members are public and start with uppercase for JSON compatibility
    public int Id;
    public String DivisionId;
    public String DivisionName;

    public DivisionData() {
    }

    public DivisionData(int id,
                        String division,
                        String name) {

        this.Id = id;
        this.DivisionId = division;
        this.DivisionName = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDivisionId() {
        return DivisionId;
    }

    public void setDivisionId(String divisionId) {
        DivisionId = divisionId;
    }

    public String getDivisionName() {
        return DivisionName;
    }

    public void setDivisionName(String divisionName) {
        DivisionName = divisionName;
    }

    public String toString() {

        //string to use for creating fake data
        String string = "new DivisionData (" +
                +Id + ", " +
                "\"" + DivisionId + "\", " +
                "\"" + DivisionName + "\", " + "\"),";

        return string;

    }
}
