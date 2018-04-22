package uploadfile.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import uploadfile.service.AmazonClient;

@Controller
public class HomeController {
	
	private AmazonClient amazonClient;

	/*
	 * private static final String ACCESS_KEY = "AKIAJEXBMWTVXUU5UCAA"; private
	 * static final String SECRET_KEY = "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";
	 * private static final String BUCKET_NAME = "bucket-group4-uploadfile";
	 */

	@Autowired
	HomeController(AmazonClient amazonClient) {
		this.amazonClient = amazonClient;
	}
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		String urlFile = this.amazonClient.uploadFile(file);
		request.setAttribute("linkFileUpSuccess", urlFile);
        return "home";
    }

	@DeleteMapping("/deleteFile")
	public String deleteFile(@RequestPart(value = "url") String fileUrl) {
		return this.amazonClient.deleteFileFromS3Bucket(fileUrl);
	}


}
