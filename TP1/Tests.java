public class Tests {
    public static void main(String[] args) {
        int test = 5000;
        System.out.println(Math.log10(test));
        System.out.println((int)Math.log10(test));
        for (int i = 0; i < (int)Math.log10(test); i++) {
            System.out.println("oui");
        }
    }

}
