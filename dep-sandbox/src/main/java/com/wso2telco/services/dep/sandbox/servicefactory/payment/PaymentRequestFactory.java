/*******************************************************************************
 * Copyright (c) 2015-2017, WSO2.Telco Inc. (http://www.wso2telco.com)
 *
 * All Rights Reserved. WSO2.Telco Inc. licences this file to you under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.wso2telco.services.dep.sandbox.servicefactory.payment;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wso2telco.services.dep.sandbox.dao.model.custom.RequestDTO;
import com.wso2telco.services.dep.sandbox.servicefactory.RequestHandleable;


public class PaymentRequestFactory {
    private static Log LOG = LogFactory.getLog(PaymentRequestFactory.class);

    public static RequestHandleable getInstance(final RequestDTO requestDTO) {

        final String MAKE_PAYMENT = "ChargePaymentRequestWrapper";
        final String REFUND_PAYMENT = "PaymentRefundRequestWrapper";
        final String LIST_PAYMENT = "transactions";

        if(requestDTO.getHttpRequest().getPathInfo().contains("v1")){

       if(requestDTO.toString().contains(REFUND_PAYMENT)){
           LOG.debug("LOADING REFUND PAYMENT SERVICE");
           return new PaymentRefundRequestHandler1_3();
        } else if(requestDTO.toString().contains(MAKE_PAYMENT)){
           LOG.debug("LOADING MAKE PAYMENT SERVICE");
           return new PaymentRequestHandler();
       } else if (requestDTO.getRequestPath().contains(LIST_PAYMENT)){
            LOG.debug("LOADING LIST PAYMENT SERVICE");
            return new PaymentListTransactionRequestHandler();
       }
        return null;
        } else if (requestDTO.getHttpRequest().getPathInfo().contains("v0_8")) {

            if (requestDTO.toString().contains(REFUND_PAYMENT)) {
                LOG.debug("LOADING REFUND PAYMENT SERVICE");
                return new PaymentRefundRequestHandler0_8();
            } else if (requestDTO.toString().contains(MAKE_PAYMENT)) {
                LOG.debug("LOADING MAKE PAYMENT SERVICE");
                return new PaymentRequestHandler();
            }
            return null;
        }
        return null;
    }

}
