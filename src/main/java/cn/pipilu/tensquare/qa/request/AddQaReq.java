package cn.pipilu.tensquare.qa.request;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
@Data
@ToString
public class AddQaReq implements Serializable {
    private String title;
    private String content;
}
