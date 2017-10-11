package info.liuxing.mybatis.chapter1.mapper;

import info.liuxing.mybatis.chapter1.model.User;

/**
 * UserMapper
 *
 * @author liuxing (SE)
 * @summary UserMapper
 * @Copyright (c) 2017, Lianjia Group All Rights Reserved.
 * @since 2017-10-11 17:24
 */
public interface UserMapper {

    void insert(User user);

    long update(User user);

    User findById(int id);

    long delete(int id);

}
