package org.sam.stu.vo;

import org.springframework.stereotype.Component;

/**
 * Title: 统一响应结构
 * Description:使用REST框架实现前后端分离架构，我们需要首先确定返回的JSON响应结构是统一的，
 * 也就是说，每个REST请求将返回相同结构的JSON响应结构。不妨定义一个相对通用的JSON响应结构，其
 * 中包含两部分：元数据与返回值，其中，元数据表示操作是否成功与返回值消息等，返回值对应服务端方法所返回的数据。
 * { "meta": { "success": true, "message": "ok" }, "data": ... }
 */

/**
 * 自定义接口统一返回的JSON格式
 *
 * @author samphin
 */
@Component
public class ResponseResult {

    private static final String SUCCESS = "SUCCESS";
    private static final String ERROR = "ERROR";

    private Meta meta;     // 元数据
    private Object data;   // 响应内容

    public ResponseResult success() {
        this.meta = new Meta(true, SUCCESS);
        return this;
    }

    public ResponseResult success(Object data) {
        this.meta = new Meta(true, SUCCESS);
        this.data = data;
        return this;
    }

    public ResponseResult success(Object data, String message) {
        this.meta = new Meta(true, message);
        this.data = data;
        return this;
    }

    public ResponseResult failure() {
        this.meta = new Meta(false, ERROR);
        return this;
    }

    public ResponseResult failure(String message) {
        this.meta = new Meta(false, message);
        return this;
    }

    public ResponseResult failure(int code, String message) {
        this.meta = new Meta(code, message);
        return this;
    }

    public Meta getMeta() {
        return meta;
    }

    public Object getData() {
        return data;
    }

    /**
     * Title: 请求元数据
     *
     * @author samphin
     * @created 2019-6-26 15:16:29
     */
    public class Meta {

        private boolean success;
        private String message;
        private int code;

        public Meta(boolean success) {
            this.success = success;
        }


        public Meta(boolean success, String message) {
            //如果成功，code=0,失败code=1
            this.code = success == true ? 0 : 1;
            this.success = success;
            this.message = message;
        }

        /**
         * 异常信息，默认不成功，设置错误编码、信息
         *
         * @param code
         * @param message
         */
        public Meta(int code, String message) {
            this.success = false;
            this.code = code;
            this.message = message;
        }

        public boolean isSuccess() {
            return success;
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

    }
}
