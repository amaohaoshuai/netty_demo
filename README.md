# netty_demo
springboot+ netty demo


注意事项：
  1、本Demo中使用的是分隔符过滤器来处理拆包粘包的问题，可自行替换分隔符，或使用其他过滤器来处理拆包粘包的问题，Netty也提供了多种，请参考Netty API；
  2、本Demo中使用的自定义过滤器未能处理Client发送的中文数据（时间不足，我未尝试多种方法，只是改变编码来处理，效果不佳），使用该Demo时请务必注意该问题；
  3、本Demo中使用的是mysql数据库，sql文件并未提供，仅供参考，实体对象需要根据业务自行创建，如果只是使用本Demo，可以在/resources/mapper文件夹下的xml文件
  中获取对应的数据库表字段和表名，大小可自行定义；
  4、本Demo中采用反射机制来绑定实体对象，但由于作者能力较差，未能很好的实现该功能，如果各位有好的解决方案，请替换。
