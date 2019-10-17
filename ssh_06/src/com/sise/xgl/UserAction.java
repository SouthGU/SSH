package com.sise.xgl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
//MODEL
public class UserAction extends ActionSupport implements ModelDriven {

	private Register register = new Register();
	public Object getModel() {
		return register;
	}
	public String register() throws Exception{
		return SUCCESS;
	}
	public String login() throws Exception{
		return SUCCESS;
	}

}
