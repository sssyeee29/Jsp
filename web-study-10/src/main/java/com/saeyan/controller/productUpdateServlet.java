package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.saeyan.dao.ProductDAO;
import com.saeyan.dto.ProductVO;

@WebServlet("/productUpdate.do")
public class productUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String code = request.getParameter("code"); //상품 수정 누르면 넘어오는게 코드라서 - 어떤걸 수정할지 코드를 보고판단 ->코드가 기본키 같은존재 
	
		ProductVO pVo = ProductDAO.getInstance().selectProductByCode(code);
		
		request.setAttribute("product", pVo);
		
		request.getRequestDispatcher("product/productUpdate.jsp").forward(request, response);
	} 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8"); //한글깨지지말라는 코드
		
		ServletContext context = getServletContext();
		String path = context.getRealPath("upload");
		
		String encType = "utf-8";
		
		int sizeLimit = 20*1024*1024; //20MB까지 - 최대크기
		
		MultipartRequest multi = new MultipartRequest(
				request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		
//		System.out.println(path); //사진 경로가 어디인지 확인하려고 -> 여기로 nonmakeimg 넣어야 나옴
		
		int code = Integer.parseInt(multi.getParameter("code"));
		String name = multi.getParameter("name");
		int price = Integer.parseInt(multi.getParameter("price"));
		String pictureUrl = multi.getFilesystemName("pictureUrl");
		String description = multi.getParameter("description");
		
		//수정시 이미지 첨부를 하지않으면 기본이미지사용(noimage.gif) - 사진이 없을때 이 사진으로 넣는다고 했으니까 
		if(pictureUrl == null) {
			pictureUrl = multi.getParameter("nonmakeImg");
		}
		
		ProductVO pVo = new ProductVO();
		pVo.setCode(code); 
		pVo.setName(name);
		pVo.setPrice(price);
		pVo.setPictureUrl(pictureUrl);
		pVo.setDescription(description);
		
		ProductDAO.getInstance().updateProduct(pVo); //51,52번 코드를 체인기법으로 한줄로 정리 
		
		response.sendRedirect("productList.do"); //리스트 목록으로 이동
		
	}

}
