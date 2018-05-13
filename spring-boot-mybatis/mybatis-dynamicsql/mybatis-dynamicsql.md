## mybatis-dynamicsql
## 概述
这是是一个用于生成动态SQL语句的框架。
把它看作是一个类型化的SQL模板库，
它对MyBase3和Spring JDBC模板有额外的支持。
由MybATIS或Spring使用的完全删除、插入、选择和更新语句。最常见的用例是生成语句和一组匹配的参数，这些参数可以直接由MybATIS使用。库还将生成与Spring JDBC模板兼容的语句和参数对象。

 该库通过实现一个SQL类DSL来创建一个对象，该对象包含一个完整的SQL语句和该语句所需的任何参数。SQL语句对象可以直接由MybATIS作为映射器方法的参数使用。

库将生成这些类型的SQL语句：

使用灵活的WHERE子句删除语句
插入几种类型的语句：
插入单个记录并将空值插入列（“完整”插入）的语句
插入一个忽略空输入值及其关联列的单个记录的语句（“选择性”插入）
使用SELECT语句的结果插入到表中的语句
一个参数对象被设计用于用JDBC批处理多个对象。
选择具有灵活列列表的语句、灵活的WHERE子句，并支持不同的“组”、“联接”、“联合”、“按顺序”等。
用灵活的WHERE子句更新语句。与INSERT语句类似，更新语句有两种：
将设置空值的“完全”更新
“忽略”空输入值的“选择性”更新
图书馆的主要目标是：

尽可能地，库将确保参数类型与数据库列类型匹配。
表达-陈述是以清晰的方式表达他们的意思（感谢哈姆雷斯特的灵感）
灵活的WHERE子句可以使用任意组合的、或或嵌套的条件来构建。
可扩展库将为MyBase3、Spring JDBC模板或普通JDBC呈现语句。它也可以扩展到为其他框架生成子句。如果没有足够的内置条件满足您的需要，则可以方便地添加条件。
小-库是添加的小依赖项。它没有传递依赖关系。
这个库是出于创建一个实用程序的需要，它可以用来改进MybATS生成器生成的代码，但是该库可以在它自己的基础上使用，但所需的设置很少。
## where 条件
MyBATIs动态SQL支持各种各样的WHERE子句条件。所有条件都可以与“和”和“或”操作符相结合，以创建任意复杂的WHERE子句。
在下面的例子中：
“x”和“y”是将作为准备语句参数呈现的值。生成的SQL以与目标运行时（MybATIS或Spring）兼容的格式呈现，但为了简单起见，我们将显示标准准备的语句参数标记。
“FO”和“bar”是Sql列的实例。
简单条件
最简单的条件是最常见的——它们呈现基本的SQL运算符。
Condition	Example	Result
Between	where(foo, isBetween(x).and(y))	where foo between ? and ?
Equals	where(foo, isEqualTo(x))	where foo = ?
Greater Than	where(foo, isGreaterThan(x))	where foo > ?
Greater Than or Equals	where(foo, isGreaterThanOrEqualTo(x))	where foo >= ?
In	where(foo, isIn(x, y))	where foo in (?,?)
In (case insensitive)	where(foo, isInCaseInsensitive(x, y))	where upper(foo) in (?,?) (the framework will transform the values for x and y to upper case)
Less Than	where(foo, isLessThan(x))	where foo < ?
Less Than or Equals	where(foo, isLessThanOrEqualTo(x))	where foo <= ?
Like	where(foo, isLike(x))	where foo like ? (the framework DOES NOT add the SQL wild cards to the value - you will need to do that yourself)
Like (case insensitive)	where(foo, isLikeCaseInsensitive(x))	where upper(foo) like ? (the framework DOES NOT add the SQL wild cards to the value - you will need to do that yourself, the framework will transform the value of x to upper case)
Not Between	where(foo, isNotBetween(x).and(y))	where foo not between ? and ?
Not Equals	where(foo, isNotEqualTo(x))	where foo <> ?
Not In	where(foo, isNotIn(x, y))	where foo not in (?,?)
Not In (case insensitive)	where(foo, isNotInCaseInsensitive(x, y))	where upper(foo) not in (?,?) (the framework will transform the values for x and y to upper case)
Not Like	where(foo, isLike(x))	where foo not like ? (the framework DOES NOT add the SQL wild cards to the value - you will need to do that yourself)
Not Like (case insensitive)	where(foo, isNotLikeCaseInsensitive(x))	where upper(foo) not like ? (the framework DOES NOT add the SQL wild cards to the value - you will need to do that yourself, the framework will transform the value of x to upper case)
Not Null	where(foo, isNotNull())	where foo is not null
Null	where(foo, isNull())	where foo is null


## select 语句





