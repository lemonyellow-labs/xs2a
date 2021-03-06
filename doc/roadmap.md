# Roadmap

## Versions in progress

### version 2.3 (Planned date 12.04.2019)
- Bugfix: Transaction access using an invalid dynamic consent 
- Bugfix: SCA-Status EXEMPTED should be a finalised status 
- Bugfix: Update PSU Data with sca method shouldn't demand PSU-ID
- Bugfix: Links balances and transactions should appear in getAccoutList response according to consent accesses 
- Bugfix: Get authorisations of payment when one is already finalised 
- Bugfix: XS2A ObjectMapper clashes with Bank Offered Consents
- Bugfix: Embedded approach will not work if order of scaApproaches in bank_profile is: first - REDIRECT then - EMBEDDED 

### version 3.1 (Planned date 12.04.2019)
- Migrate to new Docker images 
- Migrate to .yaml open API ver 1.3.3 
- Support OAuth and Standart variants for Redirect approach in profile
- Support OAuth sca for AIS 


# Further development
Starting 15th of March 2019 XS2A Team is going to provide development within two branches:

## Stable branch 2.x
Stable branch will contain bugfixing and possibly necessary changes to support mandatory endpoints defined by Berlin Group NextGenPSD2 Spec 1.3
Stable branch 2.x will be supported at least till 01.09.2019

### version 2.4 (Planned date 26.04.2019)
- Bugfix: scaStatus link not available in response for Update PSU data for payment initiation (Decoupled Implicit) 
- Bugfix: Updating authorsation status not working like api-doc 
- Bugfix: "Currency" should be optional in Account Reference
- Bugfix: Use Sca Approach from Authorisation Object instead of separate resolving 
- Bugfix: EndToEndIdentification in CMS DB too short
- Extend logging with technical activities 

### version 2.5 (Planned date 10.05.2019)
- Bugfix: Check incoming requests to have required information
- Bugfix: Retrieve payment data by redirect-id with correct endpoint
- Bugfix: Consents without successful authorisation should expire with status Rejected 

### version 2.6 (Planned date 24.05.2019)
- Bugfix: Wrong Error code in payment initiation respond for not supported xml product types 
- Bugfix: startAuthorisationWithPsuAuthentication link not available in response for start the authorisation process for a payment initiation 
- Bugfix: Wrong response body for Start Payment Authorisation request Redirect Explicit approach

### version 2.7 (Planned date 07.06.2019)
- Bugfix: Get consent status request do not return mandated lastActionDate attribute in response body
- Bugfix: startAuthorisationWithPsuAuthentication link not available in response for  start the authorisation process for a payment initiation
- Bugfix: Populating PSU_DATA table with excessive data
- Bugfix: Provide correct PSU Data to the SPI in SpiContextData

### version 2.8 (Planned date 21.06.2019)
- Bugfix: Matching of fund confirmation to aspspConsentData
- Bugfix: Bad request when TPP enters an unknown user in the AIS consent embedded approach
- Bugfix: Wrong response for provision of an invalid TAN or password 
- Bugfix: PIIS should validate IBAN 


### Upcoming features 2.x/3.x (Priorities may be changed)
- Bugfix: Invalid format in PIS payment initiation request returns successful response
- Payment Authorisations and Payment Cancellation Authorisations should be separated from AIS Consent Authorisations
- Optional SCA for Access to all Accounts for all PSD2 defined AIS – Global Consent
- Provide creation date and time in SPIrequest
- add the request execution duration to the log
- Payment sepa-credit-transfers validator
- Consent validator
- PIIS should validate IBAN


## Development branch 3.x
Development branch is oriented on implementation of new features and optional endpoints.
No backward compatibility with 2.x is guaranteed.

### version 3.2 (Planned date 26.04.2019)
- Support OAuth sca for PIS
- Support OAuth sca for Payment cancellation
- Multilevel SCA for Establish Consent in Redirect approach 


### version 3.3 (Planned date 26.04.2019)
- Multilevel SCA for Payment Initiation in Redirect approach
- Payment Cancellation Request update according to Errata for Specification v.1.3



### Upcoming features 3.x (Priorities may be changed)
- Support of relative links 
- "transactions" or "balances" access right also gives access to the generic /accounts endpoints 
- Validation of authorisation sub-resources  
- Move AuthenticationObject to xs2a-core 
- Support delta access for transaction list 
- Component for scheduled batch processing 
- Support Get Transaction Status Response with xml format 
- Support Get Payment request for xml 
- Support of multicurrency accounts in AIS requests 
- Support of download link 
- Remove PSU data from CMS by request from ASPSP (for example due to Data protection (GDPR))
- Support sessions: Combination of AIS and PIS services 
- Add a new optional header TPP-Rejection-NoFunds-Preferred 
- Requirements on TPP URIs  
- FrequencyPerDay should be counted for requests without PSU involvement  
- aspspAccountId no longer available for SPI 
- handling for standard pain types 
- Update enum MessageErrorCode.java 
- Move PaymentAuthorisationType to the xs2a-core 
- Add instance_id for export PIIS consent 
- Extend CMS to store sca method and TAN for Redirect approach 
- Add to events rejected requests 
- Restructure profile by services 
- Extract events to separate module in CMS 
- Refactoring of payment saving Part 2 
- Refactor field validators (especially IBAN) to perform validation in Spring Component, not in static context 
- Recoverability 
- Change the logic of SpiResponseStatus to MessageErrorCode mapping 
- Implement CommonPaymentSpi interface in connector 
- Support all 3 formats of ISODateTime 
- Add service to delete consents and payments after period of time 

###### Support of Signing Basket
- Implement Establish Signing Basket request
- Implement Get Signing Basket request
- Get Signing Basket Status Request
- Implement Get Authorisation Sub-resources for Signing Baskets
- Implement Get SCA Status request for Signing Baskets
- Implement Cancellation of Signing Baskets
- Support Signing Basket in Embedded approach with multilevel sca
- Support Signing Basket in Decoupled approach with multilevel sca
- Support Signing Basket in Redirect approach with multilevel sca


###### Support of FundsConfirmation Consent:
- Establish FundsConfirmationConsent 
- Get FundsConfirmationConsent Status + object
- Revoke FundsConfirmationConsent
- FundsConfirmationConsent in Redirect approach with multilevel sca
- FundsConfirmationConsent in Embedded approach with multilevel sca
- FundsConfirmationConsent in Decoupled approach with multilevel sca
- Get Authorisation Sub-resource request for FundsConfirmationConsent
- Get Sca Status request for FundsConfirmationConsent 
- Create interface in cms-aspsp-api to get FundsConfirmationConsent 

###### Support of Card Accounts:
- Implement Read Card Account List request
- Implement Read Card Account Details request
- Implement Read Card Account Balance request
- Implement Read Card Account Transaction List request
