/*******************************************************************************
 * Copyright  (c) 2015-2016, WSO2.Telco Inc. (http://www.wso2telco.com) All Rights Reserved.
 * 
 * WSO2.Telco Inc. licences this file to you under  the Apache License, Version 2.0 (the "License");
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
package com.wso2telco.services.dep.sandbox.dao.model.custom;

import java.util.ArrayList;
import java.util.List;


public class ServiceList {

	private List<ServiceInfo> serviceInfo = new ArrayList<>();
	
	private List<CustomerInfo> customerInfo = new ArrayList<>();

	private String currencyCode;

	private String resourceURL;

	/**
	 * @return the serviceInfo
	 */
	public List<ServiceInfo> getServiceInfo() {
		return serviceInfo;
	}

	/**
	 * @param serviceInfo
	 *            the serviceInfo to set
	 */
	public void setServiceInfo(List<ServiceInfo> serviceInfo) {
		this.serviceInfo = serviceInfo;
	}

	/**
	 * @return the customerInfo
	 */
	public List<CustomerInfo> getCustomerInfo() {
		return customerInfo;
	}

	/**
	 * @param customerInfo
	 *            the customerInfo to set
	 */
	public void setCustomerInfo(List<CustomerInfo> customerInfo) {
		this.customerInfo = customerInfo;
	}
	
	/**
	 * @return the currencyCode
	 */
	public String getCurrencyCode() {
		return currencyCode;
	}

	/**
	 * @param currencyCode
	 *            the currencyCode to set
	 */
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	/**
	 * @return the resourceURL
	 */
	public String getResourceURL() {
		return resourceURL;
	}

	/**
	 * @param resourceURL
	 *            the resourceURL to set
	 */
	public void setResourceURL(String resourceURL) {
		this.resourceURL = resourceURL;
	}

	public ServiceInfo addNewServiceInfo() {
		ServiceInfo serviceInfo = new ServiceInfo();
		this.serviceInfo.add(serviceInfo);
		return serviceInfo;
	}
	
	public CustomerInfo addNewCustomerInfo() {
		CustomerInfo customerInfo = new CustomerInfo();
		this.customerInfo.add(customerInfo);
		return customerInfo;
	}


}
