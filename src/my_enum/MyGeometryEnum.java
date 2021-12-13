package my_enum;

import java.lang.reflect.Field;

public class MyGeometryEnum {
    private final String name;

    protected MyGeometryEnum(String name) {
        this.name = name;
    }

    public static final MyGeometryEnum NOT_DEFINED = new MyGeometryEnum("not defined");
    public static final MyGeometryEnum DOT = new MyGeometryEnum("dot");
    public static final MyGeometryEnum LINE = new MyGeometryEnum("line");
    public static final MyGeometryEnum CIRCLE = new MyGeometryEnum("circle");
    public static final MyGeometryEnum TRIANGLE = new MyGeometryEnum("triangle");
    public static final MyGeometryEnum SQUARE = new MyGeometryEnum("square");
    public static final MyGeometryEnum RECTANGLE = new MyGeometryEnum("rectangle");
    public static final MyGeometryEnum PARALLELOGRAM = new MyGeometryEnum("parallelogram");

    @Override
    public String toString() {
        return "Figure type is " + name + '.';
    }

    public static Object valueOf(String value){

        for (Field field: MyGeometryEnum.class.getDeclaredFields()){
            if (field.getName().equals(value)){
                try {
                    return MyGeometryEnum.class.getDeclaredField(field.getName()).get(null);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return NOT_DEFINED;
    }
}