package com.example.mybatis_demo.mybatis;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;

import java.sql.Connection;
import java.util.Properties;

/**
 * 慢查询sql 插件
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
public class SlowSqlPlugin implements Interceptor {
    private long slowTime;

    //拦截后需要处理的业务
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        //通过StatementHandler获取执行的sql
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        BoundSql boundSql = statementHandler.getBoundSql();
        String sql = boundSql.getSql();
        long start = System.currentTimeMillis();
        //结束拦截
        Object proceed = invocation.proceed();
        long end = System.currentTimeMillis();
        long f = end - start;
        System.out.println(sql);
        System.out.println("耗时=" + f);
        if (f > slowTime) {
            System.out.println("本次数据库操作是慢查询，sql是:");
            System.out.println(sql);
        }
        return proceed;
    }

    //获取到拦截的对象，底层也是通过代理实现的，实际上是拿到一个目标代理对象
    @Override
    public Object plugin(Object target) {
        //触发intercept方法
        return Plugin.wrap(target, this);
    }

    //设置属性
    @Override
    public void setProperties(Properties properties) {
        //获取我们定义的慢sql的时间阈值slowTime
        this.slowTime = Long.parseLong(properties.getProperty("slowTime"));
    }
}