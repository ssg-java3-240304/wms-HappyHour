package wms.menu.model.dto;

import lombok.*;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DispatchDto {
    private int dispatchNo;
    private LocalDateTime date;
    private int productNo;
    private String productName;
    private int amount;
    private int sectionNo;
}
