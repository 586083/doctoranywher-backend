package com.doctoranywhere.doctoranywhere.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SequenceMapper {
	
	public int getPatientSeq();
	public int getPatientAddressSeq();
}
