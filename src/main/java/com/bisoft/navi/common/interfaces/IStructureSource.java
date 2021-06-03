package com.bisoft.navi.common.interfaces;

import com.bisoft.navi.common.exceptions.GetObjectNamesException;
import com.bisoft.navi.common.exceptions.LoadStructureSourceException;

import java.util.Iterator;
import java.util.List;

public interface IStructureSource {
    Iterator<IModelObject> objectCollection(String prefix) throws LoadStructureSourceException;

    class Fake implements IStructureSource {
        private final List<IModelObject> list;

        public Fake(List<IModelObject> list){
            this.list = list;
        }

        @Override
        public Iterator<IModelObject> objectCollection(String prefix) throws LoadStructureSourceException {
            return (list)
                    .listIterator();
        }
    }

}
