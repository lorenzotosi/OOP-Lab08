package it.unibo.oop.lab.advanced;

/**
 */
public final class DrawNumberApp implements DrawNumberViewObserver {

    //private static final int MIN = 0;
    //private static final int MAX = 100;
    //private static final int ATTEMPTS = 10;
    private final DrawNumber model;
    private final DrawNumberView view;

    /**
     * 
     */
    public DrawNumberApp() {
        final SetValues s1 = new SetValues();
        s1.readFromFile();
        this.model = new DrawNumberImpl(s1.getMin(), s1.getMax(), s1.getAttempts());
        this.view = new DrawNumberViewImpl();
        this.view.setObserver(this);
        this.view.start();
        System.out.println(s1.getMax());
    }

    @Override
    public void newAttempt(final int n) {
        try {
            final DrawResult result = model.attempt(n);
            this.view.result(result);
        } catch (IllegalArgumentException e) {
            this.view.numberIncorrect();
        } catch (AttemptsLimitReachedException e) {
            view.limitsReached();
        }
    }

    @Override
    public void resetGame() {
        this.model.reset();
    }

    @Override
    public void quit() {
        System.exit(0);
    }

    /**
     * @param args
     *            ignored
     */
    public static void main(final String... args) {
        new DrawNumberApp();
    }

}
