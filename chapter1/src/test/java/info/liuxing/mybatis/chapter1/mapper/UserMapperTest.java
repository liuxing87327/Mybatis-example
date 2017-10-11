package info.liuxing.mybatis.chapter1.mapper;

import info.liuxing.mybatis.chapter1.model.User;
import info.liuxing.mybatis.chapter1.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * UserMapperTest
 *
 * @author liuxing (SE)
 * @summary UserMapperTest
 * @Copyright (c) 2017, Lianjia Group All Rights Reserved.
 * @since 2017-10-11 18:01
 */
public class UserMapperTest {

    @Test
    public void testInsert() throws Exception {
        User user = new User();
        user.setUserName("test");
        user.setPassword("111111");

        SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession();
        sqlSession.getMapper(UserMapper.class).insert(user);
        sqlSession.commit();
        sqlSession.close();
        Assert.assertNotNull(user.getId());
    }

    @Test
    public void testUpdate() throws Exception {
        User user = new User();
        user.setId(1);
        user.setUserName("test");
        user.setPassword("111111");

        SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession();
        long count = sqlSession.getMapper(UserMapper.class).update(user);
        sqlSession.commit();
        sqlSession.close();
        Assert.assertTrue(count > 0);
    }

    @Test
    public void testFindById() throws Exception {
        SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession();

        User user = sqlSession.getMapper(UserMapper.class).findById(1);
        sqlSession.close();

        System.out.println(user.toString());

        Assert.assertNotNull(user);
    }

    @Test
    public void testDelete() throws Exception {
        SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession();

        long count = sqlSession.getMapper(UserMapper.class).delete(1);
        sqlSession.commit();
        sqlSession.close();

        Assert.assertTrue(count > 0);
    }

}