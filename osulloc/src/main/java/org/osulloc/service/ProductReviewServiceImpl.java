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
	
	//게시판 글쓰기 설계된 것 구현
	
//	@Transactional
	public void write(ProductReviewDTO review) {
		pmapper.insertSelectKey(review);
//		review.getAttachList().forEach(attach->{
//			attach.setBno(review.getBno());
//			amapper.insert(attach);
//		});
	}
	
	//리뷰 목록리스트 설계된 것 구현
/*	public ArrayList<ProductReviewDTO> productreview(ProductReviewDTO review) {
		return pmapper.productreview(review);
	}*/
	
	//리뷰 목록리스트 페이징 설계된 것 구현
	public ArrayList<ProductReviewDTO> productcri(Criteria cri) {
		
		System.out.println(pmapper.productcri(cri));
		return pmapper.productcri(cri);
	}
	
	//리뷰 페이징에 쓰일 데이터건수
	public int getTotalCount(Criteria cri) {
		return pmapper.getTotalCount(cri);
	}
	
//	//게시판 상세페이지에 파일업로드된 이미지 출력하는 것을 구현
//	public ArrayList<AttachFileDTO> fileList(int bno){
//		return amapper.fileList(bno);
//	}
	
	
}
