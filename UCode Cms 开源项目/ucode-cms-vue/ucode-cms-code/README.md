### 一、模块简介

视频教程[MybatisPlus代码生成器](https://www.bilibili.com/video/BV12Y4y1W7oc)

##### 1、功能亮点

实时读取库表结构元数据信息，比如表名、字段名、字段类型、注释等，选中修改后的表，点击`一键生成`，代码成即可提现出表结构的变化。

单表快速转化restful风格的API接口并对外暴露服务。对于百余张表的数据库，使用代码生成器让开发事半功倍。

多表连接查询。多表连接查询默认不开启，需要在全局文件中手动配置。

开启多表连接查询后，代码生成器会自动读取数据库元数据信息中的`主外键关系`，分别生成`一对一`、`一对多`、`多对多`风格的源代码。

##### 2、运行依赖服务

代码生成器运行依赖`Mysql数据库`，版本不限。

- Mysql数据库

Mysql数据库中库表结构为用户自定义的库表，代码生成将会读取。项目SQL脚本提供5张测试表，方便用于测试使用。

>   当前代码生成器属于`1.6.3`版本。
```xml
<dependency>
    <groupId>xin.altitude.cms</groupId>
    <artifactId>ucode-cms-code-spring-boot-starter</artifactId>
    <version>1.6.4.1-beta</version>
</dependency>
```

### 二、两种典型使用场景


#### （一）克隆Demo项目

使用demo脚手架[cms demo项目](https://gitee.com/decsa/demo-code) ，脚手架是标准的Spring Web工程，稍微修改配置文件可快速入门上手。

```bash
# 拉去脚手架，并初始化项目
git clone https://gitee.com/decsa/demo-code.git
```
##### 1、修改数据库连接配置

运行测试SQL脚本，添加数据库表结构，开始体验代码生成的功能。

```
spring:
  datasource:
    driverClassName: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/ucode-cms
    username: root
    password: 123456
```

##### 2、添加依赖

检查pom文件中是否包含代码生成器Maven包依赖，如果没有，则添加如下依赖。如果使用阿里云Maven镜像，可能同步不及时，适当降低版本号即可。

```xml
<dependency>
    <groupId>xin.altitude.cms</groupId>
    <artifactId>ucode-cms-code-spring-boot-starter</artifactId>
    <version>1.6.4.1-beta</version>
</dependency>
```

附带检查POM文件中是否有如下依赖，版本号既可以相同也可以自行选择，没有自行添加。
```xml
<dependency>
    <groupId>xin.altitude.cms</groupId>
    <artifactId>ucode-cms-common</artifactId>
    <version>1.6.4.1-beta</version>
</dependency>
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.5.0</version>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>
```

> 将关联依赖从starter启动器内剥离，是为了更好的解决版本兼容性问题
> 同时移除代码生成器依赖会更佳流畅

完成上述两步配置后，启动项目，查看控制台日志，点击链接进入`可视化控制台`界面。形如：
```text
========点击(http://localhost:8080/#/gen)进入代码生成器控制台========
```
其中端口是通过自动读取配置计算出来的。
##### 3、可视化界面

点击免登录进入代码生成器，进入管理界面。

![WX20220612-185859@2x3333A](https://www.altitude.xin/typora/WX20220612-185859@2x3333A.png)

勾选表结构，点击生成，重启项目，相应的代码生效。

> 代码生成后，找不到代码的朋友，请检查是否是多模块项目。多模块项目需要指定`模块名`，否则它也不知道改存储在哪里呀！参考下面常见配置！

---

#### （二）独立创建项目
独立创建项目支持从零构建代码生成器运行环境，既支持嵌入已存在的项目中，也支持新创建的项目。2.0版本重点优化此部分内容。

##### 1、添加依赖
```xml
<!--代码本地化生成依赖-->
<dependency>
    <groupId>xin.altitude.cms</groupId>
    <artifactId>ucode-cms-code-spring-boot-starter</artifactId>
    <version>1.6.4.1-beta</version>
</dependency>
```
关联依赖也要添加，如果有，可以忽略
```xml
<dependency>
    <groupId>xin.altitude.cms</groupId>
    <artifactId>ucode-cms-common</artifactId>
    <version>1.6.4.1-beta</version>
</dependency>
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.5.0</version>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>
```
如果使用代码生成器功能，则代码本地化生成依赖为必选项。

##### 2、配置数据库连接
数据库连接配置对应的数据库应包含带生成代码的库表结构。

```yml
spring:
  datasource:
    driverClassName: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/ucode-cms
    username: root
    password: 123456
```

##### 3、启动项目
启动项目，查看控制台日志，点击链接进入`可视化控制台`界面。形如：
```text
========点击(http://localhost:8080/#/gen)进入代码生成器控制台========
```
选中对应表，点击生成代码，在项目中便新添相应的代码。

### 三、高级使用

在完成简单入门体验后，需要了解代码生成的高级部分，即全局配置。在项目中搜索类名`CodeProperties`即可查看所有内置可供修改的参数，在全局`yml`文件中覆盖默认值即可完成修改，按需配置。

##### 1、单表处理

当全局配置`ucode.code.joinQuery = false`或者使用默认配置时，则仅处理单表结构。将表名、字段名、字段类型、备注信息转化为SSM风格的源代码。

##### 2、多表连接

当在全局配置`ucode.code.joinQuery = true`时，则手动开启主外键查询，系统会自动读取表的主外键关系，并将其转化为连接查询的源代码。

##### 3、主要参数

| 参数                           | 默认值               | 使用备注                                           |
| ------------------------------ | -------------------- | -------------------------------------------------- |
| `ucode.code.projectDir`        | 空                   | 用户自定义`多模块`项目需要指定`项目名`                 |
| `ucode.code.removeTablePrefix` | `false`              | 根据需要是否在生成代码时移除表前缀                 |
| `ucode.code.packageName`       | `xin.altitude.front` | 配置用户自己的包名                                 |
| `ucode.code.useLombok`         | `true`               | 默认使用Lombok                                     |
| `ucode.code.filterSysTable`    | `true`               | 默认过滤不显示系统表                               |
| `ucode.code.joinQuery`         | `false`              | 是否使用连接查询（默认单表查询）                   |
| `ucode.code.xml.addXml`        | `false`              | 虽然说不建议使用XML文件编写SQL，但仍提高可开启开关 |
| `ucode.code.mapper.useCache`   | `true`               | 默认开启二级缓存，自定义业务缓存可关闭             |
| `ucode.code.filterSysTable`   | `true`               | 默认忽略`sys`开始的表名           |

注意，如果配置xml文件不生效，请确保版本号不低于`1.6.2`。

### 四、常见问题

##### 1、找不到依赖？
找不到依赖很大可能是因为阿里云景象仓库尚未同步完成Jar包，在项目中`pom`文件添加如下配置：
```xml
<repository>
    <id>public</id>
    <name>maven nexus</name>
    <url>https://repo1.maven.org/maven2/</url>
    <snapshots>
        <updatePolicy>always</updatePolicy>
    </snapshots>
    <releases>
        <updatePolicy>always</updatePolicy>
    </releases>
</repository>
```
##### 2、项目打包发布时如何处理代码生成器依赖？
项目打包发布时建议手动移除代码生成器依赖，实际上代码生成器的生命周期存在于开发阶段。手动不移除对打包不会产生影响，但仍然建议在打包时移除代码生成器依赖。
```xml
<!--代码生成器模块（非必选）-->
<dependency>
    <groupId>xin.altitude.cms</groupId>
    <artifactId>ucode-cms-code-spring-boot-starter</artifactId>
    <version>1.6.4.1-beta</version>
</dependency>
```

代码生成器依赖可直接移除，不会对程序运行产生影响。

##### 3、多表连接查询异常
对表连接查询是一项复杂的业务，目前支持：一个员工对应一个部门（一对一）、一个部门对应多个员工（一对多）、一名学生可选修多门课程每门课程可被多名学生选修（多对多）。
更高级别的套娃尚不支持。

##### 4、生成后的代码能无缝迁移到新项目吗？
能。生成的代码具有高度的迁移属性，在新项目中导入缺省依赖即可。如果找不到相关依赖，请参考问题一。


---
> 如有疑问，可通过微信`dream4s`与作者联系。源码在[GitHub](https://gitee.com/decsa) ，视频讲解在[B站](https://space.bilibili.com/1936685014) ，本文收藏在[博客天地](http://www.altitude.xin) 。

---
