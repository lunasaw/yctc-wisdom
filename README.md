# Genesis

#### 项目介绍
{*本项目是基于图片识别和数据分析的智能知识点课程识别系统,除实现基本教务功能外,另实现了对于老师设定的固定知识点
加以动态识别录制,并同步知识点反馈学生学情状态,但并不是实时监控式,由于为后期录制并检测,故不会实时监控学生行为
,后期反馈给老师的也是饼状图比例分析,并不会影响学生个人,老师根据本堂可反馈从而执行下次课的教学计划和方式*}

#### 软件架构
软件架构说明:
     本系统采用spring_boot+thymeleaf+shiro架构,利用强大的spring框架实现是,数据库采用小型数据库mysql
     存储搭建基本框架,系统的具体体现,运用远程数据库连接,云短信接口实现验证,采取spring_boot+thymeleaf+shiro,分布式实现


#### 安装教程

1. 如需人脸识别需要安装Tesseract-OCR.exe 文件,可自行自定安装目录
2. 需要配置application.properties 
spring.datasource.url =jdbc:mysql://localhost:3306/"your database name"?serverTimezone=GMT%2B8&useSSL=false
spring.datasource.username =root
spring.datasource.password =czy1024
可根据用户自行更改,附带sql文件study
3. 如需视频识别知识点则需安装ffmpeg的ffplay.exe文件,视频目录和剪裁图片目录可自行修改

#### 使用说明

1. 本产品需要使用球机,具体型号可自行购买,
2. 本产品用户名采用sha256加密 可使用 http://www.ttmd5.com/rang.php解密 后自行导入数据库 后期会实现注册功能
3. xxxx

#### 参与贡献

1. Fork 本项目
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request


#### github特技

)