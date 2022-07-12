package hello.servlet.web.frontcontroller.v1.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRespository;
import hello.servlet.web.frontcontroller.v1.ControllerV1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSaveController implements ControllerV1 {

    MemberRespository memberRespository = MemberRespository.getInstance();

    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        int age = Integer.parseInt(req.getParameter("age"));

        Member mem = new Member(username, age);
        memberRespository.save(mem);

        req.setAttribute("member", mem);
        String viewPath = "/WEB-INF/views/save-result.jsp";
        RequestDispatcher di = req.getRequestDispatcher(viewPath);
        di.forward(req, resp);
    }
}
