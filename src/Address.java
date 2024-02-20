import java.text.DecimalFormat;

public class Address {
    private String houseNum;
    private String streetName;
    private String apartNum;
    private String city;
    private String state;
    private int zipcode;

    public Address(String hn, String sn, String an, String c, String s, int zc) {
        houseNum = hn;
        streetName = sn;
        apartNum = an;
        city = c;
        state = s;
        zipcode = zc;
    }

    public Address(Address toCopy) {
        houseNum = toCopy.getHouseNum();
        streetName = toCopy.getStreetName();
        apartNum = toCopy.getApartNum();
        city = toCopy.getCity();
        state = toCopy.getState();
        zipcode = toCopy.getZipcode();
    }

    public Address(String location) {
        String[] addressParts = location.split(" ");
        houseNum = addressParts[0];
        streetName = addressParts[1] + " " + addressParts[2];
        apartNum = addressParts[3] + " " + addressParts[4].replaceAll(",", "");
        city = addressParts[5].replaceAll(",", "");
        state = addressParts[6];
        zipcode = Integer.parseInt(addressParts[7]);
    }

    public static Address randomAddress(){
        return new Address("123 Random Street Apt A0, City, State " + ((int) (Math.random() * 99001) + 1000));
    }

    public String getHouseNum() {
        return houseNum;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getApartNum() {
        return apartNum;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZipcode() {
        return zipcode;
    }

    public String toString() {
        return houseNum + " " + streetName + " " + apartNum + ", " + city + ", " + state + " " + String.format("%05d" , zipcode);
    }

}
