package entities.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthenticationRoute {
    @JsonProperty("createRequestToken")
    private String createRequestToken;

    @JsonProperty("createSessionWithLogin")
    private String createSessionWithLogin;

    @JsonProperty("createSession")
    private String createSession;


    @JsonProperty("base")
    private String base;

    public String getCreateRequestToken() {
        return createRequestToken;
    }

    public void setCreateRequestToken(String createRequestToken) {
        this.createRequestToken = createRequestToken;
    }

    public String getCreateSessionWithLogin() {
        return createSessionWithLogin;
    }

    public void setCreateSessionWithLogin(String createSessionWithLogin) {
        this.createSessionWithLogin = createSessionWithLogin;
    }

    public String getCreateSession() {
        return createSession;
    }

    public void setCreateSession(String createSession) {
        this.createSession = createSession;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }
}
