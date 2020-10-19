package pojos;

public class ResponsePayload {

    private int statusCode;
    private String statusTitle;
    private String message;

    public ResponsePayload() {
    }

    public ResponsePayload(int statusCode, String statusTitle, String message) {
        this.statusCode = statusCode;
        this.statusTitle = statusTitle;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusTitle() {
        return statusTitle;
    }

    public void setStatusTitle(String statusTitle) {
        this.statusTitle = statusTitle;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
