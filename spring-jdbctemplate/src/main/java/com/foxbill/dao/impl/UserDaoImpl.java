package com.foxbill.dao.impl;

import com.foxbill.dao.UserDao;
import com.foxbill.pojo.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create() {
        String sql = "CREATE TABLE `tb_user`  (\n" +
                "  `id` int NOT NULL AUTO_INCREMENT,\n" +
                "  `username` varchar(20) ,\n" +
                "  `password` varchar(20) ,\n" +
                "  `gender` char(1) ,\n" +
                "  `addr` varchar(30) ,\n" +
                "  PRIMARY KEY (`id`) \n" +
                ");";
        jdbcTemplate.execute(sql);
    }

    @Override
    public void add(User user) {
        String sql = "insert into tb_user values(null,?,?,?,?)";
        Object[] params = {user.getUsername(),user.getPassword(),user.getGender(),user.getAddr()};
        jdbcTemplate.update(sql,params);
    }

    @Override
    public void delete(int id) {
        String sql = "delete from tb_user where id = ?";
        Object[] params = {id};
        jdbcTemplate.update(sql,params);
    }

    @Override
    public void update(User user) {
        String sql = "update tb_user set username = ?,password = ?, gender = ?,addr = ? where id = ?";
        Object[] params = {user.getUsername(),user.getPassword(),user.getGender(),user.getAddr(),user.getId()};
        jdbcTemplate.update(sql,params);
    }

    @Override
    public List<User> findAllUsers() {
        String sql = "select * from tb_user";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        List<User> list = jdbcTemplate.query(sql, rowMapper);
        return list;
    }

    @Override
    public User findUserById(int id) {
        String sql = "select * from tb_user where id = ?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        Object[] params = {id};
        User user = jdbcTemplate.queryForObject(sql,rowMapper,params);
        return user;
    }

    @Override
    public int count() {
        String sql = "select count(*) from tb_user";
        SqlRowSet srs = jdbcTemplate.queryForRowSet(sql);
        if (srs.next()){
            return srs.getInt(1);
        }
        return 0;
    }
}
