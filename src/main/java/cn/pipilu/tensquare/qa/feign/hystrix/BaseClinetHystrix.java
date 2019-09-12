package cn.pipilu.tensquare.qa.feign.hystrix;

import cn.pipilu.plus.common.response.Response;
import cn.pipilu.tensquare.qa.feign.BaseClient;
import cn.pipilu.tensquare.qa.response.QueryLabelResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BaseClinetHystrix implements BaseClient {
    private Logger logger = LoggerFactory.getLogger(BaseClinetHystrix.class);
    @Override
    public Response<QueryLabelResp> findById(String id) {
        logger.info("远程调用查询标签失败。标签id：{}",id);
        return null;
    }
}
