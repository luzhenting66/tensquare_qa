package cn.pipilu.tensquare.qa.service;

import cn.pipilu.plus.common.response.Response;
import cn.pipilu.tensquare.qa.entity.ProblemEntity;
import cn.pipilu.tensquare.qa.request.AddQaReq;
import cn.pipilu.tensquare.qa.response.QueryLabelResp;

import java.util.List;

public interface ProblemService {
    List<ProblemEntity> findList(int pageNo, int pageSize);

    void add(AddQaReq reqData);

    Response<QueryLabelResp> queryProblemsByLabelId(String labelId);
}
