package com.icbc.orient.Bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("返回数据的格式")
public class ReturnType {

    String code;@ApiModelProperty("处理码")
    String msg;@ApiModelProperty("返回信息")
    Boolean success;@ApiModelProperty("成功与否")
    Object  result;@ApiModelProperty("返回的数据")

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Boolean getSuccess() {
        return success;
    }

    public Object getResult() {
        return result;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
