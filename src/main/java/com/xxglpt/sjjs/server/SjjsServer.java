package com.xxglpt.sjjs.server;

import java.util.HashMap;
import java.util.List;

import com.xxglpt.sjjs.bean.Hjch;
import com.xxglpt.sjjs.bean.HjchMx;
import com.xxglpt.sjjs.bean.Jcch;
import com.xxglpt.sjjs.bean.JcchMx;

public interface SjjsServer {

	int selectHjchListCount(Hjch hm);

	List<Hjch> selectHjchList(Hjch hm);
	List<HjchMx> selectHjchMx(Hjch hm);
	

	boolean insertHjch(Hjch Hjch);
	boolean addHjchMxBatch(List<HjchMx> list);
	
	boolean deleteHjch(String id);

	boolean updateHjch(Hjch Hjch);
	
	Hjch selectHjchById(Hjch hjch);
	HashMap selectHjchById2(Hjch hjch);
	
	boolean deleteHjchMxById(String id);
	
	int selectJcchListCount(Jcch hm);

	List<Jcch> selectJcchList(Jcch hm);
	List<JcchMx> selectJcchMx(Jcch hm);
	

	boolean insertJcch(Jcch Jcch);
	boolean addJcchMxBatch(List<JcchMx> list);
	
	boolean deleteJcch(String id);

	boolean updateJcch(Jcch Jcch);
	
	Jcch selectJcchById(Jcch jcch);
	HashMap selectJcchById2(Jcch jcch);
	
	boolean deleteJcchMxById(String id);
}
