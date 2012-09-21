package com.nexse.swat.liferay.examples.hook.example2;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GlobalPreEventAction extends Action {

    private static final Log log = LogFactoryUtil.getLog(GlobalPreEventAction.class);

    @Override
    public void run(HttpServletRequest request, HttpServletResponse response) throws ActionException {
        final String answer = request.getHeader("answer");
        log.info("answer=" + answer);

        if ("42".equals(answer)) {
            log.info("the answer is correct, you shall pass");
        } else {
            throw new ActionException("the answer is incorrect, you shall not pass");
        }
    }

}
