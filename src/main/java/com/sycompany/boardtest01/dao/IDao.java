package com.sycompany.boardtest01.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.sycompany.boardtest01.dto.MemberDto;

@Mapper
public interface IDao {
	
	public void memberJoin(String mid, String mpw, String mname, String memail);
	public ArrayList<MemberDto> memberList();  //DB에 저장된 모든 값 리스트타입으로 받아오기
	public MemberDto searchIdOk(String mid);
	
}
