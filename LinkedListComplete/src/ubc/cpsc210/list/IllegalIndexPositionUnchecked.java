package ubc.cpsc210.list;

/**
 * Reperesents an exception raised when an illegal index is used.
 */
public class IllegalIndexPositionUnchecked extends RuntimeException {
    /**
     * Constructor
     *
     * @param index the illegal index
     */
    public IllegalIndexPositionUnchecked(int index) {
        super("The index" + index + "is not valid");
    }
}
