package entities.pojos;

public class UserAuthentication {
    private String username;
    private String password;
    private String request_token;

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRequest_token() {
        return request_token;
    }

    public void setRequest_token(String request_token) {
        this.request_token = request_token;
    }

    public UserAuthentication(String userName, String password, String requestToken) {
        this.username = userName;
        this.password = password;
        this.request_token = requestToken;
    }
}
