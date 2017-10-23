

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SocketController
 */
@WebServlet("/SocketController")
@Controller
public class SocketController {
     
    @RequestMapping("/chat")
    public String viewChattingPage() {
        return "chatting/chat";
    }
}