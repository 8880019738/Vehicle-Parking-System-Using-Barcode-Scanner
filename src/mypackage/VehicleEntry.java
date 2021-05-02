/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Dad
 */
@Entity
@Table(name = "VEHICLE_ENTRY", catalog = "", schema = "HR")
@NamedQueries({
    @NamedQuery(name = "VehicleEntry.findAll", query = "SELECT v FROM VehicleEntry v")
    , @NamedQuery(name = "VehicleEntry.findByVehicleNo", query = "SELECT v FROM VehicleEntry v WHERE v.vehicleNo = :vehicleNo")})
public class VehicleEntry implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "VEHICLE_NO")
    private String vehicleNo;

    public VehicleEntry() {
    }

    public VehicleEntry(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        String oldVehicleNo = this.vehicleNo;
        this.vehicleNo = vehicleNo;
        changeSupport.firePropertyChange("vehicleNo", oldVehicleNo, vehicleNo);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vehicleNo != null ? vehicleNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehicleEntry)) {
            return false;
        }
        VehicleEntry other = (VehicleEntry) object;
        if ((this.vehicleNo == null && other.vehicleNo != null) || (this.vehicleNo != null && !this.vehicleNo.equals(other.vehicleNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mypackage.VehicleEntry[ vehicleNo=" + vehicleNo + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
