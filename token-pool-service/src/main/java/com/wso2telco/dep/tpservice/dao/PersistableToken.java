/*
 * Copyright (c) 2016, WSO2 Inc. (http://wso2.com) All Rights Reserved.
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

package com.wso2telco.dep.tpservice.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

interface PersistableToken {
 
	
	 @SqlUpdate(" INSERT  INTO  tsttoken  ( tsxwhodid , tokenauth, tokenvalidity , isvalid , accesstoken , refreshtoken , parenttokendid ) " +
				" VALUES  (:tsxwhodid ,:tokenauth, :tokenvalidity , :isvalid , :accesstoken , :refreshtoken , :parenttokendid )")
	 @GetGeneratedKeys
	public int inset(@Bind("tsxwhodid") int tsxwhodid,@Bind("tokenauth") String tokenauth,@Bind("tokenvalidity") long tokenvalidity ,
						@Bind("isvalid")boolean isvalid,@Bind("accesstoken") String accesstoken,@Bind("refreshtoken") String refreshtoken,@Bind("parenttokendid") int parenttokendid) ;
	 
	 @SqlUpdate(" INSERT  INTO  tsttoken  ( tsxwhodid , tokenauth, tokenvalidity , isvalid , accesstoken , refreshtoken  ) " +
				" VALUES  (:tsxwhodid ,:tokenauth, :tokenvalidity , :isvalid , :accesstoken , :refreshtoken  )")
	 @GetGeneratedKeys
	public int inset(@Bind("tsxwhodid") int tsxwhodid,@Bind("tokenauth") String tokenauth,@Bind("tokenvalidity") long tokenvalidity ,
						@Bind("isvalid")boolean isvalid,@Bind("accesstoken") String accesstoken,@Bind("refreshtoken") String refreshtoken)  ;
	 
	 @SqlUpdate(" UPDATE tsttoken  SET  isvalid = :validity   WHERE   tokendid = :did")
	 public void update(@Bind("validity") boolean validity,@Bind("did")int did ) ;
}