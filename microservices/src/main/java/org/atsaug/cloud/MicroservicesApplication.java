/* java *****************************************************************************\
 *               *  Project: microservices-spring-cloud-poc                         *
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

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class MicroservicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicesApplication.class, args);
    }

    @SuppressWarnings("serial")
    @RequestMapping(value = "/go")
    public List<String> available() {
        return new ArrayList<String>() {{
            System.getenv().forEach((k, v) -> {
                add(k + ":" + v);
            });
        }};
    }
}
