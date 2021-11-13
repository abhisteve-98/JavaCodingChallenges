package Challenge.Java;


public class PhoneContacts {
    private final String Name;
    private final String PhoneNumber;

    public PhoneContacts(String name, String phoneNumber) {
        Name = name;
        PhoneNumber = phoneNumber;
    }

    public String getName() {
        return Name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }
    public static PhoneContacts createContact(String name, String number){
        return new PhoneContacts(name ,number);
    }
}
