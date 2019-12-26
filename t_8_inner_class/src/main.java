public class main {

    public static void main(String[] args) {
        System.out.println("Secret Society Slogen:\n\t" + SecretSociety.getSlogen());

        SecretSociety s_society = new SecretSociety("The Society");
        s_society.addMember("Alexander Luthor");
        s_society.addMember("Calculator");
        s_society.addMember("Dr. Psycho");
        s_society.addMember("Deathstroke");
        s_society.addMember("Talia al Ghul");
        s_society.addSuperSecretMember("Black Adam");

        System.out.println(s_society);
    }
}
