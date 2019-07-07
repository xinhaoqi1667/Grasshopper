# Grasshopper
蝈蝈是由大数据一班和软信等一批优秀的年轻人创始的前后端分离的项目，希望能更新走得更远。

＃设计模式，前后端分离（服务端工程名:Grasshopper_server 客户端工程名:Grasshopper_client）
前端开发框架采取MUI数据渲染采用JS模板引擎
后端接口开发采取的是的Servlet对外暴露接口，okjson或GSON对数据进行序列化
数据库采用的是MySQL
前端采取hbuilder开发，后端采取eclipse开发
版本控制工具采取的是GitHubDesktop
其他技术由后续人员追加细节

# okjson的资料：https://gitee.com/calvinwilliams/okjson
# js模板引擎资料
http://aui.github.io/art-template/zh-cn/docs/syntax.html
https://www.cnblogs.com/shiyou00/p/6841801.html
https://blog.csdn.net/qq_40147863/article/details/82857401


#后端serlvet请求路径自行分发。其中对外暴露接口的控制器文件只能在com.hp.controller包下面，并且命名必须采取的是XXservlet开头。
#注意：
1.数据库文件上传存放到db文件夹下，数据库名字：Grasshopper_db

2.所有命名严格按照命名规则，大驼峰或者下划线命名，严格按照关键单词来命名

3.数据表给字段注释，其中注释和数据设计文档以及其他相关资料上传至doc文件夹下

#统一返回格式：{
	"result": {
		"resultCode": "200",
		"reason": "请求成功！"
	},
	"resultData":{...}
}


相关状态码注册写在doc文件夹下面的resultCode.properties中
okjson.jar等相关jar包已经上传至lib文件夹下面
图片请放置到images文件夹下面

前后端项目均测试成功！
