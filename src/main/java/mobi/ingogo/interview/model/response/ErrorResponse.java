package mobi.ingogo.interview.model.response;

public class ErrorResponse {

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

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

