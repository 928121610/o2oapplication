package cn.swb.o2osys.application.config;

public enum PersonInfoFlag {
	CUSTOMER(0, "普通用户") , SHOPOEMPLOYEE(1, "店主 ") ;
	private int code;
	private String msg;
	PersonInfoFlag(){}
	PersonInfoFlag (int code, String msg) {
		this.msg = msg;
	}
	public int getCode (){
		return code;
	}
}