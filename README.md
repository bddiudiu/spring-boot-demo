# spring-boot-demo

主要功能如下：
=====
1、数据库
======

    Druid数据库连接池，监控数据库访问性能，详细统计SQL的执行性能，这对于线上分析数据库访问性能有帮助。
    数据库密码加密。(暂无)

2、持久层
======

    mybatis持久化，PageHelper分页。
    Transtraction注解。(自行使用注解)
    通用Mapper。

3、MVC
======

    基于spring mvc注解。
    Exception统一管理。(暂无)
    shiro权限管理。(暂无)
    aop日志记录。

4、调度
======

    定时任务。
    Spring task, 可以查询已经注册的任务。立即执行一次任务。(暂无)

5、缓存和Session
===========

    注解redis缓存数据，Spring-session和redis实现分布式session同步(暂无)。

6、日志
===========

    logback打印日志，业务日志和调试日志分开打印。同时基于时间和文件大小分割日志文件。(暂无)