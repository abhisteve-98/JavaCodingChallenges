package Challenge.Java;

import java.util.ArrayList;

public class MobilePhone {
    private final ArrayList<PhoneContacts> contactList;

    public MobilePhone(){

        this.contactList=new ArrayList<>();

    }
    public boolean addContact(PhoneContacts contact){
        if(findContact(contact.getName())>=0){
            System.out.println("Contact already exists in the contact list ");
            return false;
        }
        contactList.add(contact);
          return true;
    }
    private int findContact(PhoneContacts find_contact)
    {
        return this.contactList.indexOf(find_contact);
    }

    public int findContact(String contactName)
    {
        for(int i=0;i<this.contactList.size();i++){
            PhoneContacts Search_Contact = this.contactList.get(i);
            if(Search_Contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;

    }
    public void updateContact(PhoneContacts old_contact,PhoneContacts new_contact)
    {
        int found_position= findContact(old_contact);

        if (found_position<0){
            System.out.println("The contact you want to update is not present in the list.");
        }
        else if(findContact(new_contact.getName())!=-1){
            System.out.println("The name: "+new_contact.getName()+ " already exists ");
        }
        this.contactList.set(found_position,new_contact);
        System.out.println("The old contact is replaced by "+new_contact.getName()+"->"+
                    new_contact.getPhoneNumber());

    }
    public boolean removeContact(PhoneContacts remContact )
    {
        if(findContact(remContact)>=0){
            this.contactList.remove(findContact(remContact));
            System.out.println("The contact "+remContact.getName()+" is removed");
            return true;
        }
        return false;
    }
    public PhoneContacts queryContact(String name){
        int position = findContact(name);
        if(position>=0){
            return this.contactList.get(position);
        }
        else{
            return null;
        }
    }

    public void printContacts(){
        for(int i=0;i<contactList.size();i++){
            System.out.println(i+1+". "+contactList.get(i).getName()+"->"+contactList.get(i).getPhoneNumber());
        }
    }









}
