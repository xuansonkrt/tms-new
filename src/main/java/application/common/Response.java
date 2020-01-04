package application.common;


public class Response {
    private String status;
    private Object data;
    private String type;
    private String code;
    private String message;
    private boolean isSuccess;

    
    
    
    public boolean isSuccess() {
        return isSuccess;
    }

    
    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    
    public String getType() {
        return type;
    }

    
    public void setType(String type) {
        this.type = type;
    }

    
    public String getCode() {
        return code;
    }

    
    public void setCode(String code) {
        this.code = code;
    }

    
    public String getMessage() {
        return message;
    }

    
    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
