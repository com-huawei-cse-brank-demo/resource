package com.huawei.cse.demoresource.mapper;

import com.huawei.cse.demoresource.entity.Resource;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface ResourceMapper {
	@Insert("insert into t_demo_resource_l50001838(customer_id, status) values(#{customerId},#{status})")
	@Options(useGeneratedKeys = true,keyProperty = "resource_id", keyColumn = "resource_id")
	void save(Resource resource);

	@Select("select count(*) from t_demo_resource_l50001838 where name=#{name}")
	int exits(@Param("name") String name);

	@Select("select count(*) from t_demo_resource_l50001838 where customer_id=#{customer_id}")
	int findResourceCountByCustomerId(@Param("customer_id") int customer_id);

//	@Update("update t_demo_resource_l50001838(resource_id, customer_id, status) values(#{resourceId},#{customerId},#{status})")
//	@Options(useGeneratedKeys = true,keyProperty = "resourceId", keyColumn = "resource_id")
//	void updateResource(Resource resource);

    @Update("update t_demo_resource_l50001838 set customer_id=#{customerId}, status=#{status} where resource_id=#{resourceId}")
    @Options(useGeneratedKeys = true,keyProperty = "resourceId", keyColumn = "resource_id")
    void updateResource(Resource resource);

    @Select("select * from t_demo_resource_l50001838 where resource_id=#{resource_id}")
	Resource findResourceByResourceId(@Param("resource_id") int resource_id);

	@Select("select * from t_demo_resource_l50001838 where customer_id=#{customer_id}")
	List<Resource> findResourcesByCustomerId(@Param("customer_id") int customer_id);

	@Select("select * from t_demo_resource_l50001838 where status=#{status}")
	List<Resource> findResourcesByStatus(@Param("status") String status);

	@Update("update t_demo_resource_l50001838 set password=#{newPassWord} where name=#{name} and password=#{oldPassWord}")
	int update(@Param("name") String name, @Param("oldPassWord") String oldPassWord, @Param("newPassWord") String newPassWord);
}
