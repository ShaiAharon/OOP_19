// Driver Class 
class Main
{
    public static void main(String args[])
    {
        // instantiating a class with variable x
        Multitone x = Multitone.getInstance();

        // instantiating a class with variable y
        Multitone y = Multitone.getInstance();

        // instantiating a class with variable z
        Multitone z = Multitone.getInstance();

        // changing variable of instance x 
        x.s = (x.s).toUpperCase();

        System.out.println("String from x is " + x.s);
        System.out.println("String from y is " + y.s);
        System.out.println("String from z is " + z.s);
        System.out.println("\n");

        // changing variable of instance z 
        z.s = (z.s).toLowerCase();

        System.out.println("String from x is " + x.s);
        System.out.println("String from y is " + y.s);
        System.out.println("String from z is " + z.s);
    }
}