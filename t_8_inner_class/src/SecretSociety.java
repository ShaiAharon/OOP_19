import java.util.ArrayList;

public class SecretSociety {
    private static String mClassName = "secretSociety";
    private static int mInstCounter = 0;
    private String mName;
    private ArrayList<secretMember> mMembers = new ArrayList<>();
    private int mId = 0;

    private class secretMember {
        private String mName;
        private String mCodename;

        secretMember(String name, String codename) {
            mName = name;
            mCodename = codename;
        }

        @Override
        public String toString() {
            return "secretMember{" +
                    "\n\t\tmName='" + mName +
                    ", tmCodename='" + mCodename +
                    "\n\t\tAll Hail '" + SecretSociety.this.mName + "'" +
                    "\n\t}";
        }
    }

    SecretSociety(String name) {
        mInstCounter += 1;
        mName = name;
    }

    public void addMember(String new_member) {
        mMembers.add(new secretMember(
                new_member,
                "secrete Dude #" + mId++));

        System.out.println("Welcome " + new_member);
        System.out.println("\tOne Of Us!");
        System.out.println("\tOne Of Us!");
        System.out.println("\tOne Of Us!");
    }


    public void addSuperSecretMember(String new_member) {
        mMembers.add(
                new secretMember(new_member, "") {
                    @Override
                    public String toString() {
                        return "Shhhhhh....";
                    }
                }
        );

        System.out.println("Welcome " + new_member);
        System.out.println("\tOne Of Us!");
        System.out.println("\tOne Of Us!");
        System.out.println("\tOne Of Us!");
    }

    @Override
    public String toString() {
        return "secretSociety{" +
                "\n\t\tmName=" + mName +
                "\n\t\tmMembers=" + mMembers +
                "\n\t}";
    }

    public static String getSlogen() {
        return "secrete but cool " + mInstCounter;
    }
}
