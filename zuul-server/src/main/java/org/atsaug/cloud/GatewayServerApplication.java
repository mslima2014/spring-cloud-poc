/* java *****************************************************************************\
 *               *  Project: spring-cloud-poc                         *
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

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class GatewayServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayServerApplication.class, args);
    }
}