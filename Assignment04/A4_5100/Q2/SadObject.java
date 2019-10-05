package A4_5100.Q2;

public class SadObject extends MoodyObject {
    private static String CRYING_STRING = "'wah' 'boo boo' 'weep' 'sob' 'weep'";
    private static String MESSAGE = "Subject cries a lot";

    protected String getMood() {
        return "Sad";
    }

    public void expressFeelings() {
        System.out.println(CRYING_STRING);
    }

    public String toString() {
        return MESSAGE;
    }
}
