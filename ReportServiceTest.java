package com.itucity.yjreport.junit;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itucity.common.ResourceTypeEnum;
import com.itucity.yjreport.dao.ReportDao;
import com.itucity.yjreport.dao.entity.ReportEO;
import com.itucity.yjreport.dao.entity.ResourceEO;
import com.itucity.yjreport.service.ReportService;
import com.itucity.yjreport.service.ResourceService;
import com.itucity.yjreport.vo.FileVO;
import com.itucity.yjreport.vo.ProductSalesVO;
import com.itucity.yjreport.vo.ReportCondition;


@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })  
@PropertySource("classpath*:datasource.properties")
public class ReportServiceTest {
	
	@Autowired  
	ReportService reportService;
	
	@Autowired  
	ReportDao reportDao;
	
	@Autowired  
	ResourceService resourceService;
	
	@Test
	public void getResourceByRoleIDTest(){
		resourceService.getResourceByRoleID(3);
	}
	
	@Test
	public void getProductSalesStatisticsTest(){
		List<ProductSalesVO> p = resourceService.getProductSalesStatistics("GP1", null);
		System.out.print(p.toString());
		return ;
	}
	
	@Test
	public void saveTest(){
		ResourceEO resource = new ResourceEO();
		resource.setName("test");
		resource.setType(ResourceTypeEnum.GP);
		reportDao.save(resource);
		System.out.print(resource);
	}
	
	
//	@Test
//	public void getSalesBySalesNameTest(){
//		
//		ReportCondition condition = new ReportCondition();
//		condition.setRegion("华东");		
//		
//		Map<String, BigDecimal>  pSales = reportService.
//									getSalesBySalesName("salesJoy", condition);
//		
//		ReportEO report = newReportEO();
//		report.setOrderNo("001-01");
//		report.setQuantitySold(2);
//		report.setAllPrice(new BigDecimal(200.0));
//		report.setSalesName("salesJoy");
//		report.setRegion("华东");	
//		reportDao.save(report);
//		
//		ReportEO report2 = newReportEO();
//		report2.setOrderNo("001-02");
//		report2.setQuantitySold(3);
//		report2.setAllPrice(new BigDecimal(300.0));
//		report2.setSalesName("salesJoy");
//		report2.setRegion("华东");	
//		reportDao.save(report2);
//		
//		ReportEO report3 = newReportEO();
//		report3.setOrderNo("001-03");
//		report3.setQuantitySold(3);
//		report3.setAllPrice(new BigDecimal(300.0));	
//		report3.setSalesName("salesNick");
//		report3.setRegion("华东");	
//		reportDao.save(report3);
//		
//		Map<String, BigDecimal>  sales = reportService.
//									getSalesBySalesName("salesJoy", condition);
//		
//		BigDecimal expectSales = new BigDecimal(500.0).setScale(4);
//		if(pSales == null || pSales.get("salesJoy") == null){
//			assertEquals(expectSales,
//					(BigDecimal)sales.get("salesJoy"));
//			reportDao.delete(report);
//			reportDao.delete(report2);
//			reportDao.delete(report3);
//			return;
//		}
//		assertEquals(expectSales.add(pSales.get("salesJoy")),
//				(BigDecimal)sales.get("salesJoy"));
//		
//		reportDao.delete(report);
//		reportDao.delete(report2);
//		reportDao.delete(report3);
//	}
//
//	@Test
//	public void getSalesByRegionTest() throws Exception{
//		ReportCondition condition = new ReportCondition();
//		condition.setProduct("yj_print");	
//		
//		Map<String, BigDecimal>  pSales = reportService.
//									getSalesByRegion("华东", condition);
//		
//		ReportEO report = newReportEO();
//		report.setOrderNo("001-05");
//		report.setQuantitySold(2);
//		report.setAllPrice(new BigDecimal(200.0));
//		report.setRegion("华东");
//		report.setProduct("yj_print");
//		reportDao.save(report);
//		
//		ReportEO report2 = newReportEO();
//		report2.setOrderNo("001-05");
//		report2.setQuantitySold(2);
//		report2.setAllPrice(new BigDecimal(200.0));
//		report2.setRegion("华南");
//		report2.setProduct("yj_print");
//		reportDao.save(report2);
//		
//		Map<String, BigDecimal>  sales = reportService.
//											getSalesByRegion("华东", condition);
//		
//		BigDecimal expectSales = new BigDecimal(200.0).setScale(4);
//		if(pSales == null || pSales.get("华东") == null){
//			assertEquals(expectSales,
//					(BigDecimal)sales.get("华东"));
//			reportDao.delete(report);
//			reportDao.delete(report2);
//			return;
//		}
//		assertEquals(expectSales.add(pSales.get("华东")),
//				(BigDecimal)sales.get("华东"));
//		
//		reportDao.delete(report);
//		reportDao.delete(report2);
//	}
//	
//	@Test
//	public void getSalesByProductTest() throws Exception{
//		ReportCondition condition = new ReportCondition();
//		condition.setRegion("华东");		
//		
//		Map<String, BigDecimal>  pSales = reportService.
//									getSalesByProduct("yj_report", condition);
//		
//		ReportEO report = newReportEO();
//		report.setOrderNo("001-06");
//		report.setQuantitySold(2);
//		report.setAllPrice(new BigDecimal(200.0));
//		report.setProduct("yj_print");
//		report.setRegion("华东");
//		reportDao.save(report);
//		
//		ReportEO report2 = newReportEO();
//		report2.setOrderNo("001-05");
//		report2.setQuantitySold(3);
//		report2.setAllPrice(new BigDecimal(300.0));
//		report2.setProduct("yj_scanner");
//		report2.setRegion("华东");
//		reportDao.save(report2);
//		
//		Map<String, BigDecimal>  sales = reportService.
//									getSalesByProduct("yj_report", condition);
//		
//		BigDecimal expectSales = new BigDecimal(200.0).setScale(4);
//		if(pSales == null || pSales.get("yj_report") == null){
//			assertEquals(expectSales,
//					(BigDecimal)sales.get("yj_report"));
//			reportDao.delete(report);
//			reportDao.delete(report2);
//			return;
//		}
//		assertEquals(expectSales.add(pSales.get("yj_report")),
//				(BigDecimal)sales.get("yj_report"));
//		
//		reportDao.delete(report);
//		reportDao.delete(report2);
//	}
//	
//	@Test
//	public void getSalesByPartnerTest() throws Exception{
//		ReportCondition condition = new ReportCondition();
//		condition.setRegion("华东");		
//		
//		Map<String, BigDecimal>  pSales = reportService.
//									getSalesByPartner("vadppjoy", condition);
//		
//		ReportEO report = newReportEO();
//		report.setOrderNo("001-06");
//		report.setQuantitySold(3);
//		report.setAllPrice(new BigDecimal(300.0));
//		report.setVadPpName("vadppjoy");
//		report.setRegion("华东");
//		reportDao.save(report);
//		
//		ReportEO report2 = newReportEO();
//		report2.setOrderNo("001-05");
//		report2.setQuantitySold(2);
//		report2.setAllPrice(new BigDecimal(200.0));
//		report2.setVadPpName("vadppnick");
//		report2.setRegion("华东");
//		reportDao.save(report2);
//		
//		Map<String, BigDecimal>  sales = reportService.
//									getSalesByPartner("vadppjoy", condition);
//		
//		BigDecimal expectSales = new BigDecimal(300.0).setScale(4);
//		if(pSales == null || pSales.get("vadppjoy") == null){
//			assertEquals(expectSales,
//					(BigDecimal)sales.get("vadppjoy"));
//			reportDao.delete(report);
//			reportDao.delete(report2);
//			return;
//		}
//		assertEquals(expectSales.add(pSales.get("vadppjoy")),
//				(BigDecimal)sales.get("vadppjoy"));
//		
//		reportDao.delete(report);
//		reportDao.delete(report2);
//	}
//	
//	@Test
//	public void deleteByConditonTest() throws Exception{
//		ReportCondition condition = new ReportCondition();
//		condition.setImportAuthor("joy");
//		condition.setImportFileName("joy_sales.xls");
//		
//		ReportEO report = newReportEO();
//		report.setOrderNo("001-07");
//		report.setQuantitySold(3);
//		report.setAllPrice(new BigDecimal(300.0));
//		report.setImportAuthor("joy");
//		report.setImportFileName("joy_sales.xls");
//		reportDao.save(report);
//		
//		reportService.deleteSalesDataByConditon(condition);
//	}
//	
//	@Test
//	public void getReportFileByConditionTest() throws Exception{
//		
//		
//		Date importTime = new Date(System.currentTimeMillis());
//		
//		ReportEO report = newReportEO();
//		report.setOrderNo("001-08");
//		report.setQuantitySold(3);
//		report.setAllPrice(new BigDecimal(300.0));
//		report.setImportAuthor("joy");
//		report.setImportFileName("joy_sales.xls");
//		report.setImportTime(importTime);
//		reportDao.save(report);
//		
//		ReportCondition condition = new ReportCondition();
//		condition.setImportAuthor("joy");
//		condition.setImportFileName("joy_sales.xls");
//		condition.setImportTime(importTime);
//		
//		List<FileVO> reports = reportService.getFileListByCondition(condition);
//		
//		if(reports.size() != 0){
//			assertEquals("joy", reports.get(0).getImportAuthor());
//			assertEquals("joy_sales.xls", reports.get(0).getImportFileName());
//			reportDao.delete(report);
//		}
//	}
//	
//	@Test
//	public void getBpsBySalesNameTest(){
//		ReportCondition condition = new ReportCondition();
//		condition.setRegion("华东");		
//		
//		Map<String, Integer>  pSales = reportService.
//									getBpsBySalesName("salesJoy", condition);
//		
//		ReportEO report = newReportEO();
//		report.setOrderNo("001-09");
//		report.setQuantitySold(2);
//		report.setAllPrice(new BigDecimal(200.0));
//		report.setSalesName("salesJoy");
//		report.setRegion("华东");	
//		reportDao.save(report);
//		
//		ReportEO report2 = newReportEO();
//		report2.setOrderNo("001-10");
//		report2.setQuantitySold(3);
//		report2.setAllPrice(new BigDecimal(300.0));
//		report2.setSalesName("salesJoy");
//		report2.setRegion("华南");	
//		reportDao.save(report2);
//		
//		ReportEO report3 = newReportEO();
//		report3.setOrderNo("001-11");
//		report3.setQuantitySold(3);
//		report3.setAllPrice(new BigDecimal(300.0));	
//		report3.setSalesName("salesNick");
//		report3.setRegion("华东");	
//		reportDao.save(report3);
//		
//		Map<String, Integer>  sales = reportService.
//									getBpsBySalesName("salesJoy", condition);
//		
//		if(pSales == null || pSales.get("salesJoy") == null){
//			assertEquals((Integer)1,
//					(Integer)sales.get("salesJoy"));
//			reportDao.delete(report);
//			reportDao.delete(report2);
//			reportDao.delete(report3);
//			return;
//		}
//		assertEquals((Integer)(1+pSales.get("salesJoy")),
//				(Integer)sales.get("salesJoy"));
//		
//		reportDao.delete(report);
//		reportDao.delete(report2);
//		reportDao.delete(report3);
//	}
//	
//	@Test
//	public void test1(){
//		reportService.exportReport(null);
//	}
//	
//	private ReportEO newReportEO(){
//		return new ReportEO();
//	}

}
