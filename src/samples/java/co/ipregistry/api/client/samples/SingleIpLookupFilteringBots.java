/*
 * Copyright 2019 Ipregistry (https://ipregistry.co).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package co.ipregistry.api.client.samples;

import co.ipregistry.api.client.IpregistryClient;
import co.ipregistry.api.client.exceptions.ApiException;
import co.ipregistry.api.client.exceptions.ClientException;
import co.ipregistry.api.client.model.IpInfo;
import co.ipregistry.api.client.util.UserAgent;

public class SingleIpLookupFilteringBots {

    public static void main(String[] args) {
        IpregistryClient client = new IpregistryClient("tryout");

        // For testing purposes, you can retrieve you current user agent from:
        // https://api.ipregistry.co/user_agent?key=tryout (look at the field named "header")
        if (UserAgent.isBot("TO_REPLACE_BY_USER_AGENT_RETRIEVED_FROM_REQUEST_HEADER")) {
            try {
                IpInfo ipInfo = client.lookup("8.8.8.8");
                // Here is an example to print out the country name associated with the IP address
                System.out.println(ipInfo.getLocation().getCountry().getName());
            } catch (ApiException e) {
                // Handle API errors (e.g. insufficient credits, throttling) here
                e.printStackTrace();
            } catch (ClientException e) {
                // Handle client errors (e.g. network error) here
                e.printStackTrace();
            }
        }
    }

}
