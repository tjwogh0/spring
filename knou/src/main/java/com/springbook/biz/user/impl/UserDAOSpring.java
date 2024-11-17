package com.springbook.biz.user.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.springbook.biz.user.UserVO;

//DAO(Data Access Object)
@Repository
public class UserDAOSpring {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // SQL 명령어들
    private final String USER_GET = "select * from user where user_id=? and password=?";
    private final String USER_ADD = "insert into users(id, pass, name) values(?,?,?)";
    private final String USER_UPDATE = "update users set name=?, role=? where id=?";

    public void updateUser(UserVO vo) {
        Object[] params = {vo.getName(), vo.getRole(), vo.getId()};
        int[] types = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        jdbcTemplate.update( USER_UPDATE, params, types );
    }
    public void addUser(UserVO vo) {
        jdbcTemplate.update( USER_ADD, vo.getId(), vo.getPassword(), vo.getName());
    }

    // CRUD 기능의 메소드 구현
    public UserVO getUser(UserVO vo){
        System.out.println("===> JDBC로 getUser() 기능 처리");
        Object[] args ={vo.getId(), vo.getPassword()};
        return jdbcTemplate.queryForObject(USER_GET, args, new UserRowMapper());
    }
}
class UserRowMapper implements RowMapper<UserVO>{
    public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserVO user = new UserVO();
        user.setId(rs.getString("ID"));
        user.setPassword(rs.getString("PASSWORD"));
        user.setName(rs.getString("NAME"));
        user.setRole(rs.getString("ROLE"));
        return user;
    }
}