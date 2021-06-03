package com.bisoft.navi.common.interfaces;

import com.bisoft.navi.common.exceptions.GetObjectNamesException;

import java.io.IOException;

public interface IObjectStructure {
    void save() throws IOException, GetObjectNamesException;
    
    enum ElementType {
        OBJ,
        REL,
        FACT,
        DIC,
        ALL
    }
    
}
