// Driver Class
class Main
{
    public static void main(String args[])
    {
        // instantiating a class with variable x
        Singleton x = Singleton.getInstance();

        // instantiating a class with variable y
        Singleton y = Singleton.getInstance();

        // instantiating a class with variable z
        Singleton z = Singleton.getInstance();

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