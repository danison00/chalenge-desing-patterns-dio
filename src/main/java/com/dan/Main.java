package com.dan;

import com.dan.infra.Application;
import com.dan.infra.InjectManager;

public class Main {
    public static void main(String[] args) {

        Application.run(Library.class);

    }
}