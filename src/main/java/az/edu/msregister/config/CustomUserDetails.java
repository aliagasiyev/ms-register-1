package az.edu.msregister.config;

import az.edu.msregister.entity.UserEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

public record CustomUserDetails(UserEntity userEntity) implements UserDetails, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    public Collection getAuthorities() {
        return Collections.singletonList(
                new SimpleGrantedAuthority("ROLE_" + userEntity.getRole().name())
        );
    }

    @Override
    public String getPassword() {
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return userEntity.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}