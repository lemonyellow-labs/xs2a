/**
 * ASPSP Profile rest API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1.0
 * Contact: pru@adorsys.com.ua
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


export interface AspspSettings {
    aisRedirectUrlToAspsp?: string;
    allPsd2Support?: boolean;
    availableBookingStatuses?: Array<AspspSettings.AvailableBookingStatusesEnum>;
    availablePaymentProducts?: Array<string>;
    availablePaymentTypes?: Array<string>;
    bankOfferedConsentSupport?: boolean;
    combinedServiceIndicator?: boolean;
    consentLifetime?: number;
    frequencyPerDay?: number;
    multicurrencyAccountLevel?: AspspSettings.MulticurrencyAccountLevelEnum;
    pisRedirectUrlToAspsp?: string;
    supportedAccountReferenceFields?: Array<AspspSettings.SupportedAccountReferenceFieldsEnum>;
    tppSignatureRequired?: boolean;
    transactionLifetime?: number;
}
export namespace AspspSettings {
    export type AvailableBookingStatusesEnum = 'BOOKED' | 'PENDING' | 'BOTH';
    export const AvailableBookingStatusesEnum = {
        BOOKED: 'BOOKED' as AvailableBookingStatusesEnum,
        PENDING: 'PENDING' as AvailableBookingStatusesEnum,
        BOTH: 'BOTH' as AvailableBookingStatusesEnum
    };
    export type MulticurrencyAccountLevelEnum = 'SUBACCOUNT' | 'AGGREGATION' | 'AGGREGATION_AND_SUBACCOUNT';
    export const MulticurrencyAccountLevelEnum = {
        SUBACCOUNT: 'SUBACCOUNT' as MulticurrencyAccountLevelEnum,
        AGGREGATION: 'AGGREGATION' as MulticurrencyAccountLevelEnum,
        AGGREGATIONANDSUBACCOUNT: 'AGGREGATION_AND_SUBACCOUNT' as MulticurrencyAccountLevelEnum
    };
    export type SupportedAccountReferenceFieldsEnum = 'IBAN' | 'BBAN' | 'PAN' | 'MASKEDPAN' | 'MSISDN';
    export const SupportedAccountReferenceFieldsEnum = {
        IBAN: 'IBAN' as SupportedAccountReferenceFieldsEnum,
        BBAN: 'BBAN' as SupportedAccountReferenceFieldsEnum,
        PAN: 'PAN' as SupportedAccountReferenceFieldsEnum,
        MASKEDPAN: 'MASKEDPAN' as SupportedAccountReferenceFieldsEnum,
        MSISDN: 'MSISDN' as SupportedAccountReferenceFieldsEnum
    };
}
