package demo3;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;



//import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.imguang.demo.service.IProductService;
//import com.imguang.demo.model.UserT;
import com.imguang.demo.service.IUserService;
import com.imguang.demo.service.impl.ProductServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
// 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class mybatisTest {
	// private static Logger logger = Logger.getLogger(mybatisTest.class);
	private ApplicationContext ac = null;
	@Resource
	@Qualifier("UserServiceImpl")
	private IUserService userService = null;

	@Resource
	@Qualifier("ProductServiceImpl")
	private IProductService productServiceImpl = null;

	@Before
	public void before() {
		ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
		productServiceImpl = (IProductService) ac.getBean("productServiceImpl");
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("limit", 5);
		maps.put("offset", 0);
	}

	@Before
	public void Before() {

	}

	@Test
	public void test1() {
		System.out.println(productServiceImpl.selectLimit(5, 0));
	}
}
