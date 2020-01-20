// Java program implementing Singleton class 
// with getInstance() method 
class Multitone {
    private static int sId = 0;

    // variable of type String 
    public String s;
    private int mId = -1;

    // private constructor restricted to this class itself 
    public Multitone() {
        mId = sId++;
        s = "Hello I am a string part of Multitone class\n" +
                "My Id is:" + mId;
    }

    // static method to create instance of Singleton class 
    public static Multitone getInstance() {
        return new Multitone();
    }
} 