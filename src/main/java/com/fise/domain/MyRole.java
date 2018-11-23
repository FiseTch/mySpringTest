package com.fise.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "sys_role")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_role")
    private String userRole;


    @Column(name = "is_locked")
    private boolean isLocked;

    //账户有效期 以天为单位
    @Column(name = "expire_period")
    private int expirePeriod;


    //密码有效期,以天为单位
    @Column(name = "pwd_valid_period")
    private int PwdValidPeriod;

    //账户是否有效
    @Column(name = "is_account_valid")
    private boolean isAccountValid;

    @Column(name = "pwd_change_time")
    private Date pwdChangeTime;


    @CreationTimestamp
    @Column(name = "create_date")
    private Date createDate;

    @UpdateTimestamp
    @Column(name = "update_date")
    private Date updateDate;

}
