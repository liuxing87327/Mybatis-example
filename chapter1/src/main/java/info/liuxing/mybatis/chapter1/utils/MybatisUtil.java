package info.liuxing.mybatis.chapter1.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * MybatisUtil
 *
 * @author liuxing (SE)
 * @summary MybatisUtil
 * @Copyright (c) 2017, Lianjia Group All Rights Reserved.
 * @since 2017-10-11 17:56
 */
public class MybatisUtil {

    private static SqlSessionFactory sqlSessionFactory = null;

    static {
        // 配置文件
        String resource = "mybatis-config.xml";

        // 加载配置文件到输入流
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(inputStream)) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        return sqlSessionFactory;
    }

}
