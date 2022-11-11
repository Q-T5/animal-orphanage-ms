package npc.martin.impalabackend.advice;

/**
 *
 * @author bikathi_martin 
 * @date Jul 26, 2022
 */
public class ErrorMessage {
    private Integer statusCode;
    private String timeInformation;
    private String message;
    private String description;

    public ErrorMessage() {
    }

    public ErrorMessage(Integer statusCode, String timeInformation, String message, String description) {
        this.statusCode = statusCode;
        this.timeInformation = timeInformation;
        this.message = message;
        this.description = description;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getTimeInformation() {
        return timeInformation;
    }

    public void setTimeInformation(String timeInformation) {
        this.timeInformation = timeInformation;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ErrorMessage{" + "statusCode=" + statusCode + ", timeInformation=" + timeInformation + ", message=" + message + ", description=" + description + '}';
    }
}
