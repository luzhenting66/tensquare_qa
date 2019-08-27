package cn.pipilu.tensquare.qa.service.impl;

import cn.pipilu.tensquare.qa.entity.ProblemEntity;
import cn.pipilu.tensquare.qa.mapper.ProblemMapper;
import cn.pipilu.tensquare.qa.service.ProblemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemServiceImpl implements ProblemService {
    @Autowired
    private ProblemMapper problemMapper;
    @Override
    public List<ProblemEntity> findList(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<ProblemEntity> pageInfo = new PageInfo<>(problemMapper.selectAll());
        return pageInfo.getList();
    }
}
