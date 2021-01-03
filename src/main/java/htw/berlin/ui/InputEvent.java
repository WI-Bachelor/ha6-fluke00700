package htw.berlin.ui;

public class InputEvent {

    private final boolean understood;

    public InputEvent(boolean understood) {
        this.understood = understood;
    }

    public boolean getUnderstood() {
        return understood;
    }
}
