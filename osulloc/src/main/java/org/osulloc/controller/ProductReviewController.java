package org.osulloc.controller;

import java.util.ArrayList;

import org.osulloc.domain.AttachFileDTO;
import org.osulloc.domain.Criteria;
import org.osulloc.domain.PageDTO;
import org.osulloc.domain.ProductDTO;
import org.osulloc.domain.ProductReviewDTO;
import org.osulloc.service.ProductReviewService;
import org.osulloc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class ProductReviewController {
	@Autowired
	private ProductReviewService pservice;
	
	@Autowired
	private ProductService service;

	//리뷰글쓰기 화면으로
	@GetMapping("reviewWrite")
	public void reviewWrite(Model model, ProductDTO prod) {
		model.addAttribute("productse", service.productse(prod));
	}
	
	//글쓰기 버튼을 클릭하면
	@PostMapping("reviewWrite")
	public String reviewWritePost(ProductReviewDTO review) {
		System.out.println("getprod1=" + review);
		System.out.println("getprod2=" + review.getProdnum());
		pservice.write(review);
		
		
		return "redirect:/page/detailProduct?prodnum="+review.getProdnum();
	}
	
	@GetMapping("detailProduct")
	public void detailProduct(Model model, Criteria cri, ProductReviewDTO review, ProductDTO prod) {
		

		System.out.println(prod);
		
		model.addAttribute("productse", service.productse(prod));

		
		//=========================================================
		
		//리뷰
		
/*		model.addAttribute("productreview", pservice.productreview(review));
		System.out.println(pservice.productreview(review));*/
		
		System.out.println("prodnum=" + pservice.productcri(cri));
		model.addAttribute("productcri", pservice.productcri(cri));
		System.out.println(pservice.productcri(cri));

		
		int total = pservice.getTotalCount(cri);
		model.addAttribute("pageMaker", new PageDTO(cri, pservice.getTotalCount(cri)));
	}
	
//	//게시판 상세페이지에서 이미지를 출력하기 위한 select된 결과를 javascript로
//	@GetMapping(value="/fileList/{bno}",produces= MediaType.APPLICATION_JSON_UTF8_VALUE)//ajax
//	public ResponseEntity<ArrayList<AttachFileDTO>> fileList(@PathVariable int bno){
//		//System.out.println("fileList");
//		return new ResponseEntity<>(pservice.fileList(bno),HttpStatus.OK);
//	}
	
	
}
