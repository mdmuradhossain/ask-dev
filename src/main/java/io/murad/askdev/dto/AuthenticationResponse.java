package io.murad.askdev.dto;

import java.time.Instant;

public class AuthenticationResponse {
    private String authenticationToken;
    private String username;
    private String refreshToken;
    private Instant expiresAt;

    public AuthenticationResponse(String authenticationToken, String username, String refreshToken, Instant expiresAt) {
        this.authenticationToken = authenticationToken;
        this.username = username;
        this.refreshToken = refreshToken;
        this.expiresAt = expiresAt;
    }

    public AuthenticationResponse() {
    }

    public static AuthenticationResponseBuilder builder() {
        return new AuthenticationResponseBuilder();
    }

    public String getAuthenticationToken() {
        return this.authenticationToken;
    }

    public String getUsername() {
        return this.username;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public Instant getExpiresAt() {
        return this.expiresAt;
    }

    public void setAuthenticationToken(String authenticationToken) {
        this.authenticationToken = authenticationToken;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void setExpiresAt(Instant expiresAt) {
        this.expiresAt = expiresAt;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof AuthenticationResponse)) return false;
        final AuthenticationResponse other = (AuthenticationResponse) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$authenticationToken = this.getAuthenticationToken();
        final Object other$authenticationToken = other.getAuthenticationToken();
        if (this$authenticationToken == null ? other$authenticationToken != null : !this$authenticationToken.equals(other$authenticationToken))
            return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
        final Object this$refreshToken = this.getRefreshToken();
        final Object other$refreshToken = other.getRefreshToken();
        if (this$refreshToken == null ? other$refreshToken != null : !this$refreshToken.equals(other$refreshToken))
            return false;
        final Object this$expiresAt = this.getExpiresAt();
        final Object other$expiresAt = other.getExpiresAt();
        if (this$expiresAt == null ? other$expiresAt != null : !this$expiresAt.equals(other$expiresAt)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AuthenticationResponse;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $authenticationToken = this.getAuthenticationToken();
        result = result * PRIME + ($authenticationToken == null ? 43 : $authenticationToken.hashCode());
        final Object $username = this.getUsername();
        result = result * PRIME + ($username == null ? 43 : $username.hashCode());
        final Object $refreshToken = this.getRefreshToken();
        result = result * PRIME + ($refreshToken == null ? 43 : $refreshToken.hashCode());
        final Object $expiresAt = this.getExpiresAt();
        result = result * PRIME + ($expiresAt == null ? 43 : $expiresAt.hashCode());
        return result;
    }

    public String toString() {
        return "AuthenticationResponse(authenticationToken=" + this.getAuthenticationToken() + ", username=" + this.getUsername() + ", refreshToken=" + this.getRefreshToken() + ", expiresAt=" + this.getExpiresAt() + ")";
    }

    public static class AuthenticationResponseBuilder {
        private String authenticationToken;
        private String username;
        private String refreshToken;
        private Instant expiresAt;

        AuthenticationResponseBuilder() {
        }

        public AuthenticationResponseBuilder authenticationToken(String authenticationToken) {
            this.authenticationToken = authenticationToken;
            return this;
        }

        public AuthenticationResponseBuilder username(String username) {
            this.username = username;
            return this;
        }

        public AuthenticationResponseBuilder refreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
            return this;
        }

        public AuthenticationResponseBuilder expiresAt(Instant expiresAt) {
            this.expiresAt = expiresAt;
            return this;
        }

        public AuthenticationResponse build() {
            return new AuthenticationResponse(authenticationToken, username, refreshToken, expiresAt);
        }

        public String toString() {
            return "AuthenticationResponse.AuthenticationResponseBuilder(authenticationToken=" + this.authenticationToken + ", username=" + this.username + ", refreshToken=" + this.refreshToken + ", expiresAt=" + this.expiresAt + ")";
        }
    }
}
