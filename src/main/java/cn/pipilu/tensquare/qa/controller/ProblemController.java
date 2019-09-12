package cn.pipilu.tensquare.qa.controller;

import cn.pipilu.plus.common.request.Request;
import cn.pipilu.plus.common.response.Response;
import cn.pipilu.plus.common.util.ResponseUtil;
import cn.pipilu.tensquare.qa.entity.ProblemEntity;
import cn.pipilu.tensquare.qa.request.AddQaReq;
import cn.pipilu.tensquare.qa.response.QueryLabelResp;
import cn.pipilu.tensquare.qa.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/tensquare-qa/problem")
public class ProblemController {

    @Autowired
    private ProblemService problemService;
    @Autowired
    private HttpServletRequest request;
    @RequestMapping(value = "/{pageNo}/{pageSize}",method = RequestMethod.GET)
    public Response<List<ProblemEntity>> findList(@PathVariable("pageNo")int pageNo, @PathVariable("pageSize")int pageSize){
        Response<List<ProblemEntity>> response = new Response<>();

        try {
            response.setRespData(problemService.findList(pageNo,pageSize));
            ResponseUtil.setRespParam(response);
        }catch (Exception e){
            ResponseUtil.setRespParam(response,e);
        }
        return response;
    }

    @RequestMapping(value = "/add",method = RequestMethod.PUT)
    public Response<Void> add(@RequestBody Request<AddQaReq> reqData){
        Response<Void> response = new Response<>();

        try {
            problemService.add(reqData.getReqData());
            ResponseUtil.setRespParam(response);
        }catch (Exception e){
            ResponseUtil.setRespParam(response,e);
        }
        return response;
    }

    @RequestMapping(value = "/label/{labelId}",method = RequestMethod.GET)
    public Response<QueryLabelResp> queryProblemsByLabelId(@PathVariable("labelId")String id){
        Response<QueryLabelResp> response = new Response<>();

        try {
            response = problemService.queryProblemsByLabelId(id);
            ResponseUtil.setRespParam(response);
        }catch (Exception e){
            ResponseUtil.setRespParam(response,e);
        }
        return response;
    }
}
