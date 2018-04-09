package com.xphsc.jpa.repository.dao;

import com.xphsc.jpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by ${huipei.x} on 2017-2-25.
 * qq群593802274
 */
public interface UserRepository extends JpaRepository<User,Integer>, QueryDslPredicateExecutor<User> {
}
