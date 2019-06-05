package com.cochau.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Van Huynh on 31-05-18.
 */
@Entity
@Table(name = "ROLE", schema = "QLCHDT", catalog = "")
public class Role {
    private String roleId;
    private String role;
    private Collection<TaiKhoan> taiKhoansByRoleId;

    @Id
    @Column(name = "role_id")
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role1 = (Role) o;

        if (roleId != null ? !roleId.equals(role1.roleId) : role1.roleId != null) return false;
        if (role != null ? !role.equals(role1.role) : role1.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId != null ? roleId.hashCode() : 0;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "roleByRoleId",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    public Collection<TaiKhoan> getTaiKhoansByRoleId() {
        return taiKhoansByRoleId;
    }

    public void setTaiKhoansByRoleId(Collection<TaiKhoan> taiKhoansByRoleId) {
        this.taiKhoansByRoleId = taiKhoansByRoleId;
    }
}
