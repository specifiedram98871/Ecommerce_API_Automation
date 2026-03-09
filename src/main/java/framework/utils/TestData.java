package framework.utils;

public class TestData {
    public static String validEmail ="validemail@test.com";
    public static String TITLE = "Mr";
    public static String NAME = "John Doe";
    public static String PASSWORD = "Test@123";

    public static String FIRST_NAME = "John";
    public static String LAST_NAME = "Doe";
    public static String COMPANY = "MyCompany";
    public static String ADDRESS1 = "123 Main St";
    public static String ADDRESS2 = "Suite 4";
    public static String COUNTRY = "United States";
    public static String STATE = "California";
    public static String CITY = "Los Angeles";
    public static String ZIPCODE = "90001";
    public static String PHONE = "1234567890";

    public static String uniqueMail() {
        return "user" + System.currentTimeMillis() + "@test.com";
    }
}