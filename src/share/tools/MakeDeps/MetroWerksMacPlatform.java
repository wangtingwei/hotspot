/*
 * Copyright (c) 1999, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 *
 */

import java.io.*;

public class MetroWerksMacPlatform extends Platform {
    public void setupFileTemplates() {
        inclFileTemplate = new FileName(this,
            ":incls:", "_", "",                  ".incl", "", ""
        );
        giFileTemplate = new FileName(this,
            "",        "",  "precompiledHeader", ".pch",  "", ""
        );
        gdFileTemplate = dummyFileTemplate;
    }

    private static String[] suffixes = { ".cpp", ".c", ".s" };

    public String[] outerSuffixes() {
        return suffixes;
    }

    public boolean includeGIInEachIncl() {
        return true;
    }

    public int defaultGrandIncludeThreshold() {
        return 150;
    }

    public void writeGIPragma(PrintWriter out) {
        out.println("#pragma precompile_target \"" +
                    giFileTemplate.preStemAltSuff() +
                    "\"");
        out.println();
    }

    public String objFileSuffix() {
        throw new RuntimeException("Unimplemented in original makeDeps");
    }

    public String asmFileSuffix() {
        throw new RuntimeException("Unimplemented in original makeDeps");
    }

    public String dependentPrefix() {
        throw new RuntimeException("Unimplemented in original makeDeps");
    }
}