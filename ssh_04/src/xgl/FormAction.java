package xgl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class FormAction extends ActionSupport implements ModelDriven {

	private FormData formData = new FormData();
	public Object getModel() {
		return formData;
	}
	public String execute(){
		if(formData.getUsername()==null || formData.getUsername().trim().length()==0)
			return INPUT;
		return SUCCESS;
		
	}
}
