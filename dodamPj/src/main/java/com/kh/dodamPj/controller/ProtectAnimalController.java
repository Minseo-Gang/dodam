package com.kh.dodamPj.controller;

import java.io.FileInputStream;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.dodamPj.service.AnimalService;
import com.kh.dodamPj.util.AnimalFileUploadUtil;
import com.kh.dodamPj.vo.A_PagingDto;
import com.kh.dodamPj.vo.AnimalVo;

@Controller
@RequestMapping(value="/protect")
public class ProtectAnimalController {
	
	@Inject
	private AnimalService animalService;
	
		// 보호중인 동물 페이지
		@RequestMapping(value="/protectAnimal", method=RequestMethod.GET)
		public String protectAnimal(Model model, A_PagingDto aPagingDto) throws Exception {
			int count = animalService.getCount(aPagingDto);
			aPagingDto.setCount(count);
			List<AnimalVo> aList = animalService.animalList(aPagingDto);
			model.addAttribute("aList", aList);
			model.addAttribute("aPagingDto", aPagingDto);
			return "protect/protectAnimal";
		}
		
		// 보호중인 동물 등록 페이지
		@RequestMapping(value="/protectAnimalForm", method=RequestMethod.GET)
		public String protectAnimalForm() throws Exception {
			return "protect/protectAnimalForm";
		}
			
		// 보호중인 동물 등록 내용 전송
		@RequestMapping(value="/insertAnimalRun", method=RequestMethod.POST)
		public String insertAnimalRun(AnimalVo animalVo, MultipartFile file, RedirectAttributes rttr) throws Exception {
			String orgFileName = file.getOriginalFilename();
			String filePath = AnimalFileUploadUtil.uploadFile("E:/upload", orgFileName, file.getBytes());
			animalVo.setA_picture(filePath);
			animalService.insertAnimalRun(animalVo);
			rttr.addFlashAttribute("result", "success");
			return "redirect:/protect/protectAnimal";
		}
		
		// 보호중인 동물 상세 페이지
		@RequestMapping(value="/protectAnimalCont", method=RequestMethod.GET)
		public String protentAnimalContent(A_PagingDto aPagingDto, Model model, int a_no) throws Exception {
			AnimalVo animalVo = animalService.selectAnimal(a_no);
			model.addAttribute("animalVo", animalVo);
			return "protect/protectAnimalCont";
		}
		
		// 보호중인 동물 삭제 내용 전송
		@RequestMapping(value="/deleteAnimalRun", method=RequestMethod.GET)
		public String deleteAnimalRun(int a_no) throws Exception {
			animalService.deleteAnimalRun(a_no);
			return "redirect:/protect/protectAnimal";
		}
		
		// 보호중인 동물 수정 페이지
		@RequestMapping(value="/protectAnimalModiForm", method=RequestMethod.GET)
		public String protectAnimalModiForm(Model model, int a_no) throws Exception {
			AnimalVo animalVo = animalService.selectAnimal(a_no);
			model.addAttribute("animalVo", animalVo);
			return "protect/protectAnimalModiForm";
		}
		
		// 보호중인 동물 수정 정보 전송
		@RequestMapping(value="/modifyAnimalRun", method=RequestMethod.POST)
		public String modifyAnimalRun(AnimalVo animalVo, RedirectAttributes rttr) throws Exception {
			animalService.modifyAnimalRun(animalVo);
			rttr.addFlashAttribute("result", "success");
			return "redirect:/protect/protectAnimal";
		}
		
		@RequestMapping(value="/uploadAjax", method=RequestMethod.POST, produces="application/text;charset=utf-8")
		@ResponseBody
		public String uploadAjax(MultipartFile file) throws Exception {
			System.out.println("file :" + file);
			String originalFilename = file.getOriginalFilename();
			System.out.println("originalFilename :" + originalFilename);
			String filePath = AnimalFileUploadUtil.uploadFile("E:/upload", originalFilename, file.getBytes());
			return filePath;
		}
		
		@RequestMapping(value="/displayImage", method=RequestMethod.GET)
		@ResponseBody
		public byte[] displayImage(String fileName) throws Exception {
			FileInputStream fis = new FileInputStream(fileName);
			byte[] bytes = IOUtils.toByteArray(fis);
			fis.close();
			return bytes;
		}
		
		@RequestMapping(value="/deleteFile", method=RequestMethod.GET)
		@ResponseBody
		public String deleteFile(String fileName) throws Exception {
			AnimalFileUploadUtil.deleteFile(fileName);
			return "success";
		}

}
