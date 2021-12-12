import geometry.*;
import phone_book.PhoneBook;

import java.util.ArrayList;
import java.util.List;

public class App {

    private static final PhoneBook phoneBook = new PhoneBook();

    public static void main(String[] args) {
        phoneBookTest();
        geometryTest();
    }

    public static void phoneBookTest() {

        System.out.println("\n|======\n| Phone book test\n|======");

        phoneBook.addContact("Vladimir");
        System.out.println("\n-->Expecting empty contact Vladimir");
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

    public static void geometryTest() {

        System.out.println("\n|======\n| Geometry figures test\n|======");

        List<GenericGeometricFigure> figureList = new ArrayList<>();
        figureList.add(new Dot(3.3453, 4.768786));
        figureList.add(new Line(1, 1, 2, 2));
        figureList.add(new Line(new Dot(2, 2), new Dot(-2, 2)));
        figureList.add(new Circle(1, 1, 3));
        figureList.add(new Circle(new Dot(3.11,6.43), 66.5));
        figureList.add(new Triangle(0, 0, 1, 0, 0, 1));
        figureList.add(new Triangle(new Dot(3,5), new Dot(-3,5), new Dot(7,5)));
        figureList.add(new Square(0, 0, 1));
        figureList.add(new Square(new Dot(-15, -2.44), 22));
        figureList.add(new Square(-3, 1, -3, 3));
        figureList.add(new Square(new Dot(-15, 1), new Dot(-14, 0)));
        figureList.add(new Rectangle(new Dot(0, 0), 1, 2));
        figureList.add(new Rectangle(5, 6, 11.3, 2));
        figureList.add(new Rectangle(3, 3, 2, 4, 1, 1));
        figureList.add(new Rectangle(new Dot(3, 3), new Dot(2, 4), new Dot(1, 1)));
        figureList.add(new Parallelogram(new Dot(1, 1), 5, 2, 1));
        figureList.add(new Parallelogram(new Line(-8, 1, -6, 5), new Line(-9, 3, -5, 3)));
        figureList.add(new Parallelogram(new ArrayList<>(List.of(
                new Dot(-8, 1), new Dot(-9, 3), new Dot(-6, 5), new Dot(-5, 3)))));

        for (GenericGeometricFigure figure : figureList) {
            System.out.println("\nFigure type:");
            System.out.println(figure.getType());
            System.out.println("Figure perimeter:");
            System.out.println(figure.getPerimeter());
            System.out.println("Figure area:");
            System.out.println(figure.getArea());
            System.out.println(figure);
        }
    }
}
