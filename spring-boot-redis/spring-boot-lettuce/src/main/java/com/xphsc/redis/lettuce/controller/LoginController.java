package com.xphsc.redis.lettuce.controller;

import com.xphsc.redis.lettuce.ResultData;
import com.xphsc.redis.lettuce.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@link }
 * @author <a href="xiongpeih@163.com">huipei.x</a>
 * @description:
 * @date:
 * @since 0.1.0
 */
@RestController
@Api(tags = {"登录测试"})
@RequestMapping(value = "/",produces = {"application/json;charset=utf-8"})
@Slf4j
public class LoginController extends BaseController {


    @RequestMapping("/login")
    @ApiOperation(value = "登录接口",httpMethod = "POST")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "userName",value = "用户名",dataType = "String",required = true,paramType = "query"),
                    @ApiImplicitParam(name = "password",value = "密码",dataType = "String",required = true,paramType = "query")
            }
    )
    public ResultData login(String userName, String password) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        setUser(user);
        return ResultData.success("登录成功", null);
    }

    @RequestMapping("/exit")
    @ApiOperation(value = "退出接口",httpMethod = "POST")
    public ResultData exit() {
        clearUser();
        return ResultData.success("退出成功", null);
    }

    /**
     * @return
     */
    @RequestMapping("/getUser")
    @ApiOperation(value = "获取用户信息",httpMethod = "POST")
    public ResultData getUser() {
        return ResultData.success("获取用户信息成功", getUserInfo());
    }

    @RequestMapping("/removeAndSetUser.do")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "userName",value = "用户名",dataType = "String",required = true,paramType = "query"),
                    @ApiImplicitParam(name = "password",value = "密码",dataType = "String",required = true,paramType = "query")
            }
    )
    @ApiOperation(value = "清除sessino并设置用户信息",httpMethod = "POST")
    public ResultData removeAndSetUser(String userName, String password) {
        exit();
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        setUser(user);
        return ResultData.success("清理并重新登录成功", null);
    }

    @RequestMapping("/dealUser.do")
    @ApiOperation(value = "业务操作类",httpMethod = "POST")
    public ResultData dealUser() {
        String userInfo = getUserInfo();
        log.info("*************进行业务操作时，获取到的用户是={}",userInfo);
        if (StringUtils.isNotBlank(userInfo)) {
            return ResultData.success("可以进行业务处理", null);
        }
        return ResultData.success("用户未登录", null);
    }
}


