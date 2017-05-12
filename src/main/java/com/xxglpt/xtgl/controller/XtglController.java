package com.xxglpt.xtgl.controller;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import sun.misc.BASE64Encoder;

import com.hdsx.webutil.struts.BaseActionSupport;
import com.xxglpt.utile.EasyUIPage;
import com.xxglpt.xtgl.bean.TreeNode;
import com.xxglpt.xtgl.bean.Unit;
import com.xxglpt.xtgl.bean.Param;
import com.xxglpt.utile.JsonUtils;
import com.xxglpt.utile.ResponseUtils;
import com.xxglpt.xtgl.bean.Master;
import com.xxglpt.xtgl.server.XtglServer;
/**
 * 系统管理Controller层
 * @author xunq
 *
 */
@Scope("prototype")
@Controller
public class XtglController extends BaseActionSupport{
	private static final long serialVersionUID = -1512493918772500846L;
	private int page = 1;
	private int rows = 10;
	@Resource(name = "xtglServerImpl")
	private XtglServer xtglServer;

	private Unit unit;
	private Param param;
	//用户实体
	private Master master;
	private String anyXml;
	private String yhm;
	private String yhzt;
	private String yhdw;
	private String yhids;
	private String username;
	private String password;
	private String gmgid;
	private String id;
	private String yzm;
	private String parent;
	
