package com.infinitecodes.jsShopBackend.dao.daoCustomImpl;

import com.infinitecodes.jsShopBackend.model.User;
import java.util.List;

public interface UserRepositoryImpl {

    List<User> findByEmail(String email);

    List<User> findByPasswort(String password);
}
