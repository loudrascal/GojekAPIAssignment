package library.model;

public class APIResponse {
    private int responseCode;
    private String exceptionType;
    private String response;
    private String url;

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(String exceptionType) {
        this.exceptionType = exceptionType;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "APIResponse{" +
                "responseCode=" + responseCode +
                ", exceptionType='" + exceptionType + '\'' +
                ", response='" + response + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}