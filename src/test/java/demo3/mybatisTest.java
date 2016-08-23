package demo3;

import java.util.ArrayList;
import java.util.List;

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
import com.imguang.demo.model.OrderItem;
import com.imguang.demo.service.IAddressService;
import com.imguang.demo.service.IOrderService;
//import com.imguang.demo.model.UserT;
import com.imguang.demo.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
// 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class mybatisTest {
	// private static Logger logger = Logger.getLogger(mybatisTest.class);
	private ApplicationContext ac = null;

	private List<OrderItem> orderItems = new ArrayList<OrderItem>();

	@Resource
	@Qualifier("UserServiceImpl")
	private IUserService userService = null;

	@Resource
	@Qualifier("ProductServiceImpl")
	private IAddressService addressServiceImpl = null;
	Address address;

	@Resource
	@Qualifier("OrderServiceImpl")
	private IOrderService orderServiceImpl;

	@Before
	public void before() {
		ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
		addressServiceImpl = (IAddressService) ac.getBean("addressServiceImpl");
		orderServiceImpl = (IOrderService) ac.getBean("orderServiceImpl");
		OrderItem orderItem = new OrderItem();
		orderItem.setOrderid("12345");
		orderItem.setpNum(100);
		orderItem.setpPrice(1000.0);
		orderItem.setProductid(12);

		OrderItem orderItem2 = new OrderItem();
		orderItem2.setOrderid("12345");
		orderItem2.setpNum(100);
		orderItem2.setpPrice(1000.0);
		orderItem2.setProductid(13);

		orderItems.add(orderItem);
		orderItems.add(orderItem2);
	}

	@Test
	public void test1() {
//		int i = orderServiceImpl.insertOrder(orderItems);
//		System.out.println(i);
		// System.out.println(addressServiceImpl.deleteAddress(5, "imguang"));
		// System.out.println(orderServiceImpl.selectCasByPrimaryKeyOrder(1));
		// System.out.println(orderServiceImpl.selectByPrimaryKeyOrder(1));
	}
}
