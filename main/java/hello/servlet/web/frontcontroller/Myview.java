package hello.servlet.web.frontcontroller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;

public class Myview {
    private String viewPath;

    public Myview(String viewPath) {
        this.viewPath = viewPath;
    }

    public void render(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        RequestDispatcher dp = req.getRequestDispatcher(viewPath);
        dp.forward(req,resp);
    }
}
