import com.huangy.mybatis.mapper.DynamicSQLMapper;
import com.huangy.mybatis.pojo.Emp;
import com.huangy.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class DynamicSQLMapperTest {

    /**
     * 动态SQL
     * 1. if：根据标签中的test属性所对应的表达式决定标签中的内容是否需要拼接到SQL中
     */
    @Test
    public void testGetEmp() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> emps = mapper.getEmpByCondition(new Emp(null, null, null, "男", "123@qq.com", -1, null));
        System.out.println(emps);
    }
}
