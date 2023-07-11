package com.infinitecodes.jsShopBackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infinitecodes.jsShopBackend.dao.daoCustomImpl.UserRepositoryImpl;
import com.infinitecodes.jsShopBackend.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryImpl {
    
}
