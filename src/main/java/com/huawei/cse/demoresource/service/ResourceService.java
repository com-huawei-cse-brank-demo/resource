package com.huawei.cse.demoresource.service;

import com.huawei.cse.demoresource.constant.ResourceCountByLevel;
import com.huawei.cse.demoresource.entity.Resource;
import com.huawei.cse.demoresource.mapper.ResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.sf.json.JSONObject;
import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.huawei.cse.demoresource.constant.ResourceCountByLevel.QUOTA;

@Service
public class ResourceService {
	@Autowired
	private ResourceMapper resourceMapper;

	public Resource findResourceByResourceId(int resource_id){
		return resourceMapper.findResourceByResourceId(resource_id);
	}


	public List<Resource> findResourcesByStatus(Resource.Status status){
		return resourceMapper.findResourcesByStatus(status.toString());
	}

	public List<Resource> findResourcesByCustomerId(int customerId){
		return resourceMapper.findResourcesByCustomerId(customerId);
	}


	public int purchaseResource(Resource resource){
		resourceMapper.updateResource(resource);
		return resource.getResourceId();
	}

	public int releaseResource(Resource resource){
		resourceMapper.updateResource(resource);
		return resource.getResourceId();
	}

	public int findRemainingResourceQuotaByCustomerId(int customerId){
		// rest调用customer接口获取用户level信息
		RestTemplate restTemplate = RestTemplateBuilder.create();
		String url = "cse://customer/hwclouds/v1/customer/"+customerId;
		String response = restTemplate.getForEntity(url,String.class).getBody();
		System.out.println("response is "+response);
		String customer = JSONObject.fromObject(response).get("resources").toString();
		System.out.println(customer);
		String level = JSONObject.fromObject(customer).getString("customerLevel");
		System.out.println(level);
		if (level == null || !level.startsWith("V")){
			return -1;
		}

		// 根据level信息获取对应配额
		int quota = QUOTA.get(ResourceCountByLevel.Level.valueOf(level));

		// 查询当前已在用资源数
		int useCount = resourceMapper.findResourceCountByCustomerId(customerId);


		return quota-useCount;
	}

}

