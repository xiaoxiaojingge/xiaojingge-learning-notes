<h1 align="center" style="margin: 30px 0 30px; font-weight: bold;">Ape Frame</h1>
<h4 align="center">基于SpringBoot开发的轻量级框架</h4>
<p align="center">
<a href='https://gitee.com/classicChickenWings/ape-frame/stargazers'>
<img src='https://gitee.com/classicChickenWings/ape-frame/badge/star.svg?theme=dark' alt='star'>
</a>
<a href="#公众号"><img src="https://img.shields.io/badge/公众号-经典鸡翅-orange.svg?style=plasticr"></a>
<a href="#公众号"><img src="https://img.shields.io/badge/交流群-开源项目实战群-purple.svg?style=plasticr"></a>
<a href="https://gitee.com/classicChickenWings/ape-frame">
<img src="https://img.shields.io/badge/version-v1.0-red.svg">
</a>
<a href="https://gitee.com/classicChickenWings/ape-frame">
<img src="https://img.shields.io/badge/微信-jingdianjichi-brightgreen.svg">
</a>
</p>

## ✨项目简介
ape-frame，ape是“猿”的意思，正好符合我们程序猿的称号！我希望未来这个框架是专属于我们程序猿的首选开发框架。

一直想做一款适用于中小企业的轻量级快速开发框架，涵盖平时业务开发的常用场景，做到开箱即用。用户可根据自身情况选择组件来进行使用。采取组件化开发模式。

比如用户需要redis，则选择redis组件，需要websocket，则引入websocket组件，用户自身不需要再开发什么，只需要按照组件规则进行使用即可。

同时，有些经典的工具以及经典的设计模式代码，提供了大量实例参考，用户的业务场景一旦用到，就可以直接使用。

项目整体采用maven结构开发，封装了大量的模块，彼此解耦。满足用户日常开发需要。

希望大家可以帮忙点点Star，您的Star就是对我最大的支持。持续更新中，微服务版本更新中！

<a href="https://imgse.com/i/pPKkSLF"><img src="https://s1.ax1x.com/2023/08/13/pPKkSLF.png" alt="pPKkSLF.png" border="0" /></a>

<a href="https://www.yuque.com/jingdianjichi/gb9bgl/ko3bclqhtuu8uif0">项目文档及视频获取方法，点击此处 </a>

## 🔥项目模块结构介绍
### ape-cloud
微服务模块更新中，目前具备以下模块
* ape-cloud-eureka：eureka服务注册组件
* ape-cloud-eureka-server：eureka服务端用于服务治理与服务发现
* ape-cloud-ribbon：ribbon负载均衡
* ape-cloud-openFeign：feign远程调用
* ape-cloud-home：用于微服务调用案例的首页微服务
* ape-cloud-sku：用于微服务调用案例的sku微服务
### ape-common
* ape-common-job：分布式任务调度组件
* ape-common-log：日志组件，提供日志切面自动记录及异步日志提升性能
* ape-common-mybatisplus：采用Mybatisplus作为与数据库交互
* ape-common-redis：缓存组件，提供基于redis的操作封装，redis分布式锁，guava的cache工具类
* ape-common-starter：启动类组件，与启动类相关的功能，放到此组件处，目前包含mongoStarter
* ape-common-swagger：swagger组件，提供整体项目访问api的入口及方法文档
* ape-common-test：测试组件，集成springboot-test，及代码单元测试，代码覆盖率，行覆盖率检测
* ape-common-tool：常用的工具类组件，满足业务日常开发的各种需要，保障安全性，低入侵性
* ape-common-web：web组件，提供统一异常处理，web模块转换，统一返回值
* ape-common-websocket：websocket组件，提供一套带鉴权的websocket，引入即用，简单方便
* ape-mail：邮件发送组件
### ape-demo
demo里提供了大量的实例，教大家如何直接使用这个项目框架，大家在开发中，可以直接参考这个模块来建立自己的项目进行使用。
目前已经提供的示例功能
<a href="https://imgse.com/i/pPM6Lge"><img src="https://s1.ax1x.com/2023/08/15/pPM6Lge.png" alt="pPM6Lge.png" border="0" /></a>

### ape-dependencies
该模块为一个父pom模块，提供项目整体的maven包的锁定及规范，统一升级，统一引入。

## 项目文档及视频
如果你觉得这个项目想要写在简历上，作为一个亮点的项目，从0到1进行视频的学习
。鸡翅老哥也是给大家录了一套视频。目前支持抖音拍下，限时领取200元优惠券，原价299，现价99。
下单后，送项目文档，简历模板，1v1答疑。拍完加下鸡哥wx：jingdianjichi。
可以联系鸡翅老哥进行学习。
<div style="display: inline-block !important;">
<p>
<a><img height="300px" src="https://s1.ax1x.com/2023/09/08/pPy4FgJ.jpg" alt="pPMcpUP.jpg" border="0" /></a>
</p>
</div>

## 知识星球
如果你想要提升，如果你正准备跳槽，欢迎加入鸡翅老哥的知识星球，找鸡翅老哥领取星球优惠券，提供如下的服务
<a href="https://imgse.com/i/pPM6xHI"><img src="https://s1.ax1x.com/2023/08/15/pPM6xHI.png" alt="pPM6xHI.png" border="0" /></a>
鸡翅老哥作为面试官，面试过太多的人了，同时也帮助了300+小伙伴成功入职新公司，进行薪资提升，相信鸡哥，相信自己。
<div style="display: inline-block !important;">
<p>
<a target="_blank" href="https://imgse.com/i/pPMcpUP"><img height="300px" src="https://s1.ax1x.com/2023/08/15/pPMcpUP.jpg" alt="pPMcpUP.jpg" border="0" /></a>
</p>
</div>

## 简历项目
<a href="https://imgse.com/i/pPM6hu9"><img src="https://s1.ax1x.com/2023/08/14/pPM6hu9.png" alt="pPM6hu9.png" border="0" /></a>

## 贡献者感谢
感谢一下咱们的项目的大大贡献者 Loser老哥。loser老哥贡献了很多高质量的代码

https://gitee.com/lyilan8080

## ☀️添砖加瓦
欢迎大家提issue一起完善，以及提供各种宝贵建议，持续做成商业化开发框架。
如果您感觉我们的代码有需要优化的地方或者有更好的方案欢迎随时提pr。
可添加微信进行交流，鸡翅老哥会拉你进入项目群。



# 🐾贡献代码的步骤
1. 在Gitee上fork项目到自己的repo
2. 把fork过去的项目也就是你的项目clone到你的本地
3. 修改代码
4. commit后push到自己的库
5. 登录Gitee在你仓库首页可以看到一个 pull request 按钮，点击它，填写一些说明信息，然后提交即可。 等待维护者合并
# 公众号
微信搜索 【经典鸡翅】 关注我的公众号
<p>
<a href="https://imgse.com/i/pPKF6VH"><img src="https://s1.ax1x.com/2023/08/13/pPKF6VH.png" alt="pPKF6VH.png" border="0" /></a>
</p>

+ 点击【一起卷】鸡哥拉你进开源项目实战群，群里热烈的讨论起来！
+ 点击【知识星球】获取全套视频，简历优化，模拟面试，性能优化！
+ 回复【面试】即可领取面试资源！有面试，无烦恼，一套带走面试官！
+ 公众号不定期更新各种鸡哥的干货实战！