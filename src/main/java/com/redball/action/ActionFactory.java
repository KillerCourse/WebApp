package com.redball.action;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ActionFactory {

    private static final Map<String, Action> actions = new ConcurrentHashMap<>();

    private static ActionFactory instance = null;

    private ActionFactory() {
    }

    static {
        /*actions.put("/index", new ShowStartPageAction());
        actions.put("/create_person", new CreatePersonAction());
        actions.put("/registration_person", new RegistrationPersonAction());
        actions.put("/registration_button", new RegistrationButtonOnIndexPageAction());
        actions.put("/login_button", new LoginButtonOnIndexPageAction());
        actions.put("/login", new LoginAction());
        actions.put("/show_rooms", new ShowRoomsAction());*/



    }

    public static ActionFactory getInstance() {

        if (instance == null) {
            instance = new ActionFactory();
        }
        return instance;
    }

    public Action getAction(HttpServletRequest request) {

        return actions.get(request.getPathInfo().toLowerCase());
    }
}