package A4_5100.Q2;

public class HappyObject extends MoodyObject {
    private static String LAUGHTER_STRING = "hehehe...hahahah...HAHAHAHAHA!!!";
    private static String MESSAGE = "Subject laughs a lot";

    protected String getMood() {
        return "Happy";
    }

    public void expressFeelings() {
        System.out.println(LAUGHTER_STRING);
    }

    public String toString() {
        return MESSAGE;
    }
}
