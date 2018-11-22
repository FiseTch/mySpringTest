package com.fise.service;

import com.fise.domain.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMyUserService extends JpaRepository<MyUser,String> {


}
