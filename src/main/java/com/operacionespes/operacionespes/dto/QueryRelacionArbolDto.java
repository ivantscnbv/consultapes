package com.operacionespes.operacionespes.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QueryRelacionArbolDto {

    @JsonProperty("ArbolId")
    private Integer arbolId;

    @JsonProperty("PersonaMoralId")
    private Integer personaMoralId;

    @JsonProperty("SubSectorId")
    private Integer subSectorId;

}
