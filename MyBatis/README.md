这个项目主要用来学习Mybatis

参考学习网站是：
https://www.bilibili.com/video/BV1VP4y1c7j7?spm_id_from=333.788.player.switch&vd_source=c671d9c583b11dc168bf9c2214512eef&p=8
对于比较重要的内容，会在项目关键位置加以注释，方便复盘学习。

官方地址：
https://github.com/mybatis/mybatis-3/releases

学习的目标：
1. Mybatis是什么
2. Mybatis的基本配置
3. Mybatis的基本使用

学习进度：
2024-11-25  
    09节 安装mysql，建表，配置一个测试环境
2024-11-26   
    11节 测试功能呢
2024-11-27
    11节，完成测试功能，获取sqlSession访问db，插入数据成功
2024-11-28
    14节，完成增删改查的测试功能，添加日志，使用ResultType
2024-11-30
    15节-18节，核心配置文件详解
    22节，完成之前内容的回顾，mapper，核心配置文件模版
2024-12-02
    23节-28节，参数如何传递；基本上归纳为两种方式，一种是用@Param，一种实体类型对象
2024-12-05
    30-33节，各种查询功能 @MapKey的使用 返回结果集，List，map
2024-12-09
    34-42节，模糊查询、批量删除，动态表名，获取自增主键；ResultMap的使用
2024-12-10
    43-45节，ResultMap表示一对多的关系，分布查询，以及延迟加载
2024-12-11
    46-47节，ResultMap表示多对一的关系，collection用法，分布查询用法
2024-12-12
    55节，动态sql学完
2024-12-13
    56节
    MyBatis一级缓存
        自动开启，SqlSession级别
    MyBatis二级缓存
        手动开启，SqlSessionFactory级别
        二级缓存必须在SqlSession关闭或提交之后有效（没关闭前，先保存到一级缓存）
    整合第三方缓存EHCache
        代替二级缓存，一级缓存无法替代
        只要会配置即可
2024-12-18
    逆向工程，清晰简洁版，奢华尊享版，QBC风格的操作
    编写配置文件generatorConfig.xml，在MavenMBG项目的plugins中，双击mybatis-generator，生成mapper接口，实体类，和xml映射文件
    
    分页插件
    Page{count=true, pageNum=2, pageSize=4, startRow=4, endRow=8, total=10, pages=3, reasonable=false, pageSizeZero=false}
    [Emp{eid=9, empName='张三3', age=null, sex='男', email='123@qq.com', did=null}, 
    Emp{eid=10, empName='张三4', age=null, sex='男', email='123@qq.com', did=null}, 
    Emp{eid=11, empName='张三1', age=null, sex='男', email='123@qq.com', did=null}, 
    Emp{eid=12, empName='张三2', age=null, sex='男', email='123@qq.com', did=null}]


    PageInfo{pageNum=2, pageSize=4, size=4, startRow=5, endRow=8, total=10, pages=3, 
    list=Page{count=true, pageNum=2, pageSize=4, startRow=4, endRow=8, total=10, pages=3, reasonable=false, pageSizeZero=false}
    [Emp{eid=9, empName='张三3', age=null, sex='男', email='123@qq.com', did=null}, 
    Emp{eid=10, empName='张三4', age=null, sex='男', email='123@qq.com', did=null}, 
    Emp{eid=11, empName='张三1', age=null, sex='男', email='123@qq.com', did=null}, 
    Emp{eid=12, empName='张三2', age=null, sex='男', email='123@qq.com', did=null}], 
    prePage=1, nextPage=3, isFirstPage=false, isLastPage=false, hasPreviousPage=true, hasNextPage=true, navigatePages=5, navigateFirstPage=1, navigateLastPage=3, 
    navigatepageNums=[1, 2, 3]}
