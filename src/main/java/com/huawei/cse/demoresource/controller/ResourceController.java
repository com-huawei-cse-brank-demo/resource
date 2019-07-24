package com.huawei.cse.demoresource.controller;


import com.huawei.cse.demoresource.entity.Resource;
import com.huawei.cse.demoresource.service.ResourceService;
import com.huawei.cse.demoresource.utils.JsonResponse;
import io.swagger.annotations.ApiParam;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.huawei.cse.demoresource.constant.Response.*;

@RestSchema(schemaId = "hwclouds")
@RequestMapping(path = "hwclouds/v1")
public class ResourceController {
	@Autowired
	private ResourceService resourceService;

	@RequestMapping(value = "/resource/{userid}", method = RequestMethod.GET)
	public Object queryECS(@PathVariable("userid") int customerId) {
		if (customerId <0){
			return new JsonResponse(NOT_FOUND,RESPONSE_INFO.get(NOT_FOUND),"").toString();


		}
		List<Resource> resources = resourceService.findResourcesByCustomerId(customerId);
		return new JsonResponse(COSTOMER_RESOURCE_SUCCESS,RESPONSE_INFO.get(COSTOMER_RESOURCE_SUCCESS),resources.toString()).toString();
	}

	@RequestMapping(value = "/resource/order", method = RequestMethod.POST)
	@ResponseBody
	public String orderECS(@ApiParam("用户id")@RequestParam("userid")int customerId) {
		// 检查是否有充足空闲ECS服务器资源
		List<Resource> freeResource = resourceService.findResourcesByStatus(Resource.Status.FREE);
		if (freeResource.size()<1){
			return new JsonResponse(FREE_SPACE_NOT_ENOUGH,RESPONSE_INFO.get(FREE_SPACE_NOT_ENOUGH),"").toString();


		}

		// 检查租户是否有足够的配额
		int remainingResourceQuota = resourceService.findRemainingResourceQuotaByCustomerId(customerId);

		if(remainingResourceQuota<0){
			return new JsonResponse(NOT_FOUND,RESPONSE_INFO.get(NOT_FOUND),"").toString();

		}
		if (remainingResourceQuota == 0){
			return new JsonResponse(QUOTA_NOT_ENOUGH,RESPONSE_INFO.get(QUOTA_NOT_ENOUGH),"").toString();

		}

		Resource resource = freeResource.get(0);
		resource.setCustomerId(customerId);
		resource.setStatus(Resource.Status.OCCUPIED.toString());
		int resourceId = resourceService.purchaseResource(resource);
		resource.setResourceId(resourceId);
		return new JsonResponse(ORDER_SUCCESS,RESPONSE_INFO.get(ORDER_SUCCESS),resource.toString()).toString();


	}

	@RequestMapping(value = "/resource/{userid}/{resourceid}", method = RequestMethod.DELETE)
	@ResponseBody
	public Object deleteECS(@ApiParam("租户id")@PathVariable("userid")int customerId,
						 @ApiParam("服务器id")@PathVariable("resourceid") int resourceId) {
		Resource resource = resourceService.findResourceByResourceId(resourceId);
		if (resource.getCustomerId() != customerId){
//			return String.format("{retcode: %s, retdesc: %s}",
//				NO_AUTH,RESPONSE_INFO.get(NO_AUTH));
			return new JsonResponse(NO_AUTH,RESPONSE_INFO.get(NO_AUTH),"").toString();

		}
		resource.setCustomerId(0);
		resource.setStatus(Resource.Status.FREE.toString());
		resourceService.releaseResource(resource);
//		return String.format("{retcode: %s, retdesc: %s}",
//			FREE_SUCCESS,RESPONSE_INFO.get(FREE_SUCCESS));
		return new JsonResponse(FREE_SUCCESS,RESPONSE_INFO.get(FREE_SUCCESS),"").toString();

	}




}
