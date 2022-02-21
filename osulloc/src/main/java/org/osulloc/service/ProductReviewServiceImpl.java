package org.osulloc.service;

import java.util.ArrayList;

import org.osulloc.domain.AttachFileDTO;
import org.osulloc.domain.Criteria;
import org.osulloc.domain.ProductDTO;
import org.osulloc.domain.ProductReviewDTO;
import org.osulloc.mapper.AttachMapper;
import org.osulloc.mapper.ProductReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductReviewServiceImpl implements ProductReviewService{
	@Autowired
	private ProductReviewMapper pmapper;
//	@Autowired
//	private AttachMapper amapper;
	
	//�Խ��� �۾��� ����� �� ����
	
//	@Transactional
	public void write(ProductReviewDTO review) {
		pmapper.insertSelectKey(review);
//		review.getAttachList().forEach(attach->{
//			attach.setBno(review.getBno());
//			amapper.insert(attach);
//		});
	}
	
	//���� ��ϸ���Ʈ ����� �� ����
/*	public ArrayList<ProductReviewDTO> productreview(ProductReviewDTO review) {
		return pmapper.productreview(review);
	}*/
	
	//���� ��ϸ���Ʈ ����¡ ����� �� ����
	public ArrayList<ProductReviewDTO> productcri(Criteria cri) {
		
		System.out.println(pmapper.productcri(cri));
		return pmapper.productcri(cri);
	}
	
	//���� ����¡�� ���� �����ͰǼ�
	public int getTotalCount(Criteria cri) {
		return pmapper.getTotalCount(cri);
	}
	
//	//�Խ��� ���������� ���Ͼ��ε�� �̹��� ����ϴ� ���� ����
//	public ArrayList<AttachFileDTO> fileList(int bno){
//		return amapper.fileList(bno);
//	}
	
	
}
