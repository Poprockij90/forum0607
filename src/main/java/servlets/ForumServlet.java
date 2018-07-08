package servlets;

import myObjects.Message;

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
        req.setAttribute("forumLogin",servLogin);
        req.getServletContext().getRequestDispatcher("/jsp/forum.jsp").forward(req,resp);
//        HttpSession session=req.getSession();
//        session.setAttribute("forumLogin", servLogin);
    }
//HttpSession session = req.getSession();
//
//String nick = (String) session.getAttribute("nick-session-param");
////todo нормальная проверка
//if("".equals(nick) || nick == null) {
//nick = req.getParameter("nick-param");
//if ("".equals(nick) || nick == null) {
//
//nick = "анонимус";
//}
//session.setAttribute("nick-session-param", nick);
//}
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String nick=req.getParameter("login");
//        HttpSession session=req.getSession();
//        String login=(String) session.getAttribute("login");
//        session.setAttribute("session_login",login);
//       req.setAttribute("forumLogin",nick);
//       req.getServletContext().getRequestDispatcher("/jsp/forum.jsp").forward(req,resp);
//        System.out.println(req.getAttribute("forumLogin"));
//
//    }




}
