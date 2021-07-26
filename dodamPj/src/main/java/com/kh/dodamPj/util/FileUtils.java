package com.kh.dodamPj.util;

import java.io.File;
import java.net.FileNameMap;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.springframework.web.multipart.MultipartFile;

import com.twelvemonkeys.imageio.metadata.Directory;


public class FileUtils {

	@Inject
	private ServletContext ctx;
	
	public void makeFolders(String path) {
		File folder = new File(path);
		if (!folder.exists()) {
			folder.mkdirs();
		}
	}
	
	public String getBasePath(String... moreFolder) {
		String temp = "";
		for (String s : moreFolder) {
			temp += s;
		}
		String basePath = ctx.getRealPath(temp);
		return basePath;
	}
	
	// 확장자 얻어오기
	public String getExt(String fileNm) {
		return fileNm.substring(fileNm.lastIndexOf(".") + 1);
	}
	
	// 랜덤 파일명 리턴
	public String getRandomFileNm(String fileNm) {
		return UUID.randomUUID().toString() + "." + getExt(fileNm);
	}
	
	// 파일 저장 & 랜덤 파일명 구하기
	public String transferTo(MultipartFile mf, String... target) {
		String fileNm = null;
		String basePath = getBasePath(target);
		makeFolders(basePath);
		
		try {
			fileNm = getRandomFileNm(mf.getOriginalFilename());
			File file = new File(basePath, fileNm);
			mf.transferTo(file);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return fileNm;
	}
	
	public String transferTo(MultipartFile mf, boolean createThumb, String... target) throws Exception {
		String fileNm = null;
		String basePath = getBasePath(target);
		System.out.println("basePath :" + basePath);
		makeFolders(basePath);
		File file;
		
		try {
			fileNm = getRandomFileNm(mf.getOriginalFilename());
			file = new File(basePath, fileNm);
			mf.transferTo(file);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		if(createThumb) {
			//saveThumb(file, basePath, 600);
			makeThumbnail(file, basePath, 500);
		}
		return fileNm;
	}
	
	private void makeThumbnail(File origin_file, String basePath, int MAX) throws Exception {
		String fileNm = origin_file.getName();
		String extension = getExt(origin_file.getName());
		
		File imageFile = new File(basePath + "/" + fileNm);
		
		int orientation = 1; // 회전정보 1 -> 0도, 3 -> 180도, 6 -> 270도, 8 -> 90도
		
//		Metadata metadata;
//		Directory directory;
//		JpegDirectory
	}
}
