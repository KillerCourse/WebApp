package com.epam.redball.action;

import com.epam.redball.action.impl.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ActionFactory {

    private static final Map<String, Action> actions = new HashMap<>();

    static {
        actions.put("/homepage", new HomePage());
        actions.put("/register", new RegisterPage());
        actions.put("/login", new LoginPage());
        actions.put("/userpage", new UserPage());
        actions.put("/signIn", new SignInAction());
        actions.put("/signUp", new SignUpAction());
        actions.put("/logout", new SignOutAction());
        actions.put("/registration", new RegistrationAction());

    }

    public Action getAction(HttpServletRequest request) {
        String actionName = getActionName(request);
        return actions.get(actionName);

    }


    private String getActionName(HttpServletRequest req) {
        return req.getRequestURI();

    }

}
