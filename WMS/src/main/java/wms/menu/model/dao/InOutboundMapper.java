package wms.menu.model.dao;

import wms.menu.model.dto.DispatchDto;
import wms.menu.model.dto.ReceiptDto;

import java.util.List;

public interface InOutboundMapper {
    List<DispatchDto> findDispatchLog();
    List<ReceiptDto> findReceiptLog();
}
