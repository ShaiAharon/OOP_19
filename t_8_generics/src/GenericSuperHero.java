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
        return "\n  \\ | /  \n" +
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

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        return this.mT == ((GenericSuperHero<T>) obj).mT;
    }

    static public <I> String genericStaticMethod(I[] sh_list, I pivot_sh) {
        int count = 0;
        if (pivot_sh == null) {
            for (I t : sh_list) {
                count += (t == null) ? 1 : 0;
            }
        } else {
            for (I t : sh_list) {
                count += (t.equals(pivot_sh)) ? 1 : 0;
            }
        }

        return count + " instances of <" + pivot_sh + "> where found";
    }
}
