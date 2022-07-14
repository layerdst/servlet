package hello.servlet.web.frontcontroller.v4.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRespository;
import hello.servlet.web.frontcontroller.v2.ModelView;
import hello.servlet.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberSaveControllerV4 implements ControllerV4 {

    private MemberRespository rp = MemberRespository.getInstance();

    @Override
    public String process(Map<String, String> param, Map<String, Object> model) {
        String username = param.get("username");
        int age = Integer.parseInt(param.get("age"));

        Member m = new Member(username, age);
        rp.save(m);

        model.put("member", m);
        return "save-result";
    }
}
