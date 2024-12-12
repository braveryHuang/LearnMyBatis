import com.huangy.mybatis.mapper.DynamicSQLMapper;
import com.huangy.mybatis.pojo.Emp;
import com.huangy.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DynamicSQLMapperTest {

    /**
     * 动态SQL
     * 1. if：根据标签中的test属性所对应的表达式决定标签中的内容是否需要拼接到SQL中
     * 2. where：
     *      当where标签中有内容时，会自动生成where关键字，并且将内容前多余的and或or去掉
     *      当where标签中没有内容时，此时where没有任何效果
     *      注意：where标签不能将其中内容后面多余的and或or去掉
     *
     * 3. trim
     *  若标签中有内容时：
     *  suffix | prefix: 将trim标签中内容前或后，添加指定内容
     *  suffixOverrides | prefixOverrides : 将trim标签中内容前或后，去掉指定内容
     *  若标签中没有内容时，trim标签也没有任何效果
     *
     * 4. choose,when,otherwise 相当于if... else if... else
     *  when 至少要有一个，otherwise最多只能有一个
     * 5. foreach
     *  collection：设置需要循环的数组或集合
     *  item：表示数组或集合中的每一个数据
     *  separator：循环体之间的分隔符
     *  open：foreach标签所循环的所有内容的开始符
     *  close：foreach标签所循环的所有内容的结束符
     *
     *  实际工作中，if，where，foreach用的比较多
     */
    @Test
    public void testGetEmp() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> emps = mapper.getEmpByCondition(new Emp(null, "张三", null, "男", "123@qq.com", -1, null));
        System.out.println(emps);
    }

    @Test
    public void testGetEmpByChoose() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> emps = mapper.getEmpByChoose(new Emp(null, "张三", null, "男", "123@qq.com", -1, null));
        System.out.println(emps);
    }

    @Test
    public void testDeleteMoreByArray() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        int count = mapper.deleteMoreByArray(new Integer[]{1, 2, 3, 4});
        System.out.println(count);
    }

    @Test
    public void testInsertMoreByList() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null, "张三1", null, "男", "123@qq.com", -1, null);
        Emp emp2 = new Emp(null, "张三2", null, "男", "123@qq.com", -1, null);
        Emp emp3 = new Emp(null, "张三3", null, "男", "123@qq.com", -1, null);
        Emp emp4 = new Emp(null, "张三4", null, "男", "123@qq.com", -1, null);
        List<Emp> emps = Arrays.asList(emp1, emp2, emp3, emp4);
        int count = mapper.insertMoreByList(emps);
        System.out.println(count);
    }
}
