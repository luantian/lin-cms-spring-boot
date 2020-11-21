package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName("category")
public class CategoryDO extends BaseModel {

    private String name;
    private String description;
    private Integer isRoot;
    private Integer parentId;
    private String img;

//    private Integer index;
    private Integer online;
    private Integer level;

}
