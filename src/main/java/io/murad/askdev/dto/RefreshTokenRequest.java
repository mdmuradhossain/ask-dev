package io.murad.askdev.dto;

import javax.validation.constraints.NotBlank;

public class RefreshTokenRequest {

    @NotBlank
    private String refreshToken;
    private String username;

    public RefreshTokenRequest(@NotBlank String refreshToken, String username) {
        this.refreshToken = refreshToken;
        this.username = username;
    }

    public RefreshTokenRequest() {
    }

    public @NotBlank String getRefreshToken() {
        return this.refreshToken;
    }

    public String getUsername() {
        return this.username;
    }

    public void setRefreshToken(@NotBlank String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof RefreshTokenRequest)) return false;
        final RefreshTokenRequest other = (RefreshTokenRequest) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$refreshToken = this.getRefreshToken();
        final Object other$refreshToken = other.getRefreshToken();
        if (this$refreshToken == null ? other$refreshToken != null : !this$refreshToken.equals(other$refreshToken))
            return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof RefreshTokenRequest;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $refreshToken = this.getRefreshToken();
        result = result * PRIME + ($refreshToken == null ? 43 : $refreshToken.hashCode());
        final Object $username = this.getUsername();
        result = result * PRIME + ($username == null ? 43 : $username.hashCode());
        return result;
    }

    public String toString() {
        return "RefreshTokenRequest(refreshToken=" + this.getRefreshToken() + ", username=" + this.getUsername() + ")";
    }
}
