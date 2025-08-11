package co.com.s.model.unitmeasure;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
public class UnitMeasure {
    private String id;

    private Integer code;

    private String name;

    private Integer codeUnitMeasureType;

    private String acronyms;

    private Boolean active;

    private String companyNit;

    private String createdBy;

    private LocalDateTime createdAt;

    private String modifiedBy;

    private LocalDateTime modifiedAt;

    private String unitMeasureType;
}
