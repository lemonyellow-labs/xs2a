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

package de.adorsys.psd2.consent.service.mapper;

import de.adorsys.psd2.consent.aspsp.api.piis.CreatePiisConsentRequest;
import de.adorsys.psd2.consent.domain.piis.PiisConsent;
import de.adorsys.psd2.xs2a.core.consent.ConsentStatus;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PiisConsentMapper {
    private final TppInfoMapper tppInfoMapper;
    private final PsuDataMapper psuDataMapper;
    private final AccountReferenceMapper accountReferenceMapper;

    public PiisConsent mapToPiisConsent(@NotNull CreatePiisConsentRequest request, @NotNull ConsentStatus consentStatus) {
        PiisConsent consent = new PiisConsent();
        consent.setConsentStatus(consentStatus);
        consent.setRequestDateTime(LocalDateTime.now());
        consent.setExpireDate(request.getValidUntil());
        consent.setPsuData(psuDataMapper.mapToPsuData(request.getPsuData()));
        consent.setTppInfo(tppInfoMapper.mapToTppInfo(request.getTppInfo()));
        consent.setAccounts(accountReferenceMapper.mapToAccountReferences(request.getAccounts()));
        consent.setTppAccessType(request.getTppAccessType());
        consent.setAllowedFrequencyPerDay(request.getAllowedFrequencyPerDay());
        return consent;
    }
}
