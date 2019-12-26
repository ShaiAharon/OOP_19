import java.util.ArrayList;

public class SecretSociety {
    private String mName;
    private ArrayList<SecreteMember> mMembers = new ArrayList<>();

    private class SecreteMember {
        private String mName;
        private String mCodename;

        SecreteMember(String name, String codename) {
            mName = name;
            mCodename = codename;
        }

        @Override
        public String toString() {
            return "SecreteMember{" +
                    "\n\t\tmName='" + mName +
                    ", tmCodename='" + mCodename +
                    "\n\t\tAll Hail '" + SecretSociety.this.mName + "'" +
                    "\n\t}";
        }
    }

    SecretSociety(String name) {
        mName = name;
    }

    public void addMember(String new_member) {
        mMembers.add(new SecreteMember(new_member, "Secrete Dude #" + mMembers.size()));

        System.out.println("Welcome " + new_member);
        System.out.println("\tOne Of Us!");
        System.out.println("\tOne Of Us!");
        System.out.println("\tOne Of Us!");
    }

    public void addSuperSecreteMember(final String new_member) {
        mMembers.add(
                new SecreteMember(new_member, "") {
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
        return "SecretSociety{" +
                "\n\t\tmName=" + mName +
                "\n\t\tmMembers=" + mMembers +
                "\n\t}";
    }

    public static String getSlogen(){
        return "Secrete but cool";
    }
}
