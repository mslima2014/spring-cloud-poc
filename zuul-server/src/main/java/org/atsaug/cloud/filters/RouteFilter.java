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

package org.atsaug.cloud.filters;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class RouteFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(RouteFilter.class);

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public String filterType() {
        return FilterConstants.ROUTE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public Object run() throws ZuulException {
        final String RESULT = URI.create(RequestContext.getCurrentContext().getRequest().getRequestURI()).getPath();
        LOGGER.info("New request for: " + RESULT);
        return RESULT;
    }
}
