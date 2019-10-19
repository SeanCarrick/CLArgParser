/*
 * Copyright (C) 2019 Integrity Solutions
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.pekinsoft.cmdlineparser;

/**
 *
 * @author Sean Carrick <sean at carricktrucking dot com>
 */
public class ParseTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CmdLineParser parser = new CmdLineParser(args);
        
        if ( parser.isSwitchPresent("-h") || parser.isSwitchPresent("-help") ) {
            displayHelp();
        } else if ( parser.isSwitchPresent("-w") || parser.isSwitchPresent("-warranty") ) {
            System.out.println("Warranty detail information goes here.");
        } else if ( parser.isSwitchPresent("-c") || parser.isSwitchPresent("-conditions") ) {
            System.out.println("Conditions detail information goes here.");
        } else if ( (parser.isSwitchPresent("-i") || parser.isSwitchPresent("--input")) 
                && (parser.isSwitchPresent("-o") || parser.isSwitchPresent("--output")) ) {
            TestClass test = null;
            test = parser.getSwitchPOJO(TestClass.class);
            System.out.println(test.toString());
        } else {
            System.out.println("Input and output files must be provided.");
        }
    }
    
    static void displayHelp() {
        System.out.println("CLArgParser v 0.1.0");
        System.out.println("Copyright(c) 2019 Integrity Solutions");
        System.out.println("This program comes with ABOSLUTELY NO WARRANTY; for details type `-w'");
        System.out.println(" or `-warranty'.");
        System.out.println("This is free software, and you are welcome to reditribute it");
        System.out.println("under certain conditions; type `-c` or `-conditions' for details.");
        System.out.println("-".repeat(80));
        System.out.println();
        System.out.println("java -jar /path/to/CLArgParser.jar [options]");
        System.out.println();
        System.out.println("OPTIONS:");
        System.out.println();
        System.out.println("\t-h | -help\t\t\tShow this help and exit");
        System.out.println("\t-i | -input [filename]\t\tThe input filename");
        System.out.println("\t-o | -output [filename]\tThe output filename");
        System.out.println("\t-w | -warranty\tWarranty information");
        System.out.println("\t-c | -conditions\tConditons information");
        System.exit(0);
    }
}
