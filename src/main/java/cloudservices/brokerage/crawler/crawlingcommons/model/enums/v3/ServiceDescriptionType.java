/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudservices.brokerage.crawler.crawlingcommons.model.enums.v3;

import cloudservices.brokerage.crawler.crawlingcommons.model.enums.v2.RawCrawledServiceType;

/**
 *
 * @author Arash Khodadadi http://www.arashkhodadadi.com/
 */
public enum ServiceDescriptionType {

    REST,
    WSDL,
    WADL;

    public static ServiceDescriptionType convertFromV2(RawCrawledServiceType type) {
        switch (type) {
            case DEVELOPERS_GUIDE:
                return ServiceDescriptionType.REST;
            case WSDL:
                return ServiceDescriptionType.WSDL;
            case WADL:
                return ServiceDescriptionType.WADL;
            default:
                return ServiceDescriptionType.REST;
        }
    }
}
