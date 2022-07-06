package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberRespositoryTest {
    MemberRespository memberRespository = MemberRespository.getInstance();


    @AfterEach
    void after(){
        memberRespository.clearStore();
    }

    @Test
    void save(){
        Member m = new Member("hello", 20);
        Member sm = memberRespository.save(m);
        Member smId = memberRespository.findById(sm.getId());

        org.assertj.core.api.Assertions.assertThat(smId).isEqualTo(sm);
    }


    @Test
    public void findAll() throws Exception{
        //given
        Member m1 = new Member("helldfafo", 20);
        Member m2 = new Member("helelo", 30);
        Member m3 = new Member("helsadflo", 40);

        memberRespository.save(m1);
        memberRespository.save(m2);
        memberRespository.save(m3);

        List<Member> all = memberRespository.findAll();
        org.assertj.core.api.Assertions.assertThat(all.size()).isEqualTo(3);
        org.assertj.core.api.Assertions.assertThat(all).contains(m1, m2, m3);
        //when

        //then
    }
}