package cn.pipilu.tensquare.qa.feign;

import cn.pipilu.plus.common.response.Response;
import cn.pipilu.tensquare.qa.feign.hystrix.BaseClinetHystrix;
import cn.pipilu.tensquare.qa.response.QueryLabelResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "tensquare-base",fallback = BaseClinetHystrix.class)
public interface BaseClient {
    @RequestMapping(value = "/tensquare-base/label/{id}",method = RequestMethod.GET)
    Response<QueryLabelResp> findById(@PathVariable("id") String id);
}
