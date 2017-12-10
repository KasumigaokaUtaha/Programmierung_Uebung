#Java Module
##Module and Package
Module 不是 Package ，所以在声明package的时候 绝对路径不能带上module
例如：
module util
package io
PATH: util/io/SimpleIO.java

在具体的class中（SimpleIO.java）
不能声明:
Package util.io;(因为util是一个module)

如果某一个module需要调用这个module中的某些类，那么必须在这个module的module-info.java中明确声明
exports p1;
exports p2;
...

测试 SSH
