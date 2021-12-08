package io.murad.askdev.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Password is required")
    private String password;

    @NotEmpty(message = "Email is required")
    private String email;

    @NotEmpty(message = "Name is required")
    private String fullname;

    private Instant created;
    private boolean enabled;

    public User(Long userId, @NotBlank(message = "Username is required") String username, @NotBlank(message = "Password is required") String password, @NotEmpty(message = "Email is required") String email, @NotEmpty(message = "Name is required") String fullname, Instant created, boolean enabled) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullname = fullname;
        this.created = created;
        this.enabled = enabled;
    }

    public User() {
    }

    public Long getUserId() {
        return this.userId;
    }

    public @NotBlank(message = "Username is required") String getUsername() {
        return this.username;
    }

    public @NotBlank(message = "Password is required") String getPassword() {
        return this.password;
    }

    public @NotEmpty(message = "Email is required") String getEmail() {
        return this.email;
    }

    public Instant getCreated() {
        return this.created;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUsername(@NotBlank(message = "Username is required") String username) {
        this.username = username;
    }

    public void setPassword(@NotBlank(message = "Password is required") String password) {
        this.password = password;
    }

    public void setEmail(@NotEmpty(message = "Email is required") String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof User)) return false;
        final User other = (User) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$userId = this.getUserId();
        final Object other$userId = other.getUserId();
        if (this$userId == null ? other$userId != null : !this$userId.equals(other$userId)) return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$created = this.getCreated();
        final Object other$created = other.getCreated();
        if (this$created == null ? other$created != null : !this$created.equals(other$created)) return false;
        if (this.isEnabled() != other.isEnabled()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof User;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $userId = this.getUserId();
        result = result * PRIME + ($userId == null ? 43 : $userId.hashCode());
        final Object $username = this.getUsername();
        result = result * PRIME + ($username == null ? 43 : $username.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $created = this.getCreated();
        result = result * PRIME + ($created == null ? 43 : $created.hashCode());
        result = result * PRIME + (this.isEnabled() ? 79 : 97);
        return result;
    }

    public String toString() {
        return "User(userId=" + this.getUserId() + ", username=" + this.getUsername() + ", password=" + this.getPassword() + ", email=" + this.getEmail() + ", created=" + this.getCreated() + ", enabled=" + this.isEnabled() + ")";
    }
}
