package wms.menu.resultview;

import wms.menu.model.dto.DispatchDto;
import wms.menu.model.dto.ReceiptDto;

import java.util.List;

public class InOutboundResultView {
    public static void displayReceiptLog(List<ReceiptDto> list) {
        if (list.isEmpty()) {
            System.out.println("조회된 입고 내역이 없습니다.");
        } else {
            System.out.println("-----------------------------------------------------------------");
            System.out.printf("%-12s\t%-12s\t%-8s\t%-11s\t%-5s\n", "No.", "Date", "Name", "Amount", "Section");
            System.out.println("-----------------------------------------------------------------");
            for (ReceiptDto rDto : list) {
                System.out.printf("%d\t%-21s\t%-7s\t%-9d\t%-5d\n",
                        rDto.getReceiptNo(),
                        rDto.getDate(),
                        rDto.getProductName(),
                        rDto.getAmount(),
                        rDto.getSectionNo());
            }
            System.out.println("-----------------------------------------------------------------");
        }
    }

    public static void displayDispatchLog(List<DispatchDto> list) {
        if (list.isEmpty()) {
            System.out.println("조회된 출고 내역이 없습니다.");
        } else {
            System.out.println("-----------------------------------------------------------------");
            System.out.printf("%-12s\t%-12s\t%-8s\t%-11s\t%-5s\n", "No.", "Date", "Name", "Amount", "Section");
            System.out.println("-----------------------------------------------------------------");
            for (DispatchDto dDto : list) {
                System.out.printf("%d\t%-21s\t%-7s\t%-9d\t%-5d\n",
                        dDto.getDispatchNo(),
                        dDto.getDate(),
                        dDto.getProductName(),
                        dDto.getAmount(),
                        dDto.getSectionNo());
            }
            System.out.println("-----------------------------------------------------------------");
        }
    }

    public static void displayReceiptDispatchLog(List<ReceiptDto> rlist, List<DispatchDto> dlist) {
        if (rlist.isEmpty() && dlist.isEmpty()) {
            System.out.println("조회된 입출고 내역이 없습니다.");
        } else {
            System.out.println("-------------------------------------------------------------------------");
            System.out.printf("%-3s\t%-12s\t%-12s\t%-8s\t%-11s\t%-5s\n", "Type", "No.", "Date", "Name", "Amount", "Section");
            System.out.println("-------------------------------------------------------------------------");
            for (ReceiptDto rDto : rlist) {
                System.out.printf("%-3s\t%d\t%-21s\t%-7s\t%-9d\t%-5d\n",
                        "입고",
                        rDto.getReceiptNo(),
                        rDto.getDate(),
                        rDto.getProductName(),
                        rDto.getAmount(),
                        rDto.getSectionNo());
            }
            for (DispatchDto dDto : dlist) {
                System.out.printf("%-3s\t%d\t%-21s\t%-7s\t%-9d\t%-5d\n",
                        "출고",
                        dDto.getDispatchNo(),
                        dDto.getDate(),
                        dDto.getProductName(),
                        dDto.getAmount(),
                        dDto.getSectionNo());
            }
            System.out.println("-------------------------------------------------------------------------");
        }
    }
}
