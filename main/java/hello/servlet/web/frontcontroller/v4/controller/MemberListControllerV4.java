package hello.servlet.web.frontcontroller.v4.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRespository;
import hello.servlet.web.frontcontroller.v4.ControllerV4;

import java.util.List;
import java.util.Map;

public class MemberListControllerV4 implements ControllerV4 {
    private final MemberRespository rep = MemberRespository.getInstance();


    @Override
    public String process(Map<String, String> param, Map<String, Object> model) {
        List<Member> members = rep.findAll();

        model.put("members", members);
        return "members";
    }
}
