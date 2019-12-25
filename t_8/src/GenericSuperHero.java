public class GenericSuperHero<T> implements GenericInterface<String, Double> {
    private T mT;

    GenericSuperHero(T t) {
        mT = t;
    }

    public void setmT(T mT) {
        this.mT = mT;
    }

    public T getmT() {
        return mT;
    }

    @Override
    public String toString() {
        return mT.toString();
    }

    @Override
    public String doSomeThingCool() {
        return "  \\ | /  \n" +
                "   \\*/   \n" +
                "--**O**-- \n" +
                "   /*\\\n" +
                "  / | \\\n" +
                "    |";
    }

    @Override
    public Double doSomeOtherCoolThing() {
        return (mT.toString()).length() * Math.PI;
    }
}
