package com.lianbi.entity;

import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

@TableName(value = "options")
public class Power implements Serializable {

    private String optionsID;

    private String optionsName;

    private String optionsPid;

    private String optionsSrc;

    private String optionCreatePer;

    private String optionUpdatePer;

    private Date optionCreateDate;

    private Date optionUpdateDate;


    public String getOptionsID() {
        return optionsID;
    }

    public void setOptionsID(String optionsID) {
        this.optionsID = optionsID;
    }

    public String getOptionsName() {
        return optionsName;
    }

    public void setOptionsName(String optionsName) {
        this.optionsName = optionsName;
    }

    public String getOptionsPid() {
        return optionsPid;
    }

    public void setOptionsPid(String optionsPid) {
        this.optionsPid = optionsPid;
    }

    public String getOptionsSrc() {
        return optionsSrc;
    }

    public void setOptionsSrc(String optionsSrc) {
        this.optionsSrc = optionsSrc;
    }

    public String getOptionCreatePer() {
        return optionCreatePer;
    }

    public void setOptionCreatePer(String optionCreatePer) {
        this.optionCreatePer = optionCreatePer;
    }

    public String getOptionUpdatePer() {
        return optionUpdatePer;
    }

    public void setOptionUpdatePer(String optionUpdatePer) {
        this.optionUpdatePer = optionUpdatePer;
    }

    public Date getOptionCreateDate() {
        return optionCreateDate;
    }

    public void setOptionCreateDate(Date optionCreateDate) {
        this.optionCreateDate = optionCreateDate;
    }

    public Date getOptionUpdateDate() {
        return optionUpdateDate;
    }

    public void setOptionUpdateDate(Date optionUpdateDate) {
        this.optionUpdateDate = optionUpdateDate;
    }
}
