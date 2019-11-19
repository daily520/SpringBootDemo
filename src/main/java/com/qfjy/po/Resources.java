package com.qfjy.po;

import java.io.Serializable;

public class Resources implements Serializable {
    private Integer id;

    private String keyurl;

    private String filtername;

    private Integer sortnum;

    private Integer status;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyurl() {
        return keyurl;
    }

    public void setKeyurl(String keyurl) {
        this.keyurl = keyurl == null ? null : keyurl.trim();
    }

    public String getFiltername() {
        return filtername;
    }

    public void setFiltername(String filtername) {
        this.filtername = filtername == null ? null : filtername.trim();
    }

    public Integer getSortnum() {
        return sortnum;
    }

    public void setSortnum(Integer sortnum) {
        this.sortnum = sortnum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", keyurl=").append(keyurl);
        sb.append(", filtername=").append(filtername);
        sb.append(", sortnum=").append(sortnum);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}