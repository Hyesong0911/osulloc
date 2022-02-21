package org.osulloc.service;

import org.osulloc.domain.MemberDTO;

public interface MemberService {
	
	//�쉶�썝媛��엯 �븯湲� �꽕怨�
		public void insert(MemberDTO mdto);
		
		
		//濡쒓렇�씤 �꽕怨�
		public MemberDTO login(MemberDTO mdto);
		
}
