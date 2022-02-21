package org.osulloc.controller;

import java.util.ArrayList;

import org.osulloc.domain.AttachFileDTO;
import org.osulloc.domain.BoardDTO;
import org.osulloc.domain.Criteria;
import org.osulloc.domain.PageDTO;
import org.osulloc.domain.PrevNextDTO;
import org.osulloc.service.BoardService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("page")
public class BoardController {
	@Autowired
	private BoardService service;
	
	//�۾��� ȭ������
	@GetMapping("write")
	public void write() {}
	
	//�۾��� ��ư�� Ŭ���ϸ�
	@PostMapping("write")
	public String writePost(BoardDTO board) {
		
		service.write(board);
		
		return "redirect:/page/detail?bno="+board.getBno();
	}
	
	@GetMapping("noticeBoard")
	public void noticeBoard(Model model, Criteria cri) {
		
		
		model.addAttribute("list", service.noticeBoard(cri));

		
		int total = service.getTotalCount(cri);
		model.addAttribute("pageMaker", new PageDTO(cri, service.getTotalCount(cri)));
	}
/*	
	@PostMapping("noticeBoardPost")
	public void noticeBoardPost(Model model, Criteria cri) {
		model.addAttribute("list", service.noticeBoard(cri));
		int total = service.getTotalCount(cri);
		model.addAttribute("pageMaker", new PageDTO(cri, service.getTotalCount(cri)));
	}*/
	
	//�Խ��� ��� ����Ʈ���� ������ Ŭ���ϸ�
	@GetMapping("detail")
	public void detail(BoardDTO board, Model model, PrevNextDTO pnBoard) {
		model.addAttribute("detail", service.detail(board));		
		model.addAttribute("detail2", service.detail2(pnBoard));
		
	}
	
	//�Խ��� ������������ �̹����� ����ϱ� ���� select�� ����� javascript��
	@GetMapping(value="/fileList/{bno}",produces= MediaType.APPLICATION_JSON_UTF8_VALUE)//ajax
	public ResponseEntity<ArrayList<AttachFileDTO>> fileList(@PathVariable int bno){
		//System.out.println("fileList");
		System.out.println(service.fileList(bno));
		
		return new ResponseEntity<>(service.fileList(bno),HttpStatus.OK);
		
	}
	
	/*@PostMapping(value="/fileList/{bno}",produces= MediaType.APPLICATION_JSON_UTF8_VALUE)//ajax
	public ResponseEntity<ArrayList<AttachFileDTO>> fileListPost(@PathVariable int bno){
		//System.out.println("fileList");
		System.out.println(service.fileListPost(bno));
		
		return new ResponseEntity<>(service.fileListPost(bno),HttpStatus.OK);
		
	}*/
	
	@PostMapping(value="/fileList/{bno}",produces= MediaType.APPLICATION_JSON_UTF8_VALUE)//ajax
	public ResponseEntity<ArrayList<AttachFileDTO>> fileListPost(@PathVariable int bno){
		//System.out.println("fileList");
		System.out.println(service.fileListPost(bno));
		
		return new ResponseEntity<>(service.fileListPost(bno),HttpStatus.OK);
		
	}
	
	//�� ���� ȭ������
	@GetMapping("modify")
	public void modify(BoardDTO board, Model model) {
		model.addAttribute("detail", service.detail(board));
	}
	
	//�ۼ��� ��ư�� Ŭ���ϸ�
	@PostMapping("modify")
	public void modifyPost(AttachFileDTO aboard, BoardDTO board, RedirectAttributes rttr) {
		service.delete(aboard);
		/*service.ainsert(aboard);*/
		
		rttr.addAttribute("bno", board.getBno());
		//return "redirect:/page/detail";
	}
	
	//�ۻ��� ��ư�� Ŭ���ϸ�
	@GetMapping("remove")
	public String remove(BoardDTO board) {
		//delete
		service.remove(board);
		return "redirect:/page/noticeBoard";
	}
	
/*	@GetMapping("cartPage")
	public void cartPage() {
		System.out.println("cartPage.jsp");


	}*/
	


	
	
}
