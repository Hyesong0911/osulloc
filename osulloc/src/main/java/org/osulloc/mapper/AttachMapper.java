package org.osulloc.mapper;

import java.util.ArrayList;

import org.osulloc.domain.AttachFileDTO;

public interface AttachMapper {
	//게시판 글쓰기 할 때 파일과 관련되어 있는 attach테이블이 insert
	public void insert(AttachFileDTO board);
	
	
	public void delete(AttachFileDTO aboard);
	/*public void ainsert(AttachFileDTO aboard);*/
	
	//게시판 상세페이지에 업로드된 이미지를 뿌리기위한 데이터list
	public ArrayList<AttachFileDTO> fileList(int bno);//넘기는 방법에 따라 fileList안의 내용이 달라짐
	public void modify(AttachFileDTO board);
	
	public ArrayList<AttachFileDTO> fileListPost(int bno);
	
	public boolean fileDelete(AttachFileDTO attach);

}
