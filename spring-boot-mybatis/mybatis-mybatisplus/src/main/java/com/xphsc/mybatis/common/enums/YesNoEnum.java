package com.xphsc.mybatis.common.enums;

/**
 * Created by ${huipei.x} on 2017-2-25
 */
public enum YesNoEnum {
	YES("是", "1"), NO("否","0");
	
	private String display;
	private String code;
	
	private YesNoEnum(String display, String code) {
		this.display = display;
		this.code = code;
		
	}
	public String getDisplay() {
		return display;
	}

	public String getCode() {
		return code;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public void setCode(String code) {
		this.code = code;
	}

    public static YesNoEnum getYesNoEnumByCode(String code){           
        YesNoEnum[] enums = YesNoEnum.values();
        for(YesNoEnum item: enums){          
            if(item.getCode().equalsIgnoreCase(code)){
                return item;
            }
        }      
        return null;
    }
}
