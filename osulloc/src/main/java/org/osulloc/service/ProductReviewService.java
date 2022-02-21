package org.osulloc.service;

import java.util.ArrayList;

import org.osulloc.domain.AttachFileDTO;
import org.osulloc.domain.Criteria;
import org.osulloc.domain.ProductDTO;
import org.osulloc.domain.ProductReviewDTO;

public interface ProductReviewService {

	//리뷰 글쓰기
	public void write(ProductReviewDTO review);
	
	//리뷰 목록리스트
/*	public ArrayList<ProductReviewDTO> productreview(ProductReviewDTO pror);
*/		
	//리뷰 목록리스트 페이징
	public ArrayList<ProductReviewDTO> productcri(Criteria cri);
	
	//리뷰 페이징에 쓰일 데이터건수
	public int getTotalCount(Criteria cri);
	
//	//게시판 리뷰페이지에 파일업로드된 이미지 출력
//	public ArrayList<AttachFileDTO> fileList(int bno);
	
	
}
