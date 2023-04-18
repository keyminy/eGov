package egovframework.example.sample.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.sample.service.DeptService;
import egovframework.example.sample.service.DeptVO;

@Controller
public class DeptController {
	
	@Resource(name="deptService")
	private DeptService deptService;
	
	@RequestMapping(value = "/deptWrite.do")
	public String deptWrite() {
		return "dept/deptWrite";
	}
	
	@RequestMapping(value = "/deptWriteSave.do")
	public String insertDept(DeptVO vo) throws Exception{
		System.out.println("부서번호 : "  + vo.getDeptno());
		System.out.println("부서이름 : "  + vo.getDname());
		System.out.println("부서위치 : "  + vo.getLoc());
		String result = deptService.insertDept(vo);
		System.out.println("결과 : " + result);
		if(result == null) {
			System.out.println("저장 완료");
		}else {
			System.out.println("저장 실패");
		}
		return "";
	}
	
	
}
