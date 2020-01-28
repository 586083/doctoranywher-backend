package com.doctoranywhere.doctoranywhere.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.doctoranywhere.doctoranywhere.dao.SequenceMapper;
import com.doctoranywhere.doctoranywhere.service.SequenceService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class SequenceServiceImpl implements SequenceService{
	
	@Autowired
	private SequenceMapper sequenceMapper;

	@Override
	public int getPatientSeq() {
		return sequenceMapper.getPatientSeq();
	}

	@Override
	public int getPatientAddressSeq() {
		return sequenceMapper.getPatientAddressSeq();
	}
}
