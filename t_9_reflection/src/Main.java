import java.lang.reflect.Method;
import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) {
        try {

            Test obj = new Test();
            Class cls = obj.getClass();

            System.out.println("The name of class is " + cls.getName());

//            System.out.println("Class Methods:");
//            Method[] methods = cls.getMethods();
//            for (Method method : methods)
//                System.out.println("\t" + method.getName());

//            System.out.print("Method Calling\n\t");
//            Method methodcall1 = cls.getDeclaredMethod("method2", int.class);
//            methodcall1.invoke(obj, 2);

//            System.out.println("Changing private variable");
//            Method methodcall2 = cls.getDeclaredMethod("method1");
//            methodcall2.invoke(obj);
//
//            Field field = cls.getDeclaredField("s");
//            field.setAccessible(true);
//            field.set(obj, "JAVA");
//            methodcall2.invoke(obj);

//            System.out.println("Accessing private method");
//            Method methodcall3 = cls.getDeclaredMethod("method3");
//            methodcall3.setAccessible(true);
//            methodcall3.invoke(obj);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
