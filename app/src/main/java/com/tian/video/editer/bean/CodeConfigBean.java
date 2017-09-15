package com.tian.video.editer.bean;

import java.util.List;

/**
 * Created by jwzt on 2016/9/21.
 */
public class CodeConfigBean {


    private String WS_MD5;
    private String TC_MD5;

    private String SC_URL;//商城
    private String INDEX_URL;//首页

    private String ABOUT_URL;//关于我们
    private String SETACCOUNT_URL;//设置

    private String MY_COURSE;//我的课程
    private String MY_CERT;//我的证书
    private String E_INVOICE;//电子发票
    private String ONLINE_SERVICE;//在线客服
    private String MY_ORDER;//我的订单
    private String REGISTER;//我的注册
    private String FAQ;//常见问题


    private PicBean WELCOME_PAGE;
    private VersionBean VERSIONUPDATE;
    private PicBean CLASS_IMG;
    private PicBean EXAM_IMG;
    private PicBean USER_IMG;
    private List<ProfilListBean> USER;

    public String getFAQ() {
        return FAQ;
    }

    public void setFAQ(String FAQ) {
        this.FAQ = FAQ;
    }

    public String getMY_COURSE() {
        return MY_COURSE;
    }

    public void setMY_COURSE(String MY_COURSE) {
        this.MY_COURSE = MY_COURSE;
    }

    public String getMY_CERT() {
        return MY_CERT;
    }

    public void setMY_CERT(String MY_CERT) {
        this.MY_CERT = MY_CERT;
    }

    public String getE_INVOICE() {
        return E_INVOICE;
    }

    public void setE_INVOICE(String e_INVOICE) {
        E_INVOICE = e_INVOICE;
    }

    public String getONLINE_SERVICE() {
        return ONLINE_SERVICE;
    }

    public void setONLINE_SERVICE(String ONLINE_SERVICE) {
        this.ONLINE_SERVICE = ONLINE_SERVICE;
    }

    public String getMY_ORDER() {
        return MY_ORDER;
    }

    public void setMY_ORDER(String MY_ORDER) {
        this.MY_ORDER = MY_ORDER;
    }



    public List<ProfilListBean> getUSER() {
        return USER;
    }

    public void setUSER(List<ProfilListBean> USER) {
        this.USER = USER;
    }

    public PicBean getCLASS_IMG() {
        return CLASS_IMG;
    }

    public void setCLASS_IMG(PicBean CLASS_IMG) {
        this.CLASS_IMG = CLASS_IMG;
    }

    public PicBean getEXAM_IMG() {
        return EXAM_IMG;
    }

    public void setEXAM_IMG(PicBean EXAM_IMG) {
        this.EXAM_IMG = EXAM_IMG;
    }

    public PicBean getUSER_IMG() {
        return USER_IMG;
    }

    public void setUSER_IMG(PicBean USER_IMG) {
        this.USER_IMG = USER_IMG;
    }

    public VersionBean getVERSIONUPDATE() {
        return VERSIONUPDATE;
    }

    public void setVERSIONUPDATE(VersionBean VERSIONUPDATE) {
        this.VERSIONUPDATE = VERSIONUPDATE;
    }

    public String getABOUT_URL() {
        return ABOUT_URL;
    }

    public void setABOUT_URL(String ABOUT_URL) {
        this.ABOUT_URL = ABOUT_URL;
    }

    public String getSETACCOUNT_URL() {
        return SETACCOUNT_URL;
    }

    public void setSETACCOUNT_URL(String SETACCOUNT_URL) {
        this.SETACCOUNT_URL = SETACCOUNT_URL;
    }
    public String getWS_MD5() {
        return WS_MD5;
    }

    public void setWS_MD5(String WS_MD5) {
        this.WS_MD5 = WS_MD5;
    }

    public String getTC_MD5() {
        return TC_MD5;
    }

    public void setTC_MD5(String TC_MD5) {
        this.TC_MD5 = TC_MD5;
    }

    public String getSC_URL() {
        return SC_URL;
    }

    public void setSC_URL(String SC_URL) {
        this.SC_URL = SC_URL;
    }

    public String getINDEX_URL() {
        return INDEX_URL;
    }

    public void setINDEX_URL(String INDEX_URL) {
        this.INDEX_URL = INDEX_URL;
    }

    public PicBean getWELCOME_PAGE() {
        return WELCOME_PAGE;
    }

    public void setWELCOME_PAGE(PicBean WELCOME_PAGE) {
        this.WELCOME_PAGE = WELCOME_PAGE;
    }


    public class ProfilListBean{
        private String IMG;
        private String TITLE;
        private String URL;


