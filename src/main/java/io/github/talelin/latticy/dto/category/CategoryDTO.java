package io.github.talelin.latticy.dto.category;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class CategoryDTO {

    @NotBlank
    @Length(min = 3, max = 30)
    private String name;

    @NotBlank
    @Length(min = 6, max = 50)
    private String description;

    @Min(value = 0)
    @Max(value = 1)
    @Positive
    private Integer isRoot;

    @Positive
    private Integer parentId;

    @NotBlank
    private String img;
    //    private Integer index;
    @Min(value = 0)
    @Max(value = 1)
    private Integer online;

    private Integer level;
}
