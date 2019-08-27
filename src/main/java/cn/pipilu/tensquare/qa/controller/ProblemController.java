package cn.pipilu.tensquare.qa.controller;

import cn.pipilu.plus.common.response.Response;
import cn.pipilu.plus.common.util.ResponseUtil;
import cn.pipilu.tensquare.qa.entity.ProblemEntity;
import cn.pipilu.tensquare.qa.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/tensquare-qa/problem")
public class ProblemController {

    @Autowired
    private ResponseUtil responseUtil;
    @Autowired
    private ProblemService problemService;
    @RequestMapping(value = "/{pageNo}/{pageSize}",method = RequestMethod.GET)
    public Response<List<ProblemEntity>> findList(@PathVariable("pageNo")int pageNo, @PathVariable("pageSize")int pageSize){
        Response<List<ProblemEntity>> response = new Response<>();

        try {
            response.setRespData(problemService.findList(pageNo,pageSize));
            responseUtil.setRespParam(response);
        }catch (Exception e){
            responseUtil.setRespParam(response,e);
        }
        return response;
    }
}
