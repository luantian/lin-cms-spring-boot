package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@TableName("banner_item")
public class BannerItemsDO extends BaseModel {
    private String name;
    private String img;
    private String keyword;
    private Integer type;

    private Integer bannerId;
}
