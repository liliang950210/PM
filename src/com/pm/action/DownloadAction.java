package com.pm.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;


public class DownloadAction extends ActionSupport{
	
	private String downloadFile;

	public String getDownloadFile() {
		return downloadFile;
	}

	public void setDownloadFile(String downloadFile) {
		this.downloadFile = downloadFile;
	}
	
	public InputStream getTargetFile(){
		return ServletActionContext.getServletContext().getResourceAsStream(downloadFile);
	}
	
	public String execute() throws Exception{
		return SUCCESS;
	}
	//ͨ��paramָ�����ļ���
/*	private String fileName;
	public void setFileName(String fileName){
		this.fileName = fileName;
	}
	
	public InputStream getIputStream() throws Exception{
		return new ByteArrayInputStream("���������ѧ��ɲ������lalala".getBytes());
	}
	
	public String execute() throws Exception{
		return "success";
	}
	
	//�ṩת�������Ĺ����ص��ļ���
	public String getDownloadFileName(){
		String downFileName = fileName;
		try{
			downFileName = new String(downFileName.getBytes(),"ISO8859-1");
		} catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return downFileName;
	}
*/	

}
