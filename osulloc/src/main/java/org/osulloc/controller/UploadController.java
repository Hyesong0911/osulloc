package org.osulloc.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.osulloc.domain.AttachFileDTO;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnailator;

@Controller
public class UploadController {
	@GetMapping("upload")//form占쎄묶域뱄옙
	public void uploadForm() {
		System.out.println("占쎈솁占쎌뵬 占쎈씜嚥≪뮆諭� 占쎌넅筌롳옙");
	}
	@GetMapping("uploadAjax")//div占쎄묶域뱄옙
	public void uploadAjaxForm() {
		System.out.println("占쎈솁占쎌뵬 占쎈씜嚥≪뮆諭� 占쎌넅筌롳옙");
	}
	//upload.jsp占쎈퓠占쎄퐣 form占쎄묶域밸챶占쏙옙 占쎌뵠占쎌뒠占쎈퉸占쎄퐣 占쎈솁占쎌뵬 占쎈씜嚥≪뮆諭�
	@PostMapping("uploadAction")
	public void uploadAction(MultipartFile[] uploadFile) {
		
		//占쎈솁占쎌뵬 占쎈씜嚥≪뮆諭띰옙釉� 野껋럥以� 筌욑옙占쎌젟
		String uploadFolder="C:\\upload";
		
		for(MultipartFile multipartFile : uploadFile) {//uploadFile獄쏄퀣肉댐옙肉� 癰귨옙占쎈땾�몴占� 占쎈릭占쎄돌 筌띾슢諭억옙堉� 揶쏅�れ뱽  multipartFile占쎈퓠 占쏙옙占쎌삢占쎈릭占쎈연 �빊�뮆�젾
			System.out.println("占쎈씜嚥≪뮆諭� 占쎈솁占쎌뵬 占쎌뵠�뵳占� = " + multipartFile.getOriginalFilename());//占쎄텢占쎌뒠占쎌쁽揶쏉옙 占쎈씜嚥≪뮆諭� 占쎈립 占쎈뼄占쎌젫 占쎈솁占쎌뵬 占쎌뵠�뵳占�
			System.out.println("占쎈씜嚥≪뮆諭� 占쎈솁占쎌뵬 占쎄쾿疫뀐옙 = " + multipartFile.getSize());//占쎄텢占쎌뒠占쎌쁽揶쏉옙 占쎈씜嚥≪뮆諭� 占쎈립 占쎈뼄占쎌젫 占쎈솁占쎌뵬 占쎄쾿疫뀐옙
			System.out.println("占쎈씜嚥≪뮆諭� 占쎈솁占쎌뵬 占쎌굨占쎈뻼 = " + multipartFile.getContentType());//占쎄텢占쎌뒠占쎌쁽揶쏉옙 占쎈씜嚥≪뮆諭� 占쎈립 占쎈뼄占쎌젫 占쎈솁占쎌뵬 占쎌굨占쎈뻼
			
			//File saveFile=new File();//File占쏙옙 疫꿸퀡�궚占쎄문占쎄쉐占쎌쁽揶쏉옙 占쎈씨疫뀐옙 占쎈르�눧紐꾨퓠 �몭占� 筌띲끆而삭퉪占쏙옙�땾�몴占� 占쎌삂占쎄쉐占쎈퉸占쎈튊 占쎈립占쎈뼄.
			//uploadFolder占쎈퓠 占쏙옙占쎌삢占쎈┷占쎈선 占쎌뿳占쎈뮉 野껋럥以덃에占� 占쎈뼄占쎌젫 占쎈솁占쎌뵬筌뤿굞�몵嚥∽옙 占쏙옙占쎌삢.
			//multipartFile.getOriginalFilename()占쎌뱽 uploadFolder野껋럥以덌옙肉� 占쏙옙占쎌삢
			File saveFile=new File(uploadFolder,multipartFile.getOriginalFilename());//占쎌뵠�뵳袁⑹뱽 占쏙옙占쎌삢占쎈퉸占쎈튊 占쎈릭疫뀐옙 占쎈르�눧紐꾨퓠
			
			try {
				multipartFile.transferTo(saveFile);//transferTo : 占쎈뼄占쎌젫嚥∽옙 筌욑옙占쎌젟占쎈립 占쎈쨨占쎈쐭占쎈퓠 占쎈씜嚥≪뮆諭띄몴占� 占쎈뻻�녹뮇竊쒙옙�뮉 占쎈열占쎌넞, 占쎌굙占쎌뇚筌ｌ꼶�봺 占쎈툡占쎈땾
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//end try
		}//for�눧占� end
	}
	
	//占쎈��/占쎌뜞/占쎌뵬 占쎈뼊占쎌맄占쎌벥 占쎈쨨占쎈쐭�몴占� 占쎄문占쎄쉐占쎈릭疫뀐옙 占쎌맄占쎈립 占쎌삂占쎈씜. 占쎈쨨占쎈쐭 占쎌뵠�뵳占� �빊遺욱뀱占쎈릭占쎈연 �뵳�뗪쉘
	private String getFolder() {
		//占쎌겱占쎌삺占쎄텊筌욎뮆占쏙옙 �빊遺욱뀱(占쎌뒄占쎌뵬 占쎌뜞 占쎌뵬 占쎈뻻:�겫占�:�룯占� KST 占쎈�덌옙猷�)
		Date date = new Date();//util//疫꿸퀡�궚占쎄문占쎄쉐占쎌쁽 占쎌깈�빊占�
		
		//->2020-01-18嚥∽옙 �빊�뮆�젾占쎈릭疫뀐옙(yyyy-mm-dd 占쎌굨占쎈뻼占쎌몵嚥∽옙 癰귨옙野껓옙(占쎈뻻揶쏉옙 �뜮�눊由�))
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//MM占쏙옙 占쏙옙�눧紐꾩쁽 占쎈툡占쎈땾 沃섎챶�뻺占쎈릭�⑨옙 �뤃�됲�롳옙釉�疫뀐옙 占쎌맄占쎈퉸
		
		//2020-01-18
		String str = sdf.format(date);
		System.out.println("date="+date);
		System.out.println(str.replace("-", File.separator));
		//str.replace("-", File.separator);
		
		//2020-01-18 -> 2022\01\18嚥∽옙 癰귨옙野껓옙
		return str.replace("-", File.separator);
	}
	
	//占쎈쑞占쎄퐬占쎌뵬 占쎌뵠沃섎챷占� 占쎄문占쎄쉐占쎌뱽 占쎈막 野껉퍔�뵥筌욑옙 占쎈툧 占쎈막 野껉퍔�뵥筌욑옙占쎈퓠 占쏙옙占쎈립 占쎈솇占쎈뼊占쎈릭占쎈뮉 筌롫뗄�꺖占쎈굡(占쎄텢占쎌뒠占쎌쁽揶쏉옙 占쎈씜嚥≪뮆諭� 占쎈립 占쎈솁占쎌뵬占쎌뵠 占쎌뵠沃섎챷占쏙옙�뵠筌롳옙 占쎄문占쎄쉐, 域밸챶�쟽筌욑옙 占쎈륫占쎌몵筌롳옙 占쎄문占쎄쉐 占쎈툧占쎈맙)
	private boolean checkImage(File file) {//占쎌뵠沃섎챷占쏙옙�뵥筌욑옙 占쎈툡占쎈빒筌욑옙 占쎌넇占쎌뵥占쎈릭疫뀐옙 占쎌맄占쎈퉸 筌띲끆而삭퉪占쏙옙�땾嚥∽옙 file占쎌뱽 獄쏆룇釉섓옙鍮� 占쎈맙  //占쎌굙占쎌뇚筌ｌ꼶�봺
		try {
			String contentType=Files.probeContentType(file.toPath());//占쎈솁占쎌뵬占쎌벥 占쏙옙占쎌뿯占쎌뱽 占쎈르占쎈툡占쎄땀占쎈뮉 probeContentType筌롫뗄�꺖占쎈굡 占쎌깈�빊�뮉釉�占쎈연 占쎄텢占쎌뒠
			return contentType.startsWith("image");//域뱄옙 占쎈솁占쎌뵬占쎌벥 占쏙옙占쎌뿯占쎌뵠 image占쎌뵠筌롳옙 true, 域밸챶�쟽筌욑옙 占쎈륫占쎌몵筌롳옙 false
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	//uploadAjax.js占쎈퓠占쎄퐣 ajax�몴占� 占쎌뵠占쎌뒠占쎈퉸占쎄퐣 占쎈솁占쎌뵬 占쎈씜嚥≪뮆諭� 占쎌뜎 controller占쎈염野껓옙
	@PostMapping(value="uploadAjaxAction",produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	//ajax�몴占� 占쎈꽰占쎈퉸占쎄퐣 占쎌깈�빊�뮉釉�筌롳옙 model占쎌뱽 占쎄텢占쎌뒠占쎈릭筌욑옙 占쎈륫�⑨옙 ResponseEntity�몴占� 占쎄텢占쎌뒠占쎈릭占쎈연 占쎌럲占쎈읂占쎌뵠筌욑옙嚥∽옙 return 占쎈뻻占쎄텚占쎈뼄.
	public ResponseEntity <ArrayList<AttachFileDTO>> uploadAjaxAction(MultipartFile[] uploadFile) {
		//AttachFileDTO占쎈퓠 占쏙옙占쎌삢占쎈┷占쎈뮉 揶쏅�れ뵠 占쎈연占쎌쑎占쎈솁占쎌뵬占쎈퓠 占쏙옙占쎈립 揶쏅�れ뵠筌롳옙 獄쏄퀣肉닸에占� 筌ｌ꼶�봺揶쏉옙 占쎈┷占쎈선占쎈튊 占쎈릭沃섓옙嚥∽옙 ArrayList占쏙옙占쎌뿯占쎌뵠 占쎈┷占쎈선占쎈튊 占쎈맙. 獄쏄퀣肉댐옙肉� 占쏙옙占쎌삢占쎈릭占쎈연 占쎈연占쎌쑎揶쏆뮄占� 占쎄돌占쎌궞 占쎈땾 占쎌뿳野껓옙 占쎈맙.
		ArrayList<AttachFileDTO> list = new ArrayList<>();
		
		//占쎈솁占쎌뵬 占쎈씜嚥≪뮆諭띰옙釉� 野껋럥以� 筌욑옙占쎌젟
		String uploadFolder="C:\\upload";//占쎄텊筌욎뮄占� 占쎈씨占쎈뮉 野껓옙
		
		//占쎈쨨占쎈쐭 占쎄문占쎄쉐                                     		(疫꿸퀣�� 占쎈쨨占쎈쐭, 占쎌겱占쎌삺 占쎈쨨占쎈쐭)占쎌맄燁살꼶占쏙옙 野껉퀬鍮�
		File uploadPath = new File(uploadFolder, getFolder());//占쎄텊筌욎뮄占� 占쎌뿳占쎈뮉 野껓옙 //占쎈뼄占쎌젫 占쎈씜嚥≪뮆諭� 野껋럥以�
		System.out.println("uploadAjaxAction osulloc uploadPath="+uploadPath);
		
		//占쎄텊筌욎뮆�뮉 �④쑴�꺗 獄쏅뗀占쎈슡由� 占쎈르�눧紐꾨퓠 占쎄텊筌욑옙 �겫占썽겫袁⑥춸 占쏙옙占쎌삢
		String uploadFolderPath=getFolder();
		
		//占쎌겱占쎌삺 筌띾슢諭억옙�젻�⑨옙 占쎈릭占쎈뮉 占쎈쨨占쎈쐭揶쏉옙 占쎈씨占쎌몵筌롳옙
		if(uploadPath.exists()==false) {//exists(), mkdirs() 占쎌뵥占쎈뮞占쎄쉘占쎈뮞 筌띲끉苑뚳옙諭�
			//占쎈쨨占쎈쐭 占쎄문占쎄쉐
			uploadPath.mkdirs();//mkdirs:Make directory=>占쎈쨨占쎈쐭�몴占� 筌띾슢諭븝옙�뼄
		}
		
		for(MultipartFile multipartFile : uploadFile) {//uploadFile獄쏄퀣肉댐옙肉� 癰귨옙占쎈땾�몴占� 占쎈릭占쎄돌 筌띾슢諭억옙堉� 揶쏅�れ뱽  multipartFile占쎈퓠 占쏙옙占쎌삢占쎈릭占쎈연 �빊�뮆�젾
			System.out.println("占쎈씜嚥≪뮆諭� 占쎈솁占쎌뵬 占쎌뵠�뵳占� = " + multipartFile.getOriginalFilename());//占쎄텢占쎌뒠占쎌쁽揶쏉옙 占쎈씜嚥≪뮆諭� 占쎈립 占쎈뼄占쎌젫 占쎈솁占쎌뵬 占쎌뵠�뵳占�
			System.out.println("占쎈씜嚥≪뮆諭� 占쎈솁占쎌뵬 占쎄쾿疫뀐옙 = " + multipartFile.getSize());//占쎄텢占쎌뒠占쎌쁽揶쏉옙 占쎈씜嚥≪뮆諭� 占쎈립 占쎈뼄占쎌젫 占쎈솁占쎌뵬 占쎄쾿疫뀐옙
			System.out.println("占쎈씜嚥≪뮆諭� 占쎈솁占쎌뵬 占쎌굨占쎈뻼 = " + multipartFile.getContentType());//占쎄텢占쎌뒠占쎌쁽揶쏉옙 占쎈씜嚥≪뮆諭� 占쎈립 占쎈뼄占쎌젫 占쎈솁占쎌뵬 占쎌굨占쎈뻼
			
			//UploadController占쎈퓠 占쎌뿳占쎈뮉 uploadAjaxAction筌롫뗄�꺖占쎈굡占쎈퓠占쎄퐣 AttachFileDTO�몴占� 占쎄텢占쎌뒠占쎈퉸占쎄퐣 揶쏅�れ뱽 占쏙옙占쎌삢占쎈퉸占쎈튊 占쎈쭆占쎈뮉占쎈쑓
			//占쎌뵠占쎌쑛 野껋럩�뒭 UploadController占쎈퓠 AttachFileDTO揶쏉옙 占쎈씨占쎌몵筌롳옙 占쎄텢占쎌뒠占쎌뱽 占쎈막 占쎈땾 占쎈씨占쎈뼄.
			//域밸챶�삋占쎄퐣 UploadController占쎈퓠 AttachFileDTO 占쎈７占쎈맙 占쎈뻻�녹뮇苑� 占쎄텢占쎌뒠占쎈릭占쎈연 揶쏅�れ뱽 占쏙옙占쎌삢占쎈맙.
			AttachFileDTO attachdto = new AttachFileDTO();//占쎈７占쎈맙�꽴占썸�⑨옙 占쎄텢占쎌뒠甕곤옙
			
			//占쎈뼄占쎌젫 占쎈솁占쎌뵬筌륅옙 占쏙옙占쎌삢
			String uploadFileName= multipartFile.getOriginalFilename();//揶쏉옙�⑤벏鍮먲옙鍮� 占쎈맙//uuid揶쏉옙 �뜮醫롮춭 占쎈씜嚥≪뮆諭띰옙留� 占쎈솁占쎌뵬 占쎌뵠�뵳占�
			
			//占쎈뼄占쎌젫 占쎈솁占쎌뵬筌륅옙(uploadFileName)占쎌뱽 AttachFileDTO占쎄깻占쎌삋占쎈뮞(attachdto)占쎈퓠 fileName占쎈퓠 占쏙옙占쎌삢(setFileName)
			attachdto.setFileName(uploadFileName);
			
			//餓λ쵎�궗占쎌뵠 占쎈┷筌욑옙 占쎈륫占쎈뮉 占쎌뿫占쎌벥占쎌벥 �눧紐꾩쁽占쎈였占쎌뱽 占쎄문占쎄쉐
			UUID uuid = UUID.randomUUID();//.randomUUID(); : 占쎄깻占쎌삋占쎈뮞 筌롫뗄苑뚳옙諭�
			
			//UUID+"_"+getOriginalFilename()占쎌벥 鈺곌퀬鍮�占쎌몵嚥∽옙 占쎈솁占쎌뵬筌뤿굞�뱽 uploadFileName占쎈퓠 占쏙옙占쎌삢
			uploadFileName=uuid.toString()+"_"+uploadFileName;
			
			//File saveFile=new File();//File占쏙옙 疫꿸퀡�궚占쎄문占쎄쉐占쎌쁽揶쏉옙 占쎈씨疫뀐옙 占쎈르�눧紐꾨퓠 �몭占� 筌띲끆而삭퉪占쏙옙�땾�몴占� 占쎌삂占쎄쉐占쎈퉸占쎈튊 占쎈립占쎈뼄.
			//uploadFolder占쎈퓠 占쏙옙占쎌삢占쎈┷占쎈선 占쎌뿳占쎈뮉 野껋럥以덃에占� 占쎈뼄占쎌젫 占쎈솁占쎌뵬筌뤿굞�몵嚥∽옙 占쏙옙占쎌삢.
			File saveFile=new File(uploadPath,uploadFileName);//占쎌뵠�뵳袁⑹뱽 占쏙옙占쎌삢占쎈퉸占쎈튊 占쎈릭疫뀐옙 占쎈르�눧紐꾨퓠
			
			try {
				//saveFile癰귨옙占쎈땾占쎈퓠 占쏙옙占쎌삢占쎈┷占쎈선 占쎌뿳占쎈뮉 占쎈쨨占쎈쐭筌뤿굞�몵嚥∽옙 占쎈솁占쎌뵬占쎌뱽 癰귣�沅∽옙�뵬.
				multipartFile.transferTo(saveFile);//transferTo : 占쎈뼄占쎌젫嚥∽옙 筌욑옙占쎌젟占쎈립 占쎈쨨占쎈쐭占쎈퓠 占쎈씜嚥≪뮆諭띄몴占� 占쎈뻻�녹뮇竊쒙옙�뮉 占쎈열占쎌넞, 占쎌굙占쎌뇚筌ｌ꼶�봺 占쎈툡占쎈땾
				
				//占쎈뼄占쎌젫 占쎈씜嚥≪뮆諭� 野껋럥以�(uploadFolderPath)占쎌뱽 AttachFileDTO占쎄깻占쎌삋占쎈뮞(attachdto)占쎈퓠 uploadPath占쎈퓠 占쏙옙占쎌삢(setUploadPath)
				attachdto.setUploadPath(uploadFolderPath); //try�눧占� 占쎈툧占쎈퓠 占쎈씨占쎈선占쎈즲 占쎈쭆占쎈뼄. for�눧占� 占쎈툧占쎈퓠筌랃옙 占쎌뿳占쎌몵筌롳옙 占쎈쭆占쎈뼄.
				
				//uuid揶쏉옙(UUID)占쎌뱽 AttachFileDTO占쎄깻占쎌삋占쎈뮞(attachdto)占쎈퓠 uploadPath占쎈퓠 占쏙옙占쎌삢(setUuid)
				attachdto.setUuid(uuid.toString()); //try�눧占� 占쎈툧占쎈퓠 占쎈씨占쎈선占쎈즲 占쎈쭆占쎈뼄. for�눧占� 占쎈툧占쎈퓠筌랃옙 占쎌뿳占쎌몵筌롳옙 占쎈쭆占쎈뼄. //uuid占쎈뮉 占쎄깻占쎌삋占쎈뮞占쏙옙占쎌뿯占쎌뵠沃섓옙嚥∽옙 �눧紐꾩쁽嚥∽옙 獄쏅떽�벊餓μ꼷鍮� 占쎈립占쎈뼄.
				
				if(checkImage(saveFile)) {//占쎌뵠沃섎챷占� 占쎈솁占쎌뵬占쎌뵠筌롳옙
					//FileType揶쏉옙(image)占쎌뱽 AttachFileDTO占쎄깻占쎌삋占쎈뮞(attachdto)占쎈퓠 uploadPath占쎈퓠 占쏙옙占쎌삢(setImage)
					attachdto.setImage(true); //try�눧占� 占쎈툧占쎈퓠 占쎈씨占쎈선占쎈즲 占쎈쭆占쎈뼄. for�눧占� 占쎈툧占쎈퓠筌랃옙 占쎌뿳占쎌몵筌롳옙 占쎈쭆占쎈뼄.
					
					//占쎈쑞占쎄퐬占쎌뵬占쎌뱽 占쎈솁占쎌뵬占쎌뱽 占쎄문占쎄쉐占쎈릭疫뀐옙 占쎌읈占쎈퓠 占쎈쑞占쎄퐬占쎌뵬 占쎈솁占쎌뵬 占쎌뵠�뵳袁⑹뱽 �빊遺욱뀱
					FileOutputStream thumnail = new FileOutputStream(new File(uploadPath,"s_"+uploadFileName));//FileOutput 占쎈솁占쎌뵬占쎌뱽 獄쏅쉼�몵嚥∽옙 �삸A占쎈뼄
					
					//占쎈쑞占쎄퐬占쎌뵬占쎌뱽 占쎈솁占쎌뵬占쎌뱽 占쎄문占쎄쉐占쎈맙
					Thumbnailator.createThumbnail(multipartFile.getInputStream(),thumnail, 200, 200);
					thumnail.close();//占쎈쑞占쎄퐬占쎌뵬 �넫�굝利�(筌롫뗀�걟�뵳占� �⑤벀而� 占쎈맙占쎈땾)
				}
				
				list.add(attachdto);//add : 揶쏅�れ뱽 占쎄퐫占쎌뱽 占쎈르 占쎄텢占쎌뒠占쎈릭占쎈뮉 筌롫뗄苑뚳옙諭� 
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//end try
		}//for�눧占� end
		//占쎈꽰占쎈뻿占쎄맒占쎄묶揶쏉옙 占쎌젟占쎄맒占쎌읅(HttpStatus.OK)占쎌뵠筌롳옙 ArrayList(list)占쎈퓠 占쏙옙占쎌삢占쎈┷占쎈선 占쎌뿳占쎈뮉 揶쏅�れ뱽 占쎌럲�뇡�슢�뵬占쎌뒭占쏙옙(uploadAjax.js占쎈퓠 占쎌뿳占쎈뮉 ajax占쎈퓠 success)占쎈퓠 癰귣�沅∽옙�뵬
		return new ResponseEntity<>(list,HttpStatus.OK);//list占쎈뮉 uploadAjax.js占쎌벥 ajax占쎈퓠 result嚥∽옙 占쎄퐜占쎈선揶쏄쑬�뼄.
	}
	
	//占쎈솁占쎌뵬 占쎈씜嚥≪뮆諭띰옙釉� 占쎈솁占쎌뵬占쏙옙占쎌뿯占쎌뵠 占쎌뵠沃섎챷占쏙옙�뵬 占쎈르 占쎌럲�뇡�슢�뵬占쎌뒭占쏙옙占쎈퓠 占쎌뵠沃섎챷占썹몴占� 占쎌뱽占쎌뒭疫뀐옙 占쎌맄占쎈퉸
	@GetMapping("display")
	public ResponseEntity<byte[]> getFile(String fileName) {//getfile()占쏙옙 �눧紐꾩쁽占쎈였嚥∽옙 占쎈솁占쎌뵬占쎌벥 野껋럥以덂첎占� 占쎈７占쎈맙占쎈쭆 fileName占쎌뱽 筌띲끆而삭퉪占쏙옙�땾 獄쏆룄�� byte[](占쎌뵠筌욊쑴�땾)�몴占� 占쎌읈占쎈꽊
		System.out.println("url雅뚯눘�꺖�몴占� 占쎈꽰占쎈립 fileName="+fileName);
		
		File file = new File("C:\\upload\\"+fileName);
		System.out.println("file="+file);
		ResponseEntity<byte[]> result = null;
		//byte[]嚥∽옙 占쎌뵠沃섎챷占� 占쎈솁占쎌뵬占쎌벥 占쎈쑓占쎌뵠占쎄숲�몴占� 占쎌읈占쎈꽊占쎈막 占쎈르 �뇡�슢�뵬占쎌뒭占쏙옙占쎈퓠 癰귣�沅∽옙�뮉 MIME占쏙옙占쎌뿯占쎌뵠 占쎈솁占쎌뵬占쎌벥 �넫�굝履�(jpg, png, xls, ppt...)占쎈퓠 占쎈뎡占쎌뵬占쎄퐣 占쎈뼎占쎌뵬筌욊쑬�뼄.
		//占쎌뵠 �겫占썽겫袁⑹뱽 占쎈퉸野껉퀬釉�疫뀐옙 占쎌맄占쎈퉸占쎄퐣 probeContentType()占쎌뱽 占쎌뵠占쎌뒠占쎈퉸占쎄퐣 MIME占쏙옙占쎌뿯 占쎈쑓占쎌뵠占쎄숲�몴占� Http占쎌벥 占쎈엘占쎈쐭 筌롫뗄苑�筌욑옙占쎈퓠 占쎈７占쎈맙占쎈막 占쎈땾 占쎌뿳占쎈즲嚥∽옙 筌ｌ꼶�봺
		try {
			HttpHeaders header = new HttpHeaders();
			result=new ResponseEntity<>(FileCopyUtils.copyToByteArray(file),header,HttpStatus.OK);
		} catch (IOException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	//占쎈솁占쎌뵬 占쎈씜嚥≪뮆諭띰옙釉� 占쎈솁占쎌뵬占쏙옙占쎌뿯占쎌뵠 占쎌뵠沃섎챷占썲첎占� 占쎈툡占쎈빜占쎈르(.txt, .xls, .ppt) 占쎌럲�뇡�슢�뵬占쎌뒭占쏙옙�몴占� 占쎈꽰占쎈퉸占쎄퐣 download占쎈막 占쎈땾 占쎌뿳占쎈즲嚥∽옙 占쎈립占쎈뼄.
	//consumes : 占쎈굶占쎈선占쎌궎占쎈뮉 占쎈쑓占쎌뵠占쎄숲 占쏙옙占쎌뿯 占쎌젟占쎌벥(占쎄문占쎌셽揶쏉옙占쎈뮟) //produces : 獄쏆꼹�넎占쎈릭占쎈뮉 占쎈쑓占쎌뵠占쎄숲 占쏙옙占쎌뿯 占쎌젟占쎌벥(占쎄문占쎌셽揶쏉옙占쎈뮟)//*占쎄문占쎌셽占쎌뱽 占쎈릭野껓옙 占쎈┷筌롳옙, 占쎌럲�뇡�슢�뵬占쎌뒭占쏙옙揶쏉옙 占쎈르占쎈툡占쎄퐣 占쏙옙占쎌뿯占쎌뱽 占쎈솇占쎈뼊(占쎄땀揶쏉옙 占쎌뜚占쎈릭占쎈뮉 占쏙옙占쎌뿯占쎌뵠 占쎈툡占쎈빜 占쎈땾占쎈즲 占쎌뿳占쎌벉)*
	//占쎌럲�뇡�슢�뵬占쎌뒭占쏙옙揶쏉옙 '占쎌뵠 占쎈솁占쎌뵬占쏙옙 download占쎈퉸占쎈튊 占쎈릭占쎈뮉 占쎈솁占쎌뵬占쎌뿯占쎈빍占쎈뼄.' 占쎌뵬占쎈뮉 野껉퍔�뱽 占쎌뵥筌욑옙占쎈막 占쎈땾 占쎌뿳占쎈즲嚥∽옙 獄쏆꼹�넎占쎌뵠 占쎈┷占쎈선占쎈튊 占쎈립占쎈뼄. 域밸챶�쑎疫뀐옙 占쎌맄占쎈퉸占쎄퐣占쎈뮉 MediaType.APPLICATION_OCTET_STREAM_VALUE 占쏙옙占쎌뿯占쎌몵嚥∽옙 獄쏆꼹�넎占쎈쑓占쎌뵠占쎄숲 占쏙옙占쎌뿯占쎌뱽 占쎄퐨占쎈섧占쎈립占쎈뼄.
	@GetMapping(value="download",produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<Resource> downloadFile(String fileName){//Resource core嚥∽옙 import
		System.out.println("download fileName="+fileName);
		
		Resource resource = new FileSystemResource("C:\\upload\\"+fileName);
		System.out.println("download resource="+resource);
		
		String resourceName = resource.getFilename();
		HttpHeaders header = new HttpHeaders();
		try {
			header.add("Content-Disposition", "attachment; filename="+new String(resourceName.getBytes("UTF-8"),"ISO-8859-1"));
		} catch (IOException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<Resource>(resource,header,HttpStatus.OK);
	}
}