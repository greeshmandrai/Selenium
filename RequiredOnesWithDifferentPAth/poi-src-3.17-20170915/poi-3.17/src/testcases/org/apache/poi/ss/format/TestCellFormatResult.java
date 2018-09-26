/* ====================================================================
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
==================================================================== */
package org.apache.poi.ss.format;

import java.awt.Color;

import junit.framework.TestCase;

public class TestCellFormatResult extends TestCase {
    
    public void testNullTextRaisesException() {
        try {
            final boolean applies = true;
            final String text = null;
            final Color textColor = Color.BLACK;
            final CellFormatResult result = new CellFormatResult(applies, text, textColor);
            fail("Cannot initialize CellFormatResult with null text parameter");
        }
        catch (IllegalArgumentException e) {
            //Expected
        }
    }
}