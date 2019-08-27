package cn.pipilu.tensquare.qa.service;

import cn.pipilu.tensquare.qa.entity.ProblemEntity;

import java.util.List;

public interface ProblemService {
    List<ProblemEntity> findList(int pageNo, int pageSize);
}
