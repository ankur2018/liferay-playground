package com.nexse.swat.liferay.examples.hook.example;

import com.liferay.portal.kernel.bean.BeanLocator;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.util.Portal;
import com.liferay.portal.util.PortalUtil;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AutoLoginExampleTest {

    private final AutoLoginExample autoLoginExample = new AutoLoginExample();

    @Test
    public void testLogin() throws Exception {
        // yup, a portlet container requires quite a bit of mocking!
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        Portal portal = mock(Portal.class);
        BeanLocator beanLocator = mock(BeanLocator.class);
        UserLocalService userLocalService = mock(UserLocalService.class);
        User user = mock(User.class);
        PortalUtil portalUtil = new PortalUtil();
        portalUtil.setPortal(portal);
        PortalBeanLocatorUtil.setBeanLocator(beanLocator);
        when(beanLocator.locate(UserLocalService.class.getName())).thenReturn(userLocalService);
        when(portal.getCompanyId(request)).thenReturn(10L);
        when(userLocalService.getUserByScreenName(10L, "pippo")).thenReturn(user);
        when(request.getParameter("userScreenName")).thenReturn("pippo");
        when(user.getUserId()).thenReturn(42L);
        when(user.getPassword()).thenReturn("password");

        String[] login = autoLoginExample.login(request, response);

        assertNotNull(login);
        assertEquals("login.length", 3, login.length);
        assertEquals("login[0]", String.valueOf(42), String.valueOf(login[0]));
        assertEquals("login[1]", "password", login[1]);
        assertEquals("login[2]", "true", login[2]);
    }
}
