package com.xxglpt.sjjs.controller;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xxglpt.utile.PropertiesReader;
import com.xxglpt.utile.EasyUIPage;
import com.xxglpt.utile.JsonUtils;
import com.xxglpt.utile.ResponseUtils;

import com.xxglpt.sjjs.bean.Cgba;
import com.xxglpt.sjjs.server.CgbaServer;
import com.hdsx.webutil.struts.BaseActionSupport;


/**
 * 系统管理Controller层
 * @author qwh
 *
 */
@Scope("prototype")
@Controller
public class CgbaController extends BaseActionSupport{

	private static final long serialVersionUID = 1L;
	private int page = 1;
	private int rows = 10;
	@Resource(name = "cgbaServerImpl")
	private CgbaServer cgbaServer;
	private Cgba cgba=new Cgba();
	
	private String id;
	private String fileuploadFileName;
	private File fileupload;
	private String kssj;
	private String jssj;
	private String gsmc;
	private String xmmc;
	
	
	
	public void uploadWjFile() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			InputStream inputStream = new FileInputStream(fileupload);
			String s = UUID.randomUUID().toString(); 
			String s1 = s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24);
			String fileurl=PropertiesReader.getInstance().getFileUrl();
			cgba.setId(s1);
			cgba.setXmmc(fileuploadFileName);
			cgba.setGsmc(gsmc);
			cgba.setFileurl(fileurl);
			
			File file =new File(fileurl);
			boolean have=uploadFile(file,fileuploadFileName,
					fileupload);
			if(!have){
				response.getWriter().print(fileuploadFileName+"已存在，请重命名文件或删除之前已存在的文件");
			}else{
				boolean bl=cgbaServer.uploadWjFile(cgba);
				if(bl)
				response.getWriter().print(fileuploadFileName+"    上传成功"+s1);
				else
				response.getWriter().print(fileuploadFileName+"    上传失败"+s1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.getWriter().print(fileuploadFileName +"上传失败！");
			e.printStackTrace();
		}
	}
	

	private boolean uploadFile(File file,String fileName,File filewj) throws FileNotFoundException,IOException {
		if(!file.exists()){
			file.mkdirs();
		}
		
		File saveFile =new File(file, fileName);
		boolean have=saveFile.exists();
		if(have){
			return false;
		}
		InputStream is = new FileInputStream(filewj); 
		OutputStream os = new FileOutputStream(saveFile);
		//设置缓存  
		byte[] buffer = new byte[1024]; 
		int length = 0;
		while((length= is.read(buffer))>0){
			os.write(buffer,0,length);
		}
		is.close();
		os.flush();
		os.close();
		return true;
	}
	public void deleteWjfile(){
		boolean bl=cgbaServer.deleteWjfile(cgba);
		ResponseUtils.write(getresponse(), bl+"");
	}
	
	public void deleteWjfile1(){
		boolean bl=cgbaServer.deleteWjfile1(id);
		ResponseUtils.write(getresponse(), bl+"");
	}
	
	public void insertCgba(){
		String fileurl=PropertiesReader.getInstance().getFileUrl();
		cgba.setUrl(fileurl);
		boolean bl=cgbaServer.insertCgba(cgba);
		ResponseUtils.write(getresponse(), bl+"");
	}
	
	public void updateCgba(){
		boolean bl=cgbaServer.updateCgba(cgba);
		ResponseUtils.write(getresponse(), bl+"");
	}
	
	public void deleteCgba(){
		
			File file =new File(cgba.getUrl(), cgba.getXmmc()+cgba.getWjlx());
			boolean have=file.exists();
			if(have)			
				file.delete();
		
		boolean bl=cgbaServer.deleteCgba(cgba);
		ResponseUtils.write(getresponse(), bl+"");
	}
	
	public void selectcgbalist(){
		cgba.setXmmc(xmmc);
		cgba.setKssj(kssj);
		cgba.setJssj(jssj);
		cgba.setGsmc(gsmc);
		cgba.setPage(page);
		cgba.setRows(rows);
		
		System.out.println(":::::::::"+cgba.getGsmc());
		List<Cgba> list = cgbaServer.selectcgbalist(cgba);
		int count = cgbaServer.selectcgbalistCount(cgba);
		EasyUIPage<Cgba> e=new EasyUIPage<Cgba>();
		e.setRows(list);
		e.setTotal(count);
		try {
			JsonUtils.write(e, getresponse().getWriter());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	
	public void selectWjfile(){
		cgba.setId(id);
		List<Cgba> list = cgbaServer.selectWjfile(cgba);
		try {
			JsonUtils.write(list, getresponse().getWriter());
		}  catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void downWjFile() throws IOException{
		try {
			HttpServletResponse response = getresponse();
			OutputStream out = new BufferedOutputStream(response.getOutputStream());
			response.setContentType("multipart/form-data");
			/*cgba.setId(id);
			Cgba cgba1=cgbaServer.selectWjById(cgba);
			System.out.println("cgba1.getFileurl()+cgba1.getXmmc()::"+cgba1.getFileurl()+"\\"+cgba1.getXmmc());*/
			File file=new File(cgba.getUrl()+"\\"+cgba.getXmmc()+cgba.getWjlx());
			
			response.addHeader("Content-Disposition", "attachment;filename="+ new String((cgba.getXmmc()+cgba.getWjlx()).getBytes("gb2312"), "ISO-8859-1"));
			try {
				FileInputStream fis= new FileInputStream(file);
				byte [] arr = new byte[1024*10];
				int i;
				while((i=fis.read(arr))!=-1){
					out.write(arr,0,i);
					out.flush();
				}
				fis.close();
				out.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private byte [] inputStreamToByte(InputStream is) throws IOException { 
	    ByteArrayOutputStream bAOutputStream = new ByteArrayOutputStream(); 
	    byte [] arr = new byte[1024*10];
	    int ch; 
	    while((ch = is.read(arr) ) != -1){ 
	        bAOutputStream.write(arr,0,ch); 
	    } 
	    byte data [] =bAOutputStream.toByteArray(); 
	    bAOutputStream.close(); 
	    return data; 
	}


	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}


	public int getRows() {
		return rows;
	}


	public void setRows(int rows) {
		this.rows = rows;
	}


	public CgbaServer getCgbaServer() {
		return cgbaServer;
	}


	public void setCgbaServer(CgbaServer cgbaServer) {
		this.cgbaServer = cgbaServer;
	}


	public Cgba getCgba() {
		return cgba;
	}


	public void setCgba(Cgba cgba) {
		this.cgba = cgba;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getFileuploadFileName() {
		return fileuploadFileName;
	}


	public void setFileuploadFileName(String fileuploadFileName) {
		this.fileuploadFileName = fileuploadFileName;
	}


	public File getFileupload() {
		return fileupload;
	}


	public void setFileupload(File fileupload) {
		this.fileupload = fileupload;
	}


	public String getKssj() {
		return kssj;
	}


	public void setKssj(String kssj) {
		this.kssj = kssj;
	}


	public String getJssj() {
		return jssj;
	}


	public void setJssj(String jssj) {
		this.jssj = jssj;
	}


	public String getGsmc() {
		return gsmc;
	}


	public void setGsmc(String gsmc) {
		this.gsmc = gsmc;
	}


	public String getXmmc() {
		return xmmc;
	}


	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}
	
}
