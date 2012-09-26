package com.nexse.swat.liferay.examples.hook.example;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.AutoLogin;
import com.liferay.portal.security.auth.AutoLoginException;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

public class AutoLoginExample implements AutoLogin {

    private static final Log log = LogFactoryUtil.getLog(AutoLoginExample.class);

    @Override
    public String[] login(HttpServletRequest request, HttpServletResponse response) throws AutoLoginException {
        log.info("login(): entered");

        String userScreenName = request.getParameter("userScreenName");
        log.info("login(): userScreenName=" + userScreenName);

        User user = null;

        if (null == userScreenName || StringPool.BLANK.equals(userScreenName.trim())) {
            return null; // login failed
        }

        try {
            user = UserLocalServiceUtil.getUserByScreenName(
                    PortalUtil.getCompanyId(request), userScreenName);
            log.info("login(): user=" + user);
        } catch (PortalException e) {
            log.error(e);
        } catch (SystemException e) {
            log.error(e);
        }

        if (user == null) {
            return null; // login failed
        }

        String[] credentials = new String[]{
                String.valueOf(user.getUserId()),
                user.getPassword(),
                String.valueOf(true) // authenticated?
        };

        log.info("login(): credentials=" + Arrays.asList(credentials));
        return credentials;
    }
}
