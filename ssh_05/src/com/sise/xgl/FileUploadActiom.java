package com.sise.xgl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileUploadActiom extends ActionSupport {
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	private String savePath;
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	
	public String getSavePath(){
		return ServletActionContext.getServletContext().getRealPath(savePath);
	}
	
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public String execute() throws IOException{
		String filePath = getSavePath()+"\\"+getUploadFileName();
		InputStream is = new FileInputStream(getUpload());
		OutputStream os = new FileOutputStream(filePath);
		byte buffer[] = new byte[1024];
		int len = 0;
		while((len=is.read(buffer))>0)
			os.write(buffer,0,len);
		os.close();
		is.close();
		return SUCCESS;
	}
}
