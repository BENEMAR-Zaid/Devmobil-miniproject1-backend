package com.example.backendp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvertionDao {
	
	@Autowired
	private ConvertionRepository rep;
	
	public void save (ConvertionEntity conv) {
		rep.save(conv);
	}
	
	public List<ConvertionEntity> getAllConvertions() {
		return rep.findAll();
	}
	
}
