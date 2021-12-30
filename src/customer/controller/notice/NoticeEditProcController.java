package customer.controller.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.controller.Controller;
import customer.dao.NoticeDao;
import customer.vo.Notice;

public class NoticeEditProcController  implements Controller{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		System.out.println("NoticeEditProcController ~~");
		request.setCharacterEncoding("utf-8");
		String seq=request.getParameter("c");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		Notice n=new Notice();
		n.setSeq(seq);
		n.setTitle(title);
		n.setContent(content);
		
		NoticeDao dao=new NoticeDao();
		int af=dao.update(n);
		
		n=dao.getNotice(seq);
		

		request.setAttribute("n", n);
		request.getRequestDispatcher("noticeDetail.jsp").forward(request, response);
				
	}

}
