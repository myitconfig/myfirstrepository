package snippet;

public class Snippet {
	#spring配置
	spring:
	  datasource:
	    driver-class-name: com.mysql.jdbc.Driver
	    url: jdbc:mysql://cdb-ej42ajla.bj.tencentcdb.com:10053/test?autoReconnect=false&useAffectedRows=true&useUnicode=true&characterEncoding=utf-8&useSSL=false
	    username: root
	    password: gcmysql123
	    type: com.alibaba.druid.pool.DruidDataSource
	  cache:
	    ehcache:
	      config: ehcache.xml
	 
	#mybatis配置
	mybatis:
	  type-aliases-
}

