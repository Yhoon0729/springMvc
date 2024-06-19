package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import member.Address;
import member.MemberInfo;

// @Service @Component 역할 함
@Component
public class MemberService {
	private int nextMemberId = 0;
	public Map<String, MemberInfo> memberMap = new HashMap();

	public MemberService() {
		memberMap.put("m1", new MemberInfo("m1", "이상화", "sanghwa@sanghwa.com", "sanghwa", false, new Address()));
		memberMap.put("m2", new MemberInfo("m2", "김연아", "yuna@yuna.com", "yuna", false, new Address()));
		nextMemberId = 3;
	}
	
	public List<MemberInfo> getMembers() {
		return new ArrayList<MemberInfo>(memberMap.values());
	}
	
	public MemberInfo getMemberInfo(String memberId) {
		return memberMap.get(memberId);
	}
}
