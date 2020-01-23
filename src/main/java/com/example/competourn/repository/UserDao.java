package com.example.competourn.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Repository
public class UserDao extends JdbcDaoSupport {


    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public boolean checkValidUser(final String userName) {
        String sql = "SELECT count(*) FROM userdetails WHERE username = ?";
        Integer userDetails = getJdbcTemplate().queryForObject(sql, new Object[]{userName}, Integer.class);
        if (userDetails == 1)
            return true;
        else
            return false;
    }

    public String getLoginCredentials(String userName) {
        String sql = "SELECT password FROM userdetails WHERE username = ?";
        return getJdbcTemplate().queryForObject(sql, new Object[]{userName}, String.class);
    }


}
