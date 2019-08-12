package com.citi.portfolio.common;

import java.io.Serializable;

/**
 * @Description:定义共同返回结果
 */

    public class Result<T> implements Serializable {

        private static final long serialVersionUID = 2488663702267110932L;
        private int code;
        private String msg;
        private String detail;
        private Double duration;
        private T data;

        public static Result<ResultEnum> successResponse() {
            return new Result<ResultEnum>(ResultEnum.SUCCESS.code,ResultEnum.SUCCESS.msg);
        }

        public static Result<ResultEnum> failureResponse() {
            return new Result<ResultEnum>(ResultEnum.FAILURE.code,ResultEnum.FAILURE.msg);
        }

        public static Result<ResultEnum> unknowResponse() {
            return new Result<ResultEnum>(ResultEnum.UNKNOWN_ERROR.code,ResultEnum.UNKNOWN_ERROR.msg);
        }

        public Result() {
            this.code = ResultEnum.SUCCESS.code;
            this.msg = ResultEnum.SUCCESS.msg;
        }

        public Result(T data) {
            this.code = ResultEnum.SUCCESS.code;
            this.msg = ResultEnum.SUCCESS.msg;
            this.data = data;
        }

        public Result(T data, String msg) {
            this.data = data;
            this.msg = msg;
        }
        public Result(T data, int code, String msg) {
            this.data = data;
            this.code = code;
            this.msg = msg;
        }

        public Result(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public Result(int code, String msg, String detail) {
            this.code = code;
            this.msg = msg;
            this.detail = detail;
        }

        public static <T> Result<T> ok(T data) {
            return new Result<T>(data, ResultEnum.SUCCESS.code, ResultEnum.SUCCESS.msg);
        }
       public static <T> Result<T> handleException(int code, String msg) {
            return new Result<T>(code,msg);
        }

        public static <T> Result<T> failure(T data) {
            return new Result<T>(data,  ResultEnum.FAILURE.code, ResultEnum.FAILURE.msg);
        }

        public static <T> Result<T> failure(T data, String msg) {
            return new Result<T>(data, ResultEnum.FAILURE.code, msg);
        }

        public static <T> Result<T> success(T data,int code,String msg) {
            return new Result<T>(data, code, msg);
        }

        public int getCode() {
            return this.code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return this.msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getDetail() {
            return this.detail;
        }

        public <T extends Result> T addDetail(String detail) {
            this.setDetail(detail);
            return (T) this;
        }

        public T getData() {
            return this.data;
        }

        public void setData(T data) {
            this.data = data;
        }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", detail='" + detail + '\'' +
                ", duration=" + duration +
                ", data=" + data.toString() +
                '}';
    }
}
