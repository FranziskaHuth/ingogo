package mobi.ingogo.interview.model.error;

public class ValidationError extends Error{
    public static final String MISSING_OR_INVALID_DATA = "MISSING_OR_INVALID_DATA";


    public ValidationError(String message, String code) {
        super(message, code);
    }
}
