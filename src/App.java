import phone_book.PhoneBook;

public class App {

    private static final PhoneBook phoneBook = new PhoneBook();

    public static void main(String[] args) {
        phoneBookTest();
    }

    public static void phoneBookTest() {

        phoneBook.addContact("Vladimir");
        System.out.println("-->Expecting empty contact Vladimir");
        System.out.println(phoneBook);
        phoneBook.addContact("Vladimir");
        System.out.println("-->Expecting empty contact Vladimir");
        System.out.println(phoneBook);
        phoneBook.addContact("Vladimir", "89123334455");
        phoneBook.addPhoneToContact("Vladimir", "89123334455");
        phoneBook.addPhoneToContact("Vladimir", "89123334455");
        System.out.println("-->Expecting contact Vladimir with number 89123334455");
        System.out.println(phoneBook);
        phoneBook.addPhoneToContact("Vladimir", "+79119998877");
        System.out.println("-->Expecting contact Vladimir with numbers 89123334455 and +79119998877");
        System.out.println(phoneBook);

        phoneBook.addContact("Valeriya", "89115556677");
        System.out.println("-->Expecting contact Vladimir with numbers 89123334455 and +79119998877 and Valeriya with number 89115556677");
        System.out.println(phoneBook);

        System.out.println("-->Expecting number 89115556677");
        System.out.println(phoneBook.getContactByName("Valeriya"));
        System.out.println("-->Expecting list of numbers 89123334455 and +79119998877");
        System.out.println(phoneBook.getContactByName("Vladimir"));

        phoneBook.addContact("Vladislav", "88005553535");
        System.out.println("-->Expecting list of contacts Vladimir, Valeriya, Vladislav");
        System.out.println(phoneBook.getContactByName("V"));
        System.out.println("-->Expecting list of contacts Vladimir, Vladislav");
        System.out.println(phoneBook.getContactByName("Vlad"));

        System.out.println("-->Expecting null");
        System.out.println(phoneBook.getContactByName("Egor"));
    }
}
