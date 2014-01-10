package com.itucity.yjreport.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itucity.common.exception.SystemRuntimeException;
import com.itucity.common.util.JsonUtil;
import com.itucity.yjreport.service.ChartService;
import com.itucity.yjreport.service.ReportService;
import com.itucity.yjreport.service.ResourceService;
import com.itucity.yjreport.util.ReturnPackaging;
import com.itucity.yjreport.vo.ProductSalesVO;
import com.itucity.yjreport.vo.ReportCondition;
import com.itucity.yjreport.vo.SummaryVO;
import com.itucity.yjreport.vo.SummaryVO.SummaryTypeEnum;

@Controller
@RequestMapping("test")
public class TestController {

	@Resource
	private ChartService chartService;

	@Resource
	private ReportService reportService;

	@Resource
	private ReturnPackaging errorMessage;
	
	@Resource
	private ResourceService resourceService;
	
	@RequestMapping(value="summary",method=RequestMethod.GET)
	public void getSummaryList(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String type = request.getParameter("type"); //SALES和GP两种
		String fromWeek = request.getParameter("fromWeek");
		String toWeek = request.getParameter("toWeek");
		String region = request.getParameter("region");
		String province = request.getParameter("province");
		try {
			ReportCondition condition = new ReportCondition();
			condition.setStartWeek(Integer.valueOf(fromWeek));
			condition.setEndWeek(Integer.valueOf(toWeek));
			
			if(region.equals("0")){//region为零表示没选择地区
				condition.setRegion(null);
			} else {
				condition.setRegion(region);
			}
			if(province.equals("0")){//province为零表示没选择省份
				condition.setState(null);
			} else {
				condition.setState(province);
			}
			
			List<SummaryVO> list = new ArrayList<SummaryVO>();
			
			switch (type) {
			case "SALES":
				list  = resourceService.getSummary2(SummaryTypeEnum.SALES, condition);
				break;
			case "GP":
				list  = resourceService.getSummary2(SummaryTypeEnum.GP, condition);
				break;
			}
			response.getWriter().print(JsonUtil.obj2JsonArr(list));
		} catch (SystemRuntimeException e) {
			e.printStackTrace();
			response.getWriter().print(JsonUtil.object2JsonStr(e));
		} catch(Exception ex){
        	ex.printStackTrace();
        	response.getWriter().print(JsonUtil.obj2JsonArr(new Exception(errorMessage.getUnknown_error())).toString());
        }
	}
	
	@RequestMapping(value="statics",method=RequestMethod.GET)
	public void getProductStatics(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String fromWeek = request.getParameter("fromWeek");
		String toWeek = request.getParameter("toWeek");
		String region = request.getParameter("region");
		String province = request.getParameter("province");
		
		String gp = request.getParameter("gp");
		String product = request.getParameter("product");
		
		try {
			ReportCondition condition = new ReportCondition();
			condition.setStartWeek(Integer.valueOf(fromWeek));
			condition.setEndWeek(Integer.valueOf(toWeek));
			
			if(region.equals("0")){//region为零表示没选择地区
				condition.setRegion(null);
			} else {
				condition.setRegion(region);
			}
			if(province.equals("0")){//province为零表示没选择省份
				condition.setState(null);
			} else {
				condition.setState(province);
			}
			condition.setProduct(product);
			
			List<ProductSalesVO> list = new ArrayList<ProductSalesVO>();
			list = resourceService.getProductSalesStatistics(gp, condition);
	
			response.getWriter().print(JsonUtil.obj2JsonArr(list));
		} catch (SystemRuntimeException e) {
			e.printStackTrace();
			response.getWriter().print(JsonUtil.object2JsonStr(e));
		} catch(Exception ex){
        	ex.printStackTrace();
        	response.getWriter().print(JsonUtil.obj2JsonArr(new Exception(errorMessage.getUnknown_error())).toString());
        }
	}
}
