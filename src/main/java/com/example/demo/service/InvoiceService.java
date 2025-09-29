package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.repository.InvoiceRepository;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceService {
    private final InvoiceRepository invoiceRepo;
    private final MemberRepository memberRepo;

    public Invoice createInvoice(Long memberId, Invoice invoice) {
        Member member = memberRepo.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found with id: " + memberId));

        invoice.setMember(member);

        // Calculate totals
        double subtotal = invoice.getItems().stream()
                .mapToDouble(InvoiceItem::getAmount)
                .sum();
        double tax = subtotal * 0.18;
        double total = subtotal + tax;

        invoice.setSubtotal(subtotal);
        invoice.setTax(tax);
        invoice.setTotal(total);

        // Link items back to invoice
        invoice.getItems().forEach(item -> item.setInvoice(invoice));

        return invoiceRepo.save(invoice);
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepo.findAll();
    }
}
