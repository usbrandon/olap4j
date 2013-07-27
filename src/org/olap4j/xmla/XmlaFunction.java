/*
// Licensed to Julian Hyde under one or more contributor license
// agreements. See the NOTICE file distributed with this work for
// additional information regarding copyright ownership.
//
// Julian Hyde licenses this file to you under the Apache License,
// Version 2.0 (the "License"); you may not use this file except in
// compliance with the License. You may obtain a copy of the License at:
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
*/
package org.olap4j.xmla;

import java.util.List;

/**
 * XML for Analysis entity representing a Function.
 *
 * <p>Corresponds to the XML/A {@code MDSCHEMA_FUNCTIONS} schema rowset.</p>
 */
public class XmlaFunction extends Entity {
    public static final XmlaFunction INSTANCE =
        new XmlaFunction();

    public RowsetDefinition def() {
        return RowsetDefinition.MDSCHEMA_FUNCTIONS;
    }

    public List<Column> columns() {
        return list(
            FunctionName,
            Description,
            ParameterList,
            ReturnType,
            Origin,
            InterfaceName,
            LibraryName,
            Caption);
    }

    public List<Column> sortColumns() {
        return list(
            LibraryName,
            InterfaceName,
            FunctionName,
            Origin);
    }

    public final Column FunctionName =
        new Column(
            "FUNCTION_NAME",
            XmlaType.String,
            null,
            Column.RESTRICTION,
            Column.REQUIRED,
            "The name of the function.");
    public final Column Description =
        new Column(
            "DESCRIPTION",
            XmlaType.String,
            null,
            Column.NOT_RESTRICTION,
            Column.OPTIONAL,
            "A description of the function.");
    public final Column ParameterList =
        new Column(
            "PARAMETER_LIST",
            XmlaType.String,
            null,
            Column.NOT_RESTRICTION,
            Column.OPTIONAL,
            "A comma delimited list of parameters.");
    public final Column ReturnType =
        new Column(
            "RETURN_TYPE",
            XmlaType.Integer,
            null,
            Column.NOT_RESTRICTION,
            Column.REQUIRED,
            "The VARTYPE of the return data type of the function.");
    public final Column Origin =
        new Column(
            "ORIGIN",
            XmlaType.Integer,
            null,
            Column.RESTRICTION,
            Column.REQUIRED,
            "The origin of the function:  1 for MDX functions.  2 for "
            + "user-defined functions.");
    public final Column InterfaceName =
        new Column(
            "INTERFACE_NAME",
            XmlaType.String,
            null,
            Column.RESTRICTION,
            Column.REQUIRED,
            "The name of the interface for user-defined functions");
    public final Column LibraryName =
        new Column(
            "LIBRARY_NAME",
            XmlaType.String,
            null,
            Column.RESTRICTION,
            Column.OPTIONAL,
            "The name of the type library for user-defined functions. "
            + "NULL for MDX functions.");
    public final Column Caption =
        new Column(
            "CAPTION",
            XmlaType.String,
            null,
            Column.NOT_RESTRICTION,
            Column.OPTIONAL,
            "The display caption for the function.");
}

// End XmlaFunction.java
