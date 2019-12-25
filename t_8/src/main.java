import java.util.ArrayList;

public class main {

    public static void main(String[] args) {

//        // Generics Demo
//        ArrayList<String> str_arr = new ArrayList<>();
//
//        str_arr.add("Hello");
//        str_arr.add("World");
//
//        for (String str : str_arr)
//            System.out.println(str);

        // Creating my own generic object
        GenericSuperHero<String> myGen = new GenericSuperHero<>("Unknown");
        System.out.println(
                "My Generic Object:\n\t" +
                        myGen.toString());

        GenericSuperHero<Integer> myGen2 = new GenericSuperHero<>(42);
        System.out.println(
                "My Generic Object:\n\t" +
                        myGen2.toString());

        System.out.println("Something Cool:\n\t" + myGen.doSomeThingCool());
        System.out.println("Some other Cool thing:\n\t" + myGen.doSomeOtherCoolThing());
    }
}
