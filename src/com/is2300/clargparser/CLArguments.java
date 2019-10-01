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

package com.is2300.clargparser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

/**
 *
 * @author Sean Carrick &lt;sean at carricktrucking dot com&gt;
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public class CLArguments {
    //<editor-fold defaultstate="collapsed" desc="Public Static Constants">
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Private Member Fields">
    private String[] args;                          // Default to null
    private HashMap<String, Integer> switchIndices; // Default to null
    private TreeSet<Integer> takenIndices;          // Default to null
    private List<String> targets;                   // Default to null
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Static Initializer">
    static {
        
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Intstance Initializer">
    {
        args = null;
        switchIndices = new HashMap<>();
        takenIndices = new TreeSet<>();
        targets = new ArrayList<>();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor(s)">
    /**
     * Creates an instance of the {@code CLArguments} class to parse command
     * line arguments into something useful.
     * 
     * @param args The command line argument passed into the implementing program.
     */
    public CLArguments(String[] args) {
        parse(args);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Public Static Methods">
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Public Instance Methods">
    /**
     * Parse the arguments into a more useful format.
     * 
     * @param arguments The command line arguments given to the calling program.
     */
    public void parse(String[] arguments) {
        this.args = arguments;
        
        switchIndices.clear();
        takenIndices.clear();
        
        int idx = 0;
        
        for ( String str : args ) {
            if ( str.startsWith("-") ) {
                switchIndices.put(str, idx);
                takenIndices.add(idx++);    // Use then increment idx.
            }
        }
    }
    
    /**
     * Retrieves the array of arguments that are stored in this object.
     * 
     * @return The command line arguments.
     */
    public String[] getArguments() {
        return args;
    }
    
    /**
     * Retrieves the argument at the given index in the argument array.
     * 
     * @param idx   The index from which to get the argument.
     * @return      The argument stored at the provided index.
     */
    public String getArgument(int idx) {
        return args[idx];
    }
    
    /**
     * Checks to see if the given switch is present in the command line arguments.
     * 
     * @param switchName    The command line switch to check for.
     * @return              {@code true} if the switch is present; {@code falcse}
     *                      otherwise.
     */
    public boolean isSwitchPresent(String switchName) {
        return switchIndices.containsKey(switchName);
    }
    
    /**
     * Retrieve the value from the given switch.
     * 
     * @param switchName    The switch for which to retrieve the value.
     * @return              The value of the given switch.
     */
    public String getSwitchValue(String switchName) {
        return getSwitchValue(switchName, null);
    }
    
    /**
     * Retrieves the value for the given switch, or the default value if the
     * given switch is not found.
     * 
     * @param switchName    The switch for which value is wanted.
     * @param defaultValue  A default value in the event the switch is not
     *                      present.
     * @return              The value, if the switch is present; the supplied
     *                      default value if the switch was not found.
     */
    public String getSwitchValue(String switchName, String defaultValue) {
//        if ( !switchIndices.containsKey(switchName) ) {
//            return defaultValue;
//        }
//        
        int idx = switchIndices.get(switchName);
        
        String val = null;
        
        if ( idx + 1 < args.length ) {
            takenIndices.add(idx + 1);
            val = args[idx + 1];
        }
        
        return val == null ? defaultValue : val;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Private Instance Methods">
    
    //</editor-fold>

}
