package com.xphsc.validation.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import java.util.Date;
/**
 * {@link }
 * @author <a href="xiongpeih@163.com">huipei.x</a>
 * @description:
 * @date:
 * @since 0.1.0
 */
@Data
public class TestModel {
    @NotEmpty(message="用户id不能为空")
    private  String userId;
    private  int type;
    @Pattern(regexp="(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|\"  \n" +
            "+ \"(\\\\b(select|update|and|or|delete|insert|trancate|char|into|substr|ascii|declare|exec|count|master|into|drop|execute)\\\\b)",message="名称不应该输入帶sql的敏感信息")
    private String username;
    private Date time;
}
