package A4_5100.Q2;

public abstract class MoodyObject {
    protected abstract String getMood();

    public void queryMood() {
        System.out.println("I feel " + this.getMood() + " today!");
    }

    public abstract void expressFeelings();
}