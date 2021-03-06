package io.opentracing.contrib.benchmarks.billing.service.impl;

import io.opentracing.contrib.benchmarks.billing.model.Invoice;
import io.opentracing.contrib.benchmarks.billing.service.NotificationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Value("${thread.sleep}")
    private String msToSleep;

    @Override
    public Boolean notifyCustomer(Invoice invoice) {

        String recipientAddress = invoice.getCustomer().getEmail();

        //mock sending email
        try {
            Thread.sleep(new Integer(msToSleep));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return Boolean.TRUE;
    }
}
