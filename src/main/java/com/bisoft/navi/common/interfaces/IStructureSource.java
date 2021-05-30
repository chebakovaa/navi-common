package com.bisoft.navi.common.interfaces;

import com.bisoft.navi.common.exceptions.GetObjectNamesException;
import com.bisoft.navi.common.exceptions.LoadStructureSourceException;

import java.util.Iterator;
import java.util.List;

public interface IStructureSource {
    Iterator<IModelObject> objectCollection(ElementType et) throws LoadStructureSourceException;

    class Fake implements IStructureSource {
        private final List<IModelObject> list;

        public Fake(List<IModelObject> list){
            this.list = list;
        }

        @Override
        public Iterator<IModelObject> objectCollection(ElementType et) throws LoadStructureSourceException {
            return (list)
                    .listIterator();
        }
    }

    enum ElementType {
        OBJ,
        REL,
        FACT,
        DIC,
        ALL
    }
}
