package io.github.talelin.latticy.bo;

import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.model.BannerItemsDO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Getter
@Setter
public class BannerWithItemsBO {

    private Integer id;
    private String name;
    private String description;
    private String title;
    private String img;
    private List<BannerItemsDO> items;

    public BannerWithItemsBO(BannerDO banner, List<BannerItemsDO> items) {
        BeanUtils.copyProperties(banner, this);
        this.setItems(items);
    }

}
