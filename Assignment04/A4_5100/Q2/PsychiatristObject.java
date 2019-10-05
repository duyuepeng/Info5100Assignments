package A4_5100.Q2;

public class PsychiatristObject {
    public void examine(MoodyObject m) {
        System.out.println("How are you feeling today?");
        m.queryMood();
    }

    public void observe(MoodyObject m) {
        m.expressFeelings();
        System.out.println("Obeservation: " + m);
    }

}