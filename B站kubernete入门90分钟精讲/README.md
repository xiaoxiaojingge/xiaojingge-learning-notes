# kubernete入门90分钟精讲

B站配套视频教程：

* [Kubernetes入门90分钟精讲(合集)](https://www.bilibili.com/video/BV1k24y197KC/)
* [Kubernetes入门实操—部署若依前后端分离版(Ruoyi-Vue)](https://www.bilibili.com/video/BV16g411s7KK/)
* [Vagrant一键安装kubernetes学习环境（只需一条命令，全程无人值守）](https://www.bilibili.com/video/BV15P411F7Qv/)

文档：

- `handbook` 90分钟精讲课程文档
- `vagrant-all` Vagrant安装k8s代码及使用说明

## 课程导读


### 为什么Kubernetes学起来很难？

- **Kubernetes本身比较复杂，组件众多，安装过程比较麻烦**
  
  - 本课程使用K3s快速创建学习环境，不要把时间和精力浪费在搭环境上
- **网络问题，许多谷歌镜像或软件仓库访问不到，拉取失败**
  - 配置阿里云镜像加速
  - 手动拉取镜像、手动导出、导入镜像
- **Kubernetes版本有重大变化，网上好多教程已过时**
  
  - kubernetes从**1.24**版本开始，移除了对**docker**的支持
  - 本课程采用**1.25**版本，使用**containerd**作为容器运行时
  - 课程中对**containerd**用法以及可能遇到的问题进行了说明
- **官方文档有错误，许多例子或命令运行不起来**
  
  - 本课程会帮你避过官方文档中的坑
- **很多教程只有例子，没有实战，导致“一学就会，一用就废”**
  
  - 本课程会演示常用中间件的安装（MySQL主从集群、Redis主从集群）
  - 本课程会演示如何在K8s上运行一个完整的应用
    - 应用程序包括前端(node/nginx)、缓存(redis)、数据库(mysql)、后端(java）

## 课程目录

### part.1-Kubernetes基础

- [01.kubernetes简介](./handbook/01.kubernetes%E7%AE%80%E4%BB%8B.md)
- [02.kubernetes架构.md](./handbook/02.kubernetes%E6%9E%B6%E6%9E%84.md)
- [03.安装Minikube.md](./handbook/03.%E5%AE%89%E8%A3%85Minikube.md)
- [04.使用K3s快速搭建集群.md](./handbook/04.%E4%BD%BF%E7%94%A8K3s%E5%BF%AB%E9%80%9F%E6%90%AD%E5%BB%BA%E9%9B%86%E7%BE%A4.md)

### part.2-运行无状态应用(Nginx)

- [05.Pod(容器集).md](./handbook/05.Pod(%E5%AE%B9%E5%99%A8%E9%9B%86).md)
- [06.Deployment(部署)与ReplicaSet(副本集).md](./handbook/06.Deployment(%E9%83%A8%E7%BD%B2)%E4%B8%8EReplicaSet(%E5%89%AF%E6%9C%AC%E9%9B%86).md)
- [07.Service(服务).md](./handbook/07.Service(%E6%9C%8D%E5%8A%A1).md)
- [08.Namespace(命名空间).md](./handbook/08.Namespace(%E5%91%BD%E5%90%8D%E7%A9%BA%E9%97%B4).md)
- [09.声明式对象配置.md](./handbook/09.%E5%A3%B0%E6%98%8E%E5%BC%8F%E5%AF%B9%E8%B1%A1%E9%85%8D%E7%BD%AE.md)
- [10.金丝雀发布.md](./handbook/10.%E9%87%91%E4%B8%9D%E9%9B%80%E5%8F%91%E5%B8%83.md)

### part.3-运行有状态应用(Mysql)

- [11.运行有状态应用.md](./handbook/11.%E8%BF%90%E8%A1%8C%E6%9C%89%E7%8A%B6%E6%80%81%E5%BA%94%E7%94%A8.md)
- [12.创建MySQL数据库.md](./handbook/12.%E5%88%9B%E5%BB%BAMySQL%E6%95%B0%E6%8D%AE%E5%BA%93.md)
- [13.ConfigMap与Secret.md](./handbook/13.ConfigMap%E4%B8%8ESecret.md)
- [14.卷(Volume).md](./handbook/14.%E5%8D%B7(Volume).md)
- [15.临时卷(EV).md](./handbook/15.%E4%B8%B4%E6%97%B6%E5%8D%B7(EV).md)
- [16.持久卷(PV)与持久卷声明(PVC).md](./handbook/16.%E6%8C%81%E4%B9%85%E5%8D%B7(PV)%E4%B8%8E%E6%8C%81%E4%B9%85%E5%8D%B7%E5%A3%B0%E6%98%8E(PVC).md)
- [17.存储类(StorageClass).md](./handbook/17.%E5%AD%98%E5%82%A8%E7%B1%BB(StorageClass).md)
- [18.StatefulSet(有状态应用集).md](./handbook/18.StatefulSet(%E6%9C%89%E7%8A%B6%E6%80%81%E5%BA%94%E7%94%A8%E9%9B%86).md)
- [19.Headless Service(无头服务).md](./handbook/19.Headless%20Service(%E6%97%A0%E5%A4%B4%E6%9C%8D%E5%8A%A1).md)
- [20.Mysql主从复制.md](./handbook/20.Mysql%E4%B8%BB%E4%BB%8E%E5%A4%8D%E5%88%B6.md)
- [21.Port-forward端口转发.md](./handbook/21.Port-forward%E7%AB%AF%E5%8F%A3%E8%BD%AC%E5%8F%91.md)
- [22.Helm安装MySQL集群.md](./handbook/22.Helm%E5%AE%89%E8%A3%85MySQL%E9%9B%86%E7%BE%A4.md)
- 探针(coming soon)

### part.4-入门实践：部署前后端分离版若依(RuoYi-Vue)

- [23.若依(RuoYI-Vue)简介.md](./handbook/23.%E8%8B%A5%E4%BE%9D(RuoYI-Vue)%E7%AE%80%E4%BB%8B.md)
- [24.安装Redis和MySQL.md](./handbook/24.%E5%AE%89%E8%A3%85Redis%E5%92%8CMySQL.md)
- [25.构建前后端镜像.md](./handbook/25.%E6%9E%84%E5%BB%BA%E5%89%8D%E5%90%8E%E7%AB%AF%E9%95%9C%E5%83%8F.md)
- [26.搭建私有镜像仓库.md](./handbook/26.%E6%90%AD%E5%BB%BA%E7%A7%81%E6%9C%89%E9%95%9C%E5%83%8F%E4%BB%93%E5%BA%93.md)
- [27.部署后端(ruoyi-admin).md](./handbook/27.%E9%83%A8%E7%BD%B2%E5%90%8E%E7%AB%AF(ruoyi-admin).md)
- [28.部署前端(ruoyi-ui).md](./handbook/28.%E9%83%A8%E7%BD%B2%E5%89%8D%E7%AB%AF(ruoyi-ui).md)
- [29.初始化容器及Pod启动顺序.md](./handbook/29.%E5%88%9D%E5%A7%8B%E5%8C%96%E5%AE%B9%E5%99%A8%E5%8F%8APod%E5%90%AF%E5%8A%A8%E9%A1%BA%E5%BA%8F.md)
- [30.Ingress(入口).md](./handbook/30.Ingress(%E5%85%A5%E5%8F%A3).md)
