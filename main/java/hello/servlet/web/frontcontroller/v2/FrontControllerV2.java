package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.v2.controller.MemberFormContollerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberListControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberSaveControllerV2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FrontControllerV2 extends HttpServlet {
    private Map<String, ControllerV2> controllerV2Map = new HashMap<>();

    public FrontControllerV2() {
        controllerV2Map.put("/front-controller/v1/members/new-form", new MemberFormContollerV2());
        controllerV2Map.put("/front-controller/v1/members/save", new MemberSaveControllerV2());
        controllerV2Map.put("/front-controller/v1/members", new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();

        ControllerV2 controller = controllerV2Map.get(requestURI);
        if(controller==null){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        controller.process(req, resp);
    }
}
