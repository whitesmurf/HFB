package com.HelpForBlind.HFB.Security;

import com.HelpForBlind.HFB.Controllers.Models.BlindUsers;
import com.HelpForBlind.HFB.Enums.Status;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
public class BlindUserDetails implements UserDetails {

    private final String email ;
    private final String  password ;
    private final List<GrantedAuthority> authorityList ;
    private final boolean isActive;

    public BlindUserDetails(BlindUsers users) {
        this.email = users.getEmail();
        this.password = users.getPassword();
        this.authorityList = List.of(new SimpleGrantedAuthority(users.getRole().name()));
        this.isActive = users.getStatus().equals(Status.ACTIVE);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorityList;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }
}
