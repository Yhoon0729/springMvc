package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import files.FileInfo;
import files.NoFileInfoException;

@Controller
@Component
public class FileController {
	
	@RequestMapping("/files/{fileId:[a-zA-Z]\\d{3}}")
	public String fileInfo(@PathVariable String fileId) throws NoFileInfoException {
		FileInfo fileInfo = getFileInfo(fileId);
		
		if(fileInfo == null) {
			throw new NoFileInfoException();
		}
		
		return "files/fileInfo";
	}
	
	@RequestMapping("/folders/**/files")
	public String list(HttpServletRequest request, Model model) {
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		if(uri.endsWith("/folders/files")) {
			model.addAttribute("folderIds", new String[0]);
		} else {
			String ctxPath = request.getContextPath();
			String path = ctxPath.isEmpty() ? uri:uri.substring(ctxPath.length());
			// localhost:8080/project명/
			String folderTreePath = path.substring("/folders/".length(),
					path.length() - "/files".length());
			String[] folderIds = folderTreePath.split("/");
			
			for(int i = 0; i < folderIds.length; i++) {
				System.out.println(folderIds[i]);
			}
			
			model.addAttribute("folderIds", folderIds);
		}

		 
		return "files/filesInFolder";
	}
	
	private FileInfo getFileInfo(String fileId) {
		if("a111".equals(fileId)) {
			return null;
		}
		return new FileInfo(fileId);
	}
}
