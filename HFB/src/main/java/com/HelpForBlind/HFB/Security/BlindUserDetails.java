package com.HelpForBlind.HFB.Security;

import com.HelpForBlind.HFB.Controllers.Models.BlindUsers;
import com.HelpForBlind.HFB.Enums.Status;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
public class BlindUserDetails implements UserDetails {

    private final String email ;
    private final String  password ;
    private final List<GrantedAuthority> authorityList ;
    private final boolean isActive;

    public BlindUserDetails(String email, String password, List<GrantedAuthority> authorityList, boolean isActive) {
        this.email = email;
        this.password = password;
        this.authorityList = authorityList;
        this.isActive = isActive;
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

    public static UserDetails fromUser(BlindUsers blindUsers){
        return new org.springframework.security.core.userdetails.User(
                blindUsers.getEmail(),
                blindUsers.getPassword(),
                blindUsers.getStatus().equals((Status.ACTIVE)),
                blindUsers.getStatus().equals((Status.ACTIVE)),
                blindUsers.getStatus().equals((Status.ACTIVE)),
                blindUsers.getStatus().equals((Status.ACTIVE)),
                blindUsers.getRole().getAuthorities()
        );

    }
}
