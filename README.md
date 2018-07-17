#monitor
<div>
    <p>
     心跳检测各类应用服务器(如Tomcat,Jetty),WEB服务器(如 Apache,Nginx) 的JAVA WEB应用程序.
    </p>
    <p>
     如何实现?
     <br/>
     使用HttpClient对指定的服务器(application-instance) URL 按频率(10秒,20秒...) 发起请求并记录响应的信息(连接耗时,是否连接成功,是否有异常,响应数据包大小),
     若检测到不正常(响应码不是200,抛出异常...)时则发送邮件给指定的地址,当检测恢复正常时也发送提醒邮件.
     <br/>
     将来会添加更多的实时提醒方式接口,如微信,短信
    </p>
</div>

<div>
    <h3>使用的框架及版本</h3>
    <ul>
        <li>JDK - 1.7</li>
        <li>Spring Framework - 3.2.2.RELEASE</li>
        <li>Quartz - 2.2.1</li>
        <li>Hibernate - 4.1.7.Final</li>
        <li>HttpClient - 4.3.5</li>
        <li><a href="http://www.bootcss.com/p/flat-ui/">Flat UI</a></li>
        <li>Maven - 3.1.0</li>
        <li>TestNG - 6.1.1 (Unit Test)</li>
    </ul>
</div>

<div>
    <h3>下载</h3>
    从0.3版本开始, 每一个版本的下载文件都在项目的 'dist' 目录.
    <ul>
        <li><a href="http://git.oschina.net/mkk/HeartBeat/raw/V-0.3/dist/HeartBeat-0.3.zip">HeartBeat-0.3.zip</a></li>
        <li><a href="http://git.oschina.net/mkk/HeartBeat/raw/V-0.4/dist/HeartBeat-0.4.zip">HeartBeat-0.4.zip</a></li>
        <li><a href="http://git.oschina.net/mkk/HeartBeat/raw/V-0.5/dist/HeartBeat-0.5.zip">HeartBeat-0.5.zip</a></li>
        <li>最新版本下载: <a href="http://git.oschina.net/mkk/HeartBeat/raw/V-1.0.0/dist/HeartBeat-1.0.0.zip">HeartBeat-1.0.0.zip</a></li>
    </ul>
</div>

<div>
    <h3>特点</h3>
    <ul>
        <li>无侵入,独立部署</li>
        <li>可同时监测多个应用服务器</li>
        <li>请求方式支持GET,POST; URL支持http与https, 可指定请求content-type, 添加请求参数(固定参数或随机参数)</li>
        <li>添加安全设置,可控制用户注册,设定用户权限等</li>
        <li>使用简洁,灵活</li>
        <li>提醒方式及时,多样(目前已实现邮件提醒,微信提醒;将来会加入短信提醒等)</li>
    </ul>
</div>

<div>
    <h3>运行环境</h3>
    <ul>
        <li>JRE 1.7 +</li>
        <li>MySql 5.5 +</li>
        <li>Tomcat 7 +</li>
    </ul>
</div>

<div>
    <h3>数据库</h3>
    导入others内heartBeat.sql
</div>

