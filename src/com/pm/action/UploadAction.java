package com.pm.action;

/*import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport{
	private File upload;//�ϴ����ļ�
	private String uploadFileName;//�ϴ����ļ���
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
	
	public String execute() throws Exception{
		InputStream is = new FileInputStream(getUpload());
		OutputStream os = new FileOutputStream("d:\\upload\\"+uploadFileName);
		byte buffer[] = new byte[1024];
		int count = 0;
		while((count=is.read(buffer))>0){
			os.write(buffer,0,count);
		}
		os.close();
		is.close();
		return "success";
	}

}*/


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;






import com.pm.service.PersonEditionService;
import com.pm.table.PersonEdition;
import com.pm.table.User;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
/* 上传文件 */
@Controller
public class UploadAction extends ActionSupport{
	@Resource
	private PersonEditionService pes;
	private static final int BUFFER_SIZE = 16*1024;
	//�����ϴ��ļ�
	private File upload;
	//�����ϴ��ļ���
	private String uploadFileName;

	
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

	public static int getBufferSize() {
		return BUFFER_SIZE;
	}

	public String execute() throws Exception{
//		User user = new User();
//		user = (User)ActionContext.getContext().getSession().get("user");
 

    	File srcFiles = this.getUpload();

    	String dstPath = "d:\\upload\\"+ this.getUploadFileName();
		File dstFile = new File(dstPath);
		this.copy(srcFiles,dstFile);
/*    	for(int i=0; i<srcFiles.length; i++){
    		String dstPath = "D:\\upload\\"+ this.getUploadFileName()[i];
    		File dstFile = new File(dstPath);
//    		String dir = "d:\\upload\\" + user.getName();
//    		makeDirs(dir);
    		this.copy(srcFiles[i],dstFile);
    	}
*/    	
    	PersonEdition pe = new PersonEdition(); 
//    	pe.setPersonEditionId(1);
        pe.setEditionId("1");  
        pe.setUserId("1");  
        
        Date date = new Date();       
//        Timestamp nousedate = new Timestamp(date.getTime());
        pe.setPersonEditionTime(date);  
        pe.setPersonEditionPath(dstPath);  
        
//        System.out.println("准备执行保存操作");
        pes.savePersonEdition(pe);
//        System.out.println("保存结束咯");
        
        List<PersonEdition> personEditionList = pes.findAllList();      
//        HttpServletRequest request=ServletActionContext.getRequest();
//        request.setAttribute("list", personEditionList);
        ActionContext.getContext().getSession().put("list",personEditionList);
    	return SUCCESS;
	}
	
	
	
	/*
	if(user.getName() != null){
		
		return "success";
	}
	else
		return "error";
	    
}
public static boolean makeDirs(String filePath) {

	if (filePath == null || filePath.isEmpty()) {
		return false;
	}
	File folder = new File(filePath);
        return (folder.exists() && folder.isDirectory()) ? true : folder.mkdirs();
}
*/
	private void copy(File src, File dst){
		InputStream in = null;
		OutputStream out = null;
		try{
			in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
			out = new BufferedOutputStream(new FileOutputStream(dst), BUFFER_SIZE);
			byte[] buffer = new byte[BUFFER_SIZE];
			int len = 0;
			while((len=in.read(buffer))>0){
				out.write(buffer, 0, len);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(in != null)
				try{
					in.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			if(out != null)
				try{
					out.close();
				}catch(IOException e){
					e.printStackTrace();
				}
		}
		
	}
	
	
    
	
	
/*	Configuration config = new Configuration().configure();
	SessionFactory sessionFactory = config.buildSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction ts = session.beginTransaction();
	this.session.save(pe);//ִ��  
    ts.commit();//�ύ 
*/ 
}


