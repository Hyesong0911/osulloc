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
	@GetMapping("upload")//form�깭洹�
	public void uploadForm() {
		System.out.println("�뙆�씪 �뾽濡쒕뱶 �솕硫�");
	}
	@GetMapping("uploadAjax")//div�깭洹�
	public void uploadAjaxForm() {
		System.out.println("�뙆�씪 �뾽濡쒕뱶 �솕硫�");
	}
	//upload.jsp�뿉�꽌 form�깭洹몃�� �씠�슜�빐�꽌 �뙆�씪 �뾽濡쒕뱶
	@PostMapping("uploadAction")
	public void uploadAction(MultipartFile[] uploadFile) {
		
		//�뙆�씪 �뾽濡쒕뱶�븷 寃쎈줈 吏��젙
		String uploadFolder="C:\\upload";
		
		for(MultipartFile multipartFile : uploadFile) {//uploadFile諛곗뿴�뿉 蹂��닔瑜� �븯�굹 留뚮뱾�뼱 媛믪쓣  multipartFile�뿉 ���옣�븯�뿬 異쒕젰
			System.out.println("�뾽濡쒕뱶 �뙆�씪 �씠由� = " + multipartFile.getOriginalFilename());//�궗�슜�옄媛� �뾽濡쒕뱶 �븳 �떎�젣 �뙆�씪 �씠由�
			System.out.println("�뾽濡쒕뱶 �뙆�씪 �겕湲� = " + multipartFile.getSize());//�궗�슜�옄媛� �뾽濡쒕뱶 �븳 �떎�젣 �뙆�씪 �겕湲�
			System.out.println("�뾽濡쒕뱶 �뙆�씪 �삎�떇 = " + multipartFile.getContentType());//�궗�슜�옄媛� �뾽濡쒕뱶 �븳 �떎�젣 �뙆�씪 �삎�떇
			
			//File saveFile=new File();//File�� 湲곕낯�깮�꽦�옄媛� �뾾湲� �븣臾몄뿉 瑗� 留ㅺ컻蹂��닔瑜� �옉�꽦�빐�빞 �븳�떎.
			//uploadFolder�뿉 ���옣�릺�뼱 �엳�뒗 寃쎈줈濡� �떎�젣 �뙆�씪紐낆쑝濡� ���옣.
			//multipartFile.getOriginalFilename()�쓣 uploadFolder寃쎈줈�뿉 ���옣
			File saveFile=new File(uploadFolder,multipartFile.getOriginalFilename());//�씠由꾩쓣 ���옣�빐�빞 �븯湲� �븣臾몄뿉
			
			try {
				multipartFile.transferTo(saveFile);//transferTo : �떎�젣濡� 吏��젙�븳 �뤃�뜑�뿉 �뾽濡쒕뱶瑜� �떆耳쒖＜�뒗 �뿭�솢, �삁�쇅泥섎━ �븘�닔
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//end try
		}//for臾� end
	}
	
	//�뀈/�썡/�씪 �떒�쐞�쓽 �뤃�뜑瑜� �깮�꽦�븯湲� �쐞�븳 �옉�뾽. �뤃�뜑 �씠由� 異붿텧�븯�뿬 由ы꽩
	private String getFolder() {
		//�쁽�옱�궇吏쒕�� 異붿텧(�슂�씪 �썡 �씪 �떆:遺�:珥� KST �뀈�룄)
		Date date = new Date();//util//湲곕낯�깮�꽦�옄 �샇異�
		
		//->2020-01-18濡� 異쒕젰�븯湲�(yyyy-mm-dd �삎�떇�쑝濡� 蹂�寃�(�떆媛� 鍮쇨린))
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//MM�� ��臾몄옄 �븘�닔 誘몃떅�븯怨� 援щ퀎�븯湲� �쐞�빐
		
		//2020-01-18
		String str = sdf.format(date);
		System.out.println("date="+date);
		System.out.println(str.replace("-", File.separator));
		//str.replace("-", File.separator);
		
		//2020-01-18 -> 2022\01\18濡� 蹂�寃�
		return str.replace("-", File.separator);
	}
	
	//�뜽�꽕�씪 �씠誘몄� �깮�꽦�쓣 �븷 寃껋씤吏� �븞 �븷 寃껋씤吏��뿉 ���븳 �뙋�떒�븯�뒗 硫붿냼�뱶(�궗�슜�옄媛� �뾽濡쒕뱶 �븳 �뙆�씪�씠 �씠誘몄��씠硫� �깮�꽦, 洹몃젃吏� �븡�쑝硫� �깮�꽦 �븞�븿)
	private boolean checkImage(File file) {//�씠誘몄��씤吏� �븘�땶吏� �솗�씤�븯湲� �쐞�빐 留ㅺ컻蹂��닔濡� file�쓣 諛쏆븘�빞 �븿  //�삁�쇅泥섎━
		try {
			String contentType=Files.probeContentType(file.toPath());//�뙆�씪�쓽 ���엯�쓣 �븣�븘�궡�뒗 probeContentType硫붿냼�뱶 �샇異쒗븯�뿬 �궗�슜
			return contentType.startsWith("image");//洹� �뙆�씪�쓽 ���엯�씠 image�씠硫� true, 洹몃젃吏� �븡�쑝硫� false
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	//uploadAjax.js�뿉�꽌 ajax瑜� �씠�슜�빐�꽌 �뙆�씪 �뾽濡쒕뱶 �썑 controller�뿰寃�
	@PostMapping(value="uploadAjaxAction",produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	//ajax瑜� �넻�빐�꽌 �샇異쒗븯硫� model�쓣 �궗�슜�븯吏� �븡怨� ResponseEntity瑜� �궗�슜�븯�뿬 �쎒�럹�씠吏�濡� return �떆�궓�떎.
	public ResponseEntity <ArrayList<AttachFileDTO>> uploadAjaxAction(MultipartFile[] uploadFile) {
		//AttachFileDTO�뿉 ���옣�릺�뒗 媛믪씠 �뿬�윭�뙆�씪�뿉 ���븳 媛믪씠硫� 諛곗뿴濡� 泥섎━媛� �릺�뼱�빞 �븯誘�濡� ArrayList���엯�씠 �릺�뼱�빞 �븿. 諛곗뿴�뿉 ���옣�븯�뿬 �뿬�윭媛쒓� �굹�삱 �닔 �엳寃� �븿.
		ArrayList<AttachFileDTO> list = new ArrayList<>();
		
		//�뙆�씪 �뾽濡쒕뱶�븷 寃쎈줈 吏��젙
		String uploadFolder="C:\\upload";//�궇吏쒓� �뾾�뒗 寃�
		
		//�뤃�뜑 �깮�꽦                                     		(湲곗〈 �뤃�뜑, �쁽�옱 �뤃�뜑)�쐞移섎�� 寃고빀
		File uploadPath = new File(uploadFolder, getFolder());//�궇吏쒓� �엳�뒗 寃� //�떎�젣 �뾽濡쒕뱶 寃쎈줈
		System.out.println("uploadAjaxAction osulloc uploadPath="+uploadPath);
		
		//�궇吏쒕뒗 怨꾩냽 諛붾�뚭린 �븣臾몄뿉 �궇吏� 遺�遺꾨쭔 ���옣
		String uploadFolderPath=getFolder();
		
		//�쁽�옱 留뚮뱾�젮怨� �븯�뒗 �뤃�뜑媛� �뾾�쑝硫�
		if(uploadPath.exists()==false) {//exists(), mkdirs() �씤�뒪�꽩�뒪 留ㅼ꽌�뱶
			//�뤃�뜑 �깮�꽦
			uploadPath.mkdirs();//mkdirs:Make directory=>�뤃�뜑瑜� 留뚮뱺�떎
		}
		
		for(MultipartFile multipartFile : uploadFile) {//uploadFile諛곗뿴�뿉 蹂��닔瑜� �븯�굹 留뚮뱾�뼱 媛믪쓣  multipartFile�뿉 ���옣�븯�뿬 異쒕젰
			System.out.println("�뾽濡쒕뱶 �뙆�씪 �씠由� = " + multipartFile.getOriginalFilename());//�궗�슜�옄媛� �뾽濡쒕뱶 �븳 �떎�젣 �뙆�씪 �씠由�
			System.out.println("�뾽濡쒕뱶 �뙆�씪 �겕湲� = " + multipartFile.getSize());//�궗�슜�옄媛� �뾽濡쒕뱶 �븳 �떎�젣 �뙆�씪 �겕湲�
			System.out.println("�뾽濡쒕뱶 �뙆�씪 �삎�떇 = " + multipartFile.getContentType());//�궗�슜�옄媛� �뾽濡쒕뱶 �븳 �떎�젣 �뙆�씪 �삎�떇
			
			//UploadController�뿉 �엳�뒗 uploadAjaxAction硫붿냼�뱶�뿉�꽌 AttachFileDTO瑜� �궗�슜�빐�꽌 媛믪쓣 ���옣�빐�빞 �맂�뒗�뜲
			//�씠�윺 寃쎌슦 UploadController�뿉 AttachFileDTO媛� �뾾�쑝硫� �궗�슜�쓣 �븷 �닔 �뾾�떎.
			//洹몃옒�꽌 UploadController�뿉 AttachFileDTO �룷�븿 �떆耳쒖꽌 �궗�슜�븯�뿬 媛믪쓣 ���옣�븿.
			AttachFileDTO attachdto = new AttachFileDTO();//�룷�븿愿�怨� �궗�슜踰�
			
			//�떎�젣 �뙆�씪紐� ���옣
			String uploadFileName= multipartFile.getOriginalFilename();//媛�怨듯빐�빞 �븿//uuid媛� 鍮좎쭊 �뾽濡쒕뱶�맂 �뙆�씪 �씠由�
			
			//�떎�젣 �뙆�씪紐�(uploadFileName)�쓣 AttachFileDTO�겢�옒�뒪(attachdto)�뿉 fileName�뿉 ���옣(setFileName)
			attachdto.setFileName(uploadFileName);
			
			//以묐났�씠 �릺吏� �븡�뒗 �엫�쓽�쓽 臾몄옄�뿴�쓣 �깮�꽦
			UUID uuid = UUID.randomUUID();//.randomUUID(); : �겢�옒�뒪 硫붿꽌�뱶
			
			//UUID+"_"+getOriginalFilename()�쓽 議고빀�쑝濡� �뙆�씪紐낆쓣 uploadFileName�뿉 ���옣
			uploadFileName=uuid.toString()+"_"+uploadFileName;
			
			//File saveFile=new File();//File�� 湲곕낯�깮�꽦�옄媛� �뾾湲� �븣臾몄뿉 瑗� 留ㅺ컻蹂��닔瑜� �옉�꽦�빐�빞 �븳�떎.
			//uploadFolder�뿉 ���옣�릺�뼱 �엳�뒗 寃쎈줈濡� �떎�젣 �뙆�씪紐낆쑝濡� ���옣.
			File saveFile=new File(uploadPath,uploadFileName);//�씠由꾩쓣 ���옣�빐�빞 �븯湲� �븣臾몄뿉
			
			try {
				//saveFile蹂��닔�뿉 ���옣�릺�뼱 �엳�뒗 �뤃�뜑紐낆쑝濡� �뙆�씪�쓣 蹂대궡�씪.
				multipartFile.transferTo(saveFile);//transferTo : �떎�젣濡� 吏��젙�븳 �뤃�뜑�뿉 �뾽濡쒕뱶瑜� �떆耳쒖＜�뒗 �뿭�솢, �삁�쇅泥섎━ �븘�닔
				
				//�떎�젣 �뾽濡쒕뱶 寃쎈줈(uploadFolderPath)�쓣 AttachFileDTO�겢�옒�뒪(attachdto)�뿉 uploadPath�뿉 ���옣(setUploadPath)
				attachdto.setUploadPath(uploadFolderPath); //try臾� �븞�뿉 �뾾�뼱�룄 �맂�떎. for臾� �븞�뿉留� �엳�쑝硫� �맂�떎.
				
				//uuid媛�(UUID)�쓣 AttachFileDTO�겢�옒�뒪(attachdto)�뿉 uploadPath�뿉 ���옣(setUuid)
				attachdto.setUuid(uuid.toString()); //try臾� �븞�뿉 �뾾�뼱�룄 �맂�떎. for臾� �븞�뿉留� �엳�쑝硫� �맂�떎. //uuid�뒗 �겢�옒�뒪���엯�씠誘�濡� 臾몄옄濡� 諛붽퓭以섏빞 �븳�떎.
				
				if(checkImage(saveFile)) {//�씠誘몄� �뙆�씪�씠硫�
					//FileType媛�(image)�쓣 AttachFileDTO�겢�옒�뒪(attachdto)�뿉 uploadPath�뿉 ���옣(setImage)
					attachdto.setImage(true); //try臾� �븞�뿉 �뾾�뼱�룄 �맂�떎. for臾� �븞�뿉留� �엳�쑝硫� �맂�떎.
					
					//�뜽�꽕�씪�쓣 �뙆�씪�쓣 �깮�꽦�븯湲� �쟾�뿉 �뜽�꽕�씪 �뙆�씪 �씠由꾩쓣 異붿텧
					FileOutputStream thumnail = new FileOutputStream(new File(uploadPath,"s_"+uploadFileName));//FileOutput �뙆�씪�쓣 諛뽰쑝濡� 혯A�떎
					
					//�뜽�꽕�씪�쓣 �뙆�씪�쓣 �깮�꽦�븿
					Thumbnailator.createThumbnail(multipartFile.getInputStream(),thumnail, 100, 100);
					thumnail.close();//�뜽�꽕�씪 醫낅즺(硫붾え由� 怨듦컙 �븿�닔)
				}
				
				list.add(attachdto);//add : 媛믪쓣 �꽔�쓣 �븣 �궗�슜�븯�뒗 硫붿꽌�뱶 
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//end try
		}//for臾� end
		//�넻�떊�긽�깭媛� �젙�긽�쟻(HttpStatus.OK)�씠硫� ArrayList(list)�뿉 ���옣�릺�뼱 �엳�뒗 媛믪쓣 �쎒釉뚮씪�슦��(uploadAjax.js�뿉 �엳�뒗 ajax�뿉 success)�뿉 蹂대궡�씪
		return new ResponseEntity<>(list,HttpStatus.OK);//list�뒗 uploadAjax.js�쓽 ajax�뿉 result濡� �꽆�뼱媛꾨떎.
	}
	
	//�뙆�씪 �뾽濡쒕뱶�븳 �뙆�씪���엯�씠 �씠誘몄��씪 �븣 �쎒釉뚮씪�슦���뿉 �씠誘몄�瑜� �쓣�슦湲� �쐞�빐
	@GetMapping("display")
	public ResponseEntity<byte[]> getFile(String fileName) {//getfile()�� 臾몄옄�뿴濡� �뙆�씪�쓽 寃쎈줈媛� �룷�븿�맂 fileName�쓣 留ㅺ컻蹂��닔 諛쏄퀬 byte[](�씠吏꾩닔)瑜� �쟾�넚
		System.out.println("url二쇱냼瑜� �넻�븳 fileName="+fileName);
		
		File file = new File("C:\\upload\\"+fileName);
		System.out.println("file="+file);
		ResponseEntity<byte[]> result = null;
		//byte[]濡� �씠誘몄� �뙆�씪�쓽 �뜲�씠�꽣瑜� �쟾�넚�븷 �븣 釉뚮씪�슦���뿉 蹂대궡�뒗 MIME���엯�씠 �뙆�씪�쓽 醫낅쪟(jpg, png, xls, ppt...)�뿉 �뵲�씪�꽌 �떖�씪吏꾨떎.
		//�씠 遺�遺꾩쓣 �빐寃고븯湲� �쐞�빐�꽌 probeContentType()�쓣 �씠�슜�빐�꽌 MIME���엯 �뜲�씠�꽣瑜� Http�쓽 �뿤�뜑 硫붿꽭吏��뿉 �룷�븿�븷 �닔 �엳�룄濡� 泥섎━
		try {
			HttpHeaders header = new HttpHeaders();
			result=new ResponseEntity<>(FileCopyUtils.copyToByteArray(file),header,HttpStatus.OK);
		} catch (IOException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	//�뙆�씪 �뾽濡쒕뱶�븳 �뙆�씪���엯�씠 �씠誘몄�媛� �븘�땺�븣(.txt, .xls, .ppt) �쎒釉뚮씪�슦��瑜� �넻�빐�꽌 download�븷 �닔 �엳�룄濡� �븳�떎.
	//consumes : �뱾�뼱�삤�뒗 �뜲�씠�꽣 ���엯 �젙�쓽(�깮�왂媛��뒫) //produces : 諛섑솚�븯�뒗 �뜲�씠�꽣 ���엯 �젙�쓽(�깮�왂媛��뒫)//*�깮�왂�쓣 �븯寃� �릺硫�, �쎒釉뚮씪�슦��媛� �븣�븘�꽌 ���엯�쓣 �뙋�떒(�궡媛� �썝�븯�뒗 ���엯�씠 �븘�땺 �닔�룄 �엳�쓬)*
	//�쎒釉뚮씪�슦��媛� '�씠 �뙆�씪�� download�빐�빞 �븯�뒗 �뙆�씪�엯�땲�떎.' �씪�뒗 寃껋쓣 �씤吏��븷 �닔 �엳�룄濡� 諛섑솚�씠 �릺�뼱�빞 �븳�떎. 洹몃윭湲� �쐞�빐�꽌�뒗 MediaType.APPLICATION_OCTET_STREAM_VALUE ���엯�쑝濡� 諛섑솚�뜲�씠�꽣 ���엯�쓣 �꽑�뼵�븳�떎.
	@GetMapping(value="download",produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<Resource> downloadFile(String fileName){//Resource core濡� import
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