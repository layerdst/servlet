package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name="requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        printStartLine(req);
        printHeader(req);
        printHeaderUtils(req);
        printEtc(req);

    }

    private void printEtc(HttpServletRequest req) {
        System.out.println();
        System.out.println("[기타조회]");

        System.out.println("[Remote 정보]");
        System.out.println(req.getRemoteUser());
        System.out.println(req.getRemoteAddr());
        System.out.println(req.getRemotePort());
        System.out.println();


        System.out.println("[Local 정보]");
        System.out.println(req.getLocalName());
        System.out.println(req.getLocalAddr());
        System.out.println(req.getLocalPort());
        System.out.println();



    }

    private void printHeaderUtils(HttpServletRequest req) {

        System.out.println("[Header 조회]");
        System.out.println("req.getServerName() : "+ req.getServerName());
        System.out.println("req.getServerPort() : "+ req.getServerPort());
        req.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale : " + locale));
        System.out.println("req.getLocale() : "+ req.getLocale());
        System.out.println();
        
        System.out.println("cookie");
        if(req.getCookies()!=null){
            for (Cookie cookie : req.getCookies()) {
                System.out.println(cookie.getName() + " : " + cookie.getValue());
            }
        }
        System.out.println();
        System.out.println("[Header Content 조회]");

        System.out.println("req.getContentType() : "+req.getContentType());
        System.out.println("req.getContentLength() : "+req.getContentLength());
        System.out.println("req.getCharacterEncoding() : "+req.getCharacterEncoding());
        
    }

    private void printStartLine(HttpServletRequest req) {
        System.out.println("getMethod : "+ req.getMethod());
        System.out.println("getProtocol : "+ req.getProtocol());
        System.out.println("getScheme  : "+ req.getScheme());
        System.out.println("getRequestURL  : "+ req.getRequestURL());
        System.out.println("getRequestURI  : "+ req.getRequestURI());
        System.out.println("getQueryString  : "+ req.getQueryString());
        System.out.println("isSecure  : "+ req.isSecure());
    }

    private void printHeader(HttpServletRequest req) {
        System.out.println("print Header start");

//        Enumeration<String> headerNames = req.getHeaderNames();
//        while (headerNames.hasMoreElements()) {
//            String headerName = headerNames.nextElement();
//            System.out.println("RequestHeaderServlet.printHeader : "+ headerName);
//        }


        req.getHeaderNames().asIterator()
                .forEachRemaining(headerName->System.out.println(headerName + " : "+ req.getHeader(headerName)));

        System.out.println("print Header end");

    }
}