	/**
	 * 重置密碼
	 */
	public void czPassword(){
		MessageDigest md5;
		String temp="";
		try {
			md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base = new BASE64Encoder();
			temp = base.encode(md5.digest("000000".getBytes()));
			this.master.setPassword(temp);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean bl = xtglServer.czPassword(master);
		if(bl){
			ResponseUtils.write(getresponse(), "true");
		}
		else
			ResponseUtils.write(getresponse(), "false");
	}
	/**
	 * 单位级联查询
	 */
	public void seldw2(){
		try {
			List<TreeNode> l=xtglServer.selchildedw(yhdw+"__");
			String s=JSONArray.fromObject(l).toString();
			ResponseUtils.write(getresponse(), s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void seldw(){
		try {
			List<TreeNode> l=xtglServer.seldw(yhdw);
			String s=JSONArray.fromObject(l).toString();
			ResponseUtils.write(getresponse(), s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * updatePassword
	 */
	public void updatePassword(){
		MessageDigest md5;
		String temp="";
		try {
			md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base = new BASE64Encoder();
			temp = base.encode(md5.digest(password.getBytes()));
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashMap hm=new HashMap();
		hm.put("id", username);
		hm.put("mm", temp);
		boolean bl = xtglServer.updatePassword(hm);
		if(bl == true){
			ResponseUtils.write(getresponse(), "true");
		}else{
			ResponseUtils.write(getresponse(), "false");
		}
	}
	/**
	 * 用户管理列表
	 */
	public void selectYhList(){
		HashMap hm=new HashMap();
		hm.put("page", page);
		hm.put("rows", rows);
		hm.put("yhm", master.getTruename());
		if(!"36".equals(master.getUnit())) hm.put("unit", master.getUnit());
		int count=xtglServer.selectYhListCount(hm);
		List<Master> list=xtglServer.selectYhList(hm);
		EasyUIPage<Master> e=new EasyUIPage<Master>();
		e.setRows(list);
		e.setTotal(count);
		try {
			JsonUtils.write(e, getresponse().getWriter());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	public void selectYhById(){
		Master m=xtglServer.selectYhById(master);
		try {
			JsonUtils.write(m, getresponse().getWriter());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	/**
	 * 选择角色列表
	 */
	public void selQxList(){
		HashMap hm=new HashMap();
		List<HashMap> list=xtglServer.selQxList(hm);
		try {
			JsonUtils.write(list, getresponse().getWriter());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	/**
	 * 添加用户
	 */
	public void insertYh(){
		MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base = new BASE64Encoder();
			String temp = base.encode(md5.digest(master.getPassword().getBytes()));
			master.setPassword(temp);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		boolean b=xtglServer.insertYh(master);
		if(b!=true){
			ResponseUtils.write(getresponse(), "false");
		}else{
			ResponseUtils.write(getresponse(), "true");
		}
	}
	/**
	 * 添加用户
	 */
	public void updatezt(){
		HashMap hm=new HashMap();
		hm.put("id", yhm);
		hm.put("zt", yhzt);
		boolean bl = xtglServer.updatezt(hm);
		if(bl == true){
			ResponseUtils.write(getresponse(), "true");
		}else{
			ResponseUtils.write(getresponse(), "false");
		}
	}
	/**
	 * 重置密码
	 */
	public void mimareset(){
		MessageDigest md5;
		String temp="";
		try {
			md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base = new BASE64Encoder();
			temp = base.encode(md5.digest("000000".getBytes()));
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashMap hm=new HashMap();
		hm.put("id", yhm);
		hm.put("password", temp);
		boolean bl = xtglServer.mimareset(hm);
		if(bl == true){
			ResponseUtils.write(getresponse(), "true");
		}else{
			ResponseUtils.write(getresponse(), "false");
		}
	}
	/**
	 * 删除用户
	 */
	public void deleteYh(){
		boolean bl = xtglServer.deleteYh(yhm);
		if(bl == true){
			ResponseUtils.write(getresponse(), "true");
		}else{
			ResponseUtils.write(getresponse(), "false");
		}
	}
	/**
	 * 删除用户
	 */
	public void updateYh(){
		/*
		MessageDigest md5;
		String temp="";
		try {
			md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base = new BASE64Encoder();
			temp = base.encode(md5.digest("000000".getBytes()));
			master.setPassword(temp);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}*/
		boolean bl = xtglServer.updateYh(master);
		if(bl == true){
			ResponseUtils.write(getresponse(), "true");
		}else{
			ResponseUtils.write(getresponse(), "false");
		}
	}
	/**
	 * 角色列表
	 */
	public void selectJsList(){
		List<Param> list=xtglServer.selectJsList(param);
		try {
			JsonUtils.write(list, getresponse().getWriter());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	/**
	 * 角色列表
	 */
	public void insertJs(){
		boolean bl  = xtglServer.insertJs(param);
		if(bl == true){
			ResponseUtils.write(getresponse(), "true");
		}else{
			ResponseUtils.write(getresponse(), "false");
		}
	}
	
	public void updateJs(){
		boolean bl  = xtglServer.updateJs(param);
		if(bl == true){
			ResponseUtils.write(getresponse(), "true");
		}else{
			ResponseUtils.write(getresponse(), "false");
		}
	}
	
	public void selectJsById(){
		Param p=xtglServer.selectJsById(param);
		try {
			JsonUtils.write(p, getresponse().getWriter());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * 删除角色
	 */
	public void deleteJsById(){
		boolean bl  = xtglServer.deleteJsById(param);
		if(bl == true){
			ResponseUtils.write(getresponse(), "true");
		}else{
			ResponseUtils.write(getresponse(), "false");
		}
	}
	public void login(){
		System.out.println("==========");
		MessageDigest md5;
		String temp="";
		try {
			md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base = new BASE64Encoder();
			temp = base.encode(md5.digest(master.getPassword().getBytes()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		HashMap hm=new HashMap();
		hm.put("truename", master.getTruename());
		hm.put("password", temp);
		HashMap<String,String> bl = xtglServer.login(hm);
		if(bl!=null){
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			session.setAttribute("truename", bl.get("TRUENAME"));
			try {
				JsonUtils.write(bl, getresponse().getWriter());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}else{
			ResponseUtils.write(getresponse(), "false");
		}
	}
	/**
	 * 从session中取出用户名查询权限（防止用户没有登录直接访问index页面）
	 */
	public void selQx(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("truename");
		if(username == null || username == ""){
			ResponseUtils.write(getresponse(), "false");
		}else{
			ResponseUtils.write(getresponse(), "true");
		}
	}
	public void selQxByUser(){
		List<Param> l=null;
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
				l=xtglServer.selQxByUser(param);
				String qx1="";String qx2="";String qx3="";String qx4="";String qx5="";String qx6="";String qx7="";
				for (Param param : l) {
					if(param.getId().length()==4)
						qx1+=","+param.getId();
					if(param.getId().length()==6)
						qx2+=","+param.getId();
					if(param.getId().length()==8)
						qx3+=","+param.getId();
					if(param.getId().length()==10)
						qx4+=","+param.getId();
					if(param.getId().length()==12)
						qx5+=","+param.getId();
					if(param.getId().length()==14)
						qx6+=","+param.getId();
					if(param.getId().length()==16)
						qx7+=","+param.getId();
				}
				if(qx1.length()>0)
				session.setAttribute("qx1", qx1.substring(1));
				if(qx2.length()>0)
				session.setAttribute("qx2", qx2.substring(1));
				if(qx3.length()>0)
				session.setAttribute("qx3", qx3.substring(1));
				if(qx4.length()>0)
				session.setAttribute("qx4", qx4.substring(1));
				if(qx5.length()>0)
				session.setAttribute("qx5", qx5.substring(1));
				if(qx6.length()>0)
				session.setAttribute("qx6", qx6.substring(1));
				if(qx7.length()>0)
				session.setAttribute("qx7", qx7.substring(1));
				//List<Param> l1	=xtglServer.selQxByUser1(param);
				session.setAttribute("sour", l);
				
		
			JsonUtils.write(l, getresponse().getWriter());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	public void getQxfromSession(){
		try {
		HttpSession session = getRequest().getSession();
		System.out.println((String)session.getAttribute(qx));
		ResponseUtils.write(getresponse(), (String)session.getAttribute(qx));
			//JsonUtils.write((String)session.getAttribute(qx), getresponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void selAllQx(){
		List<TreeNode> l=xtglServer.selQxByRoleid(param);
		TreeNode root = returnRoot(l,l.get(0),new ArrayList<Param>());
		List<TreeNode> children = root.getChildren();
		try {
		    String s=JSONArray.fromObject(children).toString();
            ResponseUtils.write(getresponse(), s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void selAllQx2(){
		List<TreeNode> l=xtglServer.selAllQx2(yhdw);
		try {
		    String s=JSONArray.fromObject(l).toString();
            ResponseUtils.write(getresponse(), s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selQxByRoleid(){
		List<TreeNode> l=xtglServer.selQxByRoleid(param);
		List<Param> l2=xtglServer.selQxListByRoleid(param);
		
		
		TreeNode root = returnRoot(l,l.get(0),l2);
		List<TreeNode> children = root.getChildren();
		try{
		    String s=JSONArray.fromObject(children).toString();
            ResponseUtils.write(getresponse(), s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private TreeNode returnRoot(List<TreeNode> list, TreeNode zzjgTree,List<Param> l2){
		for (Param p : l2) {
				if(p.getSourceid().equals(zzjgTree.getId())) zzjgTree.setChecked("true");
		}
		
		for(TreeNode temp : list){
			if(temp!=zzjgTree){
				if(temp.getParent() != null &&temp.getParent() !="" && temp.getParent().equals(zzjgTree.getId())){
					zzjgTree.setState("closed");
					zzjgTree.getChildren().add(temp);
					returnRoot(list,temp,l2);
				}
			}
		}
		return zzjgTree;
	}
	
	/**
	 * 用户退出系统时删除session信息
	 * @return
	 */
	public void clearSession(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		if(session.getAttribute("truename") != null){
			session.setAttribute("truename",null);
		}
		ResponseUtils.write(getresponse(), "true");
	}
	
	/**
	 * 单位树列表
	 */
	public void selectDwList(){
		int count = xtglServer.selectDwListCount(unit);
		List<Unit> list = xtglServer.selectDwList(unit);
		int len=unit.getId().length();
		if(len!=0) len+=4;
		for(int i=0;i<list.size();i++){
			if(!unit.getId().equals(list.get(i).getId())&&i!=0)
			{
				list.get(i).set_parentId(list.get(i).getParent());
			}
			if(list.get(i).getUnit().length()>len+11){
				list.get(i).setState("closed");
			}
		}
		EasyUIPage<Unit> ep = new EasyUIPage<Unit>();
		ep.setTotal(count);
		ep.setRows(list);
		try {
			JsonUtils.write(ep, getresponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 编码编码树列表
	 */
	public void getBmbmTreeByName(){
		try {
			yhm=java.net.URLDecoder.decode(yhm,"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		HashMap<String, String> hm=new HashMap<String, String>();
		hm.put("name", yhm);
		List<TreeNode> list =  xtglServer.getBmbmTreeByName(hm);
		try {
			JsonUtils.write(list, getresponse().getWriter());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 插入单位
	 */
	public void insertDw(){
		boolean bl=xtglServer.insertDw(unit);
		if(bl == true){
			ResponseUtils.write(getresponse(), "true");
		}else{
			ResponseUtils.write(getresponse(), "false");
		}
	}
	/**
	 * 插入单位
	 */
	public void deleteDwById(){
		boolean bl=xtglServer.deleteDwById(unit);
		if(bl == true){
			ResponseUtils.write(getresponse(), "true");
		}else{
			ResponseUtils.write(getresponse(), "false");
		}
	}
	/**
	 * cha单位
	 */
	public void selectDwById(){
		List<Unit> list =  xtglServer.selectDwById(unit);
		try {
			JsonUtils.write(list, getresponse().getWriter());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * update单位
	 */
	public void updateDw(){
		boolean bl=xtglServer.updateDw(unit);
		if(bl == true){
			ResponseUtils.write(getresponse(), "true");
		}else{
			ResponseUtils.write(getresponse(), "false");
		}
	}
	public void selAllBm(){
		try {
            List<TreeNode> l=xtglServer.selAllBm(yhdw);
		    String s=JSONArray.fromObject(l).toString();
            ResponseUtils.write(getresponse(), s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selAllBm2(){
		try {
            List<TreeNode> l=xtglServer.selAllBm2(yhdw);
		    String s=JSONArray.fromObject(l).toString();
            ResponseUtils.write(getresponse(), s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * bmbm树
	 */
	public void selectBmbmList(){
		int count = xtglServer.selectBmbmListCount(unit);
		List<Unit> list = xtglServer.selectBmbmList(unit);
		for(int i=0;i<list.size();i++){
			if(!unit.getId().equals(list.get(i).getId()))
			{
				list.get(i).set_parentId(list.get(i).getParent());
			}
			if(list.get(i).getId().length()==4){
				list.get(i).setState("closed");
			}
		}
		EasyUIPage<Unit> ep = new EasyUIPage<Unit>();
		ep.setTotal(count);
		ep.setRows(list);
		try {
			JsonUtils.write(ep, getresponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * insertBmbm
	 */
	public void insertBmbm(){
		boolean bl=xtglServer.insertBmbm(unit);
		if(bl == true){
			ResponseUtils.write(getresponse(), "true");
		}else{
			ResponseUtils.write(getresponse(), "false");
		}
	}
	/**
	 * updateBmbm
	 */
	public void updateBmbm(){
		boolean bl=xtglServer.updateBmbm(unit);
		if(bl == true){
			ResponseUtils.write(getresponse(), "true");
		}else{
			ResponseUtils.write(getresponse(), "false");
		}
	}
	/**
	 * deleteBmbm
	 */
	public void deleteBmbmById(){
		boolean bl=xtglServer.deleteBmbmById(unit);
		if(bl == true){
			ResponseUtils.write(getresponse(), "true");
		}else{
			ResponseUtils.write(getresponse(), "false");
		}
	}
	
	public void checkname(){
		HashMap hm=new HashMap();
		hm.put("truename", master.getTruename());
		List<Master> list=xtglServer.checkname(hm);
		try {
			JsonUtils.write(list, getresponse().getWriter());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public void checkJsCfByName(){
		List<Param> l=xtglServer.checkJsCfByName(param);
		try {
			JsonUtils.write(l, getresponse().getWriter());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public void selJsUsedById(){
		System.out.println(param.getRoleid());
		List<Param> l=xtglServer.selJsUsedById(param);
		try {
			JsonUtils.write(l, getresponse().getWriter());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	private String qx;

	public String getQx() {
		return qx;
	}
	public void setQx(String qx) {
		this.qx = qx;
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
	public Master getMaster() {
		return master;
	}
	public void setMaster(Master master) {
		this.master = master;
	}
	public Param getParam() {
		return param;
	}
	public void setParam(Param param) {
		this.param = param;
	}
	public XtglServer getXtglServer() {
		return xtglServer;
	}
	public void setXtglServer(XtglServer xtglServer) {
		this.xtglServer = xtglServer;
	}
	public Unit getUnit() {
		return unit;
	}
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	public String getAnyXml() {
		return anyXml;
	}
	public void setAnyXml(String anyXml) {
		this.anyXml = anyXml;
	}
	public String getYhm() {
		return yhm;
	}
	public void setYhm(String yhm) {
		this.yhm = yhm;
	}
	public String getYhzt() {
		return yhzt;
	}
	public void setYhzt(String yhzt) {
		this.yhzt = yhzt;
	}
	public String getYhdw() {
		return yhdw;
	}
	public void setYhdw(String yhdw) {
		this.yhdw = yhdw;
	}
	public String getYhids() {
		return yhids;
	}
	public void setYhids(String yhids) {
		this.yhids = yhids;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGmgid() {
		return gmgid;
	}
	public void setGmgid(String gmgid) {
		this.gmgid = gmgid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getYzm() {
		return yzm;
	}
	public void setYzm(String yzm) {
		this.yzm = yzm;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}

}
