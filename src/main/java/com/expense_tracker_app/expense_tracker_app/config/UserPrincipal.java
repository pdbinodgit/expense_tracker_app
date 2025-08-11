package com.expense_tracker_app.expense_tracker_app.config;

import com.expense_tracker_app.expense_tracker_app.role.model.Role;
import com.expense_tracker_app.expense_tracker_app.userinformation.model.UserInformation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Getter
@Setter
public class UserPrincipal implements UserDetails {

    private Long id;

    private String  firstName;

    private String middleName;

    private String lastName;

    private String username;

    @JsonIgnore
    private String password;

    public Collection<? extends GrantedAuthority> authorities;


    public UserPrincipal(Long id, String firstName, String middleName,
                         String lastName, String username, String password,
                         Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserPrincipal build(UserInformation userInformation){
        List<GrantedAuthority> grantedAuthorities=new ArrayList<>();
        for (Role role:userInformation.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName().name()));
        }
        return new UserPrincipal(userInformation.getId(),
                userInformation.getFirstName(),
                userInformation.getMiddleName(),
                userInformation.getLastName(),
                userInformation.getUsername(),
                userInformation.getPassword(),
                grantedAuthorities
        );


    }

    /**
     * Returns the authorities granted to the user. Cannot return <code>null</code>.
     *
     * @return the authorities, sorted by natural key (never <code>null</code>)
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    /**
     * Returns the password used to authenticate the user.
     *
     * @return the password
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Returns the username used to authenticate the user. Cannot return
     * <code>null</code>.
     *
     * @return the username (never <code>null</code>)
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Indicates whether the user's account has expired. An expired account cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user's account is valid (ie non-expired),
     * <code>false</code> if no longer valid (ie expired)
     */
    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    /**
     * Indicates whether the user is locked or unlocked. A locked user cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user is not locked, <code>false</code> otherwise
     */
    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    /**
     * Indicates whether the user's credentials (password) has expired. Expired
     * credentials prevent authentication.
     *
     * @return <code>true</code> if the user's credentials are valid (ie non-expired),
     * <code>false</code> if no longer valid (ie expired)
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    /**
     * Indicates whether the user is enabled or disabled. A disabled user cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user is enabled, <code>false</code> otherwise
     */
    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
