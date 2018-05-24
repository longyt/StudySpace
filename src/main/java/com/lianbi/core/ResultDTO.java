package com.lianbi.core;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class ResultDTO<T> implements Serializable {

    public static final String SUCCESS = "0000";
    public static final String EXCEPTION = "1111";
    public static final String FAIL = "9999";
    public static final String INVALID_PARAM = "0001";


    /**
     *  返回码
     */
    private String resCode;

    /**
     *  返回信息
     */

    private String resMsg;

    /**
     *  返回信息类型  1 正常  2 异常  3  失败  4 无效的参数
     */

    private String resMsgType;

    /**
     *  当前毫秒数
     */

    private long st=System.currentTimeMillis();

    /**
     *  当前记录
     */

    private T record;

    /**
     *  总数
     */

    private long total;

    /**
     *  当前页
     */

    private int current;

    //private List<T> records=Collections.emptyList();


    public ResultDTO() {
        this.resCode="0000";
        this.resMsg="成功";
        this.resMsgType="1";
    }


    public ResultDTO(T record) {
        this.resCode="0000";
        this.resMsg="成功";
        this.resMsgType="1";
        this.record = record;
    }


    public ResultDTO(String resCode, String resMsg, String resMsgType) {
        this.resCode = resCode;
        this.resMsg = resMsg;
        this.resMsgType = resMsgType;
    }
    //  返回失败结果信息
    public static <T>ResultDTO<T> Fail(String resMsg){
            return new ResultDTO(FAIL,resMsg,"3");
    }
    // 返回成功结果信息
    public static <T>ResultDTO<T> Success(String resMsg){
        return new ResultDTO(SUCCESS,resMsg,"1");
    }

    /**
     *  get  set 方法
     * @return
     */

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    public String getResMsgType() {
        return resMsgType;
    }

    public void setResMsgType(String resMsgType) {
        this.resMsgType = resMsgType;
    }

    public long getSt() {
        return st;
    }

    public void setSt(long st) {
        this.st = st;
    }

    public T getRecord() {
        return record;
    }

    public void setRecord(T record) {
        this.record = record;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    /**
     *  get  set 方法
     * @return
     */

    @Override
    public String toString() {
        return "ResultDTO{" +
                "resCode='" + resCode + '\'' +
                ", resMsg='" + resMsg + '\'' +
                ", resMsgType='" + resMsgType + '\'' +
                ", st=" + st +
                ", record=" + record +
                ", total=" + total +
                ", current=" + current +
                '}';
    }
}
