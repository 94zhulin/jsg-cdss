package com.jsg.base.result;

/**
 * Restful API返回值工具类
 *
 * @author weidong
 * @date 2018/7/24
 */
public class ResultUtil {
    public static final Integer SUCCESS = 200;
    public static final Integer FAIL = 999;
    public static final Integer EXCEPTION = 500;

    /**
     * ！！！成功：code =200 ；提示有关用户信息
     *
     * @param msg
     * @param object
     * @return
     */
    public static ResultBase success(String msg, Object object) {
        ResultBase result = new ResultBase();
        result.setStatus(SUCCESS);
        result.setMsg(msg);
        result.setData(object);
        return result;
    }

    /**
     * ！！！异常：code =500 （后台系统异常，第三方调用异常，app端参数异常）
     *
     * @param msg
     * @return
     */
    public static ResultBase exception(String msg) {
        ResultBase result = new ResultBase();
        result.setStatus(EXCEPTION);
        result.setMsg(msg);
        // 默认为空
        result.setData(null);
        return result;
    }

    /**
     * ！！！失败：code =999 用户逻辑错误
     *
     * @param msg
     * @return
     */
    public static ResultBase fail(String msg) {
        ResultBase result = new ResultBase();
        result.setStatus(FAIL);
        result.setMsg(msg);
        // 默认为空
        result.setData(null);
        return result;
    }

    // /**
    // * 提供给部分不需要出參的接口
    // * @return
    // */
    // public static ResultBase success(){
    // return success(null);
    // }
    //
    //
    //
    // /**
    // * 已知错误
    // * @param exceptionEnum 枚举类型错误
    // * @return
    // */
    // public static ResultBase error(ExceptionEnum exceptionEnum){
    // ResultBase result = new ResultBase();
    // result.setStatus(exceptionEnum.getCode());
    // result.setMsg(exceptionEnum.getMsg());
    // result.setData(null);
    // return result;
    // }
    //
    // /**
    // * 返回成功，传入返回体具体出參
    // * @param object
    // * @return
    // */
    // public static ResultBase success(Object object){
    // ResultBase result = new ResultBase();
    // result.setStatus(0);
    // result.setMsg("success");
    // result.setData(object);
    // return result;
    // }
}
