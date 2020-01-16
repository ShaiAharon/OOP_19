// Java program implementing Singleton class 
// with getInstance() method 
class Singleton {
    // static variable single_instance of type Singleton 
    private static Singleton single_instance = null;
    private static int sId = 0;

    // variable of type String 
    public String s;
    private int mId = -1;

    // private constructor restricted to this class itself 
    private Singleton() {
        mId = sId++;
        s = "Hello I am a string part of Singleton class\n" +
                "My Id is:" + mId;
    }

    // static method to create instance of Singleton class 
    public static Singleton getInstance() {
        if (single_instance == null)
            single_instance = new Singleton();

        return single_instance;
    }
} 