        @Override
        public String toString() {
            return "ProfilListBean{" +
                    "IMG='" + IMG + '\'' +
                    ", TITLE='" + TITLE + '\'' +
                    ", URL='" + URL + '\'' +
                    '}';
        }

        public String getIMG() {
            return IMG;
        }

        public void setIMG(String IMG) {
            this.IMG = IMG;
        }

        public String getTITLE() {
            return TITLE;
        }

        public void setTITLE(String TITLE) {
            this.TITLE = TITLE;
        }

        public String getURL() {
            return URL;
        }

        public void setURL(String URL) {
            this.URL = URL;
        }
    }

    public class VersionBean{
        private VersionDetialBean ANDROID;

        @Override
        public String toString() {
            return "VersionBean{" +
                    "ANDROID=" + ANDROID +
                    '}';
        }

        public VersionDetialBean getANDROID() {
            return ANDROID;
        }

        public void setANDROID(VersionDetialBean ANDROID) {
            this.ANDROID = ANDROID;
        }

        public class VersionDetialBean{
            private String VERSION_IN;
            private String VERSION_OUT;
            private String URL;
            private String DESCRIPTION;
            private String IS_IMPOSED;

            @Override
            public String toString() {
                return "VersionDetialBean{" +
                        "VERSION_IN='" + VERSION_IN + '\'' +
                        ", VERSION_OUT='" + VERSION_OUT + '\'' +
                        ", URL='" + URL + '\'' +
                        ", DESCRIPTION='" + DESCRIPTION + '\'' +
                        ", IS_IMPOSED='" + IS_IMPOSED + '\'' +
                        '}';
            }

            public String getIS_IMPOSED() {
                return IS_IMPOSED;
            }

            public void setIS_IMPOSED(String IS_IMPOSED) {
                this.IS_IMPOSED = IS_IMPOSED;
            }

            public String getVERSION_IN() {
                return VERSION_IN;
            }

            public void setVERSION_IN(String VERSION_IN) {
                this.VERSION_IN = VERSION_IN;
            }

            public String getVERSION_OUT() {
                return VERSION_OUT;
            }

            public void setVERSION_OUT(String VERSION_OUT) {
                this.VERSION_OUT = VERSION_OUT;
            }

            public String getURL() {
                return URL;
            }

            public void setURL(String URL) {
                this.URL = URL;
            }

            public String getDESCRIPTION() {
                return DESCRIPTION;
            }

            public void setDESCRIPTION(String DESCRIPTION) {
                this.DESCRIPTION = DESCRIPTION;
            }
        }

    }



     public class PicBean{
        private String YX;
        private String EX;
        private String SX;


        public String getYX() {
            return YX;
        }

        public void setYX(String YX) {
            this.YX = YX;
        }

        public String getEX() {
            return EX;
        }

        public void setEX(String EX) {
            this.EX = EX;
        }

        public String getSX() {
            return SX;
        }

        public void setSX(String SX) {
            this.SX = SX;
        }


        @Override
        public String toString() {
            return "PicBean{" +
                    "YX='" + YX + '\'' +
                    ", EX='" + EX + '\'' +
                    ", SX='" + SX + '\'' +
                    '}';
        }
    }

    public String getREGISTER() {
        return REGISTER;
    }

    public void setREGISTER(String REGISTER) {
        this.REGISTER = REGISTER;
    }


    @Override
    public String toString() {
        return "CodeConfigBean{" +
                "WS_MD5='" + WS_MD5 + '\'' +
                ", TC_MD5='" + TC_MD5 + '\'' +
                ", SC_URL='" + SC_URL + '\'' +
                ", INDEX_URL='" + INDEX_URL + '\'' +
                ", ABOUT_URL='" + ABOUT_URL + '\'' +
                ", SETACCOUNT_URL='" + SETACCOUNT_URL + '\'' +
                ", MY_COURSE='" + MY_COURSE + '\'' +
                ", MY_CERT='" + MY_CERT + '\'' +
                ", E_INVOICE='" + E_INVOICE + '\'' +
                ", ONLINE_SERVICE='" + ONLINE_SERVICE + '\'' +
                ", MY_ORDER='" + MY_ORDER + '\'' +
                ", REGISTER='" + REGISTER + '\'' +
                ", FAQ='" + FAQ + '\'' +
                ", WELCOME_PAGE=" + WELCOME_PAGE +
                ", VERSIONUPDATE=" + VERSIONUPDATE +
                ", CLASS_IMG=" + CLASS_IMG +
                ", EXAM_IMG=" + EXAM_IMG +
                ", USER_IMG=" + USER_IMG +
                ", USER=" + USER +
                '}';
    }
}
