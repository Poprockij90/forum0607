package servlets;

import myObjects.Message;
import org.omg.CORBA.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/forum")
public class ForumServlet extends HttpServlet {
    private static final String JSP_LOGIN="login";
    private static final String JSP_PASS="pass";
    private List<Message> chat = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String servLogin=req.getParameter(JSP_LOGIN);
        if ("".equals(servLogin)|| servLogin==null){
            servLogin="без имени";
        }
        HttpSession session=req.getSession();
        session.setAttribute("forumLogin", servLogin);
        String sessionLog= (String) session.getAttribute("forumLogin");
//РАЗОБРАТЬСЯ КАК ИЗ СЕССИЙ ДОСТАТЬ ИМЯ
        req.setAttribute("sessionLog",sessionLog);
        req.getServletContext().getRequestDispatcher("/jsp/forum.jsp").forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        String sessionLog= (String) session.getAttribute("forumLogin");
        String text=req.getParameter("text");
        Message message=new Message(sessionLog,text);
        chat.add(message);
        req.setAttribute("chat",chat);
        req.getServletContext().getRequestDispatcher("/jsp/forum.jsp").forward(req,resp);
}
}
