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

package com.is2300.cmdlineparser;

/**
 *
 * @author Sean Carrick &lt;sean at carricktrucking dot com&gt;
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public class TestClass {
    
    String output;

    String input;

    /**
     * Get the value of inputFile
     *
     * @return the value of inputFile
     */
    public String getInputFile() {
        return input;
    }

    /**
     * Set the value of inputFile
     *
     * @param inputFile new value of inputFile
     */
    public void setInputFile(String inputFile) {
        this.input = inputFile;
    }

    /**
     * Get the value of outputFile
     *
     * @return the value of outputFile
     */
    public String getOutputFile() {
        return output;
    }

    /**
     * Set the value of outputFile
     *
     * @param outputFile new value of outputFile
     */
    public void setOutputFile(String outputFile) {
        this.output = outputFile;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("Input File:\t").append(input).append("\n");
        sb.append("Output File:\t").append(output).append("\n");
        
        return sb.toString();
    }

    public TestClass () {
        
    }

}
