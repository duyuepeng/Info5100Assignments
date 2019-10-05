package A4_5100.Q2;

public class PsychiatristTest {
    public static void main(String args[]) {
        PsychiatristObject p = new PsychiatristObject();
        MoodyObject sad = new SadObject();
        MoodyObject happy = new HappyObject();

        p.examine(happy);
        System.out.println();
        p.observe(happy);

        System.out.println();

        p.examine(sad);
        System.out.println();
        p.observe(sad);
    }
}