package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/upload")
@MultipartConfig(  
        location = "/Users/liuji/upload/",// The directory location where files will be stored
        maxFileSize = 8388608,//The maximum size allowed for uploaded files.8388608=8MB  
        fileSizeThreshold = 819200//The size threshold after which the file will be written to disk 
        //maxRequestSize =  8*1024*1024*6 //The maximum size allowed for multipart/form-data requests  
)  
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FileUpload() {
        super();
    }

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Collection<Part> parts=request.getParts();
		List<String> fileNames=new ArrayList<String>();
		for(Part part:parts)
		{
			String fileName=getFileName(part);
			if(fileName!=null)
			{
				//save this file to /Users/liuji/upload/
				part.write(fileName);
				fileNames.add(fileName);
			}
			else
			{
				//this part is not a file
			}
		}
		displayHTML(response,fileNames);
		
	}
	private void displayHTML(HttpServletResponse response,
			List<String> fileNames) throws IOException {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.print("<title>文件上传成功</title>");
		out.print("</head>");
		out.print("<body>");
		for(String fileName:fileNames)
		{
			out.print("<p>"+fileName+"上传成功</p>");
		}
		out.print("</body>");
		out.print("</html>");
	}

	private String getFileName(Part part){
		//get file name from content-disposition in HTTP header.
		String cotentDesc = part.getHeader("content-disposition");
		String fileName = null;
		//use regular expression to find out file name
		Pattern pattern = Pattern.compile("filename=\".+\"");
		Matcher matcher = pattern.matcher(cotentDesc);
		if(matcher.find()){
			fileName = matcher.group();
			fileName = fileName.substring(10, fileName.length()-1);
		}
		return fileName;
	}

}

