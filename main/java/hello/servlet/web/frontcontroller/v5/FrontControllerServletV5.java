package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.Myview;
import hello.servlet.web.frontcontroller.v2.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import hello.servlet.web.frontcontroller.v5.adapter.ControllerV3HandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "frontControllerServlet5", urlPatterns = "/front-controller/v5/*")

public class FrontControllerServletV5 extends HttpServlet {
    private Map<String, Object> handlerMappingMap = new HashMap<>();
    private List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();


    private void initHandlerAdapter(){
        handlerAdapters.add(new ControllerV3HandlerAdapter());
    }

    public FrontControllerServletV5(){
        initHandlerMappingMap();
        initHandlerAdapter();
    }

    private void initHandlerMappingMap() {
        handlerMappingMap.put("/front-controller/v3/members/new-form", new MemberControllerV3());
        handlerMappingMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        handlerMappingMap.put("/front-controller/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object handler = getHandler(req);

        if(handler==null){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyHandlerAdapter adapter = getHandlerAdapter(handler);

        ModelView mv = adapter.handle(req, resp, handler);

        String viewName = mv.getViewName();
        Myview view = viewResolver(viewName);

        view.render(mv.getModel(), req, resp);
    }

    private MyHandlerAdapter getHandlerAdapter(Object handler) {
        for (MyHandlerAdapter adapter : handlerAdapters) {
            if(adapter.supports(handler)){
                return adapter;
            }
        }

        throw new IllegalArgumentException("handler adapter를 찾을수 없음");
    }

    private Object getHandler(HttpServletRequest req) {
        String requestURI = req.getRequestURI();
        Object handler = handlerMappingMap.get(requestURI);
        return handler;
    }

    private Myview viewResolver(String viewName){
        return new Myview("/WEB-INF/views/" + viewName + ".jsp");
    }


}
