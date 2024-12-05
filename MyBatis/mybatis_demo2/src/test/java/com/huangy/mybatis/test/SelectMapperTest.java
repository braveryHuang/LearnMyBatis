package com.huangy.mybatis.test;

import com.huangy.mybatis.mapper.SelectMapper;
import com.huangy.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class SelectMapperTest {

    /**
     * MyBatis的各种查询功能：
     * 1. 若查询出的数据只有一条
     * a> 可以通过实体类对象接收
     * b> 可以通过List集合接收
     * c> 通过map集合接收
     * 结果：{password=123456, name=admin, id=1, age=23, male=男, email=123@qq.com}
     *
     * 2. 若查询出的数据有多条
     * a> 可以通过实体类型的List集合来接收
     * b> 可以通过map类型的list集合接收
     * c> 可以在mapper接口的方法上添加@MapKey注解，此时就可以将每条数据转换到map集合作为值，以某个字段的值来作为键，放在同一个map集合中
     * 注意：一定不能通过实体类对象接收，此时会抛出异常TooManyResultsException
     *
     * MyBatis中设置了默认的类型别名
     * java.lang.Integer --> int, integer
     * int --> _int, _integer
     * Map --> map
     * string --> string
     */

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        /*System.out.println(mapper.getUserById(1));*/
        System.out.println(mapper.getAllUser());
    }

    @Test
    public void testGetCount() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getCount());
    }

    @Test
    public void testGeUserByIdToMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);

        //查询出来的结果，没有任何一个实体类与其相对应，就可以直接查询出来的结果，转换为map，字段为键，字段值为值
        //又或者是，多表查询的时候，结果集没有一个实体类对象关联，用map更合适
        System.out.println(mapper.getAllUserToMap());
    }

}
