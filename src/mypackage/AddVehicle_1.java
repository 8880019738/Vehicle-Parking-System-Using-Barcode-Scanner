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
@Table(name = "ADD_VEHICLE", catalog = "", schema = "HR")
@NamedQueries({
    @NamedQuery(name = "AddVehicle_1.findAll", query = "SELECT a FROM AddVehicle_1 a")
    , @NamedQuery(name = "AddVehicle_1.findByName", query = "SELECT a FROM AddVehicle_1 a WHERE a.name = :name")
    , @NamedQuery(name = "AddVehicle_1.findByAddress", query = "SELECT a FROM AddVehicle_1 a WHERE a.address = :address")
    , @NamedQuery(name = "AddVehicle_1.findByPhone", query = "SELECT a FROM AddVehicle_1 a WHERE a.phone = :phone")
    , @NamedQuery(name = "AddVehicle_1.findByVehicleNo", query = "SELECT a FROM AddVehicle_1 a WHERE a.vehicleNo = :vehicleNo")
    , @NamedQuery(name = "AddVehicle_1.findByDepartment", query = "SELECT a FROM AddVehicle_1 a WHERE a.department = :department")})
public class AddVehicle_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "PHONE")
    private String phone;
    @Id
    @Basic(optional = false)
    @Column(name = "VEHICLE_NO")
    private String vehicleNo;
    @Column(name = "DEPARTMENT")
    private String department;

    public AddVehicle_1() {
    }

    public AddVehicle_1(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        changeSupport.firePropertyChange("address", oldAddress, address);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        String oldPhone = this.phone;
        this.phone = phone;
        changeSupport.firePropertyChange("phone", oldPhone, phone);
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        String oldVehicleNo = this.vehicleNo;
        this.vehicleNo = vehicleNo;
        changeSupport.firePropertyChange("vehicleNo", oldVehicleNo, vehicleNo);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        String oldDepartment = this.department;
        this.department = department;
        changeSupport.firePropertyChange("department", oldDepartment, department);
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
        if (!(object instanceof AddVehicle_1)) {
            return false;
        }
        AddVehicle_1 other = (AddVehicle_1) object;
        if ((this.vehicleNo == null && other.vehicleNo != null) || (this.vehicleNo != null && !this.vehicleNo.equals(other.vehicleNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mypackage.AddVehicle_1[ vehicleNo=" + vehicleNo + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
