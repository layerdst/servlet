package hello.servlet.web.frontcontroller.v2.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRespository;
import hello.servlet.web.frontcontroller.Myview;
import hello.servlet.web.frontcontroller.v2.ControllerV2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MemberFormContollerV2 implements ControllerV2 {
    MemberRespository dd = MemberRespository.getInstance();

    @Override
    public Myview process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return new Myview("/WEB-INF/views/members.jsp");
    }
}
