package com.mab.repository;

import com.mab.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 马斌 on 2018/12/4.
 */
public interface UserRepository extends JpaRepository<User,Integer>{

}
