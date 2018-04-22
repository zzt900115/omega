package com.zzt.demo.omega.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.plugins.parser.ISqlParser;
import com.baomidou.mybatisplus.plugins.parser.tenant.TenantHandler;
import com.baomidou.mybatisplus.plugins.parser.tenant.TenantSqlParser;
import com.baomidou.mybatisplus.toolkit.PluginUtils;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import org.apache.ibatis.mapping.MappedStatement;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Description : MyBatis-Plus 配置
 * Created by com on  2017/12/5
 *
 * @author geYang
 **/
@Configuration
@MapperScan("com.gy.demo.mapper")	//添加mybatis扫描注解，参数为mapper文件所在的包名
public class MybatisPlusConfig {
    private Logger logger = LoggerFactory.getLogger(MybatisPlusConfig.class);
    /**
     * mybatis-plus SQL执行效率插件【生产环境可以关闭】
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        logger.info("Mybatis-Plus: 开启 SQL执行效率 插件");
        return new PerformanceInterceptor();
    }

    /**
     * mybatis-plus分页插件;文档:http://mp.baomidou.com
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        // 开启 PageHelper 的支持
        logger.info("Mybatis-Plus: 开启 PageHelper 的支持");
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setLocalPage(true);

       /* *//*
         * 【测试多租户】 SQL 解析处理拦截器<br>
         * 这里固定写成住户 1 实际情况你可以从cookie读取，因此数据看不到 【 麻花藤 】 这条记录（ 注意观察 SQL ）<br>
         *//*
        *//**//*
        logger.info("Mybatis-Plus: 【测试多租户】 SQL 解析处理拦截器");
        List<ISqlParser> sqlParserList = new ArrayList<>();
        TenantSqlParser tenantSqlParser = new TenantSqlParser();
        tenantSqlParser.setTenantHandler(new TenantHandler() {
            @Override
            public Expression getTenantId () {
                return new LongValue(1L);
            }
            @Override
            public String getTenantIdColumn () {
                return "tenant_id";
            }
            @Override
            public boolean doTableFilter (String s) {
                // 过滤自定义查询此时无租户信息约束【 麻花藤 】出现
                String user = "user";
                return user.equals(s);
            }
        });
        sqlParserList.add(tenantSqlParser);
        paginationInterceptor.setSqlParserList(sqlParserList);
        paginationInterceptor.setSqlParserFilter(metaObject -> {
            MappedStatement ms = PluginUtils.getMappedStatement(metaObject);
            // 过滤自定义查询此时无租户信息约束【 麻花藤 】出现
            String method = "com.gy.demo.mapper.UserMapper.selectListBySQL";
            return method.equals(ms.getId());
        });
*/

        return paginationInterceptor;
    }



}