package cn.pipilu.tensquare.qa.service.impl;

import cn.pipilu.plus.common.exception.AppException;
import cn.pipilu.plus.common.response.Response;
import cn.pipilu.plus.common.util.IdUtil;
import cn.pipilu.plus.common.util.JwtUtil;
import cn.pipilu.tensquare.qa.entity.ProblemEntity;
import cn.pipilu.tensquare.qa.feign.BaseClient;
import cn.pipilu.tensquare.qa.mapper.ProblemMapper;
import cn.pipilu.tensquare.qa.request.AddQaReq;
import cn.pipilu.tensquare.qa.response.QueryLabelResp;
import cn.pipilu.tensquare.qa.service.ProblemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class ProblemServiceImpl implements ProblemService {
    @Autowired
    private ProblemMapper problemMapper;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private IdUtil idUtil;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private BaseClient baseClient;
    @Override
    public List<ProblemEntity> findList(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<ProblemEntity> pageInfo = new PageInfo<>(problemMapper.selectAll());
        return pageInfo.getList();
    }

    @Override
    public void add(AddQaReq reqData) {
        String token = (String) request.getAttribute("claims_user");
        if (StringUtils.isBlank(token)){
            throw new AppException("2001","请先登录");
        }

        ProblemEntity entity = new ProblemEntity();
        entity.setId(idUtil.getIdStr());
        entity.setTitle(reqData.getTitle());
        entity.setContent(reqData.getContent());
        Claims claims = jwtUtil.parseJWT(token);
        entity.setCreateTime(new Date());
        entity.setUserid(claims.getId());
        entity.setNickName(claims.getSubject());
        problemMapper.insert(entity);
    }

    @Override
    public Response<QueryLabelResp> queryProblemsByLabelId(String labelId) {
        Response<QueryLabelResp> response = baseClient.findById(labelId);

        return Objects.isNull(response)?new Response<>():response;
    }
}
