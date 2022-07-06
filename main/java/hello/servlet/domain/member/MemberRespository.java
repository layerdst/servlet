package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRespository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    private static final MemberRespository instance =new MemberRespository();

    public static MemberRespository getInstance(){
        return instance;
    }

    private MemberRespository(){

    }

    public Member save(Member m){
        m.setId(++sequence);
        store.put(m.getId(), m);
        return m;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }


}
