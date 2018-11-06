### springboot整合freemarker

    1.引入freemarker依赖
        <!--整合 freemarker-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-freemarker</artifactId>
        </dependency>
        
    2.创建一个FtlIndexController类，代码如下
     @RequestMapping("/ftlIndex")
    public String ftlIndex(Map<String,String> map) {
        map.put("name","zhangsan");
        map.put("age","1");
        return "ftlIndex";
    }
    
    3.在/resources/templates文件夹下创建一个ftlIndex.ftl，代码如下
    <!DOCTYPE html>
    <html>
    <head lang="en">
        <meta charset="UTF-8" />
        <title></title>
    </head>
    <body>
    <h1>第一个ftl</h1>
    ${name},${age}
    
    <#if name="zhangsan">
        男生
    <#else>
    女生
    </#if>
    
    </body>
    </html>
    然后启动项目访问即可成功

### 全局异常捕获

    1.创建一个ErrorException异常捕获全局类
        /**
         * 设置全局异常处理类
         */
        @ControllerAdvice(basePackages = {"com.adu.springboot.controller"})
        public class ErrorException {
        
            @ExceptionHandler(RuntimeException.class)
            @ResponseBody
            public Map<String,Object> errorResult() {
                //在这里可以记录日志
                Map<String,Object> errorResultMap = new HashMap<>(10);
                errorResultMap.put("code",500);
                errorResultMap.put("message","系统错误!");
                return errorResultMap;
            }
        }
        
    2.然后其它地方只要运行时的异常就会全部捕获

### 全局日志配置

    1.创建一个log4j日志文件,代码直接看文件，里面有需要修改地址的地方
    2.创建一个WebLogAspect类
    3.执行后就会在控制台打印日志了
    注解：
    @Slf4j:同等于private static final Logger log = LoggerFactory.getLogger(WebLogAspect.class);
    
### lombok使用

    注解:
       @Data 标签，生成getter/setter toString()等方法 
       @NonNull : 让你不在担忧并且爱上NullPointerException 
       @CleanUp : 自动资源管理：不用再在finally中添加资源的close方法 
       @Setter/@Getter : 自动生成set和get方法 
       @ToString : 自动生成toString方法 
       @EqualsAndHashcode : 从对象的字段中生成hashCode和equals的实现 
       @NoArgsConstructor/@RequiredArgsConstructor/@AllArgsConstructor 
       自动生成构造方法 
       @Data : 自动生成set/get方法，toString方法，equals方法，hashCode方法，不带参数的构造方法 
       @Value : 用于注解final类 
       @Builder : 产生复杂的构建器api类
       @SneakyThrows : 异常处理（谨慎使用） 
       @Synchronized : 同步方法安全的转化 
       @Getter(lazy=true) : 
       @Log : 支持各种logger对象，使用时用对应的注解，如：@Log4
       @Accessors(chain = true):使用链式编程

### 多数据源

    1.创建2个包，为多数据源的组
        com.adu.testdatasource.test01
        com.adu.testdatasource.test02
        
    2.com.adu.testdatasource.test01包中创建业务以及数据访问类
        com.adu.testdatasource.test01.mapper.DeptMapper01
        com.adu.testdatasource.test01.service.DeptService01
        详细代码直接看项目
    3.com.adu.testdatasource.test02包中创建业务以及数据访问类
        com.adu.testdatasource.test02.mapper.DeptMapper02
        com.adu.testdatasource.test02.service.DeptService02
        详细代码直接看项目
    4.重点：在全局配置文件中创建2个链接参数
        ###datasource1
        spring.datasource.test1.driver-class-name = com.mysql.jdbc.Driver
        spring.datasource.test1.jdbc-url = jdbc:mysql://localhost:3306/clouddb01?useUnicode=true&characterEncoding=utf-8
        spring.datasource.test1.username = root
        spring.datasource.test1.password = root
        ###datasource2
        spring.datasource.test2.driver-class-name = com.mysql.jdbc.Driver
        spring.datasource.test2.jdbc-url = jdbc:mysql://localhost:3306/clouddb01?useUnicode=true&characterEncoding=utf-8
        spring.datasource.test2.username = root
        spring.datasource.test2.password = root
    5.创建DataSource1Config和DataSource2Config个配置类
        
        注意:@MapperScan(basePackages="注解中配置各自的扫描包")
        以及@ConfigurationProperties(prefix = "spring.datasource.test1或者spring.datasource.test2")
        表示扫描的配置文件中spring.datasource.test1和spring.datasource.test2下的所有参数
        
        详情见以下2个类的代码：
             com.adu.testdatasource.datasource.DataSource1Config
             com.adu.testdatasource.datasource.DataSource2Config
             
### 多数据源事物管理
    
    将service层的需要事物的方法加上@Transactional注解，然后指定事物方法即可。
    指定的事物名称为:DataSource1Config和DataSource2Config中的事务管理名称
    代码如下：
     @Transactional(transactionManager="test2TransactionManager")
        public List<DeptEntity> getAll() {
            List<DeptEntity> deptAll = deptMapper02.getAll();
            return deptAll;
        }
            
### mybatis分页插件
    
     1.引入PageHelper的jar包
        <!--整合分页-->
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper-spring-boot-starter</artifactId>
            <version>1.2.5</version>
        </dependency>
        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-lang3</artifactId>
        </dependency>
        
     2.配置文件写入以下配置代码
        logging.level.com.example.demo.dao=DEBUG
        pagehelper.helperDialect=mysql
        pagehelper.reasonable=true
        pagehelper.supportMethodsArguments=true
        pagehelper.params=count=countSql
        pagehelper.page-size-zero=true
        
     3.书写分页代码
        public PageInfo<DeptEntity> getAllPageInfo(int page,int pageSize) {
             Page<Object> objects = PageHelper.startPage(page, pageSize);
             List<DeptEntity> deptAll = deptMapper01.getAll();
             PageInfo<DeptEntity> pageInfo = new PageInfo<>(deptAll);
             return pageInfo;
         }
         
### 扫包优化

    @SpringBootApplication=@ComponentScan+@EnableAutoConfiguration
    
### java -jar xxx.jar中没有主清单属性解决方法

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <mainClass>com.adu.SpringbootStudyApplication</mainClass>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
    
### 压力测试使用软件 apache jmeter
    
    下载地址：链接：https://pan.baidu.com/s/1YLdY-0M7tZkwnlDQHZG9Kw 提取码：d5xt 
         
