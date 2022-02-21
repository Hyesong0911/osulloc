package org.osulloc.service;

import java.util.ArrayList;

import org.osulloc.domain.AttachFileDTO;
import org.osulloc.domain.Criteria;
import org.osulloc.domain.ProductDTO;
import org.osulloc.domain.ProductReviewDTO;

public interface ProductReviewService {

	//���� �۾���
	public void write(ProductReviewDTO review);
	
	//���� ��ϸ���Ʈ
/*	public ArrayList<ProductReviewDTO> productreview(ProductReviewDTO pror);
*/		
	//���� ��ϸ���Ʈ ����¡
	public ArrayList<ProductReviewDTO> productcri(Criteria cri);
	
	//���� ����¡�� ���� �����ͰǼ�
	public int getTotalCount(Criteria cri);
	
//	//�Խ��� ������������ ���Ͼ��ε�� �̹��� ���
//	public ArrayList<AttachFileDTO> fileList(int bno);
	
	
}
