package com.xphsc.redis.lettuce;

import lombok.Data;

/**
 * {@link }
 * @author <a href="xiongpeih@163.com">huipei.x</a>
 * @description:
 * @date:
 * @since 0.1.0
 */
@Data
public class ResultData {
    private int code;
    /**
     * 信息
     */
    private String msg;
    /**
     * 数据
     */
    private Object data;

    public ResultData() {
    }

    public ResultData(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public static ResultData success(String msg, Object data) {
        ResultData returnData = new ResultData();
        returnData.setCode(200);
        returnData.setMsg(msg == null ? "成功" : msg);
        returnData.setData(data);
        return returnData;
    }

    public static ResultData fail(int code, String msg, Object data) {
        ResultData returnData = new ResultData();
        returnData.setCode(code);
        returnData.setMsg(msg);
        returnData.setData(data);
        return returnData;
    }

}
