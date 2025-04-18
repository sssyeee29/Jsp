package com.saeyan.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.group.Response;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/upload.do")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //반을때
		response.setContentType("text/html; charset=utf-8"); //보낼때 
		
		PrintWriter out = response.getWriter();
		
		//업로드 경로
		String savePath = "upload"; //webapp 밑에 있는 upload 파일을 나타냄 -> 이곳을 바꿔주면 다운받는 경로가 바뀜 
	
		int uploadFileSizeLimit = 5*1024*1024; //5MB(업로드 파일의 최대크기)(1024*1024이게 메가바이트 부분)
		String encType = "utf-8";
		
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
	
		System.out.println("서버상 실제 폴더 : " + uploadFilePath);
		
		try {
			MultipartRequest multi = new MultipartRequest(
					request,
					uploadFilePath, //서버 디렉토리 
					uploadFileSizeLimit, //최대 업로드 파일 크기 
					encType, //인코딩 방법
					new DefaultFileRenamePolicy()			
			);
			
			String fileName = multi.getFilesystemName("uploadFile"); //upload.jsp-> 파일 지정하기-> name
			System.out.println("fileName" + fileName);
			
			if(fileName == null) {
				System.out.println("파일 업로드가 되지 않았습니다.");
			}else { //파일 가져올땐 따로따로 가지고 와야함 
			 out.println("<br> 글쓴이 : " + multi.getParameter("name"));
			 out.println("<br> 제목 : " + multi.getParameter("title"));
			 out.println("<br> 파일명 : " + multi.getFilesystemName("uploadFile"));
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
