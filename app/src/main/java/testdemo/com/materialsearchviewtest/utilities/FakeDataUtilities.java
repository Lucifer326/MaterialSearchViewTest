package testdemo.com.materialsearchviewtest.utilities;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Random;

import testdemo.com.materialsearchviewtest.model.DivisionData;
import testdemo.com.materialsearchviewtest.model.EmployeeGeneratedData;
import testdemo.com.materialsearchviewtest.model.LocationData;

public class FakeDataUtilities extends  Utilities{

    static public ArrayList<EmployeeGeneratedData> getFakeEmployeeData() {

        ArrayList<EmployeeGeneratedData> employeeDataArrayList = generateEmployeeData();

        return employeeDataArrayList;

    }

    static public ArrayList<EmployeeGeneratedData> getSearchEmployeeData(String name) {

        ArrayList<EmployeeGeneratedData> employeeDataArrayList = generateEmployeeData();
        ArrayList<EmployeeGeneratedData> searchDataArrayList = new ArrayList<>();

        for (EmployeeGeneratedData employeeData: employeeDataArrayList) {
          if (employeeData.getName().contains(name)) {
              searchDataArrayList.add(employeeData);
          }
        }

        return searchDataArrayList;

    }

    @NonNull
    private static ArrayList<EmployeeGeneratedData> generateEmployeeData() {
        ArrayList<EmployeeGeneratedData> employeeDataArrayList = new ArrayList<EmployeeGeneratedData>();

        EmployeeGeneratedData employeeData = new EmployeeGeneratedData();
        employeeData.setId(0);
        employeeData.setAddress("123 Sesame Street");
        employeeData.setCell("123.456.1234");
        employeeData.setCity("New York");
        employeeData.setDivision("Food Safety");
        employeeData.setEmailAddress("guy@foodsafety.com");
        employeeData.setFax("234.456.0987");
        employeeData.setLatitude(new Double("12.34"));
        employeeData.setLongitude(new Double("100.22222"));
        employeeData.setName("Gus Smith");
        employeeData.setPhone("987.543.1234");
        employeeData.setState("NY");
        employeeData.setTitle("Mr.");
        employeeData.setZip("10111");
        employeeData.setLocation("NYC");

        employeeDataArrayList.add(employeeData);

        employeeData = new EmployeeGeneratedData();
        employeeData.setId(1);
        employeeData.setAddress("333 Maple St");
        employeeData.setCell("444.456.1234");
        employeeData.setCity("Barcelona");
        employeeData.setDivision("Tapas");
        employeeData.setEmailAddress("tapas@foodinspector.com");
        employeeData.setFax("765.455.0987");
        employeeData.setLatitude(new Double("12.34"));
        employeeData.setLongitude(new Double("90.112"));
        employeeData.setName("Juan Castillo");
        employeeData.setPhone("922.533.1111");
        employeeData.setState("SP");
        employeeData.setTitle("Mr.");
        employeeData.setZip("99999");
        employeeData.setLocation("Spain");

        employeeDataArrayList.add(employeeData);

        employeeData = new EmployeeGeneratedData();
        employeeData.setId(2);
        employeeData.setAddress("3234 Ashbury Rd");
        employeeData.setCell("434.426.3334");
        employeeData.setCity("Paris");
        employeeData.setDivision("Croissant");
        employeeData.setEmailAddress("croissant@foodinspector.com");
        employeeData.setFax("765.225.1111");
        employeeData.setLatitude(new Double("14.34"));
        employeeData.setLongitude(new Double("80.112"));
        employeeData.setName("Pierre Baguette");
        employeeData.setPhone("987.876.2356");
        employeeData.setState("FR");
        employeeData.setTitle("Mssr.");
        employeeData.setZip("98888");
        employeeData.setLocation("France");

        employeeDataArrayList.add(employeeData);

        employeeData = new EmployeeGeneratedData();
        employeeData.setId(3);
        employeeData.setAddress("366 Tea Tree Lane");
        employeeData.setCell("444.426.1114");
        employeeData.setCity("London");
        employeeData.setDivision("Crumpets");
        employeeData.setEmailAddress("crumpets@foodinspector.com");
        employeeData.setFax("795.445.0222");
        employeeData.setLatitude(new Double("13.34"));
        employeeData.setLongitude(new Double("95.16"));
        employeeData.setName("Reginald Dwight");
        employeeData.setPhone("934.343.1221");
        employeeData.setState("GB");
        employeeData.setTitle("Mr.");
        employeeData.setZip("55559");
        employeeData.setLocation("England");

        employeeDataArrayList.add(employeeData);

        employeeData = new EmployeeGeneratedData();
        employeeData.setId(4);
        employeeData.setAddress("123 Uno Dos Tres");
        employeeData.setCell("123.123.1235");
        employeeData.setCity("Lima");
        employeeData.setDivision("Andes");
        employeeData.setEmailAddress("andes@mountain.com");
        employeeData.setFax("321.321.3215");
        employeeData.setLatitude(new Double("55.34"));
        employeeData.setLongitude(new Double("-95.16"));
        employeeData.setName("Jose Gonzales");
        employeeData.setPhone("234.234.4567");
        employeeData.setState("PU");
        employeeData.setTitle("Sr.");
        employeeData.setZip("78777");
        employeeData.setLocation("Peru");

        employeeDataArrayList.add(employeeData);

        employeeData = new EmployeeGeneratedData();
        employeeData.setId(5);
        employeeData.setAddress("333 Camino Tres");
        employeeData.setCell("333.333.3333");
        employeeData.setCity("Quito");
        employeeData.setDivision("Equatorial");
        employeeData.setEmailAddress("jcquito@ecu.com");
        employeeData.setFax("321.321.3215");
        employeeData.setLatitude(new Double("55.34"));
        employeeData.setLongitude(new Double("-95.16"));
        employeeData.setName("Jose Canseco");
        employeeData.setPhone("333.333.3333");
        employeeData.setState("EQ");
        employeeData.setTitle("Sr.");
        employeeData.setZip("32345");
        employeeData.setLocation("Ecuador");

        employeeDataArrayList.add(employeeData);
        return employeeDataArrayList;
    }

