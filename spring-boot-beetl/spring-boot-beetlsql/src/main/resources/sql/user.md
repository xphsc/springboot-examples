findByName
===
    * 根据用户名查询用户信息
    select * from t_user where 1=1
    @if(!isEmpty(uname)){
        and uname = #uname#
    @}
findById
===
    * 根据用户Id查询
    select * from t_user where 1=1
    @if(!isEmpty(id)){
        and id = #id#
    @}
