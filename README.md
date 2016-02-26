# MyDbEncryptDemo
数据库加密大全

 数据库操作、基本每个android应用都有涉及，有些应用需要对数据库进行加密，不让root用户去访问，有些应用表之间联系紧密要并发处理等，那么怎么建立一个比较好的成熟的框架，方便之后的应用都可以拿来直接用呢。下面介绍下我一直使用的数据库，本人使用的是Android studio 开发工具。

  我们都知道android sqlite是存储在我们应用的内部存储data/data/里面的，一般用户是查看不到的、但对于root的手机是可以查看我们的数据库的,为了也防止root用户查看、我们就要对数据库进行加密。我们要使用SQLCipher ，SQLCipher是一SQLite基础之上进行扩展的开源数据库，它主要是在SQLite的基础之上增加了数据加密功能，我们在数据库中使用，可以加大我们数据库的安全性。
详情请参考博客：http://blog.csdn.net/u011916937/article/details/50011329
