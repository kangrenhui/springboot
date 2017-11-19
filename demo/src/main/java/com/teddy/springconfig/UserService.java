package com.teddy.springconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/11/13 0013.
 */
@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public String getUserDao(){
        return userDao.getUserName();
    }
}

