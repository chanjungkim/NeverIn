package servlet;
 
import java.io.File;
import java.io.IOException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
 
@WebServlet("/upload")
public class UploadServlet extends HttpServlet{
 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = 
                req.getRequestDispatcher("upload_form.jsp");
        dispatcher.forward(req, resp);
    }
     
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("euc-kr");
        // param�� myFile�� �޾ƾ� ��.
        String uploadFolder = "c://";
         
        //������(request��û��ü, ����������, �����ִ�ũ��,�����̸��� ���� ��������)
        MultipartRequest mReq = 
            new MultipartRequest
                (req, uploadFolder, 
                1024*1024*40, new DefaultFileRenamePolicy());
         
        File uploadFile = 
                mReq.getFile("myFile"); // ���Ͼ��ε�Ϸ�
         
        System.out.println("---------------------");
        System.out.println("���� �����̸�:"
                    + mReq.getOriginalFileName("myFile"));
        System.out.println("����� �̸�:"
                    + uploadFile.getName());
        System.out.println("������:"
                    + uploadFile.getAbsolutePath());
        System.out.println("param����:"
                    + mReq.getParameter("param"));
        System.out.println("---------------------");
        // http://70.12.115.50/Day13_File/upload
        RequestDispatcher dispatcher = 
                req.getRequestDispatcher("upload_result.jsp");
        dispatcher.forward(req, resp);
    }
 
}