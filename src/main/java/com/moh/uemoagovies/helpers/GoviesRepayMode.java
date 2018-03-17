
package com.moh.uemoagovies.helpers;

public enum GoviesRepayMode {
     AMORTCONSTANT("Amort. Constant"),
    ANNUITCONSTANT("Annuite Constante"),
    INFINE("In fine");
 
     private final String repayMode;

    GoviesRepayMode(String repayMode) {
        this.repayMode = repayMode;
    }

    public String getRepayMode() {
        return repayMode;
    }


}
