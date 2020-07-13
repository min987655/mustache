package com.cos.viewresolver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Ioc : 실행할 때 스프링이 대신 메모리에 띄워줌
public class indexController {

	// Model(DI) : jsp의 리퀘스트 디스페쳐의 역할
	// 함수의 파라메터로 넘겨서 DI 편하게 사용 가능.
	@GetMapping({"","/"})
	public String index(Model model) {
		String name = "cos";
		int num = 10;
		String password = "1234";
		model.addAttribute("name", name);
		model.addAttribute("num", num);
		model.addAttribute("password", password);
		// /viewresolver/src/main/resources/templates/index.mustache
		// viewresolver 발동시 해당 폴더로 바로 찾아 감.
		// mustache 템플릿을 선택했기 때문에 해당 확장자 자동으로 찾음.
		// 프리픽스와 서픽스를 자동으로 잡아줌.
		// 리턴할 때 index를 잡아서 프리픽스를 붙여줌.
		// *** viewresolver 의 역할 두가지
		// 1. 파일을 찾음 2. 리턴값의 프리픽스와 서픽스를 잡아줌
		return "Index";
	}
	
	@GetMapping("/model/data")
	public String modelData(Model model) { // DI 하기
		Member member = Member.builder()
				.id(1)
				.username("ssar")
				.phone("01022221111")
				.build();
		model.addAttribute("member", member);
		return "modelData";
	}
	
	@GetMapping("/model/array")
	public String modelArray(Model model) { // DI 하기
		Member member1 = Member.builder()
				.id(1)
				.username("ssar")
				.phone("01022221111")
				.build();
		
		Member member2 = Member.builder()
				.id(2)
				.username("cos")
				.phone("01011112222")
				.build();
		List<Member> members = new ArrayList<>();
		members.add(member1);
		members.add(member2);
		model.addAttribute("members", members);
		model.addAttribute("user", true);
		return "modelArray";
	}
	
	@GetMapping("/layout")
	public String layout() {
		return "layout";
	}
}



