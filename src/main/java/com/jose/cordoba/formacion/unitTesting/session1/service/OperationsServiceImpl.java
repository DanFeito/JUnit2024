package com.jose.cordoba.formacion.unitTesting.session1.service;

import org.springframework.stereotype.Service;

@Service
public class OperationsServiceImpl implements OperationsService {

    @Override
    public boolean alwaysTrue() {
        return true;
    }

    @Override
    public boolean alwaysFalse() {
        return false;
    }

    @Override
    public int sum(int a, int b) {
        return a + b;
    }

    @Override
    public int div(int num, int den) {
        return num / den;
    }
}
