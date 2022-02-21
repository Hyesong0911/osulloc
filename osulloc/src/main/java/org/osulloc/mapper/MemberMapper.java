package org.osulloc.mapper;

import org.osulloc.domain.MemberDTO;

public interface MemberMapper {

	//占쎌돳占쎌뜚揶쏉옙占쎌뿯 占쎄퐬�⑨옙
	public void insert(MemberDTO mdto);
	//嚥≪뮄�젃占쎌뵥 占쎄퐬�⑨옙
	public MemberDTO login(MemberDTO mdto);
}
