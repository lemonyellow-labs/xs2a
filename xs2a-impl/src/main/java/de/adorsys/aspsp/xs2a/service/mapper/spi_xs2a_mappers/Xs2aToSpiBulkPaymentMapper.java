/*
 * Copyright 2018-2018 adorsys GmbH & Co KG
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.adorsys.aspsp.xs2a.service.mapper.spi_xs2a_mappers;

import de.adorsys.aspsp.xs2a.domain.pis.BulkPayment;
import de.adorsys.aspsp.xs2a.domain.pis.PaymentProduct;
import de.adorsys.aspsp.xs2a.domain.pis.SinglePayment;
import de.adorsys.psd2.xs2a.spi.domain.common.SpiTransactionStatus;
import de.adorsys.psd2.xs2a.spi.domain.payment.SpiBulkPayment;
import de.adorsys.psd2.xs2a.spi.domain.payment.SpiPaymentProduct;
import de.adorsys.psd2.xs2a.spi.domain.payment.SpiSinglePayment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Xs2aToSpiBulkPaymentMapper {
    private final Xs2aToSpiSinglePaymentMapper xs2aToSpiSinglePaymentMapper;
    private final Xs2aToSpiAccountReferenceMapper xs2aToSpiAccountReferenceMapper;

    public SpiBulkPayment mapToSpiBulkPayment(BulkPayment payment, PaymentProduct paymentProduct) {
        SpiBulkPayment bulk = new SpiBulkPayment();
        bulk.setBatchBookingPreferred(payment.getBatchBookingPreferred());
        bulk.setDebtorAccount(xs2aToSpiAccountReferenceMapper.mapToSpiAccountReference(payment.getDebtorAccount()));
        bulk.setPaymentProduct(SpiPaymentProduct.getByValue(paymentProduct.getCode()));
        bulk.setRequestedExecutionDate(payment.getRequestedExecutionDate());
        bulk.setPayments(mapToListSpiSinglePayment(payment.getPayments(), paymentProduct));
        bulk.setPaymentStatus(SpiTransactionStatus.RCVD);
        return bulk;
    }

    private List<SpiSinglePayment> mapToListSpiSinglePayment(List<SinglePayment> payments, PaymentProduct paymentProduct) {
        return payments.stream()
                   .map(p -> xs2aToSpiSinglePaymentMapper.mapToSpiSinglePayment(p, paymentProduct))
                   .collect(Collectors.toList());
    }
}