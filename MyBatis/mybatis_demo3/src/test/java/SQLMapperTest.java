import com.huangy.mybatis.mapper.EmpMapper;
import com.huangy.mybatis.pojo.Emp;
import com.huangy.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class SQLMapperTest {

    /**
     * 解决字段名和属性名不一致的情况：
     * a> 为字段起别名，保持和属性名的一致
     * b> 设置全局配置，将 _ 自动映射为驼峰
     * <setting name="mapUnderscoreToCamelCase" value="true"/>
     * c> 通过reusltMap设置自定义的映射关系
     *      <resultMap id="empResultMap" type="Emp">
     *         <id property="eid" column="eid"/>
     *         <result property="empName" column="emp_name"/>
     *         <result property="age" column="age"/>
     *         <result property="sex" column="sex"/>
     *         <result property="email" column="email"/>
     *      </resultMap>
     */

    @Test
    public void testEmpMapper() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> list = mapper.getAllEmp();
        System.out.println(list);
    }
}
