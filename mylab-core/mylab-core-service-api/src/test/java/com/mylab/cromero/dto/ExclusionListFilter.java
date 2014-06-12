package com.mylab.cromero.dto;

import java.util.ArrayList;
import java.util.List;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoClassFilter;

public class ExclusionListFilter implements PojoClassFilter {
    private final List<Class> exclusionList = new ArrayList<Class>();

    public ExclusionListFilter(final Class[] classes) {
        for (Class clazz : classes) {
            this.exclusionList.add(clazz);
        }
    }

    @Override
    public boolean include(PojoClass pojoClass) {
        return !this.exclusionList.contains(pojoClass.getClazz());
    }

}
