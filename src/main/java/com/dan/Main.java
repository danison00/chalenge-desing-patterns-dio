package com.dan;

import com.dan.model.infra.InjectManager;

public class Main {
    public static void main(String[] args) {

        AppSystem app = new AppSystem();
        InjectManager.injectSingleton(app);
        app.run();
    }
}