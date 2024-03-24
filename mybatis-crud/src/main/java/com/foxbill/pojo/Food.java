package com.foxbill.pojo;

public class Food {
    private Integer fid;
    private String fname;
    private Float fprice;
    private Integer fsellCount;
    private String fimage;

    public Food() {
    }

    public Food(String fname, Float fprice, String fimage) {
        this.fname = fname;
        this.fprice = fprice;
        this.fimage = fimage;
    }

    public Food(Integer fid, String fname, Float fprice, Integer fsellCount, String fimage) {
        this.fid = fid;
        this.fname = fname;
        this.fprice = fprice;
        this.fsellCount = fsellCount;
        this.fimage = fimage;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Float getFprice() {
        return fprice;
    }

    public void setFprice(Float fprice) {
        this.fprice = fprice;
    }

    public Integer getFsellCount() {
        return fsellCount;
    }

    public void setFsellCount(Integer fsellCount) {
        this.fsellCount = fsellCount;
    }

    public String getFimage() {
        return fimage;
    }

    public void setFimage(String fimage) {
        this.fimage = fimage;
    }

    @Override
    public String toString() {
        return "Food{" +
                "fid=" + fid +
                ", fname='" + fname + '\'' +
                ", fprice=" + fprice +
                ", fsellCount=" + fsellCount +
                ", fimage='" + fimage + '\'' +
                '}';
    }
}
