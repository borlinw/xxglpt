package com.xxglpt.sjjs.server.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hdsx.dao.query.base.BaseOperate;
import com.xxglpt.sjjs.bean.Hjch;
import com.xxglpt.sjjs.bean.HjchMx;
import com.xxglpt.sjjs.bean.Jcch;
import com.xxglpt.sjjs.bean.JcchMx;
import com.xxglpt.sjjs.server.SjjsServer;

@Service
public class SjjsServerImpl extends BaseOperate  implements SjjsServer{

	public SjjsServerImpl() {
		super("sjjs", "jdbc");
	}

		public int selectHjchListCount(Hjch hm) {
		return queryOne("selectHjchListCount", hm);
	}

	
	public List<Hjch> selectHjchList(Hjch hm) {
		return queryList("selectHjchList", hm);
	}

	
	public boolean insertHjch(Hjch Hjch) {
		int b=insert("insertHjch", Hjch);
		return b>0?true:false;
	}

	
	public boolean deleteHjch(String id) {
		int b=delete("deleteHjch",id);
		return b>0?true:false;
	}

	
	public boolean updateHjch(Hjch Hjch) {
		int b=update("updateHjch", Hjch);
		return b>0?true:false;
	}

		
	public Hjch selectHjchById(Hjch Hjch) {
		return queryOne("selectHjchById", Hjch);
	}

	public HashMap selectHjchById2(Hjch hjch) {
		// TODO Auto-generated method stub
		return queryOne("selectHjchById2", hjch);
	}

	public List<HjchMx> selectHjchMx(Hjch hm) {
		// TODO Auto-generated method stub
		return queryList("selectHjchMx", hm);
	}

	public boolean addHjchMxBatch(List<HjchMx> list) {
		// TODO Auto-generated method stub
		int b=insertBatch("addHjchMxBatch", list);
		return b>0?true:false;
	}

	public boolean deleteHjchMxById(String id) {
		// TODO Auto-generated method stub
		int b=delete("deleteHjchMxById",id);
		return b>0?true:false;
	}


		public int selectJcchListCount(Jcch hm) {
		return queryOne("selectJcchListCount", hm);
	}
	
	
	public List<Jcch> selectJcchList(Jcch hm) {
		return queryList("selectJcchList", hm);
	}
	
	
	public boolean insertJcch(Jcch Jcch) {
		int b=insert("insertJcch", Jcch);
		return b>0?true:false;
	}
	
	
	public boolean deleteJcch(String id) {
		int b=delete("deleteJcch",id);
		return b>0?true:false;
	}
	
	
	public boolean updateJcch(Jcch Jcch) {
		int b=update("updateJcch", Jcch);
		return b>0?true:false;
	}
	
		
	public Jcch selectJcchById(Jcch Jcch) {
		return queryOne("selectJcchById", Jcch);
	}
	
	public HashMap selectJcchById2(Jcch jcch) {
		// TODO Auto-generated method stub
		return queryOne("selectJcchById2", jcch);
	}
	
	public List<JcchMx> selectJcchMx(Jcch hm) {
		// TODO Auto-generated method stub
		return queryList("selectJcchMx", hm);
	}
	
	public boolean addJcchMxBatch(List<JcchMx> list) {
		// TODO Auto-generated method stub
		int b=insertBatch("addJcchMxBatch", list);
		return b>0?true:false;
	}
	
	public boolean deleteJcchMxById(String id) {
		// TODO Auto-generated method stub
		int b=delete("deleteJcchMxById",id);
		return b>0?true:false;
	}
}
