package com.xxglpt.sjjs.controller;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import sun.misc.BASE64Encoder;

import com.hdsx.webutil.struts.BaseActionSupport;
import com.xxglpt.utile.EasyUIPage;
import com.xxglpt.sjjs.bean.Hjch;
import com.xxglpt.sjjs.bean.HjchMx;
import com.xxglpt.sjjs.bean.Jcch;
import com.xxglpt.sjjs.bean.JcchMx;
import com.xxglpt.utile.JsonUtils;
import com.xxglpt.utile.ResponseUtils;
import com.xxglpt.utile.WordOperation;
import com.xxglpt.sjjs.server.SjjsServer;
/**
 * 系统管理Controller层
 * @author xunq
 *
 */
@Scope("prototype")
@Controller
public class SjjsController extends BaseActionSupport{
	private static final long serialVersionUID = -1512493918772500846L;
	private int page = 1;
	private int rows = 10;
	@Resource(name = "sjjsServerImpl")
	private SjjsServer sjjsServer;
	private Hjch hjch;
	private Jcch jcch;
	private String id;
	private String xmlName;

	/**
	 * 汇交测绘数据管理列表
	 */
	public void selectHjchList(){
		hjch.setPage(page);
		hjch.setRows(rows);
		int count=sjjsServer.selectHjchListCount(hjch);
		List<Hjch> list=sjjsServer.selectHjchList(hjch);
		EasyUIPage<Hjch> e=new EasyUIPage<Hjch>();
		e.setRows(list);
		e.setTotal(count);
		try {
			JsonUtils.write(e, getresponse().getWriter());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	public void selectHjchById(){
		Hjch m=sjjsServer.selectHjchById(hjch);
		try {
			JsonUtils.write(m, getresponse().getWriter());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * 添加汇交测绘数据
	 */
	public void insertHjch(){
		String str=hjch.getMxstr();
		hjch.setId(UUID.randomUUID().toString());
		boolean bl=sjjsServer.insertHjch(hjch);
		if(bl=true){
			List<HjchMx> list=new ArrayList<HjchMx>();
			str=str.substring(2);
			String[] a=str.split("on,");
			for (int i=0;i<a.length;i++){
				String[] b=a[i].split(",");
				if(!"".equals(b[0]))
				{
					HjchMx m=new HjchMx();
					m.setXh(b[0]);
					m.setSjlx(b[1]);
					m.setSl(b[2]);
					m.setZbx(b[3]);
					m.setBz(b[4]);
					m.setHjchId(hjch.getId());
					list.add(m);
				}
			}
			boolean bl2=sjjsServer.addHjchMxBatch(list);
			if(bl2!=true) {
				ResponseUtils.write(getresponse(), "false");
			}else{
				ResponseUtils.write(getresponse(), "true");
			}
		}else{
			ResponseUtils.write(getresponse(), "false");
		}
		
	}
	
	/**
	 * 删除汇交测绘数据
	 */
	public void deleteHjch(){
		boolean bl = sjjsServer.deleteHjch(id);
		if(bl == true){
			ResponseUtils.write(getresponse(), "true");
		}else{
			ResponseUtils.write(getresponse(), "false");
		}
	}
	
	
	public void selectHjchMx(){
		List<HjchMx> list=sjjsServer.selectHjchMx(hjch);
		try {
			JsonUtils.write(list, getresponse().getWriter());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	public void hjchDownDoc(){
		HashMap map=sjjsServer.selectHjchById2(hjch);
		List<HjchMx> list=sjjsServer.selectHjchMx(hjch);
		//HashMap map=new HashMap();
		//System.out.println(map.get("A1"));
		map.put("a1",map.get("A1"));
		map.put("a2",map.get("A2"));
		map.put("a3",map.get("A3"));
		map.put("a4",map.get("A4"));
		map.put("a5",map.get("A5"));
		map.put("a6",map.get("A6"));
		map.put("a7",map.get("A7"));
		map.put("a8",map.get("A8"));
		map.put("a9",map.get("A9"));
		map.put("a10",map.get("A10"));
		map.put("a11",map.get("A11"));
		map.put("a12",map.get("A12").toString().replaceAll("\n","<w:p></w:p>"));
		map.put("list", list);
		/*map.put("a13",map.get("A13"));
		map.put("a14",map.get("A14"));
		map.put("a15",map.get("A15"));
		map.put("a16",map.get("A16"));
		map.put("a17",map.get("A17"));
		map.put("a18",map.get("A18"));map
		map.put("a19",map.get("A19"));
		map.put("a20",map.get("A20"));
		map.put("a21",map.get("A21"));
		map.put("a22",map.get("A22"));
		map.put("a23",map.get("A23"));
		map.put("a24",map.get("A24"));
		map.put("a25",map.get("A25"));
		map.put("a26",map.get("A26"));
		map.put("a27",map.get("A27"));*/
		xmlName="广元市测绘成果汇交凭证.xml";
		WordOperation wo=new WordOperation();
		wo.createDoc(map,xmlName,getresponse());
	}
	/**
	 * 删除汇交测绘数据
	 */
	public void updateHjch(){
		
		boolean bl = sjjsServer.updateHjch(hjch);
		if(bl=true){
			sjjsServer.deleteHjchMxById(hjch.getId());
			String str=hjch.getMxstr();
			List<HjchMx> list=new ArrayList<HjchMx>();
			str=str.substring(2);
			String[] a=str.split("on,");
			for (int i=0;i<a.length;i++){
				String[] b=a[i].split(",");
				if(!"".equals(b[0]))
				{
					HjchMx m=new HjchMx();
					m.setXh(b[0]);
					m.setSjlx(b[1]);
					m.setSl(b[2]);
					m.setZbx(b[3]);
					m.setBz(b[4]);
					m.setHjchId(hjch.getId());
					list.add(m);
				}
			}
			boolean bl2=sjjsServer.addHjchMxBatch(list);
			if(bl2!=true) {
				ResponseUtils.write(getresponse(), "false");
			}else{
				ResponseUtils.write(getresponse(), "true");
			}
		}else{
			ResponseUtils.write(getresponse(), "false");
		}
		
	}
	
	
	/**
	 * 基础测绘数据管理列表
	 */
	public void selectJcchList(){
		jcch.setPage(page);
		jcch.setRows(rows);
		int count=sjjsServer.selectJcchListCount(jcch);
		List<Jcch> list=sjjsServer.selectJcchList(jcch);
		EasyUIPage<Jcch> e=new EasyUIPage<Jcch>();
		e.setRows(list);
		e.setTotal(count);
		try {
			JsonUtils.write(e, getresponse().getWriter());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	public void selectJcchById(){
		Jcch m=sjjsServer.selectJcchById(jcch);
		try {
			JsonUtils.write(m, getresponse().getWriter());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * 添加基础测绘数据
	 */
	public void insertJcch(){
		String str=jcch.getMxstr();
		
		jcch.setId(UUID.randomUUID().toString());
		boolean bl=sjjsServer.insertJcch(jcch);
		if(bl=true){
			List<JcchMx> list=new ArrayList<JcchMx>();
			str=str.substring(2);
			System.out.println("str:===="+str);
			String[] a=str.split("on,");
			for (int i=0;i<a.length;i++){
				String[] b=a[i].split(",");
				System.out.println("b.length::::::::"+b.length);
				
				if(!"".equals(b[0]))
				{
					JcchMx m=new JcchMx();
					m.setXh(b[0]);
					m.setSjlx(b[1]);
					m.setSl(b[2]);
					m.setZt(b[3]);
					m.setZbx(b[4]);
					m.setBz(b[5]);
					m.setJcchId(jcch.getId());
					list.add(m);
				}
			}
			boolean bl2=sjjsServer.addJcchMxBatch(list);
			if(bl2!=true) {
				ResponseUtils.write(getresponse(), "false");
			}else{
				ResponseUtils.write(getresponse(), "true");
			}
		}else{
			ResponseUtils.write(getresponse(), "false");
		}
		
	}
	
	/**
	 * 删除基础测绘数据
	 */
	public void deleteJcch(){
		boolean bl = sjjsServer.deleteJcch(id);
		if(bl == true){
			ResponseUtils.write(getresponse(), "true");
		}else{
			ResponseUtils.write(getresponse(), "false");
		}
	}
	
	
	public void selectJcchMx(){
		System.out.println("jcch:::::::"+jcch.getId());
		List<JcchMx> list=sjjsServer.selectJcchMx(jcch);
		try {
			JsonUtils.write(list, getresponse().getWriter());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	public void jcchDownDoc(){
		HashMap map=sjjsServer.selectJcchById2(jcch);
		List<JcchMx> list=sjjsServer.selectJcchMx(jcch);
		//HashMap map=new HashMap();
		//System.out.println(map.get("A1"));
		map.put("a1",map.get("A1"));
		map.put("a2",map.get("A2"));
		map.put("a3",map.get("A3"));
		map.put("a4",map.get("A4"));
		map.put("a5",map.get("A5"));
		map.put("a6",map.get("A6"));
		map.put("a7",map.get("A7"));
		map.put("a8",map.get("A8"));
		map.put("a9",map.get("A9"));
		map.put("a10",map.get("A10"));
		map.put("a11",map.get("A11"));
		map.put("a12",map.get("A12").toString().replaceAll("\n","<w:p></w:p>"));
		map.put("list", list);
		/*map.put("a13",map.get("A13"));
		map.put("a14",map.get("A14"));
		map.put("a15",map.get("A15"));
		map.put("a16",map.get("A16"));
		map.put("a17",map.get("A17"));
		map.put("a18",map.get("A18"));map
		map.put("a19",map.get("A19"));
		map.put("a20",map.get("A20"));
		map.put("a21",map.get("A21"));
		map.put("a22",map.get("A22"));
		map.put("a23",map.get("A23"));
		map.put("a24",map.get("A24"));
		map.put("a25",map.get("A25"));
		map.put("a26",map.get("A26"));
		map.put("a27",map.get("A27"));*/
		xmlName="广元市基础测绘凭证.xml";
		WordOperation wo=new WordOperation();
		wo.createDoc(map,xmlName,getresponse());
	}
	/**
	 * 删除基础测绘数据
	 */
	public void updateJcch(){
		
		boolean bl = sjjsServer.updateJcch(jcch);
		if(bl=true){
			sjjsServer.deleteJcchMxById(jcch.getId());
			String str=jcch.getMxstr();
			List<JcchMx> list=new ArrayList<JcchMx>();
			str=str.substring(2);
			String[] a=str.split("on,");
			for (int i=0;i<a.length;i++){
				String[] b=a[i].split(",");
				if(!"".equals(b[0]))
				{
					JcchMx m=new JcchMx();
					m.setXh(b[0]);
					m.setSjlx(b[1]);
					m.setSl(b[2]);
					m.setZt(b[3]);
					m.setZbx(b[4]);
					m.setBz(b[5]);
					m.setJcchId(jcch.getId());
					list.add(m);
				}
			}
			boolean bl2=sjjsServer.addJcchMxBatch(list);
			if(bl2!=true) {
				ResponseUtils.write(getresponse(), "false");
			}else{
				ResponseUtils.write(getresponse(), "true");
			}
		}else{
			ResponseUtils.write(getresponse(), "false");
		}
		
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
	public Hjch getHjch() {
		return hjch;
	}
	public void setHjch(Hjch hjch) {
		this.hjch = hjch;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getXmlName() {
		return xmlName;
	}
	public void setXmlName(String xmlName) {
		this.xmlName = xmlName;
	}
	public Jcch getJcch() {
		return jcch;
	}
	public void setJcch(Jcch jcch) {
		this.jcch = jcch;
	}

}
