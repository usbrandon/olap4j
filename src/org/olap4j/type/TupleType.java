/*
// $Id: //open/mondrian/src/main/org.olap4j.type/TupleType.java#3 $
// This software is subject to the terms of the Common Public License
// Agreement, available at the following URL:
// http://www.opensource.org/licenses/cpl.html.
// Copyright (C) 2005-2005 Julian Hyde
// All Rights Reserved.
// You must accept the terms of that agreement to use this software.
*/
package org.olap4j.type;

import org.olap4j.metadata.Dimension;
import org.olap4j.metadata.Hierarchy;
import org.olap4j.metadata.Level;
import org.olap4j.OlapException;

/**
 * Tuple type.
 *
 * @author jhyde
 * @since Feb 17, 2005
 * @version $Id: //open/mondrian/src/main/org.olap4j.type/TupleType.java#3 $
 */
public class TupleType implements Type {
    public final Type[] elementTypes;

    /**
     * Creates a type representing a tuple whose fields are the given types.
     */
    public TupleType(Type[] elementTypes) {
        assert elementTypes != null;
        this.elementTypes = elementTypes.clone();
    }

    public boolean usesDimension(Dimension dimension, boolean maybe) {
        for (Type elementType : elementTypes) {
            if (elementType.usesDimension(dimension, maybe)) {
                return true;
            }
        }
        return false;
    }

    public Dimension getDimension() {
        throw new UnsupportedOperationException();
    }

    public Hierarchy getHierarchy() {
        throw new UnsupportedOperationException();
    }

    public Level getLevel() {
        throw new UnsupportedOperationException();
    }

    public Type getValueType() throws OlapException {
        for (Type elementType : elementTypes) {
            if (elementType instanceof MemberType) {
                MemberType memberType = (MemberType) elementType;
                if (memberType.getDimension().getDimensionType() == Dimension.Type.Measures) {
                    return memberType.getValueType();
                }
            }
        }
        return new ScalarType();
    }
}

// End TupleType.java