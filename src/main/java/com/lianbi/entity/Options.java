package com.lianbi.entity;

import com.baomidou.mybatisplus.annotations.TableName;

@TableName(value = "options")
public class Options {

    private String OptionsID;

    private String OptionsName;

    private String OptionsPid;

    public String getOptionsID() {
        return OptionsID;
    }

    public void setOptionsID(String optionsID) {
        OptionsID = optionsID;
    }

    public String getOptionsName() {
        return OptionsName;
    }

    public void setOptionsName(String optionsName) {
        OptionsName = optionsName;
    }

    public String getOptionsPid() {
        return OptionsPid;
    }

    public void setOptionsPid(String optionsPid) {
        OptionsPid = optionsPid;
    }
}
