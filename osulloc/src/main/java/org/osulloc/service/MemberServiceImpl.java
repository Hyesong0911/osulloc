package org.osulloc.service;

import org.osulloc.domain.MemberDTO;
import org.osulloc.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl  implements MemberService{
	//�쉶�썝媛��엯 �븯湲�  �꽕怨꾨맂 寃껋쓣 援ы쁽 
	@Autowired
	private MemberMapper mmapper;
	public void insert(MemberDTO mdto) {
		
		mmapper.insert(mdto);
	}
	// 濡쒓렇�씤 �꽕怨꾨맂寃껋쓣 援ы쁽 
	
	public MemberDTO login(MemberDTO mdto) {
		
		return mmapper.login(mdto);
		}
	}
	

