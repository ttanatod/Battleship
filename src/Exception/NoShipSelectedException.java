package Exception;

public class NoShipSelectedException extends Exception {
    private static final long serialVersionUID = -7108982069079662317L;

    public NoShipSelectedException() {
        super("Please selected ship from ShipPane!");

    }
}
