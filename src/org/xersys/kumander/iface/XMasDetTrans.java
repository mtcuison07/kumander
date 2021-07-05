/**
 * @author Michael Cuison 2021.06.22
 */

package org.xersys.kumander.iface;

import org.json.simple.JSONObject;

public interface XMasDetTrans {
    void setListener(LMasDetTrans foValue);
    void setSaveToDisk(boolean fbValue);
    
    void setMaster(String fsFieldNm, Object foValue);
    Object getMaster(String fsFieldNm);
    
    void setDetail(int fnRow, String fsFieldNm, Object foValue);
    Object getDetail(int fnRow, String fsFieldNm);
    
    String getMessage();
    
    int getEditMode();
    int getItemCount();
    
    boolean addDetail();
    boolean delDetail(int fnRow);
    
    JSONObject SearchMaster(String fsFieldNm, Object foValue);
    JSONObject SearchDetail(int fnRow, String fsFieldNm, Object foValue);
    
    boolean NewTransaction();
    boolean SaveTransaction(boolean fbConfirmed);
    boolean SearchTransaction();
    boolean OpenTransaction(String fsTransNox);
    boolean UpdateTransaction();
    boolean CloseTransaction();
    boolean CancelTransaction();
    boolean DeleteTransaction(String fsTransNox);
    boolean PostTransaction();
}
