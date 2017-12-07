package mobi.ingogo.interview.model.error;

abstract class Error extends RuntimeException {
    private String msg;
    private String code;

    Error(String message, String code) {
        super(message);
        this.msg = message;
        this.code = code;
    }

    Error(String message, String code, Throwable cause) {
        super(message, cause);
        this.msg = message;
        this.code = code;
    }


    public String getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }
}

