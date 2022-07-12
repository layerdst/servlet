package hello.servlet.web.frontcontroller.v1.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRespository;
import hello.servlet.web.frontcontroller.v1.ControllerV1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MemberListController implements ControllerV1{

    MemberRespository dd = MemberRespository.getInstance();

    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Member> ml = dd.findAll();
        req.setAttribute("members",ml );

        String viewPath = "/WEB-INF/views/members.jsp";
        RequestDispatcher dp = req.getRequestDispatcher(viewPath);
        dp.forward(req,resp);

    }
}
