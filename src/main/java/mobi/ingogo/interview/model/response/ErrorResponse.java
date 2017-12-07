package mobi.ingogo.interview.model.response;

public class ErrorResponse {

    public ErrorResponse(String msg, String code) {
        this.msg = msg;
        this.code = code;

        if (msg != null && msg.isEmpty()) {
            this.msg = null;
        }

        if (code != null && code.isEmpty()) {
            this.code = null;
        }

    }

    private String msg;
    private String code;
    private String detail;

}

