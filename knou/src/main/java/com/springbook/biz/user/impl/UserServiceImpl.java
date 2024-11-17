package com.springbook.biz.user.impl;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

//    public void setUserDAO(UserDAO userDAO) {
//        this.userDAO = userDAO;
//    }

    public UserVO getUser(UserVO vo) {
        return userDAO.getUser(vo);
    }
}
