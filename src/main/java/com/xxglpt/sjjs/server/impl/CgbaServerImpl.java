package com.xxglpt.sjjs.server.impl;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hdsx.dao.query.base.BaseOperate;

import com.xxglpt.sjjs.bean.Cgba;
import com.xxglpt.sjjs.server.CgbaServer;

@Service
public class CgbaServerImpl extends BaseOperate implements CgbaServer {

	public CgbaServerImpl() {
		super("cgba", "jdbc");
	}

	public boolean uploadWjFile(Cgba cgba) {
		return insert("uploadWjFile", cgba)==1;
	}

	
	public boolean deleteWjfile(Cgba cgba) {
		return delete("deleteWjfile", cgba)==1;
	}

	
	public boolean deleteWjfile1(String id) {
		Cgba cgba=queryOne("selectcgbabyid", id);
		if(cgba==null)
		delete("deleteWjfile1",id);
		return true;
	}

	
	public boolean insertCgba(Cgba cgba) {
		return insert("insertCgba", cgba)==1;
	}

	
	public List<Cgba> selectcgbalist(Cgba cgba) {
		return queryList("selectcgbalist", cgba);
	}

	
	public int selectcgbalistCount(Cgba cgba) {
		return queryOne("selectcgbalistCount", cgba);
	}

	
	public List<Cgba> selectWjfile(Cgba cgba) {
		return queryList("selectWjfile",cgba);
	}
	public List<Cgba> selectWjfileByWjid(Cgba cgba) {
		return queryList("selectWjfileByWjid",cgba);
	}
	
	
	public Cgba selectWjById(Cgba cgba) {
		// TODO Auto-generated method stub
		return queryOne("selectWjById", cgba);
	}

	
	public boolean updateCgba(Cgba cgba) {
		// TODO Auto-generated method stub
		return update("updateCgba", cgba)==1;
	}

	
	public boolean deleteCgba(Cgba cgba) {
		if(delete("deleteCgba",cgba)==1){
			delete("deleteWjfile1", cgba.getId());
			return true;
		}
		return false;
	}

	
	public boolean deleteJhwj(Cgba cgba) {
		if(delete("deleteJhwj",cgba)==1){
			delete("deleteWjfile1", cgba.getId());
			return true;
		}
		return false;
	}

	
	
}
