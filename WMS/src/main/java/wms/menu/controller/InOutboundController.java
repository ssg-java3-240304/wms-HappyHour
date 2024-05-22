package wms.menu.controller;

import wms.menu.model.dto.DispatchDto;
import wms.menu.model.dto.ReceiptDto;
import wms.menu.model.service.InOutboundService;
import wms.menu.resultview.InOutboundResultView;

import java.util.List;

public class InOutboundController {
    private InOutboundService inOutboundService = new InOutboundService();
    public void findReceiptLog() {
        List<ReceiptDto> rlist = inOutboundService.findReceiptLog();
        InOutboundResultView.displayReceiptLog(rlist);
    }

    public void findDispatchLog() {
        List<DispatchDto> dlist = inOutboundService.findDispatchLog();
        InOutboundResultView.displayDispatchLog(dlist);
    }

    public void findReceiptDispatchLog() {
        List<ReceiptDto> rlist = inOutboundService.findReceiptLog();
        List<DispatchDto> dlist = inOutboundService.findDispatchLog();
        InOutboundResultView.displayReceiptDispatchLog(rlist, dlist);
    }
}