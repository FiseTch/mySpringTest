package com.fise.domain;

import com.fise.util.MyDateUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "sys_user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MyUser implements UserDetails {

    @Id
    private String username;

    private String password;


    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    private MyRole myrole;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.commaSeparatedStringToAuthorityList(this.myrole.getUserRole());
    }

    @Override
    public boolean isAccountNonExpired() {

        int day = MyDateUtils.dayToNow(this.myrole.getCreateDate());

        return (this.myrole.getExpirePeriod() > day) ? true : false;
    }

    /**
     * 为真时。表示未锁定
     *
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return !this.myrole.isLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        int day = MyDateUtils.dayToNow(this.myrole.getPwdChangeTime());
        return (this.myrole.getPwdValidPeriod() > day) ? true : false;
    }

    /**
     * 返回为真时，表示用户有效
     *
     * @return
     */
    @Override
    public boolean isEnabled() {
        return !this.myrole.isAccountValid();
    }
}
