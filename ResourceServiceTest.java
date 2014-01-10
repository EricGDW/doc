package com.itucity.yjreport.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itucity.yjreport.service.ResourceService;
import com.itucity.yjreport.vo.ResourcePrivVO;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })  
@PropertySource("classpath*:datasource.properties")
public class ResourceServiceTest {

	@Autowired  
	ResourceService resourceService;
	
	@Test
	public void getResourceByRoleIDTest(){
		ResourcePrivVO resource = resourceService.getResourceByRoleID(6);
		System.out.println(resource.toString());
	}
	
	@Test
	public void getSummary2Test(){
		
		resourceService.getGPProducts("GP1", null);
	}
	
	
	@Test
	public void getProductSalesStatisticsTest(){
		
		resourceService.getProductSalesStatistics("GP2", null);
	}
	
	@Test
	public void getProductSalesTest(){
		
		resourceService.getProductSales("GP3", "VBN", null);
	}
	
	@Test
	public void getGPRankingTest(){
		resourceService.getGPRanking("VBN", null);
	}
}
	
