package io.github.talelin.latticy.dto.Banner;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class BannerDTO {
    @NotBlank
    @Length(min = 3, max = 32)
    private String name;

    @NotBlank
    @Length(min = 3, max = 32)
    private String description;

    @NotBlank
    @Length(min = 3, max = 32)
    private String title;

    @NotBlank
    @Length(min = 3, max = 32)
    private String img;
}