    static public ArrayList<LocationData> getFakeLocationData() {

        ArrayList<LocationData> LocationDataArrayList = new ArrayList<LocationData>();

        LocationData LocationData = new LocationData();

        LocationData.setId(0);
        LocationData.setName("NYC");;
        LocationData.setGroup("The Nails");
        LocationData.setDivision("Food Safety");
        LocationData.setAddress("123 Sesame Street");
        LocationData.setAddress2("Route B");
        LocationData.setCity("New York");
        LocationData.setState("NY");
        LocationData.setZIP("10111");
        LocationData.setDisplayOrder("1");
        LocationData.setPhone("987.543.1234");
        LocationData.setFAX("234.456.0987");
        LocationData.setLatitude("12.34");
        LocationData.setLocationId("11");
        LocationData.setLongitude("100.22222");

        LocationDataArrayList.add(LocationData);

        LocationData.setId(1);
        LocationData.setName("Spain");;
        LocationData.setGroup("Los Lobos");
        LocationData.setDivision("Food Safety");
        LocationData.setAddress("444 Quinoa Street");
        LocationData.setAddress2("Apt C.");
        LocationData.setCity("Barcelona");
        LocationData.setState("NY");
        LocationData.setZIP("98765");
        LocationData.setDisplayOrder("2");
        LocationData.setPhone("987.543.1234");
        LocationData.setFAX("234.456.0987");
        LocationData.setLatitude("12.34");
        LocationData.setLocationId("22");
        LocationData.setLongitude("100.22222");

        LocationDataArrayList.add(LocationData);

        LocationData.setId(2);
        LocationData.setName("France");;
        LocationData.setGroup("Gipsy Kings");
        LocationData.setDivision("Dance & Rhythm");
        LocationData.setAddress("444 Quinoa Street");
        LocationData.setAddress2("Apt C.");
        LocationData.setCity("Barcelona");
        LocationData.setState("NY");
        LocationData.setZIP("98765");
        LocationData.setDisplayOrder("2");
        LocationData.setPhone("987.543.1234");
        LocationData.setFAX("234.456.0987");
        LocationData.setLatitude("12.34");
        LocationData.setLocationId("33");
        LocationData.setLongitude("100.22222");

        LocationDataArrayList.add(LocationData);

        LocationData.setId(3);
        LocationData.setName("England");;
        LocationData.setGroup("The Kinks");
        LocationData.setDivision("Drugs & Alcohol");
        LocationData.setAddress("44 Lola Lane");
        LocationData.setAddress2("Apt L.");
        LocationData.setCity("London");
        LocationData.setState("GB");
        LocationData.setZIP("98335");
        LocationData.setDisplayOrder("3");
        LocationData.setPhone("987.5333.1234");
        LocationData.setFAX("234.444.0987");
        LocationData.setLatitude("14.11");
        LocationData.setLocationId("44");
        LocationData.setLongitude("111.23332");

        LocationDataArrayList.add(LocationData);

        return LocationDataArrayList;

    }

