package org.kingempire.notebook.exceptionHandler;

import java.util.Date;
import java.util.Map;
import lombok.Data;

/**
 *
 * @author Anurag Singh
 */
@Data
public class ErrorDetails {

    private Integer status;
    private String error;
    private String message;
    private String timestamp;
    private String path;
    private String trace;

    private ErrorDetails() {
        this.timestamp = new Date().toString();
    }

    public ErrorDetails(String message, String path) {
        this();
        this.message = message;
        this.path = path;
    }

    public ErrorDetails(int status, Map<String, Object> errorAttributes) {
        this.status = status;
        this.error = (String) errorAttributes.get("error");
        this.message = (String) errorAttributes.get("message");
        this.timestamp = errorAttributes.get("timestamp").toString();
        this.path = (String) errorAttributes.get("path");
        this.trace = (String) errorAttributes.get("trace");
    }
}
