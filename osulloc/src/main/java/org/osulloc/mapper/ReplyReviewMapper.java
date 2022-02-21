package org.osulloc.mapper;

import java.util.ArrayList;

import org.osulloc.domain.ReplyReviewDTO;

public interface ReplyReviewMapper {
	//댓글 쓰기 설계
		//insert 성공시 ReplyMapper.xml로 부터 1,
		//insert 실패시 ReplyMapper.xml로 부터 0
		//값을 리턴받는다.
		public int write(ReplyReviewDTO rdto);
		
		//댓글 목록 리스트 설계
		public ArrayList<ReplyReviewDTO> list(int pno);
		
		//댓글 수정을 하기 위해 댓글 내용을 가져오는설계
		public ReplyReviewDTO detail(int rno);
		
		//댓글 수정 설계
		//update 성공시 ReplyMapper.xml로 부터 1,
		//update 실패시 ReplyMapper.xml로 부터 0
		public int update(ReplyReviewDTO rdto);
		
		//댓글 삭제 설계
		//remove 성공시 ReplyMapper.xml로 부터 1,
		//remove 실패시 ReplyMapper.xml로 부터 0
		public int remove(ReplyReviewDTO rdto);
}
