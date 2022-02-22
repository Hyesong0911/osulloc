
package org.osulloc.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


import org.osulloc.domain.ProductDTO;
import org.osulloc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnailator;

@Controller
@RequestMapping("page")

public class ProductController {

	
	
	@Autowired
	private ProductService productService;
	
	 
/*	@GetMapping("merchandise")
	public void merchandise() {
	
	System.out.println("占쎈쐻占쎈짗占쎌굲占쎈�뱄옙�쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻�뜝占�");
	
	
	}	  
	*/
	
	
	
	
	
	
	// post 占쎈쐻占쎈짗占쎌굲占쎈쐻�뜝占�
	/*
	@PostMapping("uploadActionForm")
	public void uploadActionPost(MultipartFile[] uploadFile, Model model) {
		String uploadFolder ="C:\\upload";
		
		
		
		
		
		for(MultipartFile multipartFile : uploadFile) {
			System.out.println("--------------------------------");
			System.out.println("Upload File Name: " +multipartFile.getOriginalFilename());
			System.out.println("Upload File Size: " +multipartFile.getSize());
			
			File saveFile = new File(uploadFolder,multipartFile.getOriginalFilename());
		
			
			try {
				multipartFile.transferTo(saveFile);
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	*/
	
	
	////////////////////////////
	
	
	
	@PostMapping("product")
	public void addProduct(ProductDTO product) {
		
		System.out.println("controller="+product);
 
		
		
	}
	

	// ajax get(�솕�뜝�룞�삕)
	@GetMapping("product")
	public void product() {
	
	System.out.println("占쎄맒占쎈�뱄옙踰묉에占� 占쎈읂占쎌뵠筌욑옙 ");
	
	
	}	
	
	
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈짗占쎌굲筌욎뭿�쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲
		
		Date date = new Date();  // 占쎈쐻占쎈뻿�ⓦ끉�굲占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲, 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈쑟占쎄텊筌욎뭿�쐻占쎈짗占쎌굲 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈뻻�ⓦ끉�굲
		
	    String str=sdf.format(date);   //占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈쑟占쎄텊筌욎뭿�쐻占쎈짗占쎌굲 占쎈쐻占쎈쑆占쎈즲4占쎈쐻占쎈솓筌뤿슣�굲 占쎈쐻占쎈짗占쎌굲2占쎈쐻占쎈솓筌뤿슣�굲 占쎈쐻占쎈짗占쎌굲2占쎈쐻占쎈솓筌뤿슣�굲 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 str占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲
	    
	    return str.replace("-", File.separator);
	    // replace 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈솓占쎌뒻占쎌굲 燁살꼹�넎 占쎈쐻占쎈솭占쎈닰占쎌굲占쎈쐻占쎈짗占쎌굲   File.separator : \ /  占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈짗占쎌굲�뇾癒⑤쐻�뜝占� 占쎈쐻占쎈뼦筌뤿슣�굲占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈솂占쎈솇占쎌굲 占쎈쐻占쎈솭占쎈꺖占쎈쿈占쎌굲
	
	}
	
		// 占쎈쐻占쎈뼓獄�袁⑹굲占쎈쐻占쎈짗占쎌굲 占쏙옙占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈뼄占쎈솇占쎌굲  
	
		private boolean checkImageType(File file) {
			try {
			//  probeContentType :占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻�뜝占� 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 占쏙옙占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈뼑占쎈툡占쎈꺋占쎌굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈솭占쎈닰占쎌굲占쎈쐻占쎈짗占쎌굲
				String contentType = Files.probeContentType(file.toPath());  
				return contentType.startsWith("image");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
		}
	
	
	
	
		
		// ajax post (占쎌넅占쎈쐻占쎈짗占쎌굲)
	@PostMapping(value="productAjaxAction",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<ProductDTO>> uploadAjaxPost(MultipartFile[] uploadFile) {
		
		
		
		
		System.out.println("aaa="+uploadFile);
		
		
		List<ProductDTO>list = new ArrayList<>();
		
		String uploadFolder="C:\\Users\\GreenArt\\Desktop\\upload";
		
		
				// make Folder......
		
				String uploadFolderPath = getFolder();
				
				File uploadPath = new File(uploadFolder, getFolder());
				
				if(uploadPath.exists()==false) {
					// exists 占쎈쐻占쎈솭占쎈닰占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻�뜝占� 占쎈쐻占쎈솋占쎈솇占쎌굲 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈솂占쎈솇占쎌굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈뼢筌뤿슣�굲 占쎈쐻占쎈뼄占쎈솇占쎌굲占쎈쐻占쎈뼣占쎈솇占쎌굲 占쎈쐻占쎈솭占쎈꺖占쎈쿈占쎌굲(true/false)
					uploadPath.mkdirs();  // yyyy/MM/dd 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲
					
				}
				System.out.println("upload path: " + uploadPath);
				
				
				
				
				System.out.println("--------------------------------");
		for (MultipartFile multipartFile : uploadFile) {
			ProductDTO ProductDTO = new ProductDTO();
			System.out.println("Upload File Name: " +multipartFile.getOriginalFilename());
			System.out.println("Upload File Size: " +multipartFile.getSize());
			System.out.println("占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈뼢占쎈쿈占쎌굲 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 = " + multipartFile.getContentType());//占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲耶껓옙占쎈쐻�뜝占� 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈뼢占쎈쿈占쎌굲 占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲
			
			String uploadFileName = multipartFile.getOriginalFilename();
			
			/*// IE
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);*/
			ProductDTO.setFilename(uploadFileName);
			
			
			//uuid 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲
			UUID uuid = UUID.randomUUID();
		
			uploadFileName = uuid.toString() + "_" + uploadFileName;
			
			// 占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲
			
			//File saveFile = new File(uploadFolder,multipartFile.getOriginalFilename());
			/*File saveFile = new File(uploadPath,uploadFileName);*/
			
			try {
				File saveFile = new File(uploadPath,uploadFileName);
				multipartFile.transferTo(saveFile);
				System.out.println("saveFile=" +saveFile);
			
				
				System.out.println("uploadPath=" +uploadPath);
				
				System.out.println("uploadFolderPath=" +uploadFolderPath);
				
				
				ProductDTO.setUploadpath(uploadFolderPath);
				ProductDTO.setUuid(uuid.toString());
				//check image type file 
				
				if(checkImageType(saveFile)) {
					
					ProductDTO.setImage(true);
					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath,"s_"+uploadFileName));
					Thumbnailator.createThumbnail(multipartFile.getInputStream(),thumbnail,100,100);
					// 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈뼓獄�袁⑹굲占쎈쐻占쎈짗占쎌굲 占쎄쾿占쎈쐻占쎈쑆�몴占� 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲100 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 100占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 
					
					thumbnail.close(); 
				}
				
				list.add(ProductDTO);
				
				
				
			}catch (Exception e) {
				 System.out.println(e.getMessage());
			}
		}// end for
		return new ResponseEntity<>(list,HttpStatus.OK);
	}  //uploadAjaxPost
	
	
	
	
	
	

	@GetMapping("display")
	public ResponseEntity<byte[]> getFile(String fileName){
		System.out.println("fileName= " +fileName);
		File file = new File("C:\\Users\\GreenArt\\Desktop\\upload\\"+fileName);
		System.out.println("file:" + file);
		
		ResponseEntity<byte[]> result=null;
		try {
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file),header,HttpStatus.OK);
		}catch(IOException e){
			e.printStackTrace();
		}
		return result;
	 
	}
		
}