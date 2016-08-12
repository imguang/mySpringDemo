package demo3;


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

import com.imguang.demo.model.Address;
import com.imguang.demo.service.IAddressService;
//import com.imguang.demo.model.UserT;
import com.imguang.demo.service.IUserService;

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
	private IAddressService addressServiceImpl = null;
	Address address;

	@Before
	public void before() {
		ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
		addressServiceImpl = (IAddressService) ac.getBean("addressServiceImpl");
	}

	@Test
	public void test1() {
		System.out.println(addressServiceImpl.deleteAddress(5, "imguang"));
	}
}
