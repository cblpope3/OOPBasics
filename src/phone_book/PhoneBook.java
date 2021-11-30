package phone_book;

import java.util.*;

public class PhoneBook {
    private final Map<String, List<String>> contacts = new HashMap<>();

    public void addPhoneToContact(String name, String phone) {
        if (contacts.containsKey(name)) {
            if (!contacts.get(name).contains(phone)) contacts.get(name).add(phone);
        }
    }

    public void addContact(String name) {
        if (!contacts.containsKey(name)) contacts.put(name, new ArrayList<>());
    }

    public void addContact(String name, String phone) {
        addContact(name);
        addPhoneToContact(name, phone);
    }

    public String getContactByName(String name) {
        if (!contacts.containsKey(name)) {
            Set<String> partialMatchedContacts = getPartialContacts(name);
            if (partialMatchedContacts == null) return null;
            else return partialMatchedContacts.toString();
        }
        return contacts.get(name).toString();
    }

    private Set<String> getPartialContacts(String partialName) {
        Set<String> foundContacts = new HashSet<>();
        for (String name : contacts.keySet()) {
            if (name.contains(partialName)) foundContacts.add(name);
        }
        if (foundContacts.isEmpty()) return null;
        else return foundContacts;
    }

    @Override
    public String toString() {
        return "PhoneBook=" + contacts;
    }
}
