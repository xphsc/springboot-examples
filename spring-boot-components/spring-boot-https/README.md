# spring-boot-https
spring-boot结合https


###jdk生成秘钥文件命令：
```
    keytool -genkey -alias tomcathttps -keyalg RSA -keysize 2048 -keystore C:\Users\ThinkPad\Desktop\javahttpskey.p12 -validity 365
```
###命令说明：
```
    genkey 表示要创建一个新的密钥。
    alias 表示 keystore 的别名。
    keyalg 表示使用的加密算法是 RSA ，一种非对称加密算法。
    keysize 表示密钥的长度。
    keystore 表示生成的密钥存放位置。
    validity 表示密钥的有效时间，单位为天。
```
###生成过程：
```
D:\Program Files\Java\jdk1.8.0_161\bin>keytool -genkey -alias tomcathttps -keyalg RSA -keysize 2048 -keystore C:\Users\ThinkPad\Desktop\javahttpskey.p12 -validity 365
输入密钥库口令:
再次输入新口令:
您的名字与姓氏是什么?
  [Unknown]:  wdy
您的组织单位名称是什么?
  [Unknown]:  aaa
您的组织名称是什么?
  [Unknown]:  chinn
您所在的城市或区域名称是什么?
  [Unknown]:  cc
您所在的省/市/自治区名称是什么?
  [Unknown]:  cc
该单位的双字母国家/地区代码是什么?
  [Unknown]:  86
CN=wdy, OU=aaa, O=chinn, L=cc, ST=cc, C=86是否正确?
  [否]:  y

输入 <tomcathttps> 的密钥口令
        (如果和密钥库口令相同, 按回车):

Warning:
JKS 密钥库使用专用格式。建议使用 "keytool -importkeystore -srckeystore C:\Users\ThinkPad\Desktop\javahttpskey.p12 -destkeystore C:\Users\ThinkPad\Desktop\javahttpskey.p12 -deststoretype pkcs12" 迁移到行业标准格式 PKCS12。
```
###生成后，将秘钥文件放到resources目录下即可。