    static public ArrayList<DivisionData> getFakeDivisionData() {

        ArrayList<DivisionData> DivisionDataList = new ArrayList<DivisionData>();

        DivisionData DivisionData = new DivisionData();

        DivisionData.setId(0);
        DivisionData.setDivisionId("0");
        DivisionData.setDivisionName("East");

        DivisionDataList.add(DivisionData);

        DivisionData.setId(1);
        DivisionData.setDivisionId("1");
        DivisionData.setDivisionName("West");

        DivisionDataList.add(DivisionData);

        DivisionData.setId(2);
        DivisionData.setDivisionId("2");
        DivisionData.setDivisionName("North");

        DivisionDataList.add(DivisionData);

        DivisionData.setId(3);
        DivisionData.setDivisionId("3");
        DivisionData.setDivisionName("South");

        DivisionDataList.add(DivisionData);

        DivisionData.setId(4);
        DivisionData.setDivisionId("4");
        DivisionData.setDivisionName("NorthEast");

        DivisionDataList.add(DivisionData);

        DivisionData.setId(5);
        DivisionData.setDivisionId("5");
        DivisionData.setDivisionName("NorthWest");

        DivisionDataList.add(DivisionData);

        DivisionData.setId(6);
        DivisionData.setDivisionId("6");
        DivisionData.setDivisionName("SouthEast");

        DivisionDataList.add(DivisionData);

        DivisionData.setId(7);
        DivisionData.setDivisionId("7");
        DivisionData.setDivisionName("SouthWest");

        DivisionDataList.add(DivisionData);

        return DivisionDataList;

    }

    static public EmployeeGeneratedData getRandomEmployee() {
        ArrayList<EmployeeGeneratedData> employeeDataArrayList = getFakeEmployeeData();

        int randomInt = randInt(0,4);

        return employeeDataArrayList.get(randomInt);

    }

    /**
     * Returns a pseudo-random number between min and max, inclusive.
     * The difference between min and max can be at most
     * <code>Integer.MAX_VALUE - 1</code>.
     *
     * @param min Minimum value
     * @param max Maximum value.  Must be greater than min.
     * @return Integer between min and max, inclusive.
     * @see java.util.Random#nextInt(int)
     */
    public static int randInt(int min, int max) {

        // NOTE: This will (intentionally) not run as written so that folks
        // copy-pasting have to think about how to initialize their
        // Random instance.  Initialization of the Random instance is outside
        // the main scope of the question, but some decent options are to have
        // a field that is initialized once and then re-used as needed or to
        // use ThreadLocalRandom (if using at least Java 1.7).
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

}
