public class TooSmallIntegerException extends IllegalArgumentException{
    private int nimimalAllowed;

    public TooSmallIntegerException(String message, int minimal) {
        super(message);
        this.nimimalAllowed = minimal;
    }

    public int getMinimal(){
        return this.nimimalAllowed;
    }
}
