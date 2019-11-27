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

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@SuppressWarnings("unchecked")
public class PostFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostFilter.class);

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 999999;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        final List<String> routing = (List<String>) RequestContext.getCurrentContext().get("routingDebug");
        routing.forEach(LOGGER::info);
        return routing;
    }
}