package hello.servlet.web.frontcontroller.v4;

import hello.servlet.web.frontcontroller.Myview;
import hello.servlet.web.frontcontroller.v2.ModelView;
import hello.servlet.web.frontcontroller.v4.controller.MemberFormControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberListControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberSaveControllerV4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="frontControllerServletV4", urlPatterns = "/front-controller/v4/*")
public class FrontContollerV4 extends HttpServlet {
    private Map<String, ControllerV4> controller = new HashMap<>();

    public FrontContollerV4() {
        controller.put("/front-contoller/v4/members/new-form", new MemberFormControllerV4());
        controller.put("/front-contoller/v4/members/save", new MemberSaveControllerV4());
        controller.put("/front-contoller/v4/members/members", new MemberListControllerV4());

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();

        ControllerV4 controllers = controller.get(requestURI);

        if(controllers == null){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

        Map<String, String> param = creatParamMap(req);
        Map<String, Object> model = new HashMap<>();
        String viewName = controllers.process(param, model);

        Myview view = viewResolver(viewName);
        view.render(model, req, resp);

    }

    private Myview viewResolver(String viewName) {
        return new Myview("/WEB-INF/views/" + viewName + ".jsp");
    }

    private Map<String, String> creatParamMap(HttpServletRequest req) {
        Map<String, String> temp = new HashMap<>();
        req.getParameterNames().asIterator().forEachRemaining(p -> temp.put(p, req.getParameter(p)));
        return temp;
    }


}
