/* java *****************************************************************************\
 *               *  Project: spring-cloud-poc                                       *
 *    #####      *  (!) Francesco Guastamacchia <guastamacchia.francesco@gmail.com> *
 *   ######      *                                                                  *
 *   ####  \     *  Copying and distribution of this file, with or without          *
 *    ###  c\    *  modification, are permitted in any medium without royalty       *
 *    ##    _\   *  provided this notice is preserved.                              *
 *    |   _/     *  This file is offered as-is, without any warranty.               *
 *    |  _/      *                                                                  *
 *               *  See: https://github.com/atsaug                                  *
\************************************************************************************/

package org.atsaug.cloud;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

@Configuration
public class HystrixFallbackConfiguration {

    @Bean
    public FallbackProvider fallbackProvider() {
        return new FallbackProvider() {

            @Override
            public String getRoute() {
                return "*";
            }

            @Override
            public ClientHttpResponse fallbackResponse(String route, Throwable throwable) {
                return new ClientHttpResponse() {
                    @Override
                    public HttpStatus getStatusCode() throws IOException {
                        return HttpStatus.OK;
                    }

                    @Override
                    public int getRawStatusCode() throws IOException {
                        return 200;
                    }

                    @Override
                    public String getStatusText() throws IOException {
                        return "OK";
                    }

                    @Override
                    public void close() {

                    }

                    @Override
                    public InputStream getBody() throws IOException {
                        return new ByteArrayInputStream("Sorry, service is down!".getBytes());
                    }
 
                    @Override
                    public HttpHeaders getHeaders() {
                        HttpHeaders headers = new HttpHeaders();
                        headers.setContentType(MediaType.APPLICATION_JSON);
                        return headers;
                    }
                };
            }
        };
    }
}
