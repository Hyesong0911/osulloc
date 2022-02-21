package org.osulloc.mapper;

import java.util.ArrayList;

import org.osulloc.domain.ReplyReviewDTO;

public interface ReplyReviewMapper {
	//��� ���� ����
		//insert ������ ReplyMapper.xml�� ���� 1,
		//insert ���н� ReplyMapper.xml�� ���� 0
		//���� ���Ϲ޴´�.
		public int write(ReplyReviewDTO rdto);
		
		//��� ��� ����Ʈ ����
		public ArrayList<ReplyReviewDTO> list(int pno);
		
		//��� ������ �ϱ� ���� ��� ������ �������¼���
		public ReplyReviewDTO detail(int rno);
		
		//��� ���� ����
		//update ������ ReplyMapper.xml�� ���� 1,
		//update ���н� ReplyMapper.xml�� ���� 0
		public int update(ReplyReviewDTO rdto);
		
		//��� ���� ����
		//remove ������ ReplyMapper.xml�� ���� 1,
		//remove ���н� ReplyMapper.xml�� ���� 0
		public int remove(ReplyReviewDTO rdto);
}
