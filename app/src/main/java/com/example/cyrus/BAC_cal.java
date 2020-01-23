package com.example.cyrus;

public class BAC_cal {

    private Double mWeight,mPercent,EBAC,BW,MR,mMin, mHr,mBeer,mMl;
    private Integer mSex;

    public BAC_cal(){
        mWeight= 50.0;
        mPercent=5.0;
        mHr=1.0;
        mMin=0.0;
        mSex=0;
        mBeer=0.0;
        mMl=300.0;
    }

    public void setWeight (double weight){
        mWeight = weight;
    }
    public void setPercent (double percent){
        mPercent = percent;
    }
    public void setHr (double hr) {
        mHr=hr;
    }
    public void setMin (double min) {
        mMin=min;
    }
    public void setSex (int sex) {
        mSex=sex;
    }
    public void setBeer (double beer) {
        mBeer=beer;
    }
    public void setMl (double ml) {
        mMl=ml;
    }
    public void compute() {

        if(mSex==0)
        {
            BW=0.58;
            MR=0.015;
        }
        else if(mSex==1)
        {
            BW=0.49;
            MR=0.017;
        }

        if (mPercent == 0)
            mPercent = 5.0;

        if (mMl == 0)
            mMl = 200.0;
        EBAC = 0.806*1.2*((mMl*mPercent*0.789)/1400)/(BW*mWeight)-(MR*(mHr+mMin/60));





    }

    public Double getEBAC() {
        return EBAC;
    }


}
