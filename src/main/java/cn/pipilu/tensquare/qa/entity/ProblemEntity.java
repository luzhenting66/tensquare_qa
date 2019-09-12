package cn.pipilu.tensquare.qa.entity;

import cn.pipilu.plus.common.base.entity.BaseEntity;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Table;
import java.util.Date;

@Data
@ToString
@Table(name = "tb_problem")
public class ProblemEntity extends BaseEntity {

    private static final long serialVersionUID = 2742801575688513627L;
     private String title;//'标题',
    private String content;// '内容',
    private Date createTime;// '创建日期',
    private Date updateTime;// '修改日期',
    private String userid;// '用户ID',
    private String nickName;// '昵称',
    private int visits;//浏览量',
    private int thumbup;//点赞数',
    private int reply;//回复数',
    private String solve;// '是否解决',
    private String replyName;//'回复人昵称',
    private Date replyTime;//'回复日期',
}
