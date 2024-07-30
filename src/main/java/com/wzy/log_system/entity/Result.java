package com.wzy.log_system.entity;


//用于controller响应格式的统一

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;//响应码，1 代表成功; 0 代表失败

    private String msg;  //响应码 描述字符串

    private Object data; //返回的数据

    //增删改 成功响应(不需要给前端返回数据)

    public static Result success(){
        return new Result(1,"success",null);

    }

    //查询 成功响应(把查询结果做为返回数据响应给前端)

    public static Result success(Object data){
        return new Result(1,"success",data);

    }

    //失败响应

    public static Result error(String msg){
        return new Result(0,msg,null);

    }

}

