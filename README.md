# spring-boot-demo

spring boot demo工程 可以作为脚手架工程使用
配置使用官方推荐的 yml配置

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
    Exception统一管理。
    shiro权限管理。
    aop日志记录。

4、调度
======

    使用quartz设置定时任务。

5、缓存和Session
===========

    注解redis缓存数据，Spring-session和redis实现分布式session同步(暂无)。

6、日志
===========

    logback打印日志，业务日志和调试日志分开打印。同时基于时间和文件大小分割日志文件。(暂无)