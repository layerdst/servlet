package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="requestParamServlet" ,urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[전체파라미터 조회]");
        req.getParameterNames().asIterator().forEachRemaining(p->System.out.println(p + " : " + req.getParameter(p)));

        System.out.println();
        System.out.println("단일파라미터");
        String userName = req.getParameter("username");
        String age = req.getParameter("age");
        System.out.println();
        System.out.println("userName : " + userName);
        System.out.println("age : " +age );
        System.out.println();

        System.out.println("이름이 같은 복수 파라미터 조회");
        String[] userNames = req.getParameterValues("username");
        for (String name : userNames) {
            System.out.println("name: " + name);
        }
        resp.getWriter().write("ok");
    }
}
