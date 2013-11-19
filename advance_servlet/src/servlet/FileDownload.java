package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FileDownload() {
        super();
    }
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String path=request.getParameter("path");
		File file=new File(path);
		String fileName=new String(file.getName().getBytes("UTF-8"),"ISO-8859-1");
		response.setHeader("Content-disposition", "attachment; filename="
				+ fileName);
		InputStream in=new FileInputStream(file);
		OutputStream out=response.getOutputStream();
		copy(in,out);
		
	}
	private void copy(InputStream in ,OutputStream out) throws IOException
	{
		byte[] bytes = new byte[1024];
		int len = 0;
		while ((len = in.read(bytes)) > 0)
			out.write(bytes, 0, len);
		out.close();
		in.close();
	}

}
