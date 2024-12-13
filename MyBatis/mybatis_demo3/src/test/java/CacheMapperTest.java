import com.huangy.mybatis.mapper.CacheMapper;
import com.huangy.mybatis.mapper.EmpMapper;
import com.huangy.mybatis.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;


public class CacheMapperTest {
    /**
     * 二级缓存开启的条件：（4个条件缺一不可）
     *  a> 核心配置文件中，设置全局配置属性cacheEnabled="true"，默认为true，不需要设置
     *  b> 在映射文件中设置标签<cache />
     *  c> 二级缓存必须在sqlSession关闭或提交之后有效
     *  d> 查询的数据所转换的实体类类型必须实现序列化的接口
     *
     *  二级缓存失效：
     *  两次查询之间执行了任意的增删改，会使一级和二级缓存
     *
     *  缓存查询的顺序：
     *  先查询二级缓存，因为二级缓存中可能会有其他程序已经查出来的数据，可以拿来直接使用
     *  如果二级没有命中，再查询一级
     *  如果一级也没有命中，则查询DB
     *  sqlSession关闭后，一级缓存中的数据会写入二级缓存
     */

    @Test
    public void testTwoCache() {
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
            CacheMapper mapper = sqlSession1.getMapper(CacheMapper.class);
            List<Emp> emps1 = mapper.getAllEmp();
            sqlSession1.close();
            System.out.println(emps1);

            SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
            CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
            List<Emp> emps2 = mapper2.getAllEmp();
            sqlSession2.close();
            System.out.println(emps2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
