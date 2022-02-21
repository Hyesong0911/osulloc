package org.osulloc.service;

import java.util.ArrayList;

import org.osulloc.domain.ReplyDTO;

public interface ReplyService {
	//��� ���� ����
	public int write(ReplyDTO rdto);
	//��� ��� ����Ʈ ����
	public ArrayList<ReplyDTO> list(int bno);
	//��� ������ �ϱ� ���� ��� ������ �������¼���
	public ReplyDTO detail(int rno);
	//��� ���� ����
	public int update(ReplyDTO rdto);
	//��� ���� ����
	public int remove(ReplyDTO rdto);
}
