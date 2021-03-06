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

package org.apache.poi.ss.formula.functions;

import junit.framework.TestCase;

import org.apache.poi.hssf.usermodel.HSSFEvaluationWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.IStabilityClassifier;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.WorkbookEvaluator;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/**
 * Tests for {@link Hex2Dec}
 *
 * @author cedric dot walter @ gmail dot com
 */
public final class TestHex2Dec extends TestCase {

    private static ValueEval invokeValue(String number1) {
		ValueEval[] args = new ValueEval[] { new StringEval(number1) };
		return new Hex2Dec().evaluate(args, -1, -1);
	}

    private static void confirmValue(String msg, String number1, String expected) {
		ValueEval result = invokeValue(number1);
		assertEquals(NumberEval.class, result.getClass());
		assertEquals(msg, expected, ((NumberEval) result).getStringValue());
	}

    private static void confirmValueError(String msg, String number1, ErrorEval numError) {
        ValueEval result = invokeValue(number1);
        assertEquals(ErrorEval.class, result.getClass());
        assertEquals(msg, numError, result);
    }

	public void testBasic() {
		confirmValue("Converts hex 'A5' to decimal (165)", "A5", "165");
		confirmValue("Converts hex FFFFFFFF5B to decimal (-165)", "FFFFFFFF5B", "-165");
		confirmValue("Converts hex 3DA408B9 to decimal (-165)", "3DA408B9", "1034160313");
	}

    public void testErrors() {
        confirmValueError("not a valid hex number","GGGGGGG", ErrorEval.NUM_ERROR);
        confirmValueError("not a valid hex number","3.14159", ErrorEval.NUM_ERROR);
    }

    public void testEvalOperationEvaluationContext() {
        OperationEvaluationContext ctx = createContext();
        
        ValueEval[] args = new ValueEval[] { ctx.getRefEval(0, 0) };
        ValueEval result = new Hex2Dec().evaluate(args, ctx);

        assertEquals(NumberEval.class, result.getClass());
        assertEquals("0", ((NumberEval) result).getStringValue());
    }
    
    public void testEvalOperationEvaluationContextFails() {
        OperationEvaluationContext ctx = createContext();
        
        ValueEval[] args = new ValueEval[] { ctx.getRefEval(0, 0), ctx.getRefEval(0, 0) };
        ValueEval result = new Hex2Dec().evaluate(args, ctx);

        assertEquals(ErrorEval.class, result.getClass());
        assertEquals(ErrorEval.VALUE_INVALID, result);
    }

    private OperationEvaluationContext createContext() {
        HSSFWorkbook wb = new HSSFWorkbook();
        wb.createSheet();
        HSSFEvaluationWorkbook workbook = HSSFEvaluationWorkbook.create(wb);
        WorkbookEvaluator workbookEvaluator = new WorkbookEvaluator(workbook, new IStabilityClassifier() {
            
            @Override
            public boolean isCellFinal(int sheetIndex, int rowIndex, int columnIndex) {
                return true;
            }
        }, null);
        OperationEvaluationContext ctx = new OperationEvaluationContext(workbookEvaluator, 
                workbook, 0, 0, 0, null);
        return ctx;
    }

    public void testRefs() {
        OperationEvaluationContext ctx = createContext();
        
        ValueEval[] args = new ValueEval[] { ctx.getRefEval(0, 0) };
        ValueEval result = new Hex2Dec().evaluate(args, -1, -1);

        assertEquals(NumberEval.class, result.getClass());
        assertEquals("0", ((NumberEval) result).getStringValue());
    }
}